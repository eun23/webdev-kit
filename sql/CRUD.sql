-- 데이터베이스 생성 및 사용 설정
CREATE DATABASE crud;  -- 'crud'라는 데이터베이스 생성
USE crud;  -- 생성한 'crud' 데이터베이스 사용

-- 사용자(user) 테이블 생성
CREATE TABLE user (
	id VARCHAR(20) NOT NULL UNIQUE,  -- 사용자 ID, 중복 불가
    password VARCHAR(255) NOT NULL, -- 사용자 비밀번호, 암호화를 고려해 255자 지정
    nickname VARCHAR(50) NOT NULL,  -- 사용자 닉네임, 최대 50자
    CONSTRAINT user_pk PRIMARY KEY (id) -- 기본키 설정
);

-- 게시판(board) 테이블 생성
CREATE TABLE board (
	board_number INT NOT NULL UNIQUE AUTO_INCREMENT, -- 게시판 번호, 자동 증가
    title TEXT NOT NULL,   -- 게시글 제목
    contents TEXT NOT NULL, -- 게시글 내용
    write_date DATE NOT NULL, -- 게시글 작성 날짜
    writer_id VARCHAR(20) NOT NULL, -- 작성자 ID (user 테이블 참조)
    
    CONSTRAINT board_pk PRIMARY KEY (board_number), -- 기본키 설정
    CONSTRAINT board_writer_fk FOREIGN KEY (writer_id) REFERENCES user (id) -- 작성자 ID 외래키 설정
);

-- 게시판 정보 뷰 생성 (작성자 닉네임 포함)
CREATE VIEW board_view AS 
SELECT 
  B.board_number board_number,
  B.title title,
  U.nickname writer_nickname,
  B.write_date write_date,
  B.contents contents
FROM board B INNER JOIN user U
ON B.writer_id = U.id; -- board 테이블과 user 테이블 조인

-- 기존 comment 테이블 삭제 (존재 시)
DROP TABLE comment;

-- 댓글(comment) 테이블 생성
CREATE TABLE comment (
  comment_number INT NOT NULL UNIQUE AUTO_INCREMENT, -- 댓글 번호, 자동 증가
  board_number INT NOT NULL,  -- 참조 게시글 번호
  writer_id VARCHAR(20) NOT NULL, -- 작성자 ID
  contents TEXT NOT NULL, -- 댓글 내용
  write_datetime DATETIME NOT NULL, -- 댓글 작성 날짜 및 시간
  status BOOLEAN NOT NULL, -- 댓글 상태 (true: 활성, false: 비활성)
  parent_comment INT, -- 부모 댓글 번호 (대댓글 구현용)

  CONSTRAINT comment_pk PRIMARY KEY (comment_number), -- 기본키 설정
  CONSTRAINT comment_board_fk FOREIGN KEY (board_number) REFERENCES board (board_number), -- 게시글 외래키 설정
  CONSTRAINT comment_user_fk FOREIGN KEY (writer_id) REFERENCES user (id), -- 사용자 외래키 설정
  CONSTRAINT parent_comment_fk FOREIGN KEY (parent_comment) REFERENCES comment (comment_number) -- 부모 댓글 외래키 설정
);

-- 즐겨찾기(favorite) 테이블 생성
CREATE TABLE favorite (
  id VARCHAR(20) NOT NULL, -- 사용자 ID
  board_number INT NOT NULL, -- 즐겨찾기한 게시글 번호

  CONSTRAINT favorite_pk PRIMARY KEY (id, board_number), -- 복합 기본키 설정 (ID와 게시글 번호 조합)
  CONSTRAINT favorite_user_fk FOREIGN KEY (id) REFERENCES user (id), -- 사용자 외래키 설정
  CONSTRAINT favorite_board_fk FOREIGN KEY (board_number) REFERENCES board (board_number) -- 게시글 외래키 설정
);

-- 댓글 데이터 삽입 (부모 댓글 없음)
INSERT INTO comment (contents, board_number, writer_id, write_datetime, status, parent_comment) 
VALUES ("Qwer", 3, "qwer1234", now(), true, null);

-- 자식 댓글 삽입 (부모 댓글: 1번)
INSERT INTO comment (contents, board_number, writer_id, write_datetime, status, parent_comment) 
VALUES ("\uC790\uC2DC\uADF8\uB8F8 1", 3, "qwer1234", now(), true, 1);

-- 또 다른 자식 댓글 삽입
INSERT INTO comment (contents, board_number, writer_id, write_datetime, status, parent_comment) 
VALUES ("\uC790\uC2DC\uADF8\uB8F8 2", 3, "qwer1234", now(), true, 1);

-- 대댓글 삽입 (부모 댓글: 3번)
INSERT INTO comment (contents, board_number, writer_id, write_datetime, status, parent_comment) 
VALUES ("\uC790\uC2DC\uADF8\uB8F8 2-1", 3, "qwer1234", now(), true, 3);

-- 댓글 전체 조회
SELECT * FROM comment;

-- 댓글 상태 업데이트 (비활성화 처리)
UPDATE comment SET status = false WHERE comment_number = 2;

-- 특정 댓글 삭제
DELETE FROM comment WHERE comment_number = 2;

-- 특정 게시글에 대한 즐겨찾기 여부 조회
SELECT * FROM favorite WHERE id = "qwer1234" AND board_number = 3;

-- 즐겨찾기 추가
INSERT INTO favorite VALUES ("qwer1234", 3);

-- 즐겨찾기 삭제
DELETE FROM favorite WHERE id = "qwer1234" AND board_number = 3;

-- 특정 게시글의 댓글 개수 조회
SELECT board_number, COUNT(*) count FROM comment
  WHERE board_number = 3
  GROUP BY board_number;

-- 특정 게시글의 즐겨찾기 개수 조회
SELECT COUNT(*) FROM favorite
WHERE board_number = 3
GROUP BY board_number;

-- 댓글 수와 즐겨찾기 수를 함께 조회
SELECT 
  C.board_number 'board_number',
  C.count 'comment_count',
  F.count 'favorite_count'
FROM 
(
  SELECT board_number, COUNT(*) count FROM comment
  WHERE board_number = 3
  GROUP BY board_number
) C 
LEFT JOIN 
(
  SELECT board_number, COUNT(*) count FROM favorite
  WHERE board_number = 3
  GROUP BY board_number
) F
ON C.board_number = F.board_number;

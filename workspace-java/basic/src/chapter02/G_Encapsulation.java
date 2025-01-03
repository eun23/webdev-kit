package chapter02;

// 캡슐화: 인스턴스 필드와 메서드를 하나로 묶어서 필드에 대한 조작을 메서드를 통해서만 하도록 하는 것
// 정보 은닉과 데이터 보호, 데이터 무결성을 보장할 수 있음

// Entity: 데이터베이스의 레코드를 관리하는 객체
// (생성자와 Getter 만 유지)
// DTO (Data Transfer Object): 데이터 전송을 위한 객체
// (불변성: 생성자와 Getter 만 유지 / 가변성: 생성자와 Getter, Sertter 모두 유지)
// VO (Value Object): 값을 표현하는 객체
// (생성자와 Getter 만 유지, Object 클래스의 equals() 메서드를 오버라이딩 해서 사용)
class Player {
	private String name;
	private String team;
	private String birth;
	private int number;

	Player(String name, String team, String birth, int number) {
		this.name = name;
		this.team = team;
		this.birth = birth;
		this.number = number < 0 ? 0 : number;
	}

	// getter 메서드: 캡슐화에서 private 필드의 값을 반환하는 메서드
	String getName() {
		return name;
	}

	String getTeam() {
		return team;
	}

	String getBirth() {
		return birth;
	}

	int getNumber() {
		return number;
	}

	// setter 메서드: 캡슐화에서 private 필드의 값을 변경하는 메서드
	void setName(String name) {
		this.name = name;
	}

	void setTeam(String team) {
		this.team = team;
	}

	void setNumber(int Number) {
		this.number = number < 0 ? 0 : number;
	}
}

class King {
	private String ho;
	private String name;

	public King(String ho, String name) {
//		super();
		this.ho = ho;
		this.name = name;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class G_Encapsulation {
	public static void main(String[] args) {
//		Player player1 = new Player();
//		player1.name = "최민우";
//		player1.team = "한국";
//		player1.birth = "2000-04-08"; 
//		player1.number = 1;

		Player player1 = new Player("최민우", "한국", "2000-04-08", 1);
		System.out.println(player1.getName());
		System.out.println(player1.getNumber());

		player1.setTeam("부산");
		System.out.println(player1.getTeam());
	}
}

/*
    타입 앨리어스 :
    - 커스텀 타입을 지정하는 방법 (타입의 별칭 지정)
    - type 키워드를 사용
*/
// let day: 'am' | 'pm';
type Day = 'am' | 'pm' | null;
let day1: Day = 'am';

type int = number;
let number: int = 10;

console.log('==================================================');

// 객체 타입 정의하는 방법
// 1. interface 이용
interface IKing {
    name: string;
    ho: string;
    age: number;
}

const iKing: IKing = {
    name: '이성계',
    ho: '태종',
    age: 74
};

// 2. type 이용
type TKing = {
    name: string;
    ho: string;
    age: number;
}

const tKing: TKing = {
    name: '이방과',
    ho: '정종',
    age: 63
}

// 3. class 이용
class CKing {
    constructor(
        public name: string,
        public ho: string,
        public age: number
    ) {}
}

const cKing1: CKing = {
    name: '이방원',
    ho: '태종',
    age: 56
}

const cKing2: CKing = new CKing('이도', '세종', 54);

const king: IKing = tKing;

class C1 {
    constructor(
        public a: number,
        public b: number
    ) {}
}

class C2 {
    constructor(
        public a: number,
        public b: number
    ) {}
}

const ins1: C1 = new C1(10, 20);
const ins2: C2 = ins1;
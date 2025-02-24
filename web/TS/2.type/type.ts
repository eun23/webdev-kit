/*
    타입선언 : 
    - 변수 및 함수에 타입을 지정하여 타입에 대한 제한을 추가할 수 있음
*/
let variable: number;
variable = 10;
// variable = '10';

let number = 10;
// number = '10';

function func1(arg: string, arg2: number): string {
    return '문자열';
}

const func2 = (arg: string): void => {

}

/*
    typescript의 타입
    - string: 문자열
    - number: 숫자
    - boolean: 논리
    - null: null 타입
    - undefined: 정의되지 않음
    - object: 객체
    - array: 배열
    - enum: 열거형
    - void: 반환값 없음
    - any: 모든 타입
*/
const numbers: number[] = [1, 2, 3];
const numbers2: Array<number> = [1, 2, 3];

let str1: string = 'string';
let str2: String = 'String';

str2 = str1;
// str1 = str2;

enum Color {
    RED = '#ff0000',
    GREEN = '#00ff00',
    BLUE = '#0000ff'
}
const color: Color = Color.RED;

let anyType: any = 10;
anyType = '10';

const funcType: (arg: string) => string = (arg: string): string => {
    return '';
}

/*
    타입추론 :
    - 타입을 선언하지 않고 변수에 값이 초기화되는 순간에 초기화된 데이터의 타입으로 결정되는 것
*/
let str = '문자열';
// str = 1234;


/*
    타입 변환 :
    - as 키워드로 형변환 가능 (객체일때 자주 사용), <> 연산자로 형변환 가능
*/
const PI: any = '3.14';
let pi: string = PI as string;
pi = <string>PI;

String(PI);

/*
    유니온 타입
    - 복수의 타입을 지정하는 방법, | 사용
*/
let union: string | number;
union = 10;
union = '10';
// union = false;

const func3 = (): string | number => {
    const a = 0;
    if (a > 0) return '양수';
    else if (a < 0) return '음수';
    else return 0;
};

let obj: {
    name: string,
    age: number
} | null = {
    name: '홍길동',
    age: 30
};

obj = null;

/*
    리터럴 타입
    - 지정한 리터럴만 가질 수 있는 타입
*/
let day: 'am' | 'pm';
day = 'am';
// day = 'AM';
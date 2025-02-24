/*
    암묵적 형변환
*/

/*
    문자열 타입으로 형변환
    - + 문자열 연결 연산자를 사용할 때 좌항이나 우항 중 하나라도 문자열이 존재한다면 문자열이 아닌 항이 문자열로 자동 형변환됨
*/
console.log(1 + '1');


console.log('==============================');

/*
    숫자 타입으로 형변환
    - + 연산자를 제외한 나머지 산술 연속 혹은 대소 비교 연산에 대해서 좌항과 우항 중 하나라도 숫자가 존재하면 숫자가 아닌 항을 숫자로 자동 형변환
*/
console.log(1 - '1');


console.log('==============================');

/*
    불리언 타입으로 형변환
    - '', 0, -0, NaN, null, undefined는 false, 나머지는 true로 자동 형변환
    - ! 피연산자가 논리값이 아니면 논리값으로 자동 형변환
*/
var x = null;
if (x) {
    console.log('is not null');
} else {
    console.log('is null');
}



console.log('==============================');

/*
    명시적 형변환
*/

/*
    문자열 타입으로 형변환
    - String 클래스의 생성자 함수를 사용 (new 연산자 없이)
    - 데이터.toString()
*/
var number = 10;
console.log(String(number), typeof String(number));
console.log(number.toString(), typeof number.toString());

console.log('==============================');

/*
    숫자 타입으로 형변환
    - Number 클래스의 생성자 함수를 사용 (new 연산자 없이)
    - 문자열일 경우 parseInt(문자열), parseFloat(문자열) 함수를 이용하여 형변환 가능
*/
var str = '10.5';
console.log(Number(str), typeof Number(str));
console.log(parseInt(str), typeof parseInt(str));


console.log('==============================');

/*
    불리언 타입으로 형변환
    - Boolean 클래스의 생성자 함수를 사용 (new 연산자 없이)
*/
var str = '문자열';
console.log(Boolean(str), typeof Boolean(str));


console.log('==============================');

/*
    단축 평가 
    - 논리 연산자는 논리 결과를 결정하는 피연산자의 값을 그대로 반환
    - true && data => data
    - false && data => false
    - true || data => true
    - false || data => data
*/


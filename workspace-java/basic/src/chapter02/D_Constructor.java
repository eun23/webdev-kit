package chapter02;

// 생성자(Constructor): 클래스의 인스턴스가 생성되는 순간에 호출되는 메서드
// 클래스와 같은 이름을 가짐, 반환타입이 존재하지 않음
// 클래스명(매개변수, ...) { 인스턴스가 생성될 때 수행할 작업 }
class Human1 {
	String name;
	int age;
	String gender;

	// final로 선언된 인스턴스 변수는 생성자에서 반드시 초기화 해야한다.
	// 즉, 필수 값 (required)
	final String address;

	int[] numbers;

	// 만약 다른 생성자(매개변수가 존재하는 생성자)만 존재한다면
	// 기본 생성자는 자동으로 생성되지 않음
	Human1() {
		// this(): 클래스의 다른 생성자를 호출하는 키워드
		// 반드시 생성자에서만 사용 가능
		// 생성자의 제일 첫 구문으로 들어와야함
		this("홍길동");

		// 1. 인스턴스를 생성할 때 특정 작업을 수행하고 싶을 때
		System.out.println("Human1의 인스턴스가 생성됩니다.");

		// 2. *인스턴스를 생성과 동시에 인스턴스 변수를 초기화하고 싶을 때
		// 의존성을 내부에서 주입하는 행위
		name = "홍길동";
		age = 20;
		gender = "남";
//		address = "부산";
	}

	Human1(String name) {
		// this: 현재 자기 자신의 인스턴스를 지칭하는 키워드
		// 인스턴스 변수나 인스턴스 메서드를 정확히 지칭할 때 사용됨
		this.name = name;
		age = 20;
		gender = "여";
		address = "부산";
	}

	Human1(String name1, int age1, String gender1) {
		// 의존성을 모두 외부에서 주입하는 행위
		name = name1;
		age = age1;
		gender = gender1;
		address = "부산";
		numbers = new int[] { 1, 2, 3 };
	}

	Human1(Human1 human1) {
		name = human1.name;
		age = human1.age;
		gender = human1.gender;
		address = human1.address;
		numbers = human1.numbers;
	}

}

public class D_Constructor {
	public static void main(String[] args) {
		// 만얀 클래스에 생성자를 정의하지 않으면
		// 컴파일러가 자동으로 기본 생성자를 제공함
		Human1 human1 = new Human1();
		human1.name = "eun";
		human1.age = 25;
		human1.gender = "여";

		Human1 human2 = new Human1();
		System.out.println(human2.name);

		Human1 human3 = new Human1("eun");
		System.out.println(human3.name);

		Human1 human4 = new Human1("민우", 26, "남");
		System.out.println(human4.name);
		System.out.println(human4.age);
		System.out.println(human4.gender);

		// 주소만 복사되는 형태 (독립적이지 않음)
		Human1 human5 = human4;
		// 새로운 주소를 생성해서 값을 복사하는 형태 (독립적)
		Human1 human6 = new Human1(human4);

		human4.numbers[0] = 99;
		System.out.println(human4.numbers[0]);
		System.out.println(human6.numbers[0]);
	}
}

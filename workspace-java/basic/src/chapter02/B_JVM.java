package chapter02;

// JVM: 자바 가상 기계
// 실제 컴파일된 코드를 실행하는 기계
// 별도의 메모리 구조를 가짐

// Method Area (메서드 영역)
// : 모든 곳에서 접근 가능한 영역, 코드를 읽고 각 클래스의 구조를 저장하고 있음

// Heap Area (힙 영역)
// : 모든 곳에서 접근 가능한 영역, 인스턴스 혹은 배열과 같은 new 연산자를 통해 생성된 객체들이 저장되는 영역

// Stack Area (스택 영역)
// : 각 스레드(실행중인 프로세스) 별로 독립적으로 존재하는 영역, 메서드 호출과 로컬 변수에 대한 정보가 저장됨
// 각 코드블럭마다 하나의 스택이 생성됨

class EC2 {
	int iv;
	static int cv;

	void im() {
		int lv = 10;
		EC2 itc = new EC2();
	}

	static void cm() {
		int clv = 10;
	}
}

public class B_JVM {
	static void method1(int arg) {
		arg++;
	}

	static void method2(EC2 arg) {
		arg.iv++;
	}

	public static void main(String[] args) {
		int lv1 = 20;
		double lv2 = 3.5;

		if (lv1 > 0) {
			int cb = 30;
			lv1 = cb;
		}

		EC2 itc1 = new EC2();
		EC2 itc2 = new EC2();

		itc1.iv = 10;
		itc2.iv = -99;

		itc1.cv = 3000;

		itc1.im();

		int a = 99;
		method1(a);
		System.out.println(a);

		EC2 b = new EC2();
		b.iv = 99;
		method2(b);
		System.out.println(b.iv);
	}
}

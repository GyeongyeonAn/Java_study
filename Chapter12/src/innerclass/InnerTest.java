package innerclass;

import innerclass.OutClass.InStaticClass;

class OutClass {
	
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;
	
	public OutClass() {
		inClass = new InClass();
	}
	
	private class InClass {
		int iNum = 100;
		
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
		}
	}
	
	public void usingInner() {
		inClass.inTest();
	}
	
	// static이기 때문에 OutClass 생성 여부와 상관없이 사용 가능하다.
	static class InStaticClass {
		int inNum = 100;
		static int sInNum = 200;
		
		// InStaticClass를 생성해야 호출할 수 있다.
		void inTest() {
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
		// 스태틱 메서드 안에는 스태틱 변수만 사용한다.
		// InStaticClass를 생성하지 않아도 사용할 수 있다.
		static void sTest() {
			System.out.println(sInNum);
			System.out.println(sNum);
		}
	}
}

public class InnerTest {

	public static void main(String[] args) {

		OutClass outClass = new OutClass();
		outClass.usingInner();
		
		System.out.println();
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();
		OutClass.InStaticClass.sTest();
	}

}

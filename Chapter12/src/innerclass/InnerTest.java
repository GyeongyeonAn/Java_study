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
	
	// static�̱� ������ OutClass ���� ���ο� ������� ��� �����ϴ�.
	static class InStaticClass {
		int inNum = 100;
		static int sInNum = 200;
		
		// InStaticClass�� �����ؾ� ȣ���� �� �ִ�.
		void inTest() {
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
		// ����ƽ �޼��� �ȿ��� ����ƽ ������ ����Ѵ�.
		// InStaticClass�� �������� �ʾƵ� ����� �� �ִ�.
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
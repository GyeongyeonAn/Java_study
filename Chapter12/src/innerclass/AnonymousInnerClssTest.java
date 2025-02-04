package innerclass;

class Outer2 {
	
	int outNum = 100;
	static int sNum = 200;
	
	// 익명 Inner 클래스  <<< 가장 많이 사용한다.
	Runnable getRunnable(int i) {
		
		int num = 100;
		return new Runnable() {

			@Override
			public void run() {
				
				System.out.println(num);
				System.out.println(i);
				System.out.println(outNum);
				System.out.println(Outer.sNum);
				
			}
		};
	}
	
	// 익명 Inner 클래스  <<< 가장 많이 사용한다.
	// 안드로이드 앱에서 클릭하고 핸들링 처리하는 것들 모두 이렇게 만든다.
	Runnable runner = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("test");
		}
	};
}

public class AnonymousInnerClssTest {

	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		outer.runner.run();
		
		Runnable runnable = outer.getRunnable(50);
		
		runnable.run();
	}
}

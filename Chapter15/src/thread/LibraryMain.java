package thread;

import java.util.ArrayList;

// Critical Section
class FastLibrary{
	
	public ArrayList<String> books = new ArrayList<String>();
	
	public FastLibrary() {
		books.add("�¹� ��� 1");
		books.add("�¹� ��� 2");
		books.add("�¹� ��� 3");
	}
	
	public synchronized String lendBook() throws InterruptedException {
	
		// ���� �������� �����带 ��ȯ�Ѵ�.
		Thread t = Thread.currentThread();
		
		// notifyAll�� ��� �����带 �������Ƿ� 
		// �ٽ� wait �ؾ� �ϴ� �����带 wait ��Ų��.
		while(books.size() == 0) {
			System.out.println(t.getName() + " waiting start");
			wait();
			System.out.println(t.getName() + " waiting end");
		}
		
		String title = books.remove(0);
		System.out.println(t.getName() + ": " + title + " lend");
		return title;
	}
	
	public synchronized void returnBook(String title) {
		
		Thread t = Thread.currentThread();
		books.add(title);
		// �� ������ ����� ��� �����带 ����� ���̴�.
		notifyAll();
		System.out.println(t.getName() + ": " + title + " return");
	}
}

class Student extends Thread{
	public void run() {
				
		try {
			String title = LibraryMain.library.lendBook();
			if(title == null) return;
			sleep(5000);
			LibraryMain.library.returnBook(title);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


public class LibraryMain {

	public static FastLibrary library = new FastLibrary();
	public static void main(String[] args) {

		Student std1 = new Student();
		Student std2 = new Student();
		Student std3 = new Student();
		Student std4 = new Student();
		Student std5 = new Student();
		Student std6 = new Student();
		
		std1.start();
		std2.start();
		std3.start();
		std4.start();
		std5.start();
		std6.start();
		
	}

}
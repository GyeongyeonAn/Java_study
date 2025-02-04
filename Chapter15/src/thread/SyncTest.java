package thread;

// Bank = Critical Section
class Bank {
	private int money = 10000;
	
	public int getMoney() {
		return money;
	}

	public  void setMoney(int money) {
		this.money = money;
	}

	public void saveMoney(int save) {
		// synchronized 블럭 방식 
		synchronized(this) {
			int m = this.getMoney();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			setMoney(m + save);
		}
	}
	
	// synchronized 메서드 방식
	public synchronized void minusMoney(int minus) {
		
		int m = this.getMoney();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		setMoney(m - minus);
		
	}
	
}

class Park extends Thread {
	
	public void run() {
		synchronized (SyncTest.myBank) {
			System.out.println("Start save");
			SyncTest.myBank.saveMoney(3000);
			System.out.println("save money: " + SyncTest.myBank.getMoney());
		}
	}
}

class ParkWife extends Thread{
	
	public void run() {
		synchronized (SyncTest.myBank) {
			System.out.println("Start minus");
			SyncTest.myBank.minusMoney(1000);
			System.out.println("minus money: " + SyncTest.myBank.getMoney());
		}
	}
}

public class SyncTest {

	public static Bank myBank = new Bank();
	
	public static void main(String[] args) throws InterruptedException {

		Park p = new Park();
		p.start();
		
		ParkWife pw = new ParkWife();
		pw.start();
		
		
	}
}

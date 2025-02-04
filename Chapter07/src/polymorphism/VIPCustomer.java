package polymorphism;

public class VIPCustomer extends Customer{

	double salseRatio;
	private int agentID;
	
	/*
	public VIPCustomer() {
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salseRatio = 0.1;
		
		System.out.println("VIPCustomer() 생성자 호출");

	}*/
		
	public VIPCustomer(int customerID, String customerName) {
		
		super(customerID, customerName);
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		salseRatio = 0.1;
		System.out.println("VIPCustomer(int, String) 생성자 호출");

	}

	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salseRatio);
	}
	
	
}

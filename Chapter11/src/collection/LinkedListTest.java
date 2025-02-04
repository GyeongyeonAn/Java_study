package collection;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<String> myList = new LinkedList<String>();
		
		myList.add("A");
		myList.add("B");
		myList.add("C");
		
		// 기본적으로 toString이 만들어져 있음.
		System.out.println(myList);
		
		// 원하는 위치에 삽입 가능
		myList.add(1, "D");
		System.out.println(myList);

		myList.removeLast();
		System.out.println(myList);
		
		for(int i=0; i<myList.size(); i++) {
			String s = myList.get(i);
			System.out.println(s);
		}
	}

}

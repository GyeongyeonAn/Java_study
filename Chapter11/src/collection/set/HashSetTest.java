package collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<String>();
		set.add("이순신");
		set.add("김유신");
		set.add("강감찬");
		set.add("이순신");
		
		
		// 순서대로 출력되는 것이 아님, 중복도 허용되지 않음.
		System.out.println(set);
		
		// 순서대로 하나씩 꺼내오고 싶다면 iterator를 사용한다.
		Iterator<String> ir = set.iterator();
		
		while(ir.hasNext()) {
			String str = ir.next();
			System.out.println(str);
		}
		
	}

}

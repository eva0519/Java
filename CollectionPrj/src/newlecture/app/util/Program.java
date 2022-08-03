package newlecture.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(7);
		list.add(7);
		System.out.println(list.get(5));
		System.out.println(list.size());
		// 중복 가능, 가변길이 배열이 필요할 때 사용
		
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(7);
		set.add(7);
		System.out.println(set.add(7));
		System.out.println(set.size());
		System.out.println(set.add(8));
		System.out.println(set.size());
		// 중복 불가능, return 값으로 boolean 반환
		// true의 경우 데이터 set
		// 식별자와 값이 같기에 특정값을 꺼낼 일이 없다.
		// 로또 복권 등의 중복값을 제거하기 위해 사용.
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", 3);
		map.put("title", "hello");
		map.put("hit", 12);
		System.out.println(map.get("title"));
		
	}

}

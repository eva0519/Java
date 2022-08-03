package newlecture.app.util;

public class Program {

	public static void main(String[] args) {
		
		GList<Integer> list = new GList<>();
		list.add(3);
		list.add(5);
		int size = list.size();
		System.out.printf("size : %d\n", size);

		list.clear();
		size = list.size();
		System.out.printf("size : %d\n", size);
		
		list.add(7);
		int num = list.get(0);
		// 제너릭 사용중이므로 (Integer) 형변환이 필요없다
		System.out.printf("num : %d\n", num);
		
	}

}

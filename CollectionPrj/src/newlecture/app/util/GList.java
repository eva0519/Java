package newlecture.app.util;

public class GList<T> {
	// generic은 무엇이든 될 수 있지만 기본은 Object
	// generic 임을 매개변수처럼 넣어줌 <T> | <T, T2>
	// 여러 형식을 넣을 수 있고 매개변수 같기에 이름도 바꿔줄수있다
	// 레퍼런스 형태의 타입참조만 가능 int 같은 값은 안됨

	private Object[] nums;
	private int current;
	private int capacity;
	private int amount;

	public GList() {
		current = 0;
		capacity = 3;
		amount = 5;
		nums = new Object[capacity];
		// 기본은 Object이기에 제너릭은 레퍼런스를 주고 받는 부분에만 사용가능
	}

	// 제너릭으로 들어옴
	// 지금같은 경우는 Integer 정수형참조형식
	public void add(T num) {

		if (capacity == current) {
			Object[] temp = new Object[capacity + amount];
			for (int i = 0; i < current; i++) {
				temp[i] = nums[i];
			}
			nums = temp;
			capacity += amount;
		}
		
		nums[current] = num;
		current++;
	}

	public int size() {

		return current;
	}

	public void clear() {
//		for(int i = 0; i<current; i++)
//			nums[i] = 0;
//		nums = new int[3];
		current = 0;
	}

	// 제너릭으로 내보냄
	public T get(int index) {
		if (current <= index)
			throw new IndexOutOfBoundsException();

		return (T) nums[index];
		// 리턴 형식에 맞게 타입캐스팅
	}

}

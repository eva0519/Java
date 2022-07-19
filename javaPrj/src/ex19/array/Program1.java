package ex19.array;

public class Program1 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		for (int i = 0; i < 7; i++)
			System.out.printf("%d", nums[i]);

		int[] temp = new int[10];

		for (int i = 0; i < 7; i++) {
			temp[i] = nums[i];
		}

		nums = temp;
		// 배열 확장 이동
		
		nums[7] = 8;

		for (int i = 0; i < 8; i++)
			System.out.printf("%d", nums[i]);

	}

}

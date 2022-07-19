package ex19.array;

public class Program4 {

	public static void main(String[] args) {

		int[] nums = {2,3,6,4,1,5};
		
		for (int i = 0; i < nums.length; i++)
			System.out.printf("%d", nums[i]);
		
		System.out.println();
		
		int temp;
		temp = nums[1];
		nums[1] = nums[3];
		nums[3] = temp;
		// 배열 값 이동
		
		for (int i = 0; i < nums.length; i++) 
			System.out.printf("%d", nums[i]);
		
		
	}

}

package ex19.array;

public class Program2 {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 4, 5, 6 };
		int[] nums = new int[6];

		for (int i = 0; i < nums1.length; i++)
			nums[i] = nums1[i];

		for (int i = 0; i < nums2.length; i++)
			nums[i + nums1.length] = nums2[i];
		// 배열 합치기
		
		for (int i=0; i<nums.length;i++)
			System.out.printf("%d", nums[i]);
		
	}

}

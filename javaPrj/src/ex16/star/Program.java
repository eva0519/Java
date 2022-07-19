package ex16.star;

public class Program {

	public static void main(String[] args) {
		
		final int MAX_STAR = 10;
		
		// 정사각
		
		for (int j=0;j<MAX_STAR;j++) {
			for (int i = 0; i < MAX_STAR; i++)
				System.out.printf("%c", '☆');
			
			System.out.println();
		}
		
		System.out.println();

		// 삼각
		
		for (int j=0;j<MAX_STAR;j++) {
			for (int i = 0; i < j+1; i++)
				System.out.printf("%c", '☆');
			
			System.out.println();
		}
		
		System.out.println();
		
		// 역삼각

		for (int j=0;j<MAX_STAR;j++) {
			for (int i = 0; i < MAX_STAR-j; i++)
				System.out.printf("%c", '☆');
			
			System.out.println();
		}
		
	}

}

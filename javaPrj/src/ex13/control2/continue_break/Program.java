package ex13.control2.continue_break;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int n = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print("값을 sp로 구분해서 5개 이상 입력하세요:");
		
//		n = scan.nextInt(); 
		// 3 enter, 34 5 6 234 345 54 45 enter
		// next는 위처럼 입력시 스페이스를 구분자로 해서 하나씩만 읽어온다.

		// hasNext 입력버퍼에 대기중인것이 있을 경우 true를 반환한다.
		while (scan.hasNext()) {
			n = scan.nextInt();
			
			if(n < 10)
				continue;
			
			if(n > 300)
				break;
			
			System.out.println(n);
		}
	}
}

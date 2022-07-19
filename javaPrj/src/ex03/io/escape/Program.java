package ex03.io.escape;
public class Program {

	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		float avg;

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

		total = kor1 + kor2 + kor3;
		avg = total / 3;
		
		/* 이스케이프 문자 */
		// \b   백스페이스
		// \t	수평 탭
		// \n	새 행
		// \f	폼피드(다음 페이지로 -도트프린트 등 사용할 때)
		// \r	캐리지리턴(제일왼쪽위치로 -파일입출력시 사용)
		// \'	홑 따옴표
		// \"	이중 따옴표
		// \\	역슬래쉬
	
		// System.out.println 출력 후 자동 개행 (\n 쓸 필요 x)
		// 프린트라인
		
		System.out.println("┌───────────────────┐");
		System.out.println("│      성적 출력      │");
		System.out.println("└───────────────────┘");
		
		System.out.println("\t국어1 : 0");
		System.out.println("\t국어2 : 0");
		System.out.println("\t국어3 : 0");
		System.out.println("\t총점 : 0");
		System.out.println("\t평균 : 0.00");
		System.out.println("─────────────────────");
		
	}

}


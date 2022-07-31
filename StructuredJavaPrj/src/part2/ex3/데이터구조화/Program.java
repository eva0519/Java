package part2.ex3.데이터구조화;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

//		Exam[] exams = new Exam[3]; 
//		// 객체참조배열 3개 생성. 객체를 만든건 아니다. 이름만 정해주고 NULL 값이 들어있다.
//		exams[0] = new Exam(); // 객체참조배열 0번에 객체 생성.
//		exams[0].kor = 30; // 이렇게 해야 값을 넣을 수 있다.
//		System.out.printf("kor:%d", exams[0].kor);

		Exam[] exams = new Exam[3];

		int menu;
		boolean keepLoop = true;

		while (keepLoop) {

			menu = inputMenu();

			switch (menu) {
			case 1:
				inputList(exams);
				break;
			case 2:
				if (exams[0] == null) {
					System.out.println("입력된 값이 없습니다.");
					continue;
				} else
					printList(exams);
				// 사용자가 출력부터 누를 경우의 처리. 입력에서 객체를 생성하기에
				// 객체참조배열만 있고 객체는 없기에 돌려보낸다.
				break;
			case 3:
				System.out.println("Bye~~");
				keepLoop = false;
				break;
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}

	}

	private static void printList(Exam[] exams) {

		for (int i = 0; i < 3; i++) {
			System.out.println("┌──────────────────┐");
			System.out.println("│     성적 출력      │");
			System.out.println("└──────────────────┘");
			System.out.println();

			Exam exam = exams[i];
			// 임시 변수에 매개변수로 받아온 객체배열 대입
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			int total = kor + eng + math;
			float avg = total / 3.0f;

			System.out.printf("국어 : %d\n", kor);
			System.out.printf("영어 : %d\n", eng);
			System.out.printf("수학 : %d\n", math);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	private static void inputList(Exam[] exams) {

		Scanner scan = new Scanner(System.in);

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력      │");
		System.out.println("└──────────────────┘");
		System.out.println();

		for (int i = 0; i < 3; i++) {
			int kor, eng, math;

			do {
				System.out.printf("국어 : ");
				kor = scan.nextInt();

				if (kor < 0 || 100 < kor) {
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			} while (kor < 0 || 100 < kor);

			do {
				System.out.printf("영어 : ");
				eng = scan.nextInt();

				if (eng < 0 || 100 < eng) {
					System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			} while (eng < 0 || 100 < eng);

			do {
				System.out.printf("수학 : ");
				math = scan.nextInt();

				if (math < 0 || 100 < math) {
					System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			} while (math < 0 || 100 < math);

			Exam exam = new Exam(); // 임시 변수 생성 후 객체 생성
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;

			exams[i] = exam;
			// 매개변수로 받아온 라벨만 있는 객체참조배열에 임시 변수값 대입
		}

	}

	static int inputMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("┌──────────────────┐");
		System.out.println("│     메인 메뉴      │");
		System.out.println("└──────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		int menu = scan.nextInt();

		return menu;
	}

}

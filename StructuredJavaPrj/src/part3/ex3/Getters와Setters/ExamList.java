package part3.ex3.Getters와Setters;

import java.util.Scanner;

public class ExamList {
	private Exam[] exams;
	private int current;
	// 판단이 힘들 때 구조체는 private
	// 서비스 함수는 public이 기본이라는 느낌으로
	
	public void printList() {
		this.printList(this.current);
		// this는 무조건 받으므로 지워서 써도 됨
		// 식별이 필요한 경우 붙여줌.
	}
	
	public void printList(int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력      │");
		System.out.println("└──────────────────┘");
		System.out.println();

		Exam[] exams = this.exams;

		for (int i = 0; i < size; i++) {
			Exam exam = exams[i];
			int kor = exam.getKor(); // exam.kor;
			int eng = exam.getEng(); // exam.eng;
			int math = exam.getMath(); // exam.math;

			int total = exam.total(); // kor + eng + math;
			float avg = exam.avg(); // total / 3.0f;

			System.out.printf("국어 : %d\n", kor);
			System.out.printf("영어 : %d\n", eng);
			System.out.printf("수학 : %d\n", math);
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	public void inputList() {

		Scanner scan = new Scanner(System.in);

		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력      │");
		System.out.println("└──────────────────┘");
		System.out.println();

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

//		Exam exam = new Exam();
//		exam.setKor(kor); // exam.kor = kor;
//		exam.setEng(eng); // exam.eng = eng;
//		exam.setMath(math); // exam.math = math;
		
		Exam exam = new Exam(kor, eng, math);

		Exam[] exams = this.exams;
		int size = this.current;

		if (exams.length == size) {
			Exam[] temp = new Exam[size + 5];
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
				this.exams = temp;
			}
			
		}

		this.exams[this.current] = exam;
		this.current++;

	}

	public ExamList() {
		exams = new Exam[3];
		current = 0;
		// this.current = 0;
		// this는 무조건 받으므로 지워서 써도 됨
	}
}

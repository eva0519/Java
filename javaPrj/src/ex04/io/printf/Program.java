package ex04.io.printf;
public class Program {

	public static void main(String[] args) {

		int kor1, kor2, kor3;
		int total;
		float avg;

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

		total = kor1 + kor2 + kor3;
		avg = total / 3.0f;
		// 같은 타입끼리만 계산이 가능하기 때문에 3으로 나누면 평균은 실수가 아닌 정수가 된다
		// avg 변수는 float 타입이고 total은 3.0f로 나누면 float으로 묵시적 형변환이 되기에 
		// 3이 아닌 3.0f로 나누어준다

		// 포멧문자열과 형식지정자
		// %d	정수(10진수)	("%5d",29)			29
		// %x	정수(16진수)	("%x %x",29,32)		1D 20
		// %o	정수(8진수)	("%o",29)			35
		// %f	실수			("%7.2f",874.9163)	874.92
		// %e	지수형 실수	("%e",874.9163)		8.749163e+02
		// %c	문자			("%c",'Y')			Y
		// %s	문자열		("%10s","Hi")		Hi
		
		// 형식지정자 옵션
		// %	Begin Format Specifier
		// 1$	Argument Index				삽입인자 변경
		// +0	Flags						공간할당
		// 20	Width						공간할당
		// .10	Percision					실수공간할당(정확성)
		// f	Conversion
		
		// System.out.printf("%5.2\n", 87.98953231); 
		// 소수점포함 5개의 공간을 사용하고 소수점 밑 2자리까지 출력
		
		// System.out.printf("%d-%d-%d", 2013, 07, 23);
		// 포멧팅 문자열을 효율적으로 만들기 위해 사용
		
		System.out.println("┌───────────────────┐");
		System.out.println("│      성적 출력      │");
		System.out.println("└───────────────────┘");
		
		System.out.printf("%d %d %d\n", 1,2,3);
		System.out.printf("%3$d %1$d %2$d\n", 1,2,3);
		System.out.printf("%1$d %1$d %1$d\n", 2);
		// 형식지정자로 인자를 제어하면 인자를 하나만 넣어도 사용할 수 있다
		
		System.out.printf("\t국어1 : %3d\n", kor1);
		System.out.printf("\t국어2 : %3d\n", kor2);
		System.out.printf("\t국어3 : %3d\n", kor3);
		System.out.printf("\t총점 : %3d\n", total);
		System.out.printf("\t평균 : %6.2f\n", avg);
		System.out.println("─────────────────────");
		
	}

}


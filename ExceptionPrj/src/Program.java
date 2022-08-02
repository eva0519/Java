
public class Program {

	public static void main(String[] args) {

		Calculator calc = new Calculator();
		// 매번 계산에 필요한 인자가 달라질 가능성이 높으므로
		// 인스턴스 함수가 아닌 static 함수로 만드는게 낫다
		
		int result = 0;
		
		try {
			result = Calculator.add(3, 1);
			System.out.printf("add : %d\n", result);
			result = Calculator.sub(3, 4);
		} 
		catch (OverThousand e) {
//			System.out.println(e.getMessage());
			System.out.println("특화된 처리");
		}
		catch (Exception e) {
			System.out.println("음수 처리");
		}
		finally {
			System.out.println("입력 값에 오류가 있습니다.");
			// finally는 마지막에 항상 실행됨
		}
		
		System.out.printf("sub : %d\n", result);
		result = Calculator.multi(3, 4);
		System.out.printf("multi : %d\n", result);
		// UnChecked 예외
		result = Calculator.div(3, 0);
		System.out.printf("div : %d\n", result);
	}
}

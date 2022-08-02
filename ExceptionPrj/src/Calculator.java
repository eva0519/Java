
public class Calculator {

	public Calculator() {
	}

	public static int add(int x, int y) throws OverThousand, NegativeInt {
		
		int result = x + y;
		
		if (result > 1000)
			throw new OverThousand();
		if (result < 0)
			throw new NegativeInt();
		
		return result;
	}

	public static int sub(int x, int y) throws NegativeInt {
		
		int result = x - y;
		
		if (result < 0)
			throw new NegativeInt();
		
		return result;
	}

	public static int multi(int x, int y) {
		return x * y;
	}

	public static int div(int x, int y) {
		return x / y;
	}

}

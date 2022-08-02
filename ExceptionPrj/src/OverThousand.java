
public class OverThousand extends RuntimeException {
	// Exception 상속이 아닌 RuntimeException 상속을 하면
	// 일일히 throws 해주지 않아도 알아서 메인 함수 밖 런타임까지 던져준다
	// UnChecked 예외로 처리됨
	
	@Override
	public String getMessage() {
		return "합이 천을 넘는 값을 입력하셨습니다";
	}
}

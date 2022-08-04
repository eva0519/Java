package part2;

public class Ex2Program_monitor_critical_section {

	public static void main(String[] args) {
		
		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				print();
			}
		};
		
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(subMain);
		th3.setName("sub3");
		
		th1.start();
		th2.start();
		th3.start();
		
		Thread th = Thread.currentThread();
		th.setName("Main");
//		print();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("=== Exit ===");
	}
	
	static Object LockIndex = new Object(); // critical section 잠금용 객체
	static int gIndex = 0; // 데이터/정적

	private static void print() {
		
		int index = 0;	// 스택
		
		Thread th = Thread.currentThread();
		
		for (int i = 0; i < 100; i++) {
			
			if (th.isInterrupted()) {
				System.err.println("요청이 들어와서 종료");
				return;
			}
				
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("자다가 깨서 스레드를 종료함");
				return;
			}
			
			synchronized (LockIndex) {
				
				index++;
				gIndex++;
				
				System.out.printf("%s[%d] : %d, index:%d, gIndex:%d\n", th.getName(), th.getId(), i+1, index, gIndex);
			}
		}
	}
}

package part1;

public class Ex6Program_interrupt {

	public static void main(String[] args) {

		Thread th = Thread.currentThread();
		th.setName("Main");

		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				System.out.printf("%s : %s\n", th.getName(), th.getState());
				print();
				System.out.printf("%s : %s\n", th.getName(), th.getState());
			}
		};

		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		
		th1.start();
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());

//		print();
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		
		if (th1.isAlive()) {
			try {
				th1.join(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			th1.interrupt();
		}

		System.out.println("======= Main Exit =======");

	}

	private static void print() {

		Thread th = Thread.currentThread();

		for (int i = 0; i < 100000000; i++) {

			try {
				Thread.sleep(200000000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
				System.out.println("누가 날 깨운거야?");
				return;
			}
			
			if(th.isInterrupted()) {
				System.out.println("------ Th Interrupted ------");
				return;
			}
			
			if (th.getName().equals("Main"))
				System.out.printf("<%s[%d] : %d>\n", th.getName(), th.getId(), i + 1);
			else
				System.out.printf("%s[%d] : %d\n", th.getName(), th.getId(), i + 1);
		}
	}
}

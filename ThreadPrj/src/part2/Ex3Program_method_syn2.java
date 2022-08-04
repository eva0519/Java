package part2;

import java.sql.Timestamp;

public class Ex3Program_method_syn2 {

	public static void main(String[] args) {
		
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		System.out.println(time1);
		
		CharList list = new CharList();
		
		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 80; i++)
					list.printNext();					
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
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Timestamp time2 = new Timestamp(System.currentTimeMillis());
		System.out.println(time2);
		System.out.println(time2.getTime()-time1.getTime());
		
		System.out.println("=== Exit ===");
	}
	
}

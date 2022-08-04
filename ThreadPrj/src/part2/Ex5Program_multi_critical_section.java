package part2;

import java.sql.Timestamp;

public class Ex5Program_multi_critical_section {

	public static void main(String[] args) throws InterruptedException {
		
		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		
		CharList3 list = new CharList3();
		
		Runnable subLoad = new Runnable() {
			@Override
			public void run() {
				list.load();					
			}
		};
		
		Runnable subPrintAll = new Runnable() {
			@Override
			public void run() {
				list.printAll(100);					
			}
		};
		
		Thread th1 = new Thread(subLoad);
		th1.setName("sub1");
		Thread th2 = new Thread(subPrintAll);
		th2.setName("sub2");
		Thread th3 = new Thread(subPrintAll);
		th3.setName("sub3");
		
		th1.start();
		
		Thread.sleep(30);
		
		th2.start();
		th3.start();
		
		Thread th = Thread.currentThread();
		th.setName("Main");
//		print();
		
		try {
			Thread.sleep(20);
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
		System.out.println(time2.getTime()-time1.getTime());
		
		System.out.println("=== Exit ===");
	}
	
}

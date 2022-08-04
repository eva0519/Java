package part2;

import java.util.concurrent.locks.ReentrantLock;

public class CharList2 {

	private char[] list;
	private int index;
	private ReentrantLock indexLock;

	public CharList2() {
		indexLock = new ReentrantLock();

		list = new char[240];
		for (int i = 0; i < 240; i++) {
			list[i] = (char)i;
		}
		
		index = 0;
	}

	public void printNext() {
		
		Thread th = Thread.currentThread();
		
		char ch = list[index];
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			return;
		}
		
		boolean aquired = indexLock.tryLock();
		
//		indexLock.lock();
//		synchronized (indexLock) {
//		}
		if(aquired) {
			System.out.printf("%s[%d] : index:%d, char:%c\n", 
					th.getName(), th.getId(), index, list[index]);
			index++;
			indexLock.unlock();
		} 
		else {
			System.out.printf("%s[%d] : alternate ...\n", 
					th.getName(), th.getId());
		}
					
	}
	
}

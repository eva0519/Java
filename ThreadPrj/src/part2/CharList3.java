package part2;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CharList3 {

	private char[] list;
	private ReentrantReadWriteLock listLock;
	private int index;
	private ReentrantLock indexLock;

	public CharList3() {
		listLock = new ReentrantReadWriteLock();
		indexLock = new ReentrantLock();
		list = new char[240];
		index = 0;
	}

	public void load() {

		Thread th = Thread.currentThread();

		listLock.writeLock().lock();

		for (int i = 0; i < 26; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list[i] = (char) ('A' + i);
		}
		System.out.printf("%s[%d] : loaded\n", th.getName(), th.getId());
		listLock.writeLock().unlock();
	}

	public void printAll(int count) {

		Thread th = Thread.currentThread();

		listLock.readLock().lock();
		for (int i = 0; i < count; i++) {
			
			StringBuilder builder = new StringBuilder();
			builder.append(list);

			System.out.printf("%s[%d-%d] : %s\n", th.getName(), th.getId(), ++index, builder.toString());
		}
		listLock.readLock().unlock();
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
		if (aquired) {
			System.out.printf("%s[%d] : index:%d, char:%c\n", th.getName(), th.getId(), index, list[index]);
			index++;
			indexLock.unlock();
		} else {
			System.out.printf("%s[%d] : alternate ...\n", th.getName(), th.getId());
		}

	}

}

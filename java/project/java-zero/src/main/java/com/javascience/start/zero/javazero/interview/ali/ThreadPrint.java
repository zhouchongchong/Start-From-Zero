package com.javascience.start.zero.javazero.interview.ali;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zhouchong
 * Created by 76409 on 9:47 2020/5/28.
 * @Description:
 */
public class ThreadPrint {
	private static volatile int count = 0;
	private static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		String[] words = {"a", "l", "i"};
		Long timeStart = System.currentTimeMillis();
		for (int i = 0; i < 3; i++) {
			new Thread(new Print(words[i], i, countDownLatch, 1000)).start();
		}
		countDownLatch.await();
		System.out.println("");
		System.out.println("consume time:" + (System.currentTimeMillis() - timeStart));

	}

	static class Print implements Runnable {
		private String printWord;
		private int flag;
		private CountDownLatch countDownLatch;
		private long printNumber;

		public Print(String printWord, int flag, CountDownLatch countDownLatch, int num) {
			this.printWord = printWord;
			this.flag = flag;
			this.countDownLatch = countDownLatch;
			this.printNumber = num;
		}


		@Override
		public void run() {
			for (int i = 0; i < printNumber; ) {
				synchronized (lock) {
					try {
						if (count == flag) {
							System.out.print(printWord);
							count = ++count % 3;
							i++;
							lock.notifyAll();
						} else {
							lock.wait();
						}
					} catch (InterruptedException e) {
						System.out.println(e.getCause());
					}

				}
			}
			countDownLatch.countDown();
		}
	}
}

package com.javascience.start.zero.javazero.interview.ali;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zhouchong
 * Created by 76409 on 14:15 2020/5/28.
 * @Description:
 */
public class ThreadPrint2 {
	private static String[] strs = {"a", "l", "i"};
	private static String[] plocks = {"i", "a", "l"};

	public static void main(String[] args) throws InterruptedException {
		long t = System.currentTimeMillis();
		for (int i = 0; i < 3; i++) {
			// a i = l a
			// l a = i l
			// i l = a i
			new Thread(new Print(strs[i], plocks[i])).start();
		}
		System.out.println(System.currentTimeMillis() - t);
	}

	static class Print implements Runnable {
		String content;
		String plock;

		public Print(String content, String plock) {
			this.content = content;
			this.plock = plock;
		}

		@Override
		public void run() {
			for (int i = 0; i < 102; i++) {
				// 该线程 对 ali 其中一个加锁
				synchronized (plock) {
					//该线程对 ali 除去 plock 另外一个加锁 还有 一个
					synchronized (content) {
						//打印 这个
//						System.out.println(content + " : " + plock);
						System.out.print(content);
						content.notify();
					}

					try {
						plock.wait(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}

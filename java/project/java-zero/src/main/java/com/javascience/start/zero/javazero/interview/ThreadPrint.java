package com.javascience.start.zero.javazero.interview;

import java.util.ArrayList;

/**
 * @Author: zhouchong
 * Created by 76409 on 17:23 2020/5/29.
 * @Description:
 */
public class ThreadPrint{
	private static volatile int currentNum = 0;
	private static Object lock = new Object();


	public static void main(String[] args)
	{
		final Printer printer1 = new Printer(0, "Printer1");
		final Printer printer2 = new Printer(1, "Printer2");
		new Thread(printer1).start();
		new Thread(printer2).start();

	}
	static class Printer implements Runnable{
		private int flag;
		private String threadName;

		public Printer(int flag,String threadName){
			this.flag = flag;
			this.threadName = threadName;
		}
		@Override
		public void run(){
			for(int i = 0; i < 100;i++){
				synchronized (lock){
					if (currentNum % 2 ==flag){
						currentNum++;
						System.out.println("++"+threadName+"+-+" + currentNum);
					}
				}
			}
		}

	}
}
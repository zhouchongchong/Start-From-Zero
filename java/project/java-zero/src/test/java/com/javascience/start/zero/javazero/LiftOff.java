package com.javascience.start.zero.javazero;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhouchong
 * Created by 76409 on 10:24 2020/5/21.
 * @Description:
 */
public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ").";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		final ExecutorService executorService = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 5; i++) {
			final LiftOff liftOff = new LiftOff();
			executorService.execute(liftOff);
		}


		executorService.shutdown();
		System.out.println("main thread");
	}
}

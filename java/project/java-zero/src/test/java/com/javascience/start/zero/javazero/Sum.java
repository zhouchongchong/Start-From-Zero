package com.javascience.start.zero.javazero;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: zhouchong
 * Created by 76409 on 15:19 2020/5/20.
 * @Description:
 */
public class Sum {


	private static final int TIMES = 10 * 1000 * 1000;

	public static void main(String[] args) throws Exception {

		final CountDownLatch c = new CountDownLatch(TIMES);

		final Accumulator a = new Accumulator(c);
		long t1 = System.currentTimeMillis();
		ExecutorService service = Executors.newFixedThreadPool(4);

		for (long i = 0; i < TIMES; i++) {

			final Long k = i;
			service.submit(() -> {
				a.add(k);
				c.countDown();
			});
		}
		c.await();

		long t2 = System.currentTimeMillis();
		System.out.printf("telapsed time: %.3fs, sum=%d", (t2 - t1) / 1000f,

				a.getSum().longValue());
		service.shutdown();
	}
}

class Accumulator {

	private AtomicLong sum = new AtomicLong(0L);

	private CountDownLatch c;

	public Accumulator(CountDownLatch c) {

		this.c = c;
	}

	AtomicLong getSum() {

		return sum;
	}

	public void add(long k) {
		sum.addAndGet(k);
	}
}

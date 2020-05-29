package com.javascience.start.zero.javazero.interview.ali;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

/**
 * @Author: zhouchong
 * Created by 76409 on 10:27 2020/5/28.
 * @Description:
 */
public class ThreadPrint1
{
	private static Integer index = 0;
	private static Integer max = 102;
	private static Object lock = new Object();

	public static void main(String[] args)
	{


		Thread a = getThread(i -> i % 3 == 0, "a");
		Thread b = getThread(i -> i % 3 == 1, "l");
		Thread c = getThread(i -> i % 3 == 2, "i");
		a.start();
		b.start();
		c.start();

	}

	private static Thread getThread(Predicate<Integer> condition, String value)
	{
		return new Thread(() -> {
			while (true)
			{
				synchronized (lock)
				{
					//判断条件 当条件满足时候直接打印 不满足进行wait
					while (!condition.test(index))
					{
						try
						{
							//如果已经不需要继续，直接return,避免继续等待
							if (index >= max)
							{
								return;
							}
							lock.wait();
						} catch (InterruptedException e)
						{
							System.out.println(e.getMessage());
						}
					}
					//如果已经不需要继续，通知所有wait的线程收拾东西回家后，然后自己回家
					if (index >= max)
					{
						lock.notifyAll();
						return;
					}

					System.out.printf(value);
					index++;
					lock.notifyAll();
				}
			}
		});
	}
}

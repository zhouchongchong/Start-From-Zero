package com.javascience.start.zero.javazero.interview;

/**
 * @Author: zhouchong
 * Created by 76409 on 17:10 2020/5/29.
 * @Description:
 */
public class Single
{
	private static Single single;

	private Single()
	{
		if (single != null)
		{
			throw new RuntimeException("singleton is exist");
		}
	}

	public static Single getInstance()
	{
		if (single == null)
		{
			synchronized (Single.class)
			{
				if (single == null)
				{
					single = new Single();
				}
			}
		}
		return  single;
	}

	public static void main(String[] args)
	{
		Single single = Single.getInstance();
		Single single1 = Single.getInstance();

		System.out.println(single == single1);
	}

}

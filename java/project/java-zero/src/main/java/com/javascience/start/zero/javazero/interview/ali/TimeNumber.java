package com.javascience.start.zero.javazero.interview.ali;

/**
 * @Author: zhouchong
 * Created by 76409 on 15:15 2020/5/28.
 * @Description:
 */
public class TimeNumber
{
	static int limit = 5;
	static int count = 0;

	public static void main(String[] args)
	{
		System.out.println(countNum(15));
	}

	static int countNum(int n)
	{
		for (int i = 0; i < n ; i++)
		{
			if (count++ == limit)
			{
				count = 1;
				limit <<= 1;
			}
		}
		return count;
	}
}

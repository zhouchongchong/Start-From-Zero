package com.javascience.start.zero.javazero.interview;

/**
 * @Author: zhouchong
 * Created by 76409 on 17:37 2020/5/29.
 * @Description:
 */
public class Solution{

	public static void main(String[] args)
	{
		int[] arr = {0,1,0,3,12};
		solution(arr,2);
		for (int num : solution(arr,0)){
			System.out.print(num + " ");
		}
	}
	private static int[] solution(int[] arr,int index){
		int movIndex = index;
		int temp = arr[index];

		for (int mov = movIndex +1;mov < arr.length ; mov ++){
			arr[mov -1] = arr[mov];
		}
		arr[arr.length - 1] = temp;

		return arr;
	}
}

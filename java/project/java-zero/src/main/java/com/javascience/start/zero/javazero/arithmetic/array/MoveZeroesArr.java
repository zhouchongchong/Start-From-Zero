package com.javascience.start.zero.javazero.arithmetic.array;

/**
 * @Author: zhou
 * Created by zhou chong on 13:25 2020/7/16.
 * @Description:
 */
public class MoveZeroesArr {

	public static void main(String[] args) {
		//{0,2,4,0,3}
		int[] nums = {0,2,4,0,3};
		final int[] ints = moveZeroes(nums);
		for (int i : ints){
			System.out.println(i);
		}
		// 2 4 3 0 0
	}

	public static int[] moveZeroes(int[] nums) {
		int mv = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				mv++;
				continue;
			}
			nums[i - mv]= nums[i];
		}
		for (int i = nums.length - mv; i < nums.length; i++){
			nums[i] = 0;
		}
		return nums;
	}
}

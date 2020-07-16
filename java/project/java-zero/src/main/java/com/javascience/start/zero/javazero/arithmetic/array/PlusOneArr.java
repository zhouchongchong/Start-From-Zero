package com.javascience.start.zero.javazero.arithmetic.array;

/**
 * @Author: zhou
 * Created by zhou chong on 15:51 2020/7/14.
 * @Description:
 */
public class PlusOneArr {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		final int[] ints = plusOne(nums);
		for (int i : ints) {
			System.out.println(i);
		}
	}

	public static int[] plusOne(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] != 9) {
				nums[i] = nums[i] + 1;
				for (int j = i + 1; j < nums.length - 1; j++) {
					nums[j] = 0;
				}
				break;
			}
			if (i == 0) {
				int[] arr = new int[nums.length + 1];
				arr[0] = 1;
				return arr;
			}
		}

		return nums;
	}
}

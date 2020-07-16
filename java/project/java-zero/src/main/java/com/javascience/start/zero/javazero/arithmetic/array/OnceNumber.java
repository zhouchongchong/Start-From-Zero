package com.javascience.start.zero.javazero.arithmetic.array;

/**
 * @Author: zhou
 * Created by zhou chong on 14:26 2020/7/10.
 * @Description:
 */
public class OnceNumber {
	public static void main(String[] args) {
		int[] arr = {2, 2, 1};
		System.out.println(1 ^ 1 ^ 2 ^ 2);
	}

	public static int singleNumber(int[] arr) {
		final int length = arr.length;

		for (int i = 0; i < length; i += 2) {
			for (int j = i + 1; j < length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = arr[i];
					break;
				}
				if (j == length - 1) {
					return arr[i];
				}
			}
			if (i == length - 1) {
				return arr[i];
			}
		}

		return 0;
	}

	public static int quickly(int[] arr) {
		int num = arr[0];
		for (int i = 1; i < arr.length; i++) {
			num = num ^ arr[i];
		}
		return num;
	}
}

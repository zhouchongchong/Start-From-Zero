package com.javascience.start.zero.javazero.arithmetic.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: zhou
 * Created by zhou chong on 14:39 2020/7/13.
 * @Description:
 */
public class IntersectArr {
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 2, 1};
		int[] arr2 = {2, 2};

		final int[] intersect = leetCodeSort(arr1, arr2);

		for (int i : intersect) {
			System.out.println(i);
		}

	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		if (nums1.length < nums2.length) {
			return intersect(nums2, nums1);
		}
		int index = 0;
		//i 为大数组的 下表
		for (int i = 0; i < nums1.length; i++) {
			for (int j = index; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					//数组2 交换数据
					int temp = nums2[index];
					nums2[index] = nums2[j];
					nums2[j] = temp;
					index++;

					break;
				}
			}
		}
		int[] ret = new int[index];

		for (int i = 0; i < index; i++) {
			ret[i] = nums2[i];
		}
		return ret;
	}

	/**
	 * leetcode 上的 hash 解法
	 *
	 * @return
	 */
	public static int[] leetCodeHash(int[] nums1, int[] nums2) {
		if (nums1.length < nums2.length) {
			return leetCodeHash(nums2, nums1);
		}
		final HashMap<Integer, Integer> arr1 = new HashMap<>();
		for (int i : nums1) {
			int count = arr1.getOrDefault(i, 0) + 1;
			arr1.put(i, count);
		}

		int[] intersect = new int[nums2.length];
		int index = 0;
		final HashMap<Integer, Integer> arr2 = new HashMap<>();
		for (int key : nums2) {
			int count = arr1.getOrDefault(key, 0);
			if (count != 0) {
				count--;
				intersect[index++] = key;

				if (count != 0) {
					arr1.put(key, count);
				} else {
					arr1.remove(key);
				}
			}
		}

		return Arrays.copyOfRange(intersect, 0, index);
	}

	public static int[] leetCodeSort(int[] nums1, int[] nums2) {
		if (nums1.length < nums2.length) {
			return leetCodeSort(nums2, nums1);
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int point_1 = 0;
		int point_2 = 0;

		int[] arr = new int[nums2.length];
		int index = 0;
		int n1, n2;

		while (true) {
			if (point_1 == nums1.length || point_2 == nums2.length)
				break;
			;

			n1 = nums1[point_1];
			n2 = nums2[point_2];
			if (n1 > n2) {
				point_2++;
			} else if (n1 == n2) {
				arr[index++] = n1;
				point_2++;
				point_1++;
			} else {
				point_1++;
			}
		}


		return Arrays.copyOfRange(arr, 0, index);
	}
}

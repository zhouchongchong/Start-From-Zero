package com.javascience.start.zero.javazero.arithmetic.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSort {
	private static Logger logger = LoggerFactory.getLogger(QuickSort.class);

	public static void main(String[] args) {
		int[] arr = {7, 8, 4, 3, 5, 1, 6, 2};
		sort(arr, 0, arr.length - 1);
		logger.info("sorted arr:{}", arr);
	}

	private static void sort(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		// 设置基准点
		int index = getBaseIndex(arr, left, right);

		sort(arr, left, index - 1);
		sort(arr, index + 1, right);

	}

	private static int getBaseIndex(int[] arr, int left, int right) {
		int baseNum = arr[left];
		int index = left;
		// 该条件是再一次排序中 没有拍讯完的判断条件
		while (right > left) {
			while (right > left) {
				// 基准数大于 右指针数值 把右指针数值放到当前base位置 左边
				if (baseNum > arr[right]) {
					// 把该数值移动到 left
					arr[index] = arr[right];
					// 把坑放到移动过的数值上 right
					index = right;
					// 左边的下标++
					left++;
					logger.info("sorting right arr:{},right:{}", arr, arr[right]);
					// 退出当前循环 从left开始比较
					break;
				}
				// 否则 该数值应该在index右边 但是不需要比较该right数值 right--;
				right--;
			}

			while (right > left) {
				// 基准数大于 左指针数值 把左指针数值放到当前base位置 右边
				if (arr[left] > baseNum) {
					arr[index] = arr[left];
					index = left;
					right--;
					logger.info("sorting left arr:{},left:{}", arr, arr[left]);
					break;
				}
				left++;
			}

			logger.info("sorting arr:{}", arr);
		}

		arr[index] = baseNum;
		return index;
	}

}
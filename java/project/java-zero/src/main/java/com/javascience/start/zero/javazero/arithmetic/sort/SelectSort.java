package com.javascience.start.zero.javazero.arithmetic.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectSort {
	private static Logger logger = LoggerFactory.getLogger(SelectSort.class);

	public static void main(String[] args) {
		int[] arr = {8, 7, 4, 9, 4, 5, 1, 2};
		arr = studySort(arr);
		logger.info("sorted arr:{}", arr);
	}

	private static int[] sort(int[] arr) {
		int min = 0;
		int temp = 0;
		//找出 length 个最小值 需要循环 length次
		for (int i = 0; i < arr.length; i++) {
			//把要比较的第一个值设为最小值
			min = arr[i];
			//找出最小值 并且把最小值占位的那个值给找到某给位置放置
			for (int j = 1 + i; j < arr.length; j++) {
				if (min > arr[j]) {
					temp = min;
					min = arr[j];
					arr[j] = temp;
				}

				logger.info("current min:{}, max:{},index:{}", min, temp, j);
			}

			arr[i] = min;
		}

		return arr;
	}

	//这种方式更优异 正确的方式
	private static int[] studySort(int[] arr) {
		//方式找到最小值 并与一个第一个比较值交换下标
		int min = 0;
		int temp = 0;
		//找出 length 个最小值 需要循环 length次
		for (int i = 0; i < arr.length; i++) {
			//把要比较的第一个值设为最小值的下标
			min = i;
			//找出最小值 并且把最小值占位的那个值给找到某给位置放置
			for (int j = 1 + i; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		return arr;
	}
}
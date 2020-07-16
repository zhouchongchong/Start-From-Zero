package com.javascience.start.zero.javazero.arithmetic.sort;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertSort {

	private static Logger logger = LoggerFactory.getLogger(InsertSort.class);

	public static void main(String[] args) {
		// int[] arr = {9,2,6,3,7,4,8,5};
		int[] arr = {2, 3, 5, 7, 4};

		arr = sort(arr);
		logger.info("Sorted arr:{}", arr);
	}

	private static int[] sort(int[] arr) {
		int cur;
		int i = 1;
		int j;
		for (; i < arr.length; i++) {
			cur = arr[i];
			logger.info("current i:{}", i);

			for (j = i; j > 0 && cur < arr[j - 1]; j--) {
				arr[j] = arr[j - 1];
			}

			logger.info("current j:{}", j);
			arr[j] = cur;
		}
		return arr;
	}
}
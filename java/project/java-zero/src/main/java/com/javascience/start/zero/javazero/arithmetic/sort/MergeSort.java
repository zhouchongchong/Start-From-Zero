package com.javascience.start.zero.javazero.arithmetic.sort;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeSort {
	private static Logger logger = LoggerFactory.getLogger(MergeSort.class);

	public static void main(String[] args) {
		// int[] arr = { 7, 5, 8, 4, 6, 1, 9, 2, 3};
		int[] arr = {7, 5, 8, 4};
		// logger.info("sorted arr:{}", sort(arr));
		int[] arr1 = {5, 7};
		int[] arr2 = {4, 8};
		merge(arr1, arr2);
	}

	private static int[] sort(int[] source) {
		int[] arr = Arrays.copyOf(source, source.length);
		if (arr.length < 2) {
			return arr;
		}
		int middle = (int) Math.floor(arr.length / 2);
		int[] left = Arrays.copyOfRange(arr, 0, middle);
		int[] right = Arrays.copyOfRange(arr, middle, arr.length);
		// logger.info("sort left arr:{}, right arr:{}",left,right);
		return merge(sort(left), sort(right));
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		logger.info("input left arr:{}, right arr:{}", left, right);

		int i = 0;
		while (left.length > 0 && right.length > 0) {
			logger.info("beforewhie left arr:{}, right arr:{},result arr:{}", left, right, result);

			if (left[0] < right[0]) {
				result[i++] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			} else {
				result[i++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
			logger.info("inwhile left arr:{}, right arr:{},result arr:{}", left, right, result);

		}
		logger.info("outwhile left arr:{}, right arr:{},result arr:{}", left, right, result);


		while (left.length > 0) {
			result[i++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		if (right.length > 0) {
			result[i++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);

		}
		logger.info("merge left arr:{}, right arr:{},result arr:{}", left, right, result);

		return result;
	}
}
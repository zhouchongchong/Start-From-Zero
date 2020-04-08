package com.javascience.start.zero.javazero.arithmetic.sort;

import com.javascience.start.zero.javazero.arithmetic.sort.inter.Sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BubbleSort{
    private static Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 8, 3, 9, 4 };
        logger.info("sorted arr:{}", sort(arr));
    }

    public static int[] sort(int[] arr) {

        int temp;
        // 1.从第一个比较到最后一个 然后是 倒数第二个 倒数第三个
        // 外层要循环 length次 内能 每次循环 递减 length -1 -2 插入排序 性能不如 插入排序 多次交换temp
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
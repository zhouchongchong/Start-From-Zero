package com.javascience.start.zero.javazero.arithmetic.array;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zhou
 * Created by zhou chong on 14:42 2020/7/16.
 * @Description:
 */
public class TwoSumArr {
	public static void main(String[] args) {
		int[] nums = {1,3};
		final int[] ints = twoHashSum(nums, 4);
		for (int i: ints){
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];

		for (int i = 0; i < nums.length; i++) {
			final int search = target - nums[i];
			for (int j = i+1;j < nums.length;j++){
				if (search == nums[j]){
					return new int[]{i,j};
				}
			}
		}

		return ret;
	}
	public static int[] twoHashSum(int[] nums, int target) {
		int[] ret = new int[2];
		final HashMap<Integer, Integer> map1 = new HashMap<>();
		final HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map1.get(nums[i]) != null){
				map2.put(nums[i], i);
				continue;
			}
			map1.put(nums[i], i);
		}
		final Set<Map.Entry<Integer, Integer>> entries = map1.entrySet();
		for (Map.Entry<Integer, Integer> entry : entries) {
			int search =  target - entry.getKey();
			if (search == entry.getKey()){
				ret[0] = entry.getValue();
				ret[1] = map2.get(search);
				return ret;
			}
			if (map1.get(search) != null){
				ret[0] = entry.getValue();
				ret[1] = map1.get(search);
				return ret;
			}
		}
		return ret;
	}
}

package com.javascience.start.zero.javazero.arithmetic.array;

import java.util.HashSet;

/**
 * @Author: zhou
 * Created by zhou chong on 16:31 2020/7/16.
 * @Description:
 */
public class IsValidSudokuArr {
	public static void main(String[] args) {

	}

	public static boolean isValidSudoku(char[][] board) {
		char point = '.';
		//hang 校验
		for(int i = 0;i < 9;i++){
			final HashSet<Character> hang = new HashSet<>(9);
			final HashSet<Character> lie = new HashSet<>(9);
			for (int j = 0;j < 9;j++){
				if(board[i][j]!= point && !hang.add(board[i][j])){
					return false;
				}
				if (board[j][i]!= point &&!lie.add(board[j][i])){
					return false;
				}
			}
		}


		return true;
	}
}

package com.tewinsid.leetcode.easy;

/**
 * @Author:
 * @Description:
 * @Date: Created in 17:23 2021/2/25}
 */
public class matrixTranspose {

    public int[][] transpose(int[][] matrix) {
        int width = matrix.length;
        int high = matrix[0].length;
        int[][] result = new int[high][width];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < result.length; j++) {
                int[] resultItem = result[j];
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}

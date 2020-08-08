package com.tewinsid.leetcode.sword;

import org.junit.Test;

public class SearchInTwoDimensionalArray {

    @Test
    public void main() {

    }

    public boolean find(int target, int[][] arr) {
        int columns = arr[0].length;
        int rows = arr.length;
        int row = 0;
        int column = columns - 1;
        if (arr == null || rows <= 0 || columns <= 0) {
            return false;
        }
        while (row <= rows && column >= 0) {
            if (arr[row][column] == target) {
                return true;
            }
            if (arr[row][column] < target) {
                row++;
            }
            if (arr[row][column] > target) {
                column--;
            }
        }
        return false;
    }
}

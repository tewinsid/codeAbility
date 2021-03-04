package com.tewinsid.leetcode.middle;

/**
 * @Author:
 * @Description:
 * @Date: Created in 15:46 2021/2/20}
 */
public class RotateArray {


    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j < 0; j++) {
                nums[j] = nums[j - 1];
            } 
            nums[0] = temp;
        }
    }
}

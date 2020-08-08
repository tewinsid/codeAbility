package com.tewinsid.leetcode.easy;

import org.junit.Test;

public class RemoveElement {

    @Test
    public void test() {
        //int[] nums = {1, 2, 3, 4, 4, 5, 4, 6};
        int[] nums = {};
        int end = removeElement(nums, 4);
        for (int i = 0; i < end; i++) {
            System.out.print(nums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

package com.tewinsid.leetcode.easy;

import org.junit.Test;

public class RemobeDuplicates {

    /*
    双指针法
    控制一个慢指针，一个快指针
        慢指针代表实际长度，快指针代表遍历下标
        当慢指针对应值与快指针代表值相等，表示出现重复元素，这时快指针继续遍历，直到不等
        当两个指针对应值不等，慢指针开始步进，复制快指针当前值
    双指针相当于将结果数组结合到了目标数组上了，慢指针指示结果数组，快指针指示目标数组
     */

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        for (int i = 0; i < removeDuplicates(nums); i++) {
            System.out.print(nums[i] + " --- ");
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}

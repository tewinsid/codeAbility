package leetcode.easy;

import org.junit.Test;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class TwoSum {

    @Test
    public void test() {
        int[] nums = new int[]{3, 3};
        int[] result = twoSUm(nums, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " --- ");
        }
    }

    public int[] twoSUm(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}

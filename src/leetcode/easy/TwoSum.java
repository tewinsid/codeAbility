package leetcode.easy;

import org.junit.Test;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * tips:
 *  推荐返回值临时创建
 *  尽量把操作靠近它生效的位置
 *  当在循环中return的情况下可以在结尾抛出异常替代return
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
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

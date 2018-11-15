package leetcode.easy;

import org.junit.Test;

/**
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
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

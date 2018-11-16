package leetcode.easy;

import org.junit.Test;

/**
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * tips:
 *  �Ƽ�����ֵ��ʱ����
 *  �����Ѳ�����������Ч��λ��
 *  ����ѭ����return������¿����ڽ�β�׳��쳣���return
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

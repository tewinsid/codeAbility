package leetcode.easy;

import org.junit.Test;

/**
 *题目：
 *  给定一个 32 位有符号整数，将整数中的数字进行反转。
 *  假设我们的环境只能存储 32 位有符号整数，其数值范围是 [?231,  231 ? 1]。根据这个假设，如>果反转后的整数溢出，则返回 0。
 *考点:
 *  此题考验对Integer的掌握，以及数学能力，
 *思路：
 *  拿到题目发现关键点是第二个限制条件，即如何判断反转之后的数据是否超过Integer的限制
 *  基本思路使用循环对输入数据进行获取个位并拼接到结果数上（区域，除法），这里我对负数的除法
 不熟导致浪费时间
 *  在循环中要判断结果是否超过限制
 *      判断详解见leetcode中的说明（https://leetcode-cn.com/problems/reverse-integer/）
 *关键：
 *  负数的取余，除法结果仍是负数
 *  要考虑result==Integer.MAX_VALUE/10的情况
 */
public class ReverseInteger {

    @Test
    public void test() {
        System.out.println((double)Integer.MAX_VALUE / 10 * 8);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public int reverse(int origin) {

        int result = 0;
        while (origin != 0) {
            int pop = origin % 10;
            origin = origin / 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7 ) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8 ) {
                return 0;
            }
            result = result * 10 + pop;
        }
        return result;
    }
}

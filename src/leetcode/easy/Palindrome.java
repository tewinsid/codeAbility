package leetcode.easy;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 我的思路：
 *  通过将数字通过取余翻转数字后比较
 * 思路缺点：
 *  没有考虑到如果数字超过Integer.MAX_VALUE的情况
 * 推荐思路：
 *  翻转回文数的一半，把半个翻转的结果与前半个未翻转的结果比较，如果一直说明是回文数
 */
public class Palindrome {

    @Test
    public void test() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal.getWeekYear());
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int palindrom = 0;
        while (x > palindrom) {
            palindrom = palindrom * 10 + x % 10;
            x = x / 10;
        }
        return palindrom == x || x == palindrom / 10;
    }
}

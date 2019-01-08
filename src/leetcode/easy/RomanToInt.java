package leetcode.easy;

import org.junit.Test;

/**
 * 给定一个罗马数字将其转化为整数
 * <p>
 * 我的想法:
 * 一开始想用hashMap，感觉switch更通用，把输入的字符串转化为char数组，分别对每个元素进行判断
 * 如果是一般情况就把对应的值加到result上，如果是特殊情况就把值做处理
 * 更好的想法：
 * 罗马数字的规则我理解的不好，正常的逻辑是
 * 取到当前数字
 * 判断当前数组小于右侧数字，result = result - 当前数字
 * 判断当前数字大于等于右侧数字 result = result + 当前数字
 */
public class RomanToInt {


    @Test
    public void test() {
        System.out.println("" + romanToIntGood("MCMXCIV"));
        System.out.println("" + romanToIntGood("LVIII"));
        System.out.println("" + romanToIntGood("IX"));
        System.out.println("" + romanToIntGood("IV"));
        System.out.println("" + romanToIntGood("III"));
    }

    public int romanToInt(String s) {
        char[] origin = s.toCharArray();
        int result = 0;
        for (int i = 0; i < origin.length; i++) {
            char temp = origin[i];
            char pre = 'Z';
            if (i != 0) {
                pre = origin[i - 1];
            }
            int tempNum = getNumber(temp, pre);
            result += tempNum;
        }
        return result;
    }

    private int romanToIntGood(String s) {
        char[] origin = s.toCharArray();
        int result = 0;
        char temp, next = '1';
        for (int i = 0; i < origin.length - 1; i++) {
            temp = origin[i];
            next = origin[i + 1];
            if (getNumberGood(temp) < getNumberGood(next)) {
                result = result - getNumberGood(temp);
            } else {
                result = result + getNumberGood(temp);
            }
        }
        result = result + getNumberGood(next);
        return result;
    }

    private int getNumberGood(char c) {
        switch (c) {
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'I':
                return 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int getNumber(char c, char pre) {
        switch (c) {
            case 'X':
                if (pre == 'I') {
                    return 8;
                }
                return 10;
            case 'V':
                if (pre == 'I') {
                    return 3;
                }
                return 5;
            case 'L':
                if (pre == 'X') {
                    return 30;
                }
                return 50;
            case 'C':
                if (pre == 'X') {
                    return 80;
                }
                return 100;
            case 'D':
                if (pre == 'C') {
                    return 300;
                }
                return 500;
            case 'M':
                if (pre == 'C') {
                    return 800;
                }
                return 1000;
            case 'I':
                return 1;
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}

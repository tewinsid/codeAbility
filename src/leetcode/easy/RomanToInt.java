package leetcode.easy;

import org.junit.Test;

/**
 * ����һ���������ֽ���ת��Ϊ����
 * <p>
 * �ҵ��뷨:
 * һ��ʼ����hashMap���о�switch��ͨ�ã���������ַ���ת��Ϊchar���飬�ֱ��ÿ��Ԫ�ؽ����ж�
 * �����һ������ͰѶ�Ӧ��ֵ�ӵ�result�ϣ��������������Ͱ�ֵ������
 * ���õ��뷨��
 * �������ֵĹ��������Ĳ��ã��������߼���
 * ȡ����ǰ����
 * �жϵ�ǰ����С���Ҳ����֣�result = result - ��ǰ����
 * �жϵ�ǰ���ִ��ڵ����Ҳ����� result = result + ��ǰ����
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

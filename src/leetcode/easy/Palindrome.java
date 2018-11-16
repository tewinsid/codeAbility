package leetcode.easy;

import org.junit.Test;

/**
 * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ��������
 * �ҵ�˼·��
 *  ͨ��������ͨ��ȡ�෭ת���ֺ�Ƚ�
 * ˼·ȱ�㣺
 *  û�п��ǵ�������ֳ���Integer.MAX_VALUE�����
 * �Ƽ�˼·��
 *  ��ת��������һ�룬�Ѱ����ת�Ľ����ǰ���δ��ת�Ľ���Ƚϣ����һֱ˵���ǻ�����
 */
public class Palindrome {

    @Test
    public void test() {
        System.out.println(isPalindrome(12321));
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

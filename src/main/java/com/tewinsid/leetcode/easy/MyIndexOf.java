package com.tewinsid.leetcode.easy;

import org.junit.Test;


/**
 * ����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��
 * ��needle�ǿ��ַ���ʱ����������
 * ��ע�㣺
 *  ��һ�뷨��˫ָ��
 *  ��©�㣺
 *      ��������ȫƥ�������£���ָ��i�Ļ���û�п��ǵ�
 *      array.length() ��ʵ���±�Ĳ�ֵ1û�п��ǵ�
 *
 */
public class MyIndexOf {


    @Test
    public void test() {
        System.out.println(strStr("mississippi", "pi"));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < haystackArray.length; i++) {
            System.out.println("i -- " + i);
            System.out.println("j -- " + j);
            char haystackTemp = haystackArray[i];
            char needleTemp = needleArray[j];
            if (haystackTemp == needleTemp) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
            if (j > 0 && haystackTemp != needleTemp) {
                i = i - j;
                j = 0;
                System.out.println("i --- " + i + " --- j --- " + j);
            }

        }
        return -1;
    }
}

package leetcode.easy;

import org.junit.Test;

/**
 * 题目:
 *  编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 注意
 *  使用for循环subString等相关截取的时候一定要注意下标的溢出判断
 *  null对象判断
 *  特出情况的考虑
 */
public class LongestCommonPrefix {

    @Test
    public void test() {
        String[] origin1 = new String[]{"1234","","1234"};
        String[] origin2 = new String[]{"1234","1234","1234"};
        String[] origin3 = new String[]{"","1234","1234"};
        String[] origin4 = new String[]{"dog","racecar","car"};
        String[] origin5 = new String[]{"","",""};
        String[] origin6 = new String[]{"1234","123","1234"};
        String[] origin7 = new String[]{};
        System.out.println("1  " + longestCommonPrefix(origin1));
        System.out.println("2  " + longestCommonPrefix(origin2));
        System.out.println("3  " + longestCommonPrefix(origin3));
        System.out.println("4  " + longestCommonPrefix(origin4));
        System.out.println("5  " + longestCommonPrefix(origin5));
        System.out.println("6  " + longestCommonPrefix(origin6));
        System.out.println("7  " + longestCommonPrefix(origin7));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = "";
        for (int i = 0; i < strs[0].toCharArray().length; i++) {
            String temp = strs[0].substring(0, i + 1);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].toCharArray().length <= i
                        || !strs[j].substring(0, i + 1).equals(temp)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            result = temp;
        }
        return result;
    }
}

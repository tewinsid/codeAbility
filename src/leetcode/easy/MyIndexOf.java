package leetcode.easy;

import org.junit.Test;


/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 当needle是空字符串时候的情况考量
 * 关注点：
 *  第一想法：双指针
 *  遗漏点：
 *      当不能完全匹配的情况下，主指针i的回退没有考虑到
 *      array.length() 与实际下标的差值1没有考虑到
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

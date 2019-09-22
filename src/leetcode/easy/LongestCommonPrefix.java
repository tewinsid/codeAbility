package leetcode.easy;

import org.junit.Test;

/**
 * 题目:
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 注意
 * 使用for循环subString等相关截取的时候一定要注意下标的溢出判断
 * null对象判断
 * 特出情况的考虑
 * 1、所求的最长公共前缀子串一定是每个字符串的前缀子串。所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，看是否是它们所有人的前缀子串。这里的时间性能是O(m*n*m)。
 * <p>
 * 2、列出所有的字符串的前缀子串，将它们合并后排序，找出其中个数为n且最长的子串。时间性能为O(n*m+m*n*log(m*n))
 * <p>
 * 3、纵向扫描：从下标0开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。时间性能为O(n*m)。
 * <p>
 * 4、横向扫描：前两个字符串找公共子串，将其结果和第三个字符串找公共子串……直到最后一个串。时间性能为O(n*m)。
 * <p>
 * 5、借助trie字典树。将这些字符串存储到trie树中。那么trie树的第一个分叉口之前的单分支树的就是所求。
 * <p>
 * 重点关注方法3
 */
public class LongestCommonPrefix {

    @Test
    public void test() {
        String[] origin1 = new String[]{"1234", "", "1234"};
        String[] origin2 = new String[]{"1234", "1234", "1234"};
        String[] origin3 = new String[]{"", "1234", "1234"};
        String[] origin4 = new String[]{"dog", "racecar", "car"};
        String[] origin5 = new String[]{"", "", ""};
        String[] origin6 = new String[]{"1234", "123", "1234"};
        String[] origin7 = new String[]{};
        System.out.println("1  " + longestCommonPrefixOne(origin1));
        System.out.println("2  " + longestCommonPrefixOne(origin2));
        System.out.println("3  " + longestCommonPrefixOne(origin3));
        System.out.println("4  " + longestCommonPrefixOne(origin4));
        System.out.println("5  " + longestCommonPrefixOne(origin5));
        System.out.println("6  " + longestCommonPrefixOne(origin6));
        System.out.println("7  " + longestCommonPrefixOne(origin7));
        System.out.println("1  " + longestCommonPrefixThree(origin1));
        System.out.println("2  " + longestCommonPrefixThree(origin2));
        System.out.println("3  " + longestCommonPrefixThree(origin3));
        System.out.println("4  " + longestCommonPrefixThree(origin4));
        System.out.println("5  " + longestCommonPrefixThree(origin5));
        System.out.println("6  " + longestCommonPrefixThree(origin6));
        System.out.println("7  " + longestCommonPrefixThree(origin7));
    }

    /**
     * 方法3
     *
     * @return
     */
    public String longestCommonPrefixThree(String[] args) {
        if (args.length == 0) {
            return "";
        }
        String template = args[0];
        boolean breakFalg = false;
        int i = 0;
        for (; i < template.length(); i++) {
            char temp = template.charAt(i);
            for (int j = 1; j < args.length; j++) {
                if (args[j].length() <= i || temp != args[j].charAt(i)) {
                    breakFalg = true;
                    break;
                }
            }
            if (breakFalg) {
                break;
            }
        }
        return template.substring(0, i);
    }

    public String longestCommonPrefixOne(String[] strs) {
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

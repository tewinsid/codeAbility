package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * author wanggang
 * 题目：
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合
 * 我的思路：
 *  使用栈
 *  左括号入栈，右括号出栈，循环出栈知道找到对应左括号，找不到false，如果最后栈不空false
 *  问题：
 *      因为正常情况下出栈一次的左括号必然对应当前的右括号（因为之间的其他括号已经全部做过出
 栈了），所以不需要循环直接pop一次判断是否符合条件
 *      没有考虑极端情况：
 *          只有左括号情况
 *          只有右括号情况
 *      没有考虑栈pop但是size==0情况
 */
public class BracketsIsValid {
    @Test
    public void test() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)"));
        System.out.println(isValid(")"));
        System.out.println(isValid("("));
    }

    public boolean isValid(String s) {
        LinkedList stack = new LinkedList();
        char[] input = s.toCharArray();
        Map<Character, Character> param = new HashMap<>();
        param.put(')', '(');
        param.put('}', '{');
        param.put(']', '[');
        for (int i = 0; i < input.length; i++) {
            char temp = input[i];
            if (temp == '{' || temp == '(' || temp == '[') {
                stack.push(temp);
            }
            if (temp == '}' || temp == ')' || temp == ']') {
                if (stack.size() == 0) {
                    return false;
                }
                char left = (char) stack.pop();
                if (param.get(temp) == null || !(param.get(temp) == left)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

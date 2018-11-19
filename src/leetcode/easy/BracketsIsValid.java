package leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * author wanggang
 * ��Ŀ��
 *  ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 *      �����ű�������ͬ���͵������űպϡ�
 *      �����ű�������ȷ��˳��պ�
 * �ҵ�˼·��
 *  ʹ��ջ
 *  ��������ջ�������ų�ջ��ѭ����ջ֪���ҵ���Ӧ�����ţ��Ҳ���false��������ջ����false
 *  ���⣺
 *      ��Ϊ��������³�ջһ�ε������ű�Ȼ��Ӧ��ǰ�������ţ���Ϊ֮������������Ѿ�ȫ��������ջ�ˣ������Բ���Ҫѭ��ֱ��popһ���ж��Ƿ��������
 *      û�п��Ǽ��������
 *          ֻ�����������
 *          ֻ�����������
 *      û�п���ջpop����size==0���
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

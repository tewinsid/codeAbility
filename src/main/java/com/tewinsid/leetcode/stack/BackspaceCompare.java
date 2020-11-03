package com.tewinsid.leetcode.stack;

import org.junit.Test;

/**
 * @Author: tewinsid
 * @Description: 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 *                  判断二者是否相等，并返回结果。 # 代表退格字符。
 * @Date: Created in 09:34 2019-10-11}
 */
public class BackspaceCompare {

    @Test
    public void test() {

    }

    public void solution() {

    }

    class myStack  {
        Object[] elements;

        public void push() {
            Object[] newElemetns = new Object[elements.length + 1];
            //Arrays.copyOf()
            for (int i = 0; i < elements.length; i++) {

            }
            //Object element = elements[]
        }

        public void pop() {

        }

        public int size() {
            return elements.length;
        }
    }

}

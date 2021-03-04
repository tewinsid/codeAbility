package com.tewinsid.leetcode.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 * @Date: Created in 15:57 2021/2/26}
 */
public class PuzzlesHard {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordMaskSet = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        //将所有的word解析为解，放入目标解集合中
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] wordCharArray = word.toCharArray();
            int mask = 0;
            for (int j = 0; j < wordCharArray.length; j++) {
                mask |= 1 << (wordCharArray[j] - 'a');
            }
            wordMaskSet.put(mask, wordMaskSet.getOrDefault(mask, 0) + 1);
        }

        for (int i = 0; i < puzzles.length; i++) {
            int total = 0;
            String puzzle = puzzles[i];
            int mask = 0;
            char[] puzzleCharArray = puzzle.toCharArray();
            for (int j = 0; j < puzzleCharArray.length; j++) {
                mask |= 1 << (puzzleCharArray[j] - 'a');
            }
            int subset = mask;
            // 这里当循环减一，到-1 二进制为是（首位是标记1代表负数）11111111，这样与mask取与后就又变成了mask终止循环
            do {
                int s = subset | (1 << (puzzleCharArray[0] - 'a'));
                if (wordMaskSet.containsKey(s)) {
                    total += wordMaskSet.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            result.add(total);
        }
        return result;
    }


    @Test
    public void test() {
        for (int i = 0; i < "1234".toCharArray().length; i++) {
            System.out.println("1234".substring(i, i + 1));
        }
        String aaa = "123";

    }

}

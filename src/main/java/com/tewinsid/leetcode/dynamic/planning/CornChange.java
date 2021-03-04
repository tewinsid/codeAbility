package com.tewinsid.leetcode.dynamic.planning;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * @Author: tewinsid
 * @Description: 凑零钱问题
 * https://leetcode-cn.com/problems/coin-change/
 * @Date: Created in 17:02 2021/1/9}
 */
public class CornChange {


    @Test
    public void coinChange() {
        int[] coins = new int[]{3, 5, 7, 11};
        int amount = 70;
        Set<String> memo = Sets.newHashSet();
        dp(amount, coins, null, memo);
        System.out.println(memo.size());
        memo.stream().forEach(System.out::println);
    }

    private void dp(int amount, int[] coins, int[] result, Set memo) {
        if (amount == 0) {
            addResult(result, memo);
        }
        if (amount < 0) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            int[] newResult;
            if (result == null) {
                newResult = new int[]{coin};
            } else {
                newResult = Arrays.copyOf(result, result.length + 1);
                newResult[newResult.length - 1] = coin;
            }
            dp(amount - coin, coins, newResult, memo);
        }
    }

    private void addResult(int[] result, Set memo) {
        Arrays.sort(result);
        if (addCondition(result)) {
            memo.add(geneResult(result));
        }
    }

    private boolean addCondition(int[] result) {
        Set set = Sets.newHashSet();
        for (int i = 0; i < result.length; i++) {
            set.add(result[i]);
        }
        if (set.size() == 4) {
            return true;
        }
        return false;
    }

    private String geneResult(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(String.valueOf(result[i]));
            if (i != result.length - 1) {
                sb.append("+");
            }
        }
        return sb.toString();
    }

    private void printResult(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));
            if (i != result.length - 1) {
                System.out.print("+");
            }
        }
        System.out.println();
    }

    @Test
    public void soutTest() {
        int[] result = new int[]{1, 3, 2, 4};
        Arrays.sort(result);
        printResult(result);

    }

}

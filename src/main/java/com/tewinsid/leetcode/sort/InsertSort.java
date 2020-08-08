package com.tewinsid.leetcode.sort;

import org.junit.Test;

public class InsertSort {
    @Test
    public void main() {
        int[] target = {1, 5, 2, 6, 83, 2};
        sort(target);
        SortUtils.printAttay(target);
    }

    public void sort(int[] target) {
        for (int i = 1; i < target.length; i++) {
            int j = i;
            int temp = target[i];
            for (; j > 0 && temp < target[j - 1]; j--) {
                target[j] = target[j - 1];
            }
            target[j] = temp;
        }
    }
}

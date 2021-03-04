package com.tewinsid.leetcode.sort;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class InsertSort {
    @Test
    public void main() {
        int[] target = {1, 5, 2, 6, 83, 2};
        //sort(target);
        SortUtils.printArray(target);
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

    public void insertSort(int[] target) {
        for (int i = 1; i < target.length; i++) {
            int j = 1;
            int temp = target[j];
            for (; j > 0 && temp < target[j - 1]; j--) {
                if (target[j] < target[j - 1]) {
                    target[j] = target[j - 1];
                }
            }
            target[j] = temp;
        }
    }


    private void swap(int[] target, int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}

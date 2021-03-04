package com.tewinsid.leetcode.sort;

public class SortUtils {

    public static void swap(int[] target, int first, int second) {
        int temp = target[first];
        target[first] = target[second];
        target[second] = temp;
    }

    public static void printArray(int[] target) {
        for (int i = 0; i < target.length; i++) {
            System.out.print(" --- " + target[i]);
        }
    }
}

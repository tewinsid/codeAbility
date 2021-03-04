package com.tewinsid.leetcode.sort;

import org.junit.Test;

/**
 * @Author:
 * @Description:
 * @Date: Created in 16:50 2021/2/24}
 */
public class QuickSort {

    @Test
    public void test() {
        int[] input = {1, 12, 33, 44, 10};
        qSort(input, 0, input.length - 1);

    }

    public void qSort(int[] target, int low, int high) {
        int pivot = fetchSlot(target, low, high);
        int i = low;
        int j = high - 1;
        for (; ; ) {
            while (target[++i] < pivot) {

            }
            while (target[--j] > pivot) {

            }
            if (i < j) {
                swap(target, i, j);
            } else {
                break;
            }
        }
        System.out.println("i " + i);
        System.out.println("j " + j);
        System.out.println("low " + low);
        System.out.println("high " + high);
        printArray(target);
        if (low < i - 1) {
            qSort(target, low, i - 1);
        }
        if (i + 1 < high) {
            qSort(target, i, high);
        }
    }

    private void printArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ,");
        }
        System.out.println();
    }

    private int fetchSlot(int[] target, int low, int high) {
        int middle = (low + high) / 2;
        if (target[low] > target[middle]) {
            swap(target, low, middle);
        }
        if (target[low] > target[high]) {
            swap(target, low, high);
        }
        if (target[middle] > target[high]) {
            swap(target, middle, high);
        }
        swap(target, middle, high - 1);
        return target[high - 1];
    }

    private void swap(int[] target, int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
}

package leetcode.sort;

import org.junit.Test;


public class BubbleSort {
    @Test
    public void main() {
        int[] target = {1, 5, 2, 6, 83, 2};
        sort(target);
        SortUtils.printAttay(target);
    }

    public void sort(int[] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = target.length - 1; j > i; j--) {
                if (target[j] < target[j - 1]) {
                    SortUtils.swap(target, j, j - 1);
                }
            }
        }
    }


}

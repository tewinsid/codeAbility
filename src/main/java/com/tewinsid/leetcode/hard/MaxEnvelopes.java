package com.tewinsid.leetcode.hard;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @Description:
 * @Date: Created in 20:26 2021/3/4}
 */
public class MaxEnvelopes {


    @Test
    public void test() {
        int[][] input = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        maxEnvelopes(input);
    }

    public int maxEnvelopes(int[][] envelopes) {
        for (int i = 1; i < envelopes.length; i++) {
            int[] envelope = envelopes[i];
            int j = i;
            for (; j > 0 && envelopeLessThan(envelope, envelopes[j]); j--) {
                envelopes[j] = envelopes[j - 1];
            }
            envelopes[j] = envelope;
        }
        int index = 0;
        int count = 1;
        System.out.println(JSON.toJSONString(envelopes));
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopeLessThanStrict(envelopes[index], envelopes[i])) {
                index = i;
                count++;
            }
        }
        return count;
    }

    private boolean envelopeLessThan(int[] x, int[] y) {
        return x[0] < y[0] || (x[0] == y[0] && x[1] < y[1]);
    }

    private boolean envelopeLessThanStrict(int[] x, int[] y) {
        return x[0] < y[0] && x[1] < y[1];
    }
}

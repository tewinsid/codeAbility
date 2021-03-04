package com.tewinsid.leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: Created in 19:35 2021/2/24}
 */
public class CommonTest {


    @Test
    public int test() {
    //    1p 0 (1-p)
    //    00 (1-p)(1-p)
    //    11 p * p
    //    10 p * (1-p)
    //    01 p * (1-p)
        String tempString = "";
        while (true) {
            int tempResult1 = randomInner();
            int tempResult2 = randomInner();

            if (tempResult1 != tempResult2) {
                return tempResult1;
            }
        }
    }

    private int randomInner() {
        return 0;
    }

    class Node{
        public Node next;

        public Object value;

        Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }
    }


    class Obsover{

        public void doSomething() {
            System.out.println("doing");
        }
    }

    class Producer{

        List<Obsover> obsoverList;

        Producer(List obsoverList) {
            this.obsoverList = obsoverList;
        }

        public void tell() {
            obsoverList.stream().forEach(item -> {
                item.doSomething();
            });
        }
    }
}

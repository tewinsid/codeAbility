package leetcode.easy;

import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 我的想法：
 *  将一个链表作为结果，遍历另一个链表插入result
 *  问题：
 *      因为是单向链表所以会丢失上一个值
 * 解决方法：
 *  result是新建的ListNode，然后以类似归并排序的形式构造result
 */

public class MergeTwoNodeLists {

    @Test
    public void test() {
        ListNode l1 = buildNodeList(new int[]{1, 2, 4});
        //printListNode(l1);
        ListNode l2 = buildNodeList(new int[]{1, 3, 4});
        printListNode(mergeTwoLists(null, l2));
    }

    public ListNode buildNodeList(int[] input) {
        ListNode result = new ListNode(input[0]);
        ListNode itera = result;
        for (int i = 1; i < input.length; i++) {
            ListNode temp = new ListNode(input[i]);
            itera.next = temp;
            itera = itera.next;
        }
        return result;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "  ===  ");
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

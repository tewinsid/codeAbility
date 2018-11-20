package leetcode.easy;

import org.junit.Test;

/**
 * ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
 * �ҵ��뷨��
 *  ��һ��������Ϊ�����������һ���������result
 *  ���⣺
 *      ��Ϊ�ǵ����������Իᶪʧ��һ��ֵ
 * ���������
 *  result���½���ListNode��Ȼ�������ƹ鲢�������ʽ����result
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
        // ���ƹ鲢�����еĺϲ�����
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
        // ��һΪ�գ�ֱ��������һ������
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

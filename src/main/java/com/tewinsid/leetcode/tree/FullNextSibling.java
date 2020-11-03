package com.tewinsid.leetcode.tree;

/**
 * @Author: tewinsid
 * @Description: 填充每个节点的下一个右侧节点指针
 * @Date: Created in 15:07 2020/10/18}
 */
public class FullNextSibling {

    /**
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * 初始状态下，所有 next 指针都被设置为 NULL。
     * 提示
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     */

    /**
     * 这种相当于穷举法，分情况讨论了所有可能场景
     * @param root
     * @return
     */
    public Node connectRecursion(Node root) {
        if (root == null) {
            return null;
        }
        Node nextIndex = root.next;
        while (nextIndex != null) {
            if (nextIndex.left != null || nextIndex.right != null) {
                break;
            }
            nextIndex = nextIndex.next;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.left != null && root.right == null) {
            if (nextIndex != null && nextIndex.left != null) {
                root.left.next = nextIndex.left;
            }
            if (nextIndex != null && nextIndex.left == null && nextIndex.right != null) {
                root.left.next = nextIndex.right;
            }
        }
        if (root.right != null && nextIndex != null) {
            if (nextIndex.left != null) {
                root.right.next = nextIndex.left;
            }
            if (nextIndex.left == null && nextIndex.right != null) {
                root.right.next = nextIndex.right;
            }
        }
        if (root.right != null) {
            connectRecursion(root.right);
        }
        if (root.left != null) {
            connectRecursion(root.left);
        }
        return root;
    }

    /**
     * 这种会占用更多的内存，但是代码结构整洁
     * 增加一个方法加深了栈深度，每次临时计算netNode，占用内存
     * @param root
     * @return
     */
    public Node connectBetter(Node root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            root.right.next = getNextNode(root.next);
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNextNode(root.next);
            }
        }
        if (root.right != null) {
            connectBetter(root.right);
        }
        if (root.left != null) {
            connectBetter(root.left);
        }
        return root;
    }

    private Node getNextNode(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}

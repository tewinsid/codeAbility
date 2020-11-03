package com.tewinsid.leetcode.tree;

import org.junit.Test;

/**
 * @Author: tewinsid
 * @Description: 根据前序和中序数组构建二叉树
 * 思路：根据前序得到根节点，根据中序分隔子数组，递归执行知道数组长度为1
 * @Date: Created in 12:36 2020/9/9}
 */
public class BuildNodeTreeByPreInArray {

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        TreeNode result = buildTree(preorder, inorder);
        printTree(result);
    }

    TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        if (inorder.length == 1) {
            return root;
        }

        int rootInorderIndex = getIndexByValue(rootValue, inorder);

        int[] leftIn = new int[rootInorderIndex];
        int[] rightIn = new int[inorder.length - rootInorderIndex -1];
        for (int i = 0; i < inorder.length; i++) {
            if (i < rootInorderIndex) {
                leftIn[i] = inorder[i];
            }
            if (i > rootInorderIndex) {
                rightIn[i - rootInorderIndex - 1] = inorder[i];
            }
        }

        int[] leftPre = new int[leftIn.length];
        int[] rightPre = new int[rightIn.length];
        for (int i = 1; i < preorder.length; i++) {
            if (i <= leftIn.length) {
                leftPre[i - 1] = preorder[i];
            }
            if (i > leftIn.length) {
                rightPre[i - leftIn.length -1] = preorder[i];
            }
        }
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }

    private int getIndexByValue(int value, int[] targetArray) {
        for (int i = 0; i < targetArray.length; i++) {
            if (targetArray[i] == value) {
                return i;
            }
        }
        return -1;
    }

    void printTree(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) {
            printTree(root.left);
        } else {
            System.out.println("---l----");
        }
        if (root.right != null) {
            printTree(root.right);
        } else {
            System.out.println("----r---");
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

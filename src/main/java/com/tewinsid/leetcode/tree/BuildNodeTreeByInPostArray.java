package com.tewinsid.leetcode.tree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: tewinsid
 * @Description: 从中序和后续数组重新构建二叉树
 * 从后续中找到根节点，使用根节点分隔中序，递归执行到数组长度为1
 * @Date: Created in 12:34 2020/7/16}
 */
public class BuildNodeTreeByInPostArray {

    @Test
    public void test() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode result = buildTree(inorder, postorder);
        printTree(result);
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

    /**
     * 我的逻辑
     * @param inorder
     * @param postorder
     * @return
     */
    TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        if (inorder.length == 1) {
            return root;
        }
        int inIndex = getIndexByValue(rootVal, inorder);
        // 处理inorder
        int[] inLeft = new int[inIndex];
        int[] inRright = new int[inorder.length - 1 - inIndex];
        for (int i = 0; i < inorder.length; i++) {
            if (i < inIndex) {
                inLeft[i] = inorder[i];
            }
            if (i > inIndex) {
                inRright[i - inIndex - 1] = inorder[i];
            }
        }
        // 处理postorder
        int[] postLeft = new int[inLeft.length];
        int[] postRright = new int[postorder.length - 1 - inLeft.length];
        for (int i = 0; i < postorder.length - 1; i++) {
            if (i < inLeft.length) {
                postLeft[i] = postorder[i];
            }
            if (i >= inLeft.length) {
                postRright[i - inLeft.length] = postorder[i];
            }
        }

        TreeNode leftChild = buildTree(inLeft, postLeft);
        TreeNode rightChild = buildTree(inRright, postRright);
        root.left = leftChild;
        root.right = rightChild;
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 更好的答案
     */
    public TreeNode buildTreeBetter(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < postorder.length; i++) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                root.left = buildTreeBetter(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTreeBetter(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
                break;
            }
        }
        return root;
    }
}

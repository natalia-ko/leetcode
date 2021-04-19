package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
      3
    /   \
  9     20
       /  \
      15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.*/
public class S_0637_AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        TreeNode tr = new TreeNode(20);
        tree.right = tr;
        tr.left = new TreeNode(15);
        tr.right = new TreeNode(7);

        System.out.println(averageOfLevels(tree));

    }


    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        double sum;
        int n;

        while (!q.isEmpty()) {
            sum = 0;
            n = 0;
            Queue<TreeNode> nextLvl = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                if (cur.right != null) {
                    nextLvl.add(cur.right);
                }
                if (cur.left != null) {
                    nextLvl.add(cur.left);
                }
                sum += cur.val;
                n++;
            }
            result.add(sum / n);
            q = nextLvl;
        }

        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}


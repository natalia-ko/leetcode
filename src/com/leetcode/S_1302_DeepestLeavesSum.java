package com.leetcode;

/*Deepest Leaves Sum
Given the root of a binary tree, return the sum of values of its deepest leaves.
Example 1:

         1
       /  \
      2    3
    /  \    \
   4    5    6
 /            \
7              8
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
Constraints:
The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100*/

import java.util.LinkedList;
import java.util.Queue;

public class S_1302_DeepestLeavesSum {

    public class TreeNode {
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


    public int deepestLeavesSum(TreeNode root) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum;

        while (!q.isEmpty()) {
            sum = 0;
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

            }
            result = sum;
            q = nextLvl;
        }

        return result;
    }
}

package com.leetcode;

import java.util.LinkedList;

/*Add One Row to Tree
Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d.
The root node is at depth 1.
The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
create two tree nodes with value v as N's left subtree root and right subtree root.
And N's original left subtree should be the left subtree of the new left subtree root,
its original right subtree should be the right subtree of the new right subtree root.
If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root
of the whole original tree, and the original tree is the new root's left subtree.
Example 1:
Input:
A binary tree as following:
       4
     /   \
    2     6
   / \   /
  3   1 5

v = 1
d = 2
Output:
       4
      / \
     1   1
    /     \
   2       6
  / \     /
 3   1   5
Example 2:
Input:
A binary tree as following:
      4
     /
    2
   / \
  3   1
v = 1
d = 3
Output:
      4
     /
    2
   / \
  1   1
 /     \
3       1
Note:
The given d is in range [1, maximum depth of the given tree + 1].
The given binary tree has at least one tree node.*/
public class S_0623_AddOneRowToTree {
    public static void main(String[] args) {
        TreeNode d2l = new TreeNode(4);
        TreeNode d1r = new TreeNode(3);
        TreeNode d1l = new TreeNode(2, d2l, null);
        TreeNode root = new TreeNode(1, d1l, d1r);

        addOneRow(root, 5, 4);

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

    public static TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            return new TreeNode(v, root, null);
        }

        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root);
        int depth = 1;

        while (depth < d - 1) {
            LinkedList<TreeNode> temp = new LinkedList<>();
            while (!ll.isEmpty()) {
                TreeNode tn = ll.poll();
                if (tn.left != null) temp.add(tn.left);
                if (tn.right != null) temp.add(tn.right);
            }
            ll = temp;
            depth++;
        }

        while (!ll.isEmpty()) {
            TreeNode cur = ll.poll();
            TreeNode left = new TreeNode(v, cur.left, null);
            TreeNode right = new TreeNode(v, null, cur.right);
            cur.left = left;
            cur.right = right;
        }

        return root;
    }
}

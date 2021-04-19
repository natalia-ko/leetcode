package com.leetcode;

import java.util.ArrayList;

/*Swapping Nodes in a Linked List
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:
Input: head = [1], k = 1
Output: [1]
Example 4:
Input: head = [1,2], k = 1
Output: [2,1]
Example 5:
Input: head = [1,2,3], k = 2
Output: [1,2,3]
Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 10'5
0 <= Node.val <= 100*/
public class S_1721_SwappingNodesInALinkedList {

    public static void main(String[] args) {
       /* ListNode h4 = new ListNode(5);
        ListNode h3 = new ListNode(4, h4);
        ListNode h2 = new ListNode(3, h3);
        ListNode h1 = new ListNode(2, h2);
        ListNode head = new ListNode(1, h1);  */

//        ListNode h2 = new ListNode(3);
        ListNode h1 = new ListNode(2);
        ListNode head = new ListNode(1, h1);


        int k = 2;
        ListNode ln = swapNodes(head, k);
        while (ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }

    }

    public static ListNode swapNodes(ListNode head, int k) {
        ArrayList<Integer> al = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            al.add(cur.val);
            cur = cur.next;
        }

        cur = head;

        int right = al.get(k - 1);
        int left = al.get(al.size() - k);

        int count = 0;
        while (cur != null) {
            if (count == k - 1) {
                cur.val = left;
            }
            if (count == al.size() - k) {
                cur.val = right;
            }
            count++;
            cur = cur.next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

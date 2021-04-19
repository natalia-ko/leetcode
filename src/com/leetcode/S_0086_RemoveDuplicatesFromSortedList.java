package com.leetcode;
/*Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
Example 1:
Input: head = [1,1,2]
Output: [1,2]
Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.*/

public class S_0086_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        S_0086_RemoveDuplicatesFromSortedList i = new S_0086_RemoveDuplicatesFromSortedList();

        ListNode h11 = new ListNode(5);
        ListNode h10 = new ListNode(5, h11);
        ListNode h9 = new ListNode(5, h10);
        ListNode h8 = new ListNode(5, h9);
        ListNode h7 = new ListNode(4, h8);
        ListNode h6 = new ListNode(3, h7);
        ListNode he2 = new ListNode(3, h6);
        ListNode he1 = new ListNode(3, he2);
        ListNode h5 = new ListNode(3, he1);
        ListNode h4 = new ListNode(3, h5);
        ListNode h3 = new ListNode(2, h4);
        ListNode h2 = new ListNode(2, h3);
        ListNode he = new ListNode(1, h2);
        ListNode head = new ListNode(1, he);

        ListNode cur = head;
        System.out.print("input : ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();

        i.deleteDuplicates(head);
        System.out.print("output : ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static class ListNode {
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

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }

        return head;
    }
}
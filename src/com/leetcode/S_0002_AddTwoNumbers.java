package com.leetcode;
/*Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1: Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807.
Example 2: Input: l1 = [0], l2 = [0] Output: [0]
Example 3: Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.*/


public class S_0002_AddTwoNumbers {

    public static void main(String[] args) {

//        ListNode l19 = new ListNode(9);
//        ListNode l18 = new ListNode(9, l19);
        ListNode l17 = new ListNode(9);
        ListNode l16 = new ListNode(9, l17);
        ListNode l15 = new ListNode(9, l16);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(9, l14);
        ListNode l12 = new ListNode(9, l13);
        ListNode l1 = new ListNode(9, l12);


//        ListNode l27 = new ListNode(2);
//        ListNode l26 = new ListNode(2, l27);
//        ListNode l25 = new ListNode(2, l26);
        ListNode l24 = new ListNode(9);
        ListNode l23 = new ListNode(9, l24);
        ListNode l22 = new ListNode(9, l23);
        ListNode l2 = new ListNode(9, l22);

        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode();
        ListNode result = current;
        int temp = 0;

        while (l1 != null || l2 != null) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sum = l1val + l2val + temp;
            temp = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (temp > 0) {
            current.next = new ListNode(temp);
        }
        return result.next;
    }
}

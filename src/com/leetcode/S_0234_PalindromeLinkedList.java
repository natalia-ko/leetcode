package com.leetcode;

/*Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome.
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
Constraints:
The number of nodes in the list is in the range [1, 10'5].
0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space?*/
public class S_0234_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode ln = new ListNode(1, new ListNode(2));
        System.out.println(isPalindrome(ln));

    }


    // Definition for singly-linked list.
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


    public static boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            System.out.println(sb);
        }

        return sb.toString().equals(sb.reverse().toString());

    }

}

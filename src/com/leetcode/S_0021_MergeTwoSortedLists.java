package com.leetcode;
/*Merge Two Sorted Lists
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
Example 1:
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: l1 = [], l2 = []
Output: []
Example 3:
Input: l1 = [], l2 = [0]
Output: [0]
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.*/
public class S_0021_MergeTwoSortedLists {

    public static void main(String[] args) {


        ListNode l13 = new ListNode(8);
        ListNode l12 = new ListNode(6, l13);
        ListNode l11 = new ListNode(4, l12);
        ListNode l1 = new ListNode(2, l11);

        ListNode l24 = new ListNode(9);
        ListNode l23 = new ListNode(7, l24);
        ListNode l22 = new ListNode(5,l23);
        ListNode l21 = new ListNode(3, l22);
        ListNode l2 = new ListNode(1,l21);

        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

      if (l1==null) return l2;
      if (l2==null) return l1;

        ListNode result = new ListNode();

        ListNode current = new ListNode();
        current = result;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                current.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        return result.next;
    }
}
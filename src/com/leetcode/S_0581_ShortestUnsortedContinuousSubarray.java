package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

//Shortest Unsorted Continuous Subarray

//Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
//then the whole array will be sorted in ascending order.
//Return the shortest such subarray and output its length.
//Example 1:
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
//Example 2:
//Input: nums = [1,2,3,4]
//Output: 0
//Example 3:
//Input: nums = [1]
//Output: 0
//Constraints:
//1 <= nums.length <= 104
//-105 <= nums[i] <= 105
//Follow up: Can you solve it in O(n) time complexity?
public class S_0581_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] array = {2, -1, 2, 2, 2, -2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 12, 15};
        System.out.println(findUnsortedSubarray(array));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int result = 0;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                al.add(i);
            }
        }

        if (!al.isEmpty()) {
            result = al.get(al.size() - 1) - al.get(0) + 1;
        }
        return result;
    }
}
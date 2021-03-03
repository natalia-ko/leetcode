package com.leetcode;

import java.util.Arrays;

// Two Sum
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

class S_0001 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6};
        int target = 5;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = j;
                    result[1] = i;
                    break;
                }
            }
        }
        return result;
    }
}

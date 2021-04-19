package com.leetcode;

import java.util.Arrays;

/*53. Maximum Subarray
"Kadane's algorithm"
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:
Input: nums = [1]
Output: 1
Example 3:
Input: nums = [0]
Output: 0
Example 4:
Input: nums = [-1]
Output: -1
Example 5:
Input: nums = [-100000]
Output: -100000
Constraints:
1 <= nums.length <= 3 * 10'4
-10'5 <= nums[i] <= 10'5
*/
public class S_0053_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        allTest();
//        maxSubArray(nums);
//        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }


    private static void test(int testName, int[] nums, int expected) {
        int result = maxSubArray(nums);
        if (result == expected) {
            System.out.println(testName + " - OK");
        } else {
            System.out.println(testName + " - ERROR !!!");
        }

    }

    private static void allTest() {
        int[] nums1 = {2, 1, 0};
        test(1, nums1, 3);

        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        test(2, nums2, 6);

        int[] nums3 = {1};
        test(3, nums3, 1);

        int[] nums4 = {-1};
        test(4, nums4, -1);

        int[] nums5 = {-100000};
        test(5, nums5, -100000);

        int[] nums6 = {1, 2, -1, -2, -3, 10, 1};
        test(6, nums6, 11);
    }
}

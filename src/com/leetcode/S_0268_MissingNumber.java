package com.leetcode;

import java.util.Arrays;

/*Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:
Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
Constraints:
n == nums.length
1 <= n <= 10'4
0 <= nums[i] <= n
All the numbers of nums are unique.*/
public class S_0268_MissingNumber {

    public static void main(String[] args) {
        allTest();
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int[] expected = new int[nums.length + 1];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = i;
        }

        for (int a = 0; a < nums.length; a++) {
            if (expected[a] != nums[a]) return expected[a];
        }
        return expected[expected.length - 1];
    }


    private static void allTest() {
        int[] nums1 = {3, 0, 1};
        test(1, nums1, 2);

        int[] nums2 = {0, 1};
        test(2, nums2, 2);

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        test(3, nums3, 8);

        int[] nums4 = {0};
        test(4, nums4, 1);
    }

    private static void test(int testName, int[] nums, int expected) {
        int result = missingNumber(nums);
        if (result == expected) {
            System.out.println(testName + " - OK");
        } else {
            System.out.println(testName + " - ERROR !!!");
        }

    }
}

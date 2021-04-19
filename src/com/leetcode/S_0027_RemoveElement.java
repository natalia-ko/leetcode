package com.leetcode;
/*Remove Element
Given an array nums and a value val, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
Internally you can think of this:
Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3]
Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.
Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100*/
public class S_0027_RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(removeElement(nums, 2));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
//        int i = 0;
//        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != val) {
//                nums[i] = nums[j];
//                i++;
//            }
//        }
//        return i;
//    }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                result++;
            } else {
                int i2 = i;
                while (nums[i2] == val && i2 < nums.length - 1) {
                    i2++;
                }
                if (nums[i2] != val) {
                    nums[i] = nums[i2];
                    nums[i2] = val;
                    result++;
                }
            }
        }
        return result;
    }
}


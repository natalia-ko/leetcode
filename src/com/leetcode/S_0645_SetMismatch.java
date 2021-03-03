package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/*Set Mismatch
You have a set of integers s, which originally contains all the numbers from 1 to n.
Unfortunately, due to some error, one of the numbers in s got duplicated to another number
in the set, which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.
Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:
Input: nums = [1,1]
Output: [1,2]
Constraints:

2 <= nums.length <= 10'4
1 <= nums[i] <= 10'4*/
public class S_0645_SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4};
        findErrorNums(nums);
    }


    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> expected = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            expected.add(i);
        }
        for (int num : nums) {
            if (!input.contains(num)) {
                result[0] = num;
            }
            input.remove(num);
            expected.remove(num);
        }

        Iterator<Integer> iterator = expected.iterator();

        result[1] = iterator.next();

        for (int i : result) {
            System.out.print(i + " ");
        }

        return result;
    }
}
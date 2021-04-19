package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*Reordered Power of 2
Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
Return true if and only if we can do this in a way such that the resulting number is a power of 2.
Example 1:
Input: 1
Output: true
Example 2:
Input: 10
Output: false
Example 3:
Input: 16
Output: true
Example 4:
Input: 24
Output: false
Example 5:
Input: 46
Output: true
Note:
1 <= N <= 10^9*/
public class S_0869_ReorderedPowerOf2 {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));

    }


    public static boolean reorderedPowerOf2(int N) {
        int[] powers = new int[30];
        powers[0] = 1;
        for (int i = 1; i < 30; i++) {
            powers[i] = 2 * powers[i - 1];
        }
        int[] nToSortedArray = intToSortedArray(N);
        int al = nToSortedArray.length;

        ArrayList<Integer> pow = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            if (Integer.toString(powers[i]).length() == al) {
                pow.add(powers[i]);
            }
            if (Integer.toString(powers[i]).length() > al) {
                break;
            }
        }

        for (int p : pow) {
            int[] po2 = intToSortedArray(p);
            if (Arrays.equals(po2, nToSortedArray)) {
                return true;
            }
        }

        return false;
    }

    public static int[] intToSortedArray(int input) {
        String s = Integer.toString(input);
        int l = s.length();
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            result[i] = s.toCharArray()[i];
        }
        Arrays.sort(result);
        return result;
    }
}

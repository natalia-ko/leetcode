package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Binary Trees With Factors
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
We make a binary tree using these integers, and each number may be used for any number of times.
Each non-leaf node's value should be equal to the product of the values of its children.
Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10'9 + 7.
Example 1:
Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:
Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 Constraints:
1 <= arr.length <= 1000
2 <= arr[i] <= 10'9*/
public class S_0823_BinaryTreesWithFactors {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 10, 12, 13, 16, 18, 20, 22, 356, 1111, 100000};
        System.out.println(numFactoredBinaryTrees(arr));
    }

    public static int numFactoredBinaryTrees(int[] arr) {

        int MODULO = 1_000_000_007;
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    int r = arr[i] / arr[j];
                    if (map.containsKey(r)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(r)]) % MODULO;
                    }
                }
            }
        }
        long res = 0;
        for (long l : dp) {
            res += l;
        }
        return (int) (res % MODULO);
    }
}
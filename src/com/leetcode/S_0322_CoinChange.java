package com.leetcode;

import java.util.Arrays;

/*You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number
of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0
Example 4:
Input: coins = [1], amount = 1
Output: 1
Example 5:
Input: coins = [1], amount = 2
Output: 2
Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2'31 - 1
0 <= amount <= 10'4
*/
public class S_0322_CoinChange {
    public static void main(String[] args) {

        int[] a = {1, 2, 5};
        int am = 0;
        System.out.println(coinChange(a, am));
        allTest();
    }

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    private static void allTest() {
        int[] coins1 = {2, 3, 4, 5, 6, 7, 8, 9};
        test(1, coins1, 10000, 1112);

        int[] coins2 = {1, 2, 5};
        test(2, coins2, 11, 3);

        int[] coins3 = {2};
        test(3, coins3, 3, -1);

        int[] coins4 = {1};
        test(4, coins4, 0, 0);

        int[] coins5 = {1, 2};
        test(5, coins5, 2, 1);

        int[] coins6 = {2, 5, 3000};
        test(6, coins6, 13, 5);


    }

    private static void test(int testName, int[] coins, int amount, int expected) {
        int result = coinChange(coins, amount);
        if (result == expected) {
            System.out.println(testName + " - OK");
        } else {
            System.out.println(testName + " - ERROR !!! EXP: " + expected + " --- ANS: " + result);
        }

    }
}


package com.leetcode;

//Given an integer x, return true if x is palindrome integer.
//An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
//Example 1:
//Input: x = 121
//Output: true
//Example 2:
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//Example 4:
//Input: x = -101
//Output: false
//Constraints:
//-231 <= x <= 231 - 1
public class S_0009 {

    public static void main(String[] args) {
        int i = 345676543;
        System.out.println(isPalindrome(i));
    }

    public static boolean isPalindrome(int x) {
        String s = x + "";
        StringBuffer sb = new StringBuffer(s);
        if (s.equals(sb.reverse().toString())) return true;
        else return false;
    }

}

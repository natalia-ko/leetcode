package com.leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*Palindromic Substrings
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.*/
public class S_0647_PalindromicSubstrings {

    public static void main(String[] args) {

        String s = "aassddffggff";
        System.out.println(countSubstrings(s));

    }

    public static int countSubstrings(String s) {
        int q = 0;

        for (int start = 0; start < s.length(); start++)
            for (int end = start; end < s.length(); end++)
                q += isPalindrome(s, start, end) ? 1 : 0;

        return q;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

}

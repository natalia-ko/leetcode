package com.leetcode;

import java.util.Arrays;

/*Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?*/
public class S_0242_ValidAnagram {
    public static void main(String[] args) {
        String s = "ddffgg";
        String t = "ffddgg";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        Arrays.sort(sarr);
        Arrays.sort(tarr);

        return Arrays.equals(sarr, tarr);

    }
}
package com.leetcode;
/*Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:
Input: s = ""
Output: 0
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/

public class S_0003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aaaaaaad";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        String substring = "";
        int maxLenght = 0;

        for (char c : s.toCharArray()) {
            while (substring.length() > 0 && substring.contains(Character.toString(c))) {
                substring = substring.substring(1);
            }
            substring += c;
            if (substring.length() > maxLenght) maxLenght = substring.length();
        }
        return maxLenght;
    }

}

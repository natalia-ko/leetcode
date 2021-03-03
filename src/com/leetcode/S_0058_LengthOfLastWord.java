package com.leetcode;

/*Length of Last Word
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
A word is a maximal substring consisting of non-space characters only.
Example 1:
Input: s = "Hello World"
Output: 5
Example 2:
Input: s = " "
Output: 0
Constraints:
1 <= s.length <= 10'4
s consists of only English letters and spaces ' '.*/
public class S_0058_LengthOfLastWord {
    public static void main(String[] args) {
        String s = "  geeee l llll asd a ";
        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {
        int res = 0;
        if (s.length() > 0) {
            String[] words = s.split(" ");
            if (words.length > 0) res = words[words.length - 1].length();
        }
        return res;
    }
}

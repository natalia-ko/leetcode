package com.leetcode;

/*Given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.
Return the minimum number of steps to make the given string empty.
A string is a subsequence of a given string, if it is generated by deleting some characters of a given string without changing its order.
A string is called palindrome if is one that reads the same backward as well as forward.
Example 1:
Input: s = "ababa"
Output: 1
Explanation: String is already palindrome
Example 2:
Input: s = "abb"
Output: 2
Explanation: "abb" -> "bb" -> "".
Remove palindromic subsequence "a" then "bb".
Example 3:
Input: s = "baabb"
Output: 2
Explanation: "baabb" -> "b" -> "".
Remove palindromic subsequence "baab" then "b".
Example 4:
Input: s = ""
Output: 0
 Constraints:
0 <= s.length <= 1000
s only consists of letters 'a' and 'b'*/
public class S_1332_RemovePalindromicSubsequences {
    public static void main(String[] args) {
        String s = "";
        System.out.println(removePalindromeSub(s));
    }

    public static int removePalindromeSub(String s) {
        return  s == null||s.length() == 0 ? 0 : (s.equals(new StringBuffer(s).reverse().toString()) ? 1 : 2);
    }

}



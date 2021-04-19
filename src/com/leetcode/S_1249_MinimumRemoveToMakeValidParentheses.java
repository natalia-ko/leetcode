package com.leetcode;

import java.util.Stack;
/*Minimum Remove to Make Valid Parentheses
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:
Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
Constraints:
1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.*/
public class S_1249_MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "))((";
        System.out.println(minRemoveToMakeValid(s));

    }

    public static String minRemoveToMakeValid(String s) {

        StringBuffer sSB = new StringBuffer(s);
        Stack<Integer> indexO = new Stack<>();
        Stack<Integer> indexRemove = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') {
                indexO.push(i);
            } else if (s.charAt(i)==')') {
                if (indexO.empty()) {
                    indexRemove.push(i);
                } else {
                    indexO.pop();
                }
            }
        }

        while (!indexO.empty()) {
            sSB.deleteCharAt(indexO.pop());
        }
        while (!indexRemove.empty()) {
            sSB.deleteCharAt(indexRemove.pop());
        }

        return sSB.toString();
    }
}

package com.leetcode;
/*Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
Example 4:
Input: s = "([)]"
Output: false
Example 5:
Input: s = "{[]}"
Output: true
Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S_0020_ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> oc = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> opening = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (oc.values().contains(s.charAt(i))) {
                opening.push(s.charAt(i));
            } else {
                if (opening.empty() || !opening.peek().equals(oc.get(s.charAt(i)))) {
                    return false;
                } else {
                    opening.pop();
                }
            }
        }
        if (opening.empty()) {
            return true;
        } else {
            return false;
        }
    }
}


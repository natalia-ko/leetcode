package com.leetcode;
    /*Roman to Integer
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II. Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.
    'I', 'V', 'X', 'L', 'C', 'D', 'M'
    Example 4:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V = 5, III = 3.
    Example 5:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.*/

import java.util.HashMap;
import java.util.Map;

public class S_0013_RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                result += map.get(s.charAt(i));
            }
        }

        if (s.contains("IV") || s.contains("IX")) {
            result -= 2;
        }
        if (s.contains("XL") || s.contains("XC")) {
            result -= 20;
        }
        if (s.contains("CD") || s.contains("CM")) {
            result -= 200;
        }

        return result;
    }
}

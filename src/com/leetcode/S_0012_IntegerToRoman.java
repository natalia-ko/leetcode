package com.leetcode;

import java.util.*;

/*Integer to Roman
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
The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle
applies to the number nine, which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.
Example 1:
Input: num = 3
Output: "III"
Example 2:
Input: num = 4
Output: "IV"
Example 3:
Input: num = 9
Output: "IX"
Example 4:
Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:
Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
Constraints:
1 <= num <= 3999*/
public class S_0012_IntegerToRoman {
    public static void main(String[] args) {
        int num = 79;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        Stack<Integer> stack = new Stack();
        int inc = 1;
        while (num != 0) {
            stack.push(num % 10 * inc);
            num /= 10;
            inc *= 10;
        }
        Integer[] i = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        List<Integer> ints = new ArrayList<Integer>(Arrays.asList(i));
        String[] strs = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        String result = "";
        while (!stack.empty()) {
            int current = stack.pop();
            while (current != 0) {
                if (!ints.contains(current)) {
                    int ind = Collections.binarySearch(ints, current) * (-1) - 2;
                    result += strs[ind];
                    current -= ints.get(ind);
                } else {
                    result += strs[ints.indexOf(current)];
                    current=0;
                }
            }
        }

        return result;
    }
}
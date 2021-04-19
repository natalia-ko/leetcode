package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/*Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"]
Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].*/
public class S_0017_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {

        LinkedList<String> result = new LinkedList<>();
        String[] pad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits.isEmpty()) {
            return result;
        }

        result.add("");

        for (int i = 0; i < digits.length(); i++) {

            int index = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String vars = result.remove();
                for (char c : pad[index].toCharArray()) {
                    result.add(vars + c);
                }
            }
        }
        return result;

    }
}
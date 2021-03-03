package com.leetcode;

/*Plus One
Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.
Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:
Input: digits = [0]
Output: [1]
Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9 */
public class S_0066_PlusOne {
    public static void main(String[] args) {
        int[] digits = {4,3,2,1};
        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        int decr = 0;
        int over = 0;
        int[] digitsCopy = new int[digits.length + 1];
        System.arraycopy(digits, 0, digitsCopy, 1, digits.length);

        while (digits.length >= 1 + decr) {
            if (digits[digits.length - 1 - decr] < 9) {
                over = 0;
                digitsCopy[digits.length - decr]++;
                digits[digits.length -1 - decr]++;
                break;
            } else {
                over = 1;
                digitsCopy[digits.length - decr] = 0;
                digits[digits.length - 1 - decr] = 0;
                decr++;
            }
        }
        if (over == 1) {
            digitsCopy[0] = over;
            return digitsCopy;
        } else {
            return digits;
        }
    }
}
package com.leetcode;
/*ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:
Input: s = "A", numRows = 1
Output: "A"
Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000*/

public class S_0006_ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 4;
        System.out.println(convert(s, rows));
    }

    public static String convert(String s, int numRows) {
        String result = "";
        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int[] r = new int[s.length()];
        int a = 0;
        while (a < s.length() - 1) {
            for (int i = 0; i < numRows; i++) {
                if (a <= s.length() - 1) {
                    r[a] = i;
                    a++;
                }
            }
            for (int j = numRows - 2; j > 0; j--) {
                if (a <= s.length() - 1) {
                    r[a] = j;
                    a++;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            rows[r[i]] += s.charAt(i);
        }

        for (String str : rows) {
            result += str;
        }

        return result;
    }
}

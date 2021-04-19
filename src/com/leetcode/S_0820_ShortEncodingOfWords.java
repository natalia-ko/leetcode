package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*A valid encoding of an array of words is any reference string s and array of indices indices such that:
words.length == indices.length
The reference string s ends with the '#' character.
For each index indices[i], the substring of s starting from indices[i] and up to (but not including) the next '#' character is equal to words[i].
Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
Example 1:
Input: words = ["time", "me", "bell"]
Output: 10
Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
Example 2:
Input: words = ["t"]
Output: 2
Explanation: A valid encoding would be s = "t#" and indices = [0].
Constraints:
1 <= words.length <= 2000
1 <= words[i].length <= 7
words[i] consists of only lowercase letters.*/
public class S_0820_ShortEncodingOfWords {

    public S_0820_ShortEncodingOfWords() {
        String[] strArr = {"time", "me", "bell"};
        test(1, strArr, 10);
    }

    public static void main(String[] args) {
        new S_0820_ShortEncodingOfWords();
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                });

        Set<String> include = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            boolean incl = true;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].endsWith(words[i])) {
                    incl = false;
                    break;
                }
            }
            if(incl){
                include.add(words[i]);
            }
        }

        int sum = 0;
        for (String s : include) {
            sum+=s.length()+1;
        }

        return sum;
    }

    private void test(int testNum, String[] strArr, int expectedResult) {
        int result = minimumLengthEncoding(strArr);
        if (result == expectedResult) {
            System.out.println(testNum + " - Ok");
        } else {
            System.out.println(testNum + " - ERROR");
            System.out.println("result = " + result);
            System.out.println("expectedResult = " + expectedResult);
        }
    }
}

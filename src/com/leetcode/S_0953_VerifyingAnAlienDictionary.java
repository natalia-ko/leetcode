package com.leetcode;

/*Verifying an Alien Dictionary
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
if the given words are sorted lexicographicaly in this alien language.
Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is
less than any other character (More info).
Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.*/
public class S_0953_VerifyingAnAlienDictionary {

    public static void main(String[] args) {

        String[] st = {"apple", "app"};
        String ord = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(st, ord));
    }


    public static boolean isAlienSorted(String[] words, String order) {
        if (words.length == 0) return true;

        int[] comp = new int[words.length - 1];
        for (int i = 1; i < words.length; i++) {
            if (compareAlien(words[i], words[i - 1], order) < 0) return false;
        }
        return true;
    }

    public static int compareAlien(String s1, String s2, String order) {
        int len1 = s1.toCharArray().length;
        int len2 = s2.toCharArray().length;
        int lim = Math.min(len1, len2);
        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return order.indexOf(c1) - order.indexOf(c2);
            }
            k++;
        }
        return len1 - len2;
    }
}
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*Word Subsets
We are given two arrays A and B of words.  Each word is a string of lowercase letters.
Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
For example, "wrr" is a subset of "warrior", but is not a subset of "world".
Now say a word a from A is universal if for every b in B, b is a subset of a.
Return a list of all universal words in A.  You can return the words in any order.

Example 1:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
Note:
1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].*/
public class S_0916_WordSubsets {

    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"ec", "oc", "ceo"};
//        String[] A = {"cbbca"};
//        String[] B = {"b", "bb", "ca"};
//        exp ["cbbca"]

        List<String> al = wordSubsets(A, B);
        for (String s : al) {
            System.out.print("[" + s + "] ");
        }
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        ArrayList<String> res = new ArrayList<>();

        int[] t = new int[26];
        for (String b : B) {
            int[] temp = new int[26];
            for (char c : b.toCharArray()) {
                temp[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                t[i] = Math.max(t[i], temp[i]);
            }
        }

        for (String a : A) {
            if (isUniversal(a, t)) {
                res.add(a);
            }
        }
        return res;
    }

    public static boolean isUniversal(String a, int[] t) {
        int[] current = new int[26];
        for (char c : a.toCharArray()) {
            current[c - 'a']++;
        }
        for (int i = 0; i < 26; i++)
            if (current[i] < t[i]) {
                return false;
            }

        return true;
    }

}
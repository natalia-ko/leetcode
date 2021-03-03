package com.leetcode;//Longest Palindromic Substring
//Given a string s, return the longest palindromic substring in s.
//Example 1:
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//Input: s = "cbbd"
//Output: "bb"
//Example 3:
//Input: s = "a"
//Output: "a"
//Example 4:
//Input: s = "ac"
//Output: "a"
//Constraints:
//1 <= s.length <= 1000
//s consist of only digits and English letters (lower-case and/or upper-case),

public class S_0005 {
    public static void main(String[] args) {
        String s = "ssa";
        s="crbidxnkyieminyzchamldzjzglygkfbbyggagwdqdqamzpguppqjfrcewfduwvcmhliahovcwoupwxwhaoiiiguahuqxiqndwxqxweppcbeoasgtucyqlxnxpvtepwretywgjigjjuxsrbwucatffkrqyfkesakglyhpmtewfknevopxljgcttoqonxpdtzbccpyvttuaisrhdauyjyxgquinvqvfvzgusyxuqkyoklwslljbimbgznpvkdxmakqwwveqrpoiabmiegoyzuyoignfcgmqxvpcmldivknulqbpyxjuvyhrzcsgiusdhsogftokekbdynmksyebsnzbxjxfvwamccphzzlzuvotvubqvhmusdtwvlsnbqwqhqcigmlfoupnqcxdyflpgodnoqaqfekhcyxythaiqxzkahfnblyiznlqkbithmhhytzpcbkwicstapygjpjzvrjcombyrmhcusqtslzdyiiyvujnrxvkrwffwxtmdqqrawtvayiskcnpyociwkeopardpjeyuymipekbefbdfuybfvgzfkjtvurfkopatvusticwbtxdtfifgklpmjamiocalcocqwdivyulupammxhdbeazrrktxiyothnvbwwrsocxzxaxmoenigbhvxffddexrwsioqoyovaqvtmkwzupstkgkmvrddzolmuzjnsj";


        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome(s));
        System.out.println(System.currentTimeMillis()-start);
    }

    public static String longestPalindrome(String s) {
        String palindrome = Character.toString(s.charAt(0));
        if (isPalindrome(s)) palindrome = s;
        else if (s.length() == 2) palindrome = Character.toString(s.charAt(0));
        else {
            for (int i = 1; i < s.length(); i++) {
                int step = 0;
                while (i - step > 0 && i + step + 1 <= s.length()) {
                    step++;
                    if (i+step+1<=s.length()&&isPalindrome(s.substring(i - step, i + step + 1))) {
                        palindrome = palindrome.length() < s.substring(i - step, i + step + 1).length() ? s.substring(i - step, i + step + 1) : palindrome;

                    } else if (isPalindrome(s.substring(i - step, i + step))) {
                        palindrome = palindrome.length() < s.substring(i - step, i + step).length() ? s.substring(i - step, i + step) : palindrome;

                    }
                }
            }
        }
        return palindrome;
    }


    public static boolean isPalindrome(String s) {


        StringBuffer reversed = new StringBuffer(s).reverse();
        return s.equals(reversed.toString());
    }
}



package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//Longest Word in Dictionary through Deleting
//Given a string and a string dictionary, find the longest string in the dictionary that can be formed
//by deleting some characters of the given string. If there are more than one possible results,
//return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
//Example 1:
//Input:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//Output:
//"apple"
//Example 2:
//Input:
//s = "abpcplea", d = ["a","b","c"]
//Output:
//"a"
//Note:
//All the strings in the input will only contain lower-case letters.
//The size of the dictionary won't exceed 1,000.
//The length of all the strings in the input won't exceed 1,000.
public class S_0524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        //"aewfafwafjlwajflwajflwafj"
        //["apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"]

        String s = "aewfafwafjlwajflwajflwafj";
        List<String> d = new ArrayList<String>() {{
            add("apple");
            add("ewaf");
            add("awefawfwaf");
            add("awef");
            add("awefe");
            add("ewafeffewafewf");
            add("wajlflwa");
            add("afff");
        }};

        System.out.println(findLongestWord(s, d));
    }

    public static String findLongestWord(String s, List<String> d) {
//        String result = "";
//        Stack<Integer> indexToDel = new Stack<>();
//
//        for (int i = 0; i < d.size(); i++) {
//            if (!s.contains(d.get(i))) {
//                int index = 0;
//                for (char c : d.get(i).toCharArray()) {
//                    if (s.indexOf(c, index) >= 0) {
//                        index = s.indexOf(c, index);
//                    } else {
//                        indexToDel.push(i);
//                        break;
//                    }
//                }
//            }
//        }
//        while (!indexToDel.empty()) {
//            int ind = indexToDel.pop();
//            d.remove(ind);
//        }
//
//        for (String value : d) {
//            if (value.length() > result.length() || value.length() == result.length() && value.compareTo(result) < 0) {
//                result = value;
//            }
//        }
//
//        return result;
//    }
//}

        String result = "";
        for (String word : d) {
            int a = word.length();
            int b = result.length();

            if (a < b || (a == b && word.compareTo(result) > 0))
                continue;
            int position = -1;
            for (int i = 0; i < a; i++) {
                position = s.indexOf(word.charAt(i), position + 1);
                if (position == -1)
                    break;
            }
            if (position != -1)
                result = word;

        }
        return result;
    }
}














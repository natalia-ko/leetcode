package com.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/*Advantage Shuffle
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
Return any permutation of A that maximizes its advantage with respect to B.
Example 1:
Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:
Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
Note:
1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9*/
public class S_0870_AdvantageShuffle {

    public static void main(String[] args) {
        int[] A = {0, 2, 12, 24, 3, 8, 32};
        int[] B = {13, 25, 32, 11, 1, 1, 2};

        System.out.println(Arrays.toString(advantageCount(A, B)));
    }


    public static int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> mapA = new TreeMap<>();

        for (int a : A) {
            if (mapA.containsKey(a)) {
                mapA.replace(a, mapA.get(a) + 1);
            } else {
                mapA.put(a, 1);
            }
        }

        for (int i = 0; i < B.length; i++) {
            Integer ceilingKey = mapA.ceilingKey(B[i] + 1);
            Integer k = null;
            if (ceilingKey != null) {
                k = ceilingKey;
            } else {
                k = mapA.firstKey();
            }
            A[i] = k;
            mapA.replace(k, mapA.get(k) - 1);
            if (mapA.get(k) == 0) {
                mapA.remove(k);
            }
        }
        return A;
    }
}

package com.leetcode;/*Validate Stack Sequences
Given two sequences pushed and popped with distinct values, return true if and only if this could have been
the result of a sequence of push and pop operations on an initially empty stack.
Example 1:
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:
Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
Constraints:
0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed is a permutation of popped.
pushed and popped have distinct values. */

import java.util.Stack;

public class S_0946_ValidateStackSequences {
    public static void main(String[] args) {


        int[] pushed = {2,3,0,1};
        int[] popped = {0,3,2,1};

        allTest();
        System.out.println(validateStackSequences(pushed, popped));
    }


    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedInd = 0;
        int pushedInd = 0;

        while (pushedInd < pushed.length) {
            while (!stack.empty() && popped[poppedInd] == stack.peek()) {
                poppedInd++;
                stack.pop();
            }
            if (popped[poppedInd] == pushed[pushedInd]) {
                poppedInd++;
                pushedInd++;

            } else {
                stack.push(pushed[pushedInd]);
                pushedInd++;
            }
        }
        while (poppedInd < popped.length) {
            if (!stack.empty() && popped[poppedInd] == stack.peek()) {
                stack.pop();
            }
                poppedInd++;
        }
        return stack.empty();
    }


    private static void allTest(){
        int[] pushed1 = {2, 1, 0};
        int[] popped1 = {1, 2, 0};
        test(1, pushed1, popped1, true);

        int[] pushed2 = {2,3,0,1};
        int[] popped2 = {0,3,2,1};
        test(2, pushed2, popped2 , true);

        int[] pushed3 = {1,2,3,4,5};
        int[] popped3 = {4,5,3,2,1};
        test(3,pushed3,popped3,true);

        int[] pushed4 = {1,2,3,4,5};
        int[] popped4 = {4,3,5,1,2};
        test(4,pushed4,popped4,false);



    }

    private static void test(int testName, int[] pushed, int[] popped, boolean expected){
        boolean result = validateStackSequences(pushed, popped);
        if(result==expected){
            System.out.println(testName+ " - OK");
        } else {
            System.out.println(testName+ " - ERROR !!!");
        }

    }
}
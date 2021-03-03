package com.leetcode;

//Search a 2D Matrix II
//Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
//Example 1:
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//Output: true
//Example 2:
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//Output: false
//Constraints:
//m == matrix.length
//n == matrix[i].length
//1 <= n, m <= 300
//-10'9 <= matix[i][j] <= 10'9
//All the integers in each row are sorted in ascending order.
//All the integers in each column are sorted in ascending order.
//-10'9 <= target <= 10'9
public class S_0240_SearchA2DMatrixII {

    public static void main(String[] args) {
        int[][] matrix = {{-1, 4, 7, 11, 1000000000}, {-2, 5, 8, 12, 1000000000-1}, {-3, 6, 9, 16, 1000000000-2}, {-10, 13, 14, 17, 24}, {-18, 21, 23, 26, 30}};
        int target = -1000000000;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                if (matrix[m][n] > target)
                    break;
                else if (matrix[m][n] == target) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}

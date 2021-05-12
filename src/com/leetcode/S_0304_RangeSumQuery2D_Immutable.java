package com.leetcode;

/*Range Sum Query 2D - Immutable [Medium]
Given a 2D matrix matrix, handle multiple queries of the following type:
Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:
-NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
-int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left
corner (row1, col1) and lower right corner (row2, col2).

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
-10'5 <= matrix[i][j] <= 10'5
0 <= row1 <= row2 < m
0 <= col1 <= col2 < n
At most 104 calls will be made to sumRegion.
*/
public class S_0304_RangeSumQuery2D_Immutable {


    public static void main(String[] args) {

    int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);

        System.out.println(obj.sumRegion(1,2,3,4));
    }

    static class NumMatrix {
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix=matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int sum = 0;

            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    sum += matrix[i][j];
                }
            }

            return sum;

        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}

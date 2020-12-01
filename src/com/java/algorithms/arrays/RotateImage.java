package com.java.algorithms.arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise). You have to rotate the image in-place, which
 * means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        /**
         * Time Complexity O(N^2+N(N/2)) == O(N^2)
         * Space Complexity O(1)
         */

        // generate transpose of matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //swap column wise
        for (int i = 0; i < matrix.length; i++) {
            int st = 0;
            int end = matrix.length - 1;
            while (st < end) {
                int temp = matrix[i][st];
                matrix[i][st] = matrix[i][end];
                matrix[i][end] = temp;
                st++;
                end--;
            }
        }

    }
}

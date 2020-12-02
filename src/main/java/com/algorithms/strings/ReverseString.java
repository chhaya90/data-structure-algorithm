package com.algorithms.strings;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {


    public void swap(char[] s, int i, int j) {
        final char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void reverseString(char[] s) {
        /**
         *  N : length of char array.
         *  Time complexity O(N/2) space Complexity O(1)
         */
        if (s.length > 1) {
            int i = 0;
            int j = s.length - 1;
            while (i < j) {
                swap(s, i, j);
                i++;
                j--;
            }
        }
    }
}

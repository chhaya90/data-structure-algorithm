package com.algorithms.strings;


/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        /**
         *  N : length of string.
         *  Time Complexity : O(N).
         */
        if (s.length() == 0) {
            return false;
        }
        String str = s.replaceAll("[^A-Z0-9a-z]", "").toLowerCase();
        int p1 = 0;
        int p2 = str.length() - 1;
        while (p1 < p2) {
            if (str.charAt(p1) != str.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}

package com.algorithms.strings;

/**
 * Given an input string , reverse the string word by word.
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 */
public class ReverseWordsInStringII {
    public void reverse(char[] s, int st, int end) {
        while (st < end) {
            char temp = s[st];
            s[st] = s[end];
            s[end] = temp;
            st++;
            end--;
        }
    }

    public void reverseWords(char[] s) {
        /**
         * char array length N.
         * Time complexity O(2N) , Space complexity O(1)
         */
        reverse(s, 0, s.length - 1);
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') {
                int j = i;
                while (j < s.length - 1 && s[j + 1] != ' ') {
                    j++;
                }
                reverse(s, i, j);
                i = j;
            }
        }
    }
}

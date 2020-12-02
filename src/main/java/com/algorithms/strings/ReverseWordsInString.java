package com.algorithms.strings;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space
 * separating the words. Do not include any extra spaces.
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = str.length-1; i >= 0 ; i--) {
            if (i == 0) {
                sb.append(str[i]);
            } else {
                sb.append(str[i] + " ");
            }
        }
        return sb.toString();
    }
}

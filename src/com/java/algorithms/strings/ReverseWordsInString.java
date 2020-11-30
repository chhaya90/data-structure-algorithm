package com.java.algorithms.strings;

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

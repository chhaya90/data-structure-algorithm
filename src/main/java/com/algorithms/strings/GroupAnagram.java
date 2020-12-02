package com.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly
 * once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagram {

    public String sortString(final String s1) {
        /**
         * sorting the string  l: length of String
         *  Time Complexity : l+26+l  = O(l)
         *  Space Complexity : O(26) = O(1)
         */
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int k = count[i];
            while (k-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
    
    
    public boolean isAnagram(final String s1, final String s2) {
        /**
         * N : length of string.
         * Time Complexity : O(N+26)
         * Space Complexity : O(26+26)
         *
         */
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < n; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(final String[] strs) {
        /**
         * l : max length of each string.
         * N : size of strs.
         *
         * Time Complexity : N * l(sorting the string)
         *
         *
         */
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String sortedString = sortString(strs[i]);
            List<String> li = map.getOrDefault(sortedString, new ArrayList<>());
            li.add(strs[i]);
            map.put(sortedString, li);
        }
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

}

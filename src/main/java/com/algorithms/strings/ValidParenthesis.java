package com.algorithms.strings;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid
 * if: Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order.
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        /**
         * N : length of String.
         * Time Complexity O(N)
         * push pop operation on stack takes O(1) time.
         */
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);
            if (input == '(' || input == '[' || input == '{') {
                st.push(input);
            } else {
                if (!st.isEmpty()) {
                    char bracket = st.pop();
                    switch (bracket) {
                        case '[':
                            if (input != ']') {
                                return false;
                            }
                            break;
                        case '(':
                            if (input != ')') {
                                return false;
                            }
                            break;
                        default:
                            if (input != '}') {
                                return false;
                            }

                    }
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}

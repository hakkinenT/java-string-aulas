package com.hakkinent.leetcode;

import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {

        System.out.println(validateBrackets("([)]{}"));
        System.out.println(validateBrackets("([]){}"));
        System.out.println(validateBrackets("]"));
        System.out.println(validateBrackets("}"));
        System.out.println(validateBrackets(")"));
        System.out.println(validateBrackets("["));
        System.out.println(validateBrackets("("));
        System.out.println(validateBrackets("{"));
        System.out.println(validateBrackets("(])")); // não pode ser true
        System.out.println(validateBrackets("(]"));

    }

    private static boolean validateBrackets(String input) {
        /*
         * An input string is valid if:
         * 
         * Open brackets must be closed by the same type of brackets.
         * Open brackets must be closed in the correct order.
         * Every close bracket has a corresponding open bracket of the same type.
         * 
         * Hints
         * When you encounter an opening bracket, push it to the top of the stack.
         * When you encounter a closing bracket, check if the top of the stack was the
         * opening for it. If yes, pop it from the stack. Otherwise, return false.
         */

        Stack<Character> brackets = new Stack<>();

        for (char c : input.toCharArray()) {
            if(brackets.isEmpty() && (c == ')' || c == ']' || c == '}')){
                return false;
            }

            if (c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            }

            if(!brackets.isEmpty()){
                char top = brackets.peek();

                if(c == ')' && top != '('){
                    return false;
                }

                if(c == ']' && top != '['){
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }

                if (c == ')' && top == '(') {
                    brackets.pop();
                }

                
                if (c == ']' && top == '[') {
                    brackets.pop();
                }

                
                if (c == '}' && top == '{') {
                    brackets.pop();
                }
            }

        }

        if (!brackets.isEmpty()) {
            return false;
        }

        return true;
    }
}

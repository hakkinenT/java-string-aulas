package com.hakkinent.leetcode;

public class LeetcodeExercice {
    public static void main(String[] args) {
        String str1 = "([])()[]";
        String str2 = "([)()[]";
        String str3 = "([)()]";
        System.out.println(validBrackets(str1));
        System.out.println(validBrackets(str2));
        System.out.println(validBrackets(str3));
    }

    private static boolean validBrackets(String brackets){
        int[] count = new int[2];

        for (int i = 0; i < brackets.length(); i++) {
            if(brackets.charAt(i) == '('){
                count[0]++;
            }

            if (brackets.charAt(i) == ')') {
                count[0]--;
            }

            if (brackets.charAt(i) == '[') {
                count[1]++;
            }

            if (brackets.charAt(i) == ']') {
                count[1]--;
            }

        }

        for(int b : count){
            if(b != 0){
                return false;
            }
        }

        return true;
    }
}

package com.hakkinent.strings;

public class Exercice4 {
    public static void main(String[] args) {
        char[] wordChars = "aaabbbccdaa".toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordChars.length; i++) {
            char value = wordChars[i];
            sb.append(value);
            
            for (int j = i+1; j < wordChars.length; j++) {
                if(value == wordChars[j]){
                    i = i+1;
                }else{
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}

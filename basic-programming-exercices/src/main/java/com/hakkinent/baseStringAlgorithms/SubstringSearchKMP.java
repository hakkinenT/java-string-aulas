package com.hakkinent.baseStringAlgorithms;

import java.util.Arrays;

public class SubstringSearchKMP {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeLPSArray("ana")));
        KMP("banana", "ana");
        System.out.println("banana".substring(1, 4));
        System.out.println("banana".substring(3, 6));
        KMP("bbbbb", "b");
    }

    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
    
    public static void KMP(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
    
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (text.charAt(i) != pattern.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
     
    
    
}

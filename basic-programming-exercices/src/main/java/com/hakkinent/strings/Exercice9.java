package com.hakkinent.strings;

import java.util.*;

public class Exercice9 {
    public static String findLongestRepeatedSubstring(String str) {
        int n = str.length();

        // Passo 1: Construir o array de sufixos
        String[] suffixArray = new String[n];
        for (int i = 0; i < n; i++) { 
            suffixArray[i] = str.substring(i);
        }

        // Ordenar os sufixos lexicograficamente
        Arrays.sort(suffixArray);

        // Passo 2: Construir o array LCP
        int[] lcp = new int[n];
        for (int i = 1; i < n; i++) {
            lcp[i] = computeLCP(suffixArray[i - 1], suffixArray[i]);
        }

        // Passo 3: Encontrar a maior entrada no array LCP
        int maxLength = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (lcp[i] > maxLength) {
                maxLength = lcp[i];
                index = i;
            }
        }

        // A substring mais longa que se repete
        return suffixArray[index].substring(0, maxLength);
    }

    // Função auxiliar para calcular o LCP de duas strings
    private static int computeLCP(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return i;
    }

    // Testar o programa
    public static void main(String[] args) {
        String input = "banana";
        String result = findLongestRepeatedSubstring(input);
        System.out.println("A substring mais longa que se repete é: " + result);
    }
    
}

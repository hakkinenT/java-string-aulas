package com.hakkinent.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercice7 {
    public static void main(String[] args) {
        System.out.println(isAnagram("amor", "roma"));
        System.out.println(isAnagram("pedra", "perda"));
        System.out.println(isAnagram("pedra", "padre"));
        System.out.println(isAnagram("café", "java"));
        System.out.println(isAnagram("Quid est veritas".replaceAll("\\s", ""), "Est vir qui adest".replaceAll("\\s", "")));
    }

    private static boolean isAnagram(String word1, String word2) {
        // Verifica se as palavras têm o mesmo comprimento
        if (word1.length() != word2.length()) {
            return false;
        }
    
        // Mapa para contar os caracteres
        Map<Character, Integer> charCountMap = new HashMap<>();
    
        // Incrementa contagem para cada caractere em word1
        for (char c : word1.toLowerCase().toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
    
        // Decrementa contagem para cada caractere em word2
        for (char c : word2.toLowerCase().toCharArray()) {
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
        }
    
        // Verifica se todas as contagens são zero
        return charCountMap.values().stream().allMatch(count -> count == 0);
    }
    

    private static boolean isAnagram1(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        char[] word1Chars = word1.toLowerCase().toCharArray();
        char[] word2Chars = word2.toLowerCase().toCharArray();

        Arrays.sort(word1Chars);
        Arrays.sort(word2Chars);

        return Arrays.equals(word1Chars, word2Chars);
    }

}

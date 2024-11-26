package com.hakkinent.strings;

public class Exercice6 {
    public static void main(String[] args) {
        String phrase = "A man, a plan, a canal, Panama";

        //* A regex "[\\p{Punct}]" remove qualquer caractere de pontução reconhecido pela classe Unicode */
        //* A regex [.,;:] remove os caracteres . , ; : respectivamente */

        String newPhrase = phrase.replaceAll("[\\p{Punct}\\s]", "").toLowerCase();

        String test = invert(newPhrase);
        System.out.println(newPhrase.compareTo(test) == 0);
    }

    private static String invert(String word){
        StringBuilder sb = new StringBuilder();
        char[] wordChars = word.toCharArray();
        
        int length = wordChars.length - 1;

        for (int i = length; i >= 0; i--) {
            sb.append(wordChars[i]);
        }

        

        return sb.toString();
    }
}

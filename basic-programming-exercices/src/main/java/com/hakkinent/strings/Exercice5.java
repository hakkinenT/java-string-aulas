package com.hakkinent.strings;

public class Exercice5 {
    public static void main(String[] args) {
        String phrase = "três coisas vida nunca voltam atrás flecha lançada palavra pronunciada oportunidade perdida";
        
        //String regex1 = "\\b\\w{1,3}\\b\\s*"; //*Palavras que não contém acento */
        String regex = "\\b[\\p{L}\\p{N}_]{1,3}\\b\\s*"; //*Palavras que contenham  acento */

        // Remove palavras com menos de 4 caracteres e os espaços extras resultantes
        String fraseSemPalavrasCurtas = phrase.replaceAll(regex, "");

        System.out.println("Frase sem palavras curtas: " + fraseSemPalavrasCurtas.trim());

    }
}

package com.hakkinent.strings;

public class Exercice2 {
    public static void main(String[] args) {
        System.out.println(countCaracterOcurrence("Há três coisas na vida que nunca voltam atrás: a flecha lançada, a palavra pronunciada e a oportunidade perdida.", 'a'));
    }

    private static int countCaracterOcurrence(String phrase, char caracter){
        int count = 0;

        for (int i = 0; i < phrase.length(); i++) {
            if(phrase.charAt(i) == caracter){
                count++;
            }
        }

        return count;
    }
}

package com.hakkinent.strings;

import java.util.Arrays;

public class Exercice3 {
    public static void main(String[] args) {
        String phrase = "três coisas vida nunca voltam atrás flecha lançada palavra pronunciada oportunidade perdida";
        String[] words = phrase.split("\\s");
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("A palavra de menor tamanho é: " + words[0]);
        System.out.println("A palavra de maior tamanho é: " + words[words.length - 1]);
    }

}


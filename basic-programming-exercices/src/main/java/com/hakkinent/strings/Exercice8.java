package com.hakkinent.strings;

public class Exercice8 {
    public static void main(String[] args) {
        String phrase = "Meu telefone é 1234 e meu código é 5678.";
        System.out.println(phrase.replaceAll("\\d", "#"));
    }
}

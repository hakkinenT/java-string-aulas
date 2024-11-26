package com.hakkinent.strings;

public class Exercice1 {
    public static void main(String[] args) {
        System.out.println(replaceCaracter("banana", "a"));
    }

    private static String replaceCaracter(String word, String caracter){
        return word.replace(caracter, "");
    }
}

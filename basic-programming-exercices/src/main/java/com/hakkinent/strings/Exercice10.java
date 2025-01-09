package com.hakkinent.strings;

public class Exercice10 {
    public static void main(String[] args) {
        String[] strings = {"pay","attention","practice","attend"};
        String prefix = "at";
        System.out.println(encontrarLCP(strings, prefix));
    }

    public static int encontrarLCP(String[] strings, String prefix) {
        
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            
            if (strings[i].startsWith(prefix)) {
                count++;
            }
        }

        return count;
    }
}

package com.hakkinent.strings;


public class CifraCesar {
    public static void main(String[] args) {
        String word = "HELLO";

        System.out.println(caesarCipherEncryption(word, 3));
        System.out.println(caesarCipherEncryption("abc", 3));
        System.out.println(caesarCipherEncryption("ZEITUNG", 3));
        System.out.println(caesarCipherEncryption("zeitung", 3));

        System.out.println(caesarCipherDecryption("KHOOR", 3));
        System.out.println(caesarCipherDecryption("def", 3));
        System.out.println(caesarCipherDecryption("AHLWXQJ", 3));
        System.out.println(caesarCipherDecryption("ahlwxqj", 3));
    }

    private static String caesarCipherEncryption(String word, int key){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int code = word.codePointAt(i) + key;

            //! Quando chega em Z|z retorna para A|a
            if (word.charAt(i) == 'Z' || word.charAt(i) == 'z') {
                code = code - 25 - key;
            }

            sb.append((char) code);
        }

        return sb.toString();
    }

    private static String caesarCipherDecryption(String word, int key){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int code = word.codePointAt(i) - key;

            //! Quando chega em A|a retorna para Z|z
            if (word.charAt(i) == 'A' || word.charAt(i) == 'a') {
                code = code + 25 + key;
            }

            sb.append((char) code);
        }

        return sb.toString();
    }
}

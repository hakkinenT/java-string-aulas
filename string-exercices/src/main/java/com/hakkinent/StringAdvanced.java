package com.hakkinent;


import java.util.Arrays;

public class StringAdvanced {
    public static void main(String[] args) {
        StringBuffer bf = new StringBuffer();
        bf.append("Hello")
            .append(" ")
            .append("world")
            .append("!")
            .append(" ")
            .append(2024)
            .append(Arrays.asList("1", "2", "3"));
        System.out.println(bf.toString());

        String numbers = "0123456789";
        StringBuffer bf2 = new StringBuffer(numbers);
        System.out.println(bf2.substring(3));
        System.out.println(bf2.substring(4, 8));
        System.out.println(bf2.replace(3, 5, "ABCDE"));

        bf2 = new StringBuffer(numbers);
        System.out.println(bf2.reverse());
        bf2.reverse();

        bf2 = new StringBuffer(numbers);
        System.out.println(bf2.delete(5, 9));
        System.out.println(bf2.deleteCharAt(1));
        System.out.println(bf2.insert(1, "one"));
    }
}

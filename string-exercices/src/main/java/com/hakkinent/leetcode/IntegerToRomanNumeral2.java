package com.hakkinent.leetcode;

import java.util.*;

public class IntegerToRomanNumeral2 {
    public static void main(String[] args) {
        //int num = 3749;
        int num = 1994;
        String numString = String.valueOf(num);

        Map<Integer, String> romanTable = Map.ofEntries(
            new AbstractMap.SimpleEntry<Integer, String>(1, "I"),
            new AbstractMap.SimpleEntry<Integer, String>(5, "V"),
            new AbstractMap.SimpleEntry<Integer, String>(10, "X"),
            new AbstractMap.SimpleEntry<Integer, String>(50, "L"),
            new AbstractMap.SimpleEntry<Integer, String>(100, "C"),
            new AbstractMap.SimpleEntry<Integer, String>(500, "D"),
            new AbstractMap.SimpleEntry<Integer, String>(1000, "M")
        );
        String romanNumber = "";

        for(int i = 0; i < numString.length(); i++){
            int exponencial = (numString.length() - 1) - i;
            int base = (int) Math.pow(10, exponencial);
            int number = Character.getNumericValue(numString.charAt(i));

            if(number >= 1 && number < 4){
                romanNumber += romanTable.get(base).repeat(number);
            }

            if(number == 4){
                romanNumber += romanTable.get(base).concat(romanTable.get(5 * base));
            }

            if(number == 5){
                romanNumber += romanTable.get(5 * base);
            }

            if(number > 5 && number < 9){
                int repeat = number - 5;
                romanNumber += romanTable.get(5 *  base).concat(romanTable.get(base).repeat(repeat));
            }

            if(number == 9){
                romanNumber += romanTable.get(base).concat(romanTable.get(base * 10));
            }
        }
        
        System.out.println(romanNumber);

        //System.out.println("M".repeat(3));

        //System.out.println(thousands);
        //System.out.println(hundred);
        //System.out.println(ten);
        //System.out.println(unit);
    }
}

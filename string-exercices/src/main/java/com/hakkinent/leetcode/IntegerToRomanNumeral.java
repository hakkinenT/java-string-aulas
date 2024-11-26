package com.hakkinent.leetcode;

import java.util.*;

public class IntegerToRomanNumeral {
    public static void main(String[] args) {
        int num = 3749;
        int thousands = num / 1000;
        int hundred = (num % 1000) / 100;
        int ten = (num % 100) / 10;
        int unit = (num % 10);

        Map<Integer, String> romanTable = new HashMap<>();
        romanTable.put(1, "I");
        romanTable.put(5, "V");
        romanTable.put(10, "X");
        romanTable.put(50, "L");
        romanTable.put(100, "C");
        romanTable.put(500, "D");
        romanTable.put(1000, "M");
        
        System.out.println();
        String romanNumber = "";

        romanNumber += romanTable.get(1000).repeat(thousands);
        
        if(hundred >= 1 && hundred <= 3){
            romanNumber += romanTable.get(100).repeat(hundred);
        }
        if (hundred == 4) {
            String romanFourHundred = romanTable.get(100).concat(romanTable.get(500));
            romanNumber += romanFourHundred;
        }
        if(hundred == 5){
            romanNumber += romanTable.get(500);
        }
        if(hundred > 5 && hundred <= 8){
            int cquantity = hundred -  5;
            String dc = "D".concat(romanTable.get(100).repeat(cquantity));
            romanNumber += dc;
        }

        if (hundred == 9) {
            String romanNineHundred = romanTable.get(100).concat(romanTable.get(1000));
            romanNumber += romanNineHundred;
        }

        if(ten >= 1 && ten <= 3){
            romanNumber += "X".repeat(ten);
        }
        if (ten == 4) {
            String romanForty = romanTable.get(10).concat(romanTable.get(50));
            romanNumber += romanForty;
        }
        if(ten == 5){
            romanNumber += romanTable.get(50);
        }
        if(ten > 5 && ten <= 8){
            int xquantity = ten -  5;
            String lx = "L".concat(romanTable.get(10).repeat(xquantity));
            
            romanNumber += lx;
        }
        if (ten == 9) {
            String romanNinety = romanTable.get(10).concat(romanTable.get(100));
            romanNumber += romanNinety;
        }

        if(unit >= 1 && unit <= 3){
            romanNumber += "I".repeat(unit);
        }
        if (unit == 4) {
            String romanFour = romanTable.get(1).concat(romanTable.get(5));
            romanNumber += romanFour;
        }
        if(unit == 5){
            romanNumber += romanTable.get(5);
        }
        if(unit > 5 && unit <= 8){
            int iquantity = unit -  5;
            String vi = "V".concat(romanTable.get(1).repeat(iquantity));
            
            romanNumber += vi;
        }
        if (unit == 9) {
            String romanNine = romanTable.get(1).concat(romanTable.get(10));
            romanNumber += romanNine;
        }

 

        System.out.println(romanNumber);

        //System.out.println("M".repeat(3));

        //System.out.println(thousands);
        //System.out.println(hundred);
        //System.out.println(ten);
        //System.out.println(unit);
    }
}

package com.hakkinent.arrays;


import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Exercice3 {
    public static void main(String[] args) {
        int[] arr = new int[]{9,50,-6,4,0};
        int position = simpleSearch(arr, 50);
        System.out.println(position);
        position = simpleSearch(arr, 500);
        System.out.println(position);

        int position2 = searchWithStream(arr, 9);
        System.out.println(position2);
        position2 = searchWithStream(arr, 4);
        System.out.println(position2);
        position2 = searchWithStream(arr, -1);
        System.out.println(position2);

    }

    private static int simpleSearch(int[] arr, int element){
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if(element == arr[i]){
                return i;
            }
        }

        return -1;
    }

    private static int searchWithStream(int[] arr, int element){
        OptionalInt position = IntStream.range(0, arr.length)
                .filter(i -> arr[i] == element)
                .findFirst();

        if(position.isPresent()){
            return position.getAsInt();
        }else{
            return -1;
        }
    }
}

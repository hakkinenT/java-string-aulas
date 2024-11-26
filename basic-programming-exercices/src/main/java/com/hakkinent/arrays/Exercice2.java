package com.hakkinent.arrays;

import java.util.stream.IntStream;

public class Exercice2 {
    public static void main(String[] args) {
        String result = sumArrayWithoutStream(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5});
        System.out.println(result);

        String result1 = sumArraysWithStream(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5});
        System.out.println(result1);
    }

    private static String sumArrayWithoutStream(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            throw new IllegalArgumentException("Os arrays precisam ter tamanhos iguais");
        }

        int[] result = new int[arr1.length];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        
        return arrayToString(result);
    }

    private static String sumArraysWithStream(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Os arrays precisam ter tamanhos iguais");
        }

        int[] result = IntStream.range(0, arr1.length)
                            .map(i -> arr1[i] + arr2[i])
                            .toArray();

        return arrayToString(result);
    }

    private static String arrayToString(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                sb.append(arr[i]).append("]");
            }else{
                sb.append(arr[i]).append(", ");
            }
        }

        return sb.toString();
    }
}

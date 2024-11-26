package com.hakkinent.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Exercice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a quantidade de elementos do array: ");
        int tam = sc.nextInt();
        int[] arr = new int[tam];
        int i = 0;
        System.out.println("Informe os elementos do array:");
        while (i < tam) {
            arr[i] = sc.nextInt();
            i++;
        }
        
        System.out.println();
        int sum = sumWithStream(arr);
        double average = avgWithStream(arr);
        int min = minWithStream(arr);
        int max = maxWithStream(arr);
        System.out.println("somatório = " + sum);
        System.out.println("média = " + average);
        System.out.println("min = " + min);
        System.out.println("max = " + max);

        sc.close();
        
    }

    private static int sumWithoutStream(int[] arr){
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    private static double avgWithoutStream(int[] arr){
        int tam = arr.length;
        int sum = sumWithoutStream(arr);
        return sum / tam;
    }

    private static int minWithoutStream(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }

        return min;
    }

    private static int maxWithoutStream(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    private static int sumWithStream(int[] arr){
        return Arrays.stream(arr).sum();
    }

    private static double avgWithStream(int[] arr){
        return Arrays.stream(arr).average().orElse(Double.NaN);
    }

    private static int minWithStream(int[] arr){
        return Arrays.stream(arr).min().getAsInt();
    }

    private static int maxWithStream(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}

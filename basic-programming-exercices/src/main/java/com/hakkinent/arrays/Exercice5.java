package com.hakkinent.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercice5 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,4,5};
        int[] finalArr = excludeRepeatingNumbers(arr);

        for (int i : finalArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr1 = {1, 2, 2, 3, 4, 4, 5}; // Resultado esperado: [1, 2, 3, 4, 5]
        System.out.println(arrayToString(excludeRepeatingNumbers2(arr1)));
        int[] arr2 = {5, 5, 5, 5};          // Resultado esperado: [5]
        System.out.println(arrayToString(excludeRepeatingNumbers2(arr2)));
        int[] arr3 = {1, 2, 3, 4, 5};       // Resultado esperado: [1, 2, 3, 4, 5]
        System.out.println(arrayToString(excludeRepeatingNumbers2(arr3)));
        int[] arr4 = {2, 1, 2, 3, 4};       // Resultado esperado: [2, 1, 3, 4]
        System.out.println(arrayToString(excludeRepeatingNumbers2(arr4)));

    }

    //! O código abaixo funciona para duplicata consecutivas, mas não funciona para arrays não ordenados
    //! Além disso é uma solução custosa em termos de desempenho por ter de "empurrar" os elementos após encontrar duplicatas
    private static int[] excludeRepeatingNumbers(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean boundPosition = (i+1 > arr.length-1) || (i+2 > arr.length-1);
            if(!boundPosition && arr[i] == arr[i+1]){
                count++;
                
                int j = i+1;
                while (j < arr.length-1) {
                    arr[j] = arr[j+1];
                    arr[j+1] = 0;
                    j++;
                }
            }
        }

        int[] finalArr = Arrays.copyOf(arr, arr.length - count);
        return finalArr;
    }

    //* Solução melhorada pelo chatGPT */
    //* BENEFICIOS DESSE CÓDIGO */
    //*    1. Funciona com arrays desordenados - Devido ao uso do Set que só admite números unicos */
    //*    2. Mantém a ordem original - devido ao uso do LinkedHashSet que preserva a ordem de inserção */
    //*    3. O código é mais fácil de entender */
    //*    4. Melhor desempenho: inserção em um Set é O(1), eliminação de movimentações no array */
    private static int[] excludeRepeatingNumbers2(int[] arr){
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        for (int num : arr) {
            uniqueNumbers.add(num);
        }

        int[] result = new int[uniqueNumbers.size()];
        int index = 0;
        for (int num : uniqueNumbers) {
            result[index++] = num;
        }

        return result;
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

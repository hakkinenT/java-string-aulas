package com.hakkinent.arrays;



public class Exercice4 {
    public static void main(String[] args) {
        System.out.println(simpleReverse(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    private static String simpleReverse(int[] arr){
        for (int i = 0; i < arr.length/2; i++) {
            int aux = arr[i];
            int lastIndex = arr.length - 1 - i;
            arr[i] = arr[lastIndex];
            arr[lastIndex] = aux;
        }
        
        return arrayToString(arr);
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

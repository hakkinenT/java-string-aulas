package com.hakkinent.arrays;

import java.util.Arrays;

public class Exercice9 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] result = new int[]{1,1,1,1};

        
        int currentIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            
            currentIndex = i + 1;
            if(i == arr.length-1){
                currentIndex = 0;
            }
            
            for (int k = 1; k < result.length; k++) {
                result[i] *= arr[currentIndex];
                currentIndex++;
                if(currentIndex >= arr.length){
                    currentIndex = 0;
                }
                
                
            }
            
        }

        System.out.println(Arrays.toString(result));
    }
}

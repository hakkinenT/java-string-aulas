package com.hakkinent.arrays;

import java.util.Arrays;

public class RotationUniArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        circularShiftRight(arr, 2);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[]{1,2,3,4,5};
        shiftRight(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{1,2,3,4,5};
        rearrange(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{1,2,3,4,5,6,7,8,9,10};
        rotateLeft(arr4, 4);
        System.out.println(Arrays.toString(arr4));
        System.out.println();
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        //transpose(matrix1);
        shiftColumnUp(matrix1, 1);
        System.out.println(printMatrix(matrix1));
    }

    private static String printMatrix(int[][] matrix1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix1.length; i++) {
            sb.append("{");
            for (int j = 0; j < matrix1[0].length; j++) {
                sb.append(" ").append(matrix1[i][j]);
                if(j != matrix1[0].length - 1){
                    sb.append(", ");
                }
            }
            sb.append("}");

            if (i != matrix1.length-1) {
                sb.append(",").append("\n");
            };
        }

        return sb.toString();
    }

    public static void circularShiftRight(int[] arr, int steps){
        rotateRight(arr, steps);
    }

    private static void rotateRight(int[] arr, int steps){
        int n = arr.length;
        steps %= n;
         
        reverse(arr, 0, n - 1);
        reverse(arr, 0, steps - 1);
        reverse(arr, steps, n - 1);
    }

    private static void reverse(int[] arr, int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    private static void rotateLeft(int[] arr, int steps){
        int n = arr.length;
        steps %= n;
        
         
        reverse(arr, 0, steps - 1);
        reverse(arr, steps, n - 1);
        reverse(arr, 0, n - 1 );
    }

    

    public static void shiftRight(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = 0;
    }

    public static void shiftLeft(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = 0;
    }

    public static void rearrange(int[] arr){
        int left = 0; int right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 0 && left < right) left++;
            while (arr[right] % 2 != 0 && left < right) right--;
            if(left < right){
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
    }

    //* ARRAY MULTIDIMENSIONAL */
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void rotateMatrix90Clockwise(int[][] matrix) {
        int n = matrix.length;
        // Transpor a matriz
        transpose(matrix);
        // Inverter as colunas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
    
    public static void shiftRowRight(int[][] matrix, int row) {
        int cols = matrix[row].length;
        int temp = matrix[row][cols - 1];
        for (int j = cols - 1; j > 0; j--) {
            matrix[row][j] = matrix[row][j - 1];
        }
        matrix[row][0] = temp;
    }

    public static void shiftRowLeft(int[][] matrix, int row) {
        int cols = matrix[row].length;
        int temp = matrix[row][0];
        for (int j = 0; j < cols - 1; j++) {
            matrix[row][j] = matrix[row][j + 1];
        }
        matrix[row][cols - 1] = temp;
    }

    public static void shiftColumnDown(int[][] matrix, int col) {
        int rows = matrix.length;
        int temp = matrix[rows - 1][col];
        for (int i = rows - 1; i > 0; i--) {
            matrix[i][col] = matrix[i - 1][col];
        }
        matrix[0][col] = temp;
    }

    public static void shiftColumnUp(int[][] matrix, int col) {
        int rows = matrix.length;
        int temp = matrix[0][col];
        for (int i = 0; i < rows - 1; i++) {
            matrix[i][col] = matrix[i + 1][col];
        }
        matrix[rows - 1][col] = temp;
    }
    
}

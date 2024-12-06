package com.hakkinent.arrays;

public class Exercice6 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println("sum = " + sum);

        
        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        System.out.println("diagonal principal = " + sum);

        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int j = (matrix[0].length - 1) - i;
            sum += matrix[i][j];
        }

        System.out.println("diagonal secundária = " + sum);

    }
}

package com.hakkinent.arrays;

public class Exercice7 {
    public static void main(String[] args) {
        int[][] matrixA = {
            {1,2},
            {3,4}
        };

        int[][] matrixB = {
            {5,6},
            {7,8}
        };

        int[][] result = {
            {0,0},
            {0,0}
        };

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                for (int k = 0; k < result.length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }         
            }
        }

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                System.out.print(result[i][j] + " ");         
            }
        }
    }
}

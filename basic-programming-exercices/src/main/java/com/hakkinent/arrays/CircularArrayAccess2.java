package com.hakkinent.arrays;

public class CircularArrayAccess2 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        // Número de acessos circulares que queremos fazer
        int accesses = 10;

        for (int i = 0; i < accesses; i++) {
            // O índice circular é calculado usando o operador de módulo
            int circularIndex = i % array.length;

            // Acessa o elemento do array no índice calculado
            System.out.println("Acesso " + i + ": " + array[circularIndex]);
        }
    }
        
}


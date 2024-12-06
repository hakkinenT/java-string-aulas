package com.hakkinent.arrays;

public class CircularArrayAccess {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};

        // Número de acessos circulares que queremos fazer
        int accesses = 10;

        int currentIndex = 0; // Índice inicial
        for (int i = 0; i < accesses; i++) {
            // Acessa o elemento no índice atual
            System.out.println("Acesso " + i + ": " + array[currentIndex]);

            // Atualiza o índice circularmente sem usar divisão
            currentIndex++;
            if (currentIndex >= array.length) {
                currentIndex = 0; // Volta para o início
            }
        }
    }
}


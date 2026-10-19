package Semana2;

import java.util.Scanner;

public class Aregloundimencional9 {
     public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Tamaño del arreglo: ");
            int n = scanner.nextInt();
            int[] arreglo = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese el elemento " + (i + 1) + ": ");
                arreglo[i] = scanner.nextInt();
            }

            System.out.print("Número a buscar: ");
            int numero = scanner.nextInt();

            int contador = 0;
            for (int i = 0; i < n; i++) {
                if (arreglo[i] == numero) {
                    contador++;
                }
            }

            System.out.println("El número " + numero + " aparece " + contador + " veces.");
        }
    }
}


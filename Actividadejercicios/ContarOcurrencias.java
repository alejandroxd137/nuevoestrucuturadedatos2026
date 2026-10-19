package Actividadejercicios;

import java.util.Scanner;

public class ContarOcurrencias {
   public static int contarOcurrencias(int[] arreglo, int numero) {
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = sc.nextInt();

        int[] arreglo = new int[n];
        System.out.println("Ingrese los " + n + " elementos:");
        for (int i = 0; i < n; i++) {
            arreglo[i] = sc.nextInt();
        }

        System.out.print("Ingrese el número a buscar: ");
        int numero = sc.nextInt();

        int veces = contarOcurrencias(arreglo, numero);

        System.out.println("El número " + numero + " aparece " + veces + " veces en el arreglo.");

        sc.close();
    }
}
package Actividadejercicios;

import java.util.Scanner;

public class ClasificaciondeArreglo {
    public static int main(String[] args) {
    int N;
    System.out.print("Ingrese el tamaño del arreglo: ");
    try (Scanner sc = new Scanner(System.in)) {
        N = sc.nextInt();

        int A[] = new int[N];
        int negativos[] = new int[N];
        int ceros[] = new int[N];
        int positivos[] = new int[N];
        int iNeg = 0, iCero = 0, iPos = 0;

        for (int i = 0; i < N; i++) {
            System.out.print("A[" + i + "]: ");
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] < 0)
                negativos[iNeg++] = A[i];
            else if (A[i] == 0)
                ceros[iCero++] = A[i];
            else
                positivos[iPos++] = A[i];
        }

        System.out.print("Negativos: ");
        for (int i = 0; i < iNeg; i++) System.out.print(negativos[i] + " ");

        System.out.print("\nCeros: ");
        for (int i = 0; i < iCero; i++) System.out.print(ceros[i] + " ");

        System.out.print("\nPositivos: ");
        for (int i = 0; i < iPos; i++) System.out.print(positivos[i] + " ");
    }
    return 0;
}
}
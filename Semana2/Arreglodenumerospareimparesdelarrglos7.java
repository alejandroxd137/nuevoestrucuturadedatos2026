package Semana2;

public class Arreglodenumerospareimparesdelarrglos7 {
     public static void main(String[] args) {
        int[] arreglo = { 8, 5, 3, 10, 2, 8, 1 };
        int[] arregloPar = new int[arreglo.length / 2];
        int[] arregloImpar = new int[arreglo.length / 2 + 1];

        if (arreglo.length % 2 == 0) {
            for (int i = 0; i < arreglo.length / 2; i++) {
                arregloPar[i] = arreglo[i] + arreglo[arreglo.length - 1 - i];
            }
            System.out.println("Arreglo Par: ");
            for (int num : arregloPar) {
                System.out.print(num + " ");
            }
        } else {
            for (int i = 0; i < arreglo.length / 2; i++) {
                arregloImpar[i] = arreglo[i] + arreglo[arreglo.length - 1 - i];
            }
            arregloImpar[arregloImpar.length - 1] = arreglo[arreglo.length / 2];
            System.out.println("Arreglo Impar: ");
            for (int num : arregloImpar) {
                System.out.print(num + " ");
            }
        }
}
}


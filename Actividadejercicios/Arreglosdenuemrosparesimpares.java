package Actividadejercicios;

public class Arreglosdenuemrosparesimpares {
        public static void main(String[] args) {
            int[] numeros = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 };
           int contPares = 0;
        int contImpares = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                contPares++;
            } else {
                contImpares++;
            }
        }

        // Crear los arreglos con el tamaño exacto   necesario
        int[] pares = new int[contPares];
        int[] impares = new int[contImpares];

        // 3) Llenar cada arreglo
        int p = 0;
        int im = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                pares[p] = numeros[i];
                p++;
            } else {
                impares[im] = numeros[i];
                im++;
            }
        }

        // Mostrar resultados
        System.out.println("Números pares:");
        for (int i = 0; i < pares.length; i++) {
            System.out.println(pares[i]);
        }

        System.out.println("\nNúmeros impares:");
        for (int i = 0; i < impares.length; i++) {
            System.out.println(impares[i]);
        }
    }
}
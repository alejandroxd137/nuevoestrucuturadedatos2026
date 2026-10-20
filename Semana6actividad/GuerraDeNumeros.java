package Semana6actividad;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class GuerraDeNumeros {

    // Método principal para resolver la guerra de números usando una cola
    public static int calcularGuerraDeNumeros(List<Integer> conjuntoEnteros) {
        // Creación de la cola para almacenar los números
        Queue<Integer> cola = new ArrayDeque<>();
        
        int sumaPares = 0;
        int sumaImpares = 0;

        // 1. Encolar todos los números del conjunto
        for (int numero : conjuntoEnteros) {
            cola.offer(numero);
        }

        // 2. Desencolar uno a uno y sumar por separado pares e impares
        while (!cola.isEmpty()) {
            int numeroActual = cola.poll(); // Desencola el número al frente
            
            if (numeroActual % 2 == 0) {
                sumaPares += numeroActual;
            } else {
                sumaImpares += numeroActual;
            }
        }

        // 3. Retornar la diferencia absoluta entre ambas sumas
        return Math.abs(sumaImpares - sumaPares);
    }

    // Pruebas con los ejemplos de verificación de la imagen
    public static void main(String[] args) {
        // Ejemplo 1
        List<Integer> entrada1 = Arrays.asList(2, 8, 7, 5);
        System.out.println("Ejemplo 1 - Entrada: " + entrada1);
        System.out.println("Salida esperada: 2 -> Salida real: " + calcularGuerraDeNumeros(entrada1));
        System.out.println();

        // Ejemplo 2
        List<Integer> entrada2 = Arrays.asList(1, 3, 5, 9);
        System.out.println("Ejemplo 2 - Entrada: " + entrada2);
        System.out.println("Salida esperada: 18 -> Salida real: " + calcularGuerraDeNumeros(entrada2));
        System.out.println();

        // Ejemplo 3
        List<Integer> entrada3 = Arrays.asList(2, 4, 6, 8);
        System.out.println("Ejemplo 3 - Entrada: " + entrada3);
        System.out.println("Salida esperada: 20 -> Salida real: " + calcularGuerraDeNumeros(entrada3));
    }
}

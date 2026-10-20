package Semana6actividad;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FiltradoPalabras {

    // Método principal para realizar el filtrado utilizando una cola
    public static List<String> filtrarCadenasDeCuatroLetras(List<String> listaPalabras) {
        // Creación de la cola para modelar el proceso
        Queue<String> cola = new ArrayDeque<>();
        List<String> resultado = new ArrayList<>();

        // 1. Modela el proceso encolando todas las palabras
        for (String palabra : listaPalabras) {
            cola.offer(palabra);
        }

        // 2. Desencolando para filtrar las que tienen exactamente 4 letras
        while (!cola.isEmpty()) {
            String palabraActual = cola.poll(); // Desencola la palabra al frente
            
            if (palabraActual.length() == 4) {
                resultado.add(palabraActual);
            }
        }

        return resultado;
    }

    // Pruebas con los ejemplos de verificación de la imagen
    public static void main(String[] args) {
        // Ejemplo 1
        List<String> entrada1 = Arrays.asList("Tomate", "Papa", "Par");
        System.out.println("Ejemplo 1 - Entrada: " + entrada1);
        System.out.println("Salida esperada: [Papa] -> Salida real: " + filtrarCadenasDeCuatroLetras(entrada1));
        System.out.println();

        // Ejemplo 2
        List<String> entrada2 = Arrays.asList("Luz", "Casa", "Sol", "Lago");
        System.out.println("Ejemplo 2 - Entrada: " + entrada2);
        System.out.println("Salida esperada: [Casa, Lago] -> Salida real: " + filtrarCadenasDeCuatroLetras(entrada2));
        System.out.println();

        // Ejemplo 3
        List<String> entrada3 = Arrays.asList("Azul", "Rojo", "Verde");
        System.out.println("Ejemplo 3 - Entrada: " + entrada3);
        System.out.println("Salida esperada: [Azul, Rojo] -> Salida real: " + filtrarCadenasDeCuatroLetras(entrada3));
    }
}

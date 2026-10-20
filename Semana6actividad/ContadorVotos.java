package Semana6actividad;

import java.util.LinkedList;
import java.util.Queue;

public class ContadorVotos {

    public static int calcularDiferenciaVotos(int upvotes, int downvotes) {
        // Creamos la cola utilizando LinkedList (implementación común de Queue en Java)
        Queue<Integer> colaVotos = new LinkedList<>();

        // 1. Modelar los votos a favor (+1) agregándolos a la cola
        for (int i = 0; i < upvotes; i++) {
            colaVotos.add(1);
        }

        // 2. Modelar los votos en contra (-1) agregándolos a la cola
        for (int i = 0; i < downvotes; i++) {
            colaVotos.add(-1);
        }

        // 3. Procesar la cola sumando todos los valores hasta vaciarla
        int sumaTotal = 0;
        while (!colaVotos.isEmpty()) {
            // poll() extrae y elimina el elemento al frente de la cola
            sumaTotal += colaVotos.poll(); 
        }

        // Retornar el resultado final de la diferencia
        return sumaTotal;
    }

    // Método principal para verificar los ejemplos del enunciado
    public static void main(String[] args) {
        // Ejemplo 1: upvotes = 13, downvotes = 0
        System.out.println("Ejemplo 1 -> Salida: " + calcularDiferenciaVotos(13, 0)); // Esperado: 13

        // Ejemplo 2: upvotes = 2, downvotes = 33
        System.out.println("Ejemplo 2 -> Salida: " + calcularDiferenciaVotos(2, 33)); // Esperado: -31

        // Ejemplo 3: upvotes = 132, downvotes = 132
        System.out.println("Ejemplo 3 -> Salida: " + calcularDiferenciaVotos(132, 132)); // Esperado: 0
    }
}

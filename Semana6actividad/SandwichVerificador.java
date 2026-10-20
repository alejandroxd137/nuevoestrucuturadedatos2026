package Semana6actividad;

import java.util.ArrayDeque;
import java.util.Deque;

public class SandwichVerificador {

    public static boolean tienenPanSimilar(String[] s1, String[] s2) {
        // Creamos una cola de doble extremo (Deque) para cada sándwich
        Deque<String> sandwich1 = new ArrayDeque<>();
        Deque<String> sandwich2 = new ArrayDeque<>();

        // Llenamos el primer Deque con los ingredientes de S1
        for (String ingrediente : s1) {
            sandwich1.addLast(ingrediente);
        }

        // Llenamos el segundo Deque con los ingredientes de S2
        for (String ingrediente : s2) {
            sandwich2.addLast(ingrediente);
        }

        // Obtenemos los panes del primer sándwich (inicio y final) sin removerlos
        String panInicioS1 = sandwich1.peekFirst();
        String panFinalS1 = sandwich1.peekLast();

        // Obtenemos los panes del segundo sándwich (inicio y final) sin removerlos
        String panInicioS2 = sandwich2.peekFirst();
        String panFinalS2 = sandwich2.peekLast();

        // Verificamos si usan el mismo tipo de pan tanto al inicio como al final
        boolean mismoInicio = panInicioS1.equals(panInicioS2);
        boolean mismoFinal = panFinalS1.equals(panFinalS2);

        return mismoInicio && mismoFinal;
    }

    // Método principal para probar con los ejemplos del enunciado
    public static void main(String[] args) {
        // Ejemplo de verificación 1
        String[] s1_ej1 = {"pan blanco", "lechuga", "pan blanco"};
        String[] s2_ej1 = {"pan blanco", "tomate", "pan blanco"};
        System.out.println("Ejemplo 1 -> Salida: " + tienenPanSimilar(s1_ej1, s2_ej1)); // Esperado: true

        // Ejemplo de verificación 2
        String[] s1_ej2 = {"pan integral", "queso", "pan integral"};
        String[] s2_ej2 = {"pan blanco", "queso", "pan integral"};
        System.out.println("Ejemplo 2 -> Salida: " + tienenPanSimilar(s1_ej2, s2_ej2)); // Esperado: false
    }
}
package Semanaevaluativa;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistorialOperaciones {
    // Definimos la pila usando ArrayDeque
    private Deque<String> pilaOperaciones;

    // Constructor
    public HistorialOperaciones() {
        this.pilaOperaciones = new ArrayDeque<>();
    }

    // Método para registrar una nueva acción (Push)
    public void registrarOperacion(String operacion) {
        pilaOperaciones.push(operacion);
    }

    // Método para deshacer o simular el botón "atrás" (Pop)
    public String deshacerUltimaOperacion() {
        if (!pilaOperaciones.isEmpty()) {
            return pilaOperaciones.pop();
        }
        return "No hay operaciones en el historial.";
    }

    // Método para ver qué fue lo último que se hizo sin borrarlo (Peek)
    public String verUltimaOperacion() {
        return pilaOperaciones.peek();
    }
}

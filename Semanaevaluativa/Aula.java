package Semanaevaluativa;
public class Aula {
    private String nombre;
    private int capacidad;
    // 1. Declaración de la matriz booleana para el horario/disponibilidad
    private boolean[][] disponibilidad; 

    // Constructor obligatorio
    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        // 2. Inicialización de la matriz (por defecto todos los valores serán false)
        this.disponibilidad = new boolean[7][24]; 
    }

    // Getters y Setters públicos (Encapsulamiento)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // 3. Getter y Setter para la matriz completa
    public boolean[][] getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean[][] disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    // 4. Método útil para interactuar con una celda específica de la matriz
    public boolean estaDisponible(int dia, int hora) {
        return disponibilidad[dia][hora];
    }

    public void asignarDisponibilidad(int dia, int hora, boolean estado) {
        this.disponibilidad[dia][hora] = estado;
    }

    @Override
    public String toString() {
        return "Aula: " + nombre + " (Capacidad: " + capacidad + ")";
    }
}
package Semanaevaluativa;
public class Aula {
    private String nombre;
    private int capacidad;

    // Constructor obligatorio
    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
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

    @Override
    public String toString() {
        return "Aula: " + nombre + " (Capacidad: " + capacidad + ")";
    }
}
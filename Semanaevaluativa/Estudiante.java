
package Semanaevaluativa;

import java.util.ArrayList;

public class Estudiante extends Persona {
    private String carrera;
    private int semestre;
    private ListaEnlazada<String> historialMaterias;

    private static class ListaEnlazada<T> {
        private final ArrayList<T> elementos = new ArrayList<>();

        public void agregar(T elemento) {
            elementos.add(elemento);
        }

        public boolean contiene(T elemento) {
            return elementos.contains(elemento);
        }
    }

    public Estudiante(String id, String nombre, String email,
                      String carrera, int semestre) {
        super(id, nombre, email);
        this.carrera = carrera;
        this.semestre = semestre;
        this.historialMaterias = new ListaEnlazada<>();
    }

    public void agregarMateriaCursada(String codigoMateria) {
        historialMaterias.agregar(codigoMateria);
    }

    public boolean yaCursado(String codigoMateria) {
        return historialMaterias.contiene(codigoMateria);
    }

    public ListaEnlazada<String> getHistorialMaterias() {
        return historialMaterias;
    }

    @Override
    public String obtenerInfo() {
        return "Estudiante: " + getNombre() +
               " - Carrera: " + carrera +
               " - Semestre: " + semestre;
    }
}
package Semanaevaluativa;

public class Estudiante extends Persona {
    private String carrera;
    private int semestre;
    private ListaEnlazada<String> historialMaterias;
    // 1. Declaración de la matriz de distancias entre edificios
    private int[][] distanciasEdificios;

    // Implementación real de Lista Enlazada Simple usando Nodos
    public static class ListaEnlazada<T> {
        private Nodo<T> cabeza;

        private static class Nodo<T> {
            T dato;
            Nodo<T> siguiente;

            Nodo(T dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }

        public ListaEnlazada() {
            this.cabeza = null;
        }

        public void agregar(T elemento) {
            Nodo<T> nuevoNodo = new Nodo<>(elemento);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                Nodo<T> actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }

        public boolean contiene(T elemento) {
            Nodo<T> actual = cabeza;
            while (actual != null) {
                if (actual.dato != null && actual.dato.equals(elemento)) {
                    return true;
                }
                actual = actual.siguiente;
            }
            return false;
        }
    }

    // Constructor original (mantiene compatibilidad con tu Main)
    public Estudiante(String id, String nombre, String email, String carrera, int semestre) {
        super(id, nombre, email);
        this.carrera = carrera;
        this.semestre = semestre;
        this.historialMaterias = new ListaEnlazada<>();
        // Inicialización por defecto (ej. 5 edificios) para evitar NullPointerException
        this.distanciasEdificios = new int[5][5];
    }

    // 2. Constructor sobrecargado por si deseas definir N al crear el estudiante
    public Estudiante(String id, String nombre, String email, String carrera, int semestre, int cantidadEdificios) {
        this(id, nombre, email, carrera, semestre);
        this.distanciasEdificios = new int[cantidadEdificios][cantidadEdificios];
    }

    // 3. Métodos para gestionar la matriz int[N][N]
    public void inicializarMatrizDistancias(int n) {
        this.distanciasEdificios = new int[n][n];
    }

    public void registrarDistancia(int edificioOrigen, int edificioDestino, int distancia) {
        if (edificioOrigen >= 0 && edificioOrigen < distanciasEdificios.length &&
            edificioDestino >= 0 && edificioDestino < distanciasEdificios.length) {
            distanciasEdificios[edificioOrigen][edificioDestino] = distancia;
        }
    }

    public int obtenerDistancia(int edificioOrigen, int edificioDestino) {
        if (edificioOrigen >= 0 && edificioOrigen < distanciasEdificios.length &&
            edificioDestino >= 0 && edificioDestino < distanciasEdificios.length) {
            return distanciasEdificios[edificioOrigen][edificioDestino];
        }
        return -1; // Retorna -1 si los índices están fuera de rango
    }

    public int[][] getDistanciasEdificios() {
        return distanciasEdificios;
    }

    public void setDistanciasEdificios(int[][] distanciasEdificios) {
        this.distanciasEdificios = distanciasEdificios;
    }

    // -- Tus métodos actuales --
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
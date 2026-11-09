package Semanaevaluativa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;


public class GestionMaterias {
    // Encapsulamiento: Estructuras de datos privadas
    private List<Materia> listaMaterias;
    // Mapa para asociar cada código de materia con su respectiva cola de espera de estudiantes
    private java.util.Map<String, Queue<Estudiante>> colasEspera;

    // Constructor: Inicializa las estructuras dinámicas provistas por Java
    public GestionMaterias() {
        this.listaMaterias = new LinkedList<>(); // Cumple con el requisito de Listas Enlazadas
        this.colasEspera = new java.util.HashMap<>();
    }

    // Funcionalidad: Agregar una nueva materia al catálogo
    public void registrarMateria(Materia materia) {
        listaMaterias.add(materia);
        // Inicializamos una cola de espera vacía para esta materia específica
        colasEspera.put(materia.getCodigo(), new ArrayDeque<>()); // Cumple con el requisito de Colas
    }

    // Funcionalidad: Inscribir un estudiante o mandarlo a la cola de espera si no hay cupos
    public void inscribirEstudianteEnMateria(String codigoMateria, Estudiante estudiante) {
        Materia materiaEncontrada = null;
        
        // Buscamos la materia en nuestra lista enlazada
        for (Materia mat : listaMaterias) {
            if (mat.getCodigo().equalsIgnoreCase(codigoMateria)) {
                materiaEncontrada = mat;
                break;
            }
        }

        if (materiaEncontrada == null) {
            System.out.println("Error: La materia con código " + codigoMateria + " no existe.");
            return;
        }

        // Control de cupos dinámico
        if (materiaEncontrada.getCuposMaximos() > 0) {
            // Restamos un cupo e inscribimos al estudiante
            materiaEncontrada.setCuposMaximos(materiaEncontrada.getCuposMaximos() - 1);
            System.out.println("¡Inscripción exitosa! " + estudiante.getNombre() + " ha sido inscrito en " + materiaEncontrada.getNombre());
        } else {
            // Si no hay cupos, se añade al estudiante al final de la Cola de Espera
            Queue<Estudiante> cola = colasEspera.get(codigoMateria);
            cola.offer(estudiante);
            System.out.println("Sin cupos en " + materiaEncontrada.getNombre() + ". " + estudiante.getNombre() + " ha sido enviado a la COLA DE ESPERA.");
        }
    }

    // Funcionalidad: Mostrar el estado de las materias y sus colas de espera
    public void mostrarCatalogoMaterias() {
        if (listaMaterias.isEmpty()) {
            System.out.println("No hay materias registradas en el sistema.");
            return;
        }
        System.out.println("\n=== CATÁLOGO DE MATERIAS Y DISPONIBILIDAD ===");
        for (Materia mat : listaMaterias) {
            System.out.println(mat);
            Queue<Estudiante> cola = colasEspera.get(mat.getCodigo());
            if (cola != null && !cola.isEmpty()) {
                System.out.println("  -> En cola de espera: " + cola.size() + " estudiante(s).");
            }
        }
    }
}
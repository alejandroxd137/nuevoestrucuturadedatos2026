import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GestionEstudiantes {

    // HashMap para almacenar estudiantes usando su ID como clave
    private Map<String, Estudiante> mapaEstudiantes;
    
    // Pila para almacenar los estudiantes eliminados y poder deshacer la acción
    private Stack<Estudiante> pilaEliminados;

    // Constructor
    public GestionEstudiantes() {
        this.mapaEstudiantes = new HashMap<>();
        this.pilaEliminados = new Stack<>();
    }

    // 1. Registrar estudiante
    public void registrarEstudiante(Estudiante estudiante) {
        if (estudiante != null && estudiante.getId() != null) {
            mapaEstudiantes.put(estudiante.getId(), estudiante);
            System.out.println("Estudiante registrado con éxito: " + estudiante.getNombre());
        } else {
            System.out.println("Error: Datos del estudiante no válidos.");
        }
    }

    // 2. Buscar estudiante por ID usando el HashMap
    public Estudiante buscarEstudiantePorId(String id) {
        return mapaEstudiantes.get(id); 
    }

    // 3. Mostrar historial académico completo (notas desde el arreglo del estudiante)
    public void mostrarHistorialAcademico(String id) {
        Estudiante est = buscarEstudiantePorId(id);
        if (est != null) {
            System.out.println("Historial Académico de: " + est.getNombre());
            // Nota: Aquí invocamos al método que recorre el arreglo dentro de tu clase Estudiante
            est.mostrarNotasPorSemestre(); 
        } else {
            System.out.println("Estudiante con ID " + id + " no encontrado.");
        }
    }

    // 4. Eliminar estudiante (baja definitiva) -> Guarda en la pila
    public void eliminarEstudiante(String id) {
        Estudiante est = mapaEstudiantes.remove(id); // remueve del mapa y lo retorna
        if (est != null) {
            pilaEliminados.push(est); // Se guarda en la pila por si se quiere deshacer
            System.out.println("Estudiante " + est.getNombre() + " eliminado (dado de baja).");
        } else {
            System.out.println("No se encontró ningún estudiante con el ID enviado.");
        }
    }

    // 4b. Deshacer la última eliminación desde la pila
    public void deshacerEliminacion() {
        if (!pilaEliminados.isEmpty()) {
            Estudiante recuperado = pilaEliminados.pop(); // Saca el último eliminado
            mapaEstudiantes.put(recuperado.getId(), recuperado); // Lo vuelve a meter al mapa
            System.out.println("Eliminación deshecha. Estudiante recuperado: " + recuperado.getNombre());
        } else {
            System.out.println("No hay eliminaciones recientes para deshacer.");
        }
    }

    // 5. Listar todos los estudiantes registrados
    public void listarTodosLosEstudiantes() {
        if (mapaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }
        System.out.println("--- Lista de Estudiantes Registrados ---");
        for (Estudiante est : mapaEstudiantes.values()) {
            System.out.println("ID: " + est.getId() + " | Nombre: " + est.getNombre() + " | Semestre: " + est.getSemestreActual());
        }
    }
}
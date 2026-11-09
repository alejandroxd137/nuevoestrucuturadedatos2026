package Semanaevaluativa;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //  (Estructuras de datos encapsuladas)
        GestionEstudiantes gestionEstudiantes = new GestionEstudiantes();
        GestionMaterias gestionMaterias = new GestionMaterias();
        
    
        // Una materia con 1 cupo para probar el comportamiento de la cola de espera
        gestionMaterias.registrarMateria(new Materia("INF101", "Programación Orientada a Objetos", 1, 4));
        gestionMaterias.registrarMateria(new Materia("MAT202", "Cálculo Integral", 30, 4));

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=======================================");
            System.out.println("     SISTEMA DE GESTIÓN UNIVERSITARIA  ");
            System.out.println("=======================================");
            System.out.println("1. Registrar Estudiante (HashMap)");
            System.out.println("2. Buscar Estudiante por ID");
            System.out.println("3. Listar Todos los Estudiantes");
            System.out.println("4. Mostrar Catálogo de Materias (LinkedList)");
            System.out.println("5. Inscribir Estudiante en Materia (Control de Cupos / Cola)");
            System.out.println("0. Salir del Programa");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR NUEVO ESTUDIANTE ---");
                    System.out.print("Ingrese ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.print("Ingrese Nombre Completo: ");
                    String nombre = scanner.nextLine().trim();
                    System.out.print("Ingrese Correo Electrónico: ");
                    String email = scanner.nextLine().trim();
                    System.out.print("Ingrese Semestre Actual: ");
                    int semestre = Integer.parseInt(scanner.nextLine());

                    Estudiante nuevoEstudiante = new Estudiante(id, nombre, email, semestre);
                    
                    if (gestionEstudiantes.registrarEstudiante(nuevoEstudiante)) {
                        System.out.println("¡Estudiante registrado con éxito!");
                    } else {
                        System.out.println("Error: Ya existe un estudiante con el ID " + id);
                    }
                    break;

                case 2:
                    System.out.println("\n--- BUSCAR ESTUDIANTE POR ID ---");
                    System.out.print("Ingrese el ID a buscar: ");
                    String idBuscar = scanner.nextLine().trim();
                    
                    Estudiante estudianteEncontrado = gestionEstudiantes.buscarEstudiantePorId(idBuscar);
                    
                    if (estudianteEncontrado != null) {
                        System.out.println("Estudiante Encontrado: " + estudianteEncontrado);
                    } else {
                        System.out.println("No se encontró ningún estudiante con el ID: " + idBuscar);
                    }
                    break;

                case 3:
                    gestionEstudiantes.listarEstudiantes();
                    break;

                case 4:
                    gestionMaterias.mostrarCatalogoMaterias();
                    break;

                case 5:
                    System.out.println("\n--- INSCRIBIR ESTUDIANTE EN MATERIA ---");
                    System.out.print("Ingrese el ID del Estudiante: ");
                    String idEst = scanner.nextLine().trim();
                    
                    Estudiante estInscribir = gestionEstudiantes.buscarEstudiantePorId(idEst);
                    
                    if (estInscribir == null) {
                        System.out.println("Error: El estudiante no está registrado en el sistema.");
                        break;
                    }

                    System.out.print("Ingrese el Código de la Materia (Ej: INF101): ");
                    String codMat = scanner.nextLine().trim();
                    
                    // Lógica que administra listas, cupos y la cola de espera de la materia
                    gestionMaterias.inscribirEstudianteEnMateria(codMat, estInscribir);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema universitario... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}

class GestionEstudiantes {
    private final Map<String, Estudiante> estudiantes = new HashMap<>();

    public boolean registrarEstudiante(Estudiante estudiante) {
        // El ID se conserva como clave al registrar para evitar duplicados.
        try {
            java.lang.reflect.Field campoId = Estudiante.class.getDeclaredField("id");
            campoId.setAccessible(true);
            String id = (String) campoId.get(estudiante);
            if (estudiantes.containsKey(id)) {
                return false;
            }
            estudiantes.put(id, estudiante);
            return true;
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("No se pudo obtener el ID del estudiante", e);
        }
    }

    public Estudiante buscarEstudiantePorId(String id) {
        return estudiantes.get(id);
    }

    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante estudiante : estudiantes.values()) {
            System.out.println(estudiante);
        }
    }
}
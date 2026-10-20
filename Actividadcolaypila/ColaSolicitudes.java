import java.util.*;

class Solicitud {
    int numero;
    String nombre;
    String tramite;

    public Solicitud(int numero, String nombre, String tramite) {
        this.numero = numero;
        this.nombre = nombre;
        this.tramite = tramite;
    }

    public void mostrar() {
        System.out.println("Numero: " + numero);
        System.out.println("Estudiante: " + nombre);
        System.out.println("Tramite: " + tramite);
        System.out.println("----------------------");
    }
}

public class ColaSolicitudes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Solicitud> cola = new LinkedList<>();
        int opcion;

        do {
            System.out.println("\n=== ATENCION DE SOLICITUDES ===");
            System.out.println("1. Registrar solicitud");
            System.out.println("2. Atender solicitud");
            System.out.println("3. Consultar siguiente solicitud");
            System.out.println("4. Mostrar solicitudes pendientes");
            System.out.println("5. Consultar estado de la cola");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    if (cola.size() < 10) {
                        System.out.print("Numero de solicitud: ");
                        int numero = Integer.parseInt(sc.nextLine());

                        System.out.print("Nombre del estudiante: ");
                        String nombre = sc.nextLine();

                        System.out.print("Tipo de tramite: ");
                        String tramite = sc.nextLine();

                        cola.offer(new Solicitud(numero, nombre, tramite));
                        System.out.println("Solicitud registrada correctamente.");
                    } else {
                        System.out.println("Cola llena. No se pueden registrar mas solicitudes.");
                    }
                    break;

                case 2:
                    if (!cola.isEmpty()) {
                        Solicitud atendida = cola.poll();
                        System.out.println("Solicitud atendida:");
                        atendida.mostrar();
                    } else {
                        System.out.println("La cola esta vacia.");
                    }
                    break;

                case 3:
                    if (!cola.isEmpty()) {
                        System.out.println("Siguiente solicitud por atender:");
                        cola.peek().mostrar();
                    } else {
                        System.out.println("No hay solicitudes pendientes.");
                    }
                    break;

                case 4:
                    if (!cola.isEmpty()) {
                        System.out.println("Solicitudes pendientes (orden FIFO):");
                        for (Solicitud s : cola) {
                            s.mostrar();
                        }
                    } else {
                        System.out.println("No hay solicitudes pendientes.");
                    }
                    break;

                case 5:
                    System.out.println("Solicitudes en cola: " + cola.size() + "/10");

                    if (cola.isEmpty()) {
                        System.out.println("Estado: COLA VACIA");
                    } else if (cola.size() == 10) {
                        System.out.println("Estado: COLA LLENA");
                    } else {
                        System.out.println("Estado: COLA CON ESPACIO DISPONIBLE");
                    }
                    break;

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
import java.util.Stack;
import java.util.Scanner;

class Operacion {
    int identificador;
    String descripcion;
    String tipo;

    public Operacion(int identificador, String descripcion, String tipo) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public void mostrar() {
        System.out.println("ID: " + identificador);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Tipo: " + tipo);
        System.out.println("----------------------");
    }
}

class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Pila con capacidad para 10 operaciones
        Stack<Operacion> pila = new Stack<>();
        int opcion;
        int id = 1;
        final int CAPACIDAD = 10;

        do {
            System.out.println("\n=== HISTORIAL DE OPERACIONES ===");
            System.out.println("1. Apilar nueva operacion");
            System.out.println("2. Desapilar ultima operacion");
            System.out.println("3. Consultar operacion del tope");
            System.out.println("4. Mostrar todas las operaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                case 1:
                    if (pila.size() == CAPACIDAD) {
                        System.out.println("La pila esta llena.");
                    } else {
                        System.out.print("Ingrese la descripcion: ");
                        String descripcion = entrada.nextLine();

                        System.out.print("Ingrese el tipo de operacion: ");
                        String tipo = entrada.nextLine();

                        Operacion nueva =
                            new Operacion(id, descripcion, tipo);

                        pila.push(nueva);
                        System.out.println(
                            "Operacion registrada correctamente. ID: " + id
                        );
                        id++;
                    }
                    break;

                case 2:
                    if (pila.empty()) {
                        System.out.println("La pila esta vacia.");
                    } else {
                        Operacion eliminada = pila.pop();
                        System.out.println("Operacion desapilada:");
                        eliminada.mostrar();
                    }
                    break;

                case 3:
                    if (pila.empty()) {
                        System.out.println(
                            "No hay operaciones en el tope."
                        );
                    } else {
                        System.out.println("Operacion del tope:");
                        pila.peek().mostrar();
                    }
                    break;

                case 4:
                    if (pila.empty()) {
                        System.out.println("La pila esta vacia.");
                    } else {
                        System.out.println(
                            "\nHistorial (del tope hacia abajo):"
                        );

                        for (int i = pila.size() - 1; i >= 0; i--) {
                            pila.get(i).mostrar();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        entrada.close();
    }
}
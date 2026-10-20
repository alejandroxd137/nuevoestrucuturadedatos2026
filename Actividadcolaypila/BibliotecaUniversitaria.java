import java.util.*;

public class BibliotecaUniversitaria {

    static class Libro {
        String codigo, titulo, autor, seccion;
        boolean disponible = true;

        Libro(String c, String t, String a, String s) {
            codigo = c;
            titulo = t;
            autor = a;
            seccion = s;
        }

        public String toString() {
            return codigo + " - " + titulo + " - " + autor
                    + " - " + seccion + " - "
                    + (disponible ? "Disponible" : "Prestado");
        }
    }

    // 1. Arreglo de objetos
    static LinkedList<Libro> libros = new LinkedList<>();

    // 2. Matriz de objetos por secciones
    static String[] secciones = {
        "Literatura", "Ciencia", "Historia"
    };
    static LinkedList<Libro>[] matriz = new LinkedList[3];

    // 3. Cola de prestamos
    static Queue<String> cola = new LinkedList<>();

    // 4. Pila de operaciones
    static Stack<String> historial = new Stack<>();

    static Scanner sc = new Scanner(System.in);

    static Libro buscar(String codigo) {
        for (Libro l : libros)
            if (l.codigo.equalsIgnoreCase(codigo))
                return l;
        return null;
    }

    static void registrarLibro() {
        System.out.print("Codigo: ");
        String c = sc.nextLine();

        if (buscar(c) != null) {
            System.out.println("Codigo existente.");
            return;
        }

        System.out.print("Titulo: ");
        String t = sc.nextLine();
        System.out.print("Autor: ");
        String a = sc.nextLine();
        System.out.print("Seccion (Literatura, Ciencia, Historia): ");
        String s = sc.nextLine();

        boolean valida = false;
        for (String sec : secciones)
            if (sec.equalsIgnoreCase(s)) {
                s = sec;
                valida = true;
            }

        if (!valida) {
            System.out.println("Seccion no valida.");
            return;
        }

        libros.add(new Libro(c, t, a, s));
        historial.push("Libro registrado: " + t);
        actualizarMatriz();
        System.out.println("Libro registrado.");
    }

    static void actualizarMatriz() {
        for (int i = 0; i < secciones.length; i++)
            matriz[i] = new LinkedList<>();

        for (Libro l : libros)
            for (int i = 0; i < secciones.length; i++)
                if (l.seccion.equals(secciones[i]))
                    matriz[i].add(l);
    }

    static void consultarLibros() {
        System.out.print("Titulo, autor o codigo: ");
        String b = sc.nextLine().toLowerCase();

        for (Libro l : libros)
            if (l.titulo.toLowerCase().contains(b)
                || l.autor.toLowerCase().contains(b)
                || l.codigo.toLowerCase().contains(b))
                System.out.println(l);

        historial.push("Consulta de libros");
    }

    static void solicitarPrestamo() {
        System.out.print("Codigo del libro: ");
        String c = sc.nextLine();
        Libro l = buscar(c);

        if (l == null || !l.disponible) {
            System.out.println("Libro inexistente o prestado.");
            return;
        }

        System.out.print("Nombre del estudiante: ");
        String e = sc.nextLine();

        cola.offer(c + " - " + e);
        historial.push("Solicitud de prestamo: " + c);
        System.out.println("Solicitud agregada.");
    }

    static void procesarPrestamo() {
        if (cola.isEmpty()) {
            System.out.println("No hay solicitudes.");
            return;
        }

        String solicitud = cola.poll();
        String codigo = solicitud.split(" - ")[0];
        Libro l = buscar(codigo);

        if (l != null && l.disponible) {
            l.disponible = false;
            historial.push("Prestamo realizado: " + solicitud);
            System.out.println("Prestamo realizado.");
        } else {
            historial.push("Prestamo rechazado: " + solicitud);
            System.out.println("Libro no disponible.");
        }
    }

    static void mostrarSecciones() {
        actualizarMatriz();

        for (int i = 0; i < secciones.length; i++) {
            System.out.println("\n" + secciones[i] + ":");
            for (Libro l : matriz[i])
                System.out.println(l);
        }
    }

    static void mostrarHistorial() {
        for (int i = historial.size() - 1; i >= 0; i--)
            System.out.println(historial.get(i));
    }

    public static void main(String[] args) {
        for (int i = 0; i < matriz.length; i++)
            matriz[i] = new LinkedList<>();

        int op;
        do {
            System.out.println("\n--- BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Consultar libros");
            System.out.println("3. Solicitar prestamo");
            System.out.println("4. Procesar prestamo");
            System.out.println("5. Mostrar secciones");
            System.out.println("6. Ver historial");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1: registrarLibro(); break;
                    case 2: consultarLibros(); break;
                    case 3: solicitarPrestamo(); break;
                    case 4: procesarPrestamo(); break;
                    case 5: mostrarSecciones(); break;
                    case 6: mostrarHistorial(); break;
                    case 0: System.out.println("Hasta luego."); break;
                    default: System.out.println("Opcion incorrecta.");
                }
            } catch (NumberFormatException ex) {
                op = -1;
                System.out.println("Escribe un numero.");
            }
        } while (op != 0);

        sc.close();
    }
}
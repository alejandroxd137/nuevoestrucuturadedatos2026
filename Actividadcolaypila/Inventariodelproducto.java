import java.util.*; // Importa las herramientas de Java que necesitamos

// Clase que representa cada producto del inventario
class Producto {

    int codigo;      // Numero que identifica al producto
    String nombre;   // Nombre del producto
    double precio;   // Precio del producto
    int cantidad;    // Unidades disponibles

    // Constructor: recibe los datos para crear un producto
    public Producto(int codigo, String nombre,
                    double precio, int cantidad) {

        this.codigo = codigo;       // Guarda el codigo recibido
        this.nombre = nombre;       // Guarda el nombre recibido
        this.precio = precio;       // Guarda el precio recibido
        this.cantidad = cantidad;   // Guarda la cantidad recibida
    }

    // Metodo que imprime la informacion del producto
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
    }
}

// Clase principal del programa
public class Inventariodelproducto {

    static Scanner sc = new Scanner(System.in);
    // Permite leer datos que escribes en la consola

    static Producto[][] matriz = new Producto[3][4];
    // Crea una matriz con 3 filas y 4 columnas

    static Stack<Producto> pila = new Stack<>();
    // Crea una pila que guarda productos

    static Queue<Producto> cola = new LinkedList<>();
    // Crea una cola que guarda productos

    public static void main(String[] args) {

        // Carga los productos de ejemplo
        cargarDatos();

        // Imprime los productos registrados en la matriz
        mostrar();

        // Calcula el valor de todo el inventario
        total();

        // Busca el producto con mayor cantidad
        mayor();

        // Cuenta los espacios sin productos
        vacios();

        System.out.println("\n--- PILA ---");
        mostrarPila(); // Imprime los productos de la pila

        System.out.println("\n--- COLA ---");
        mostrarCola(); // Imprime los productos de la cola

        // Pide al usuario el codigo que quiere buscar
        System.out.print("\nIngrese codigo para buscar: ");
        int codigo = sc.nextInt();

        buscar(codigo); // Busca el codigo ingresado

        sc.close(); // Cierra el Scanner
    }

    // Registra tres productos de ejemplo
    public static void cargarDatos() {

        Producto p1 = new Producto(101, "Teclado", 50000, 5);
        Producto p2 = new Producto(102, "Mouse", 25000, 8);
        Producto p3 = new Producto(103, "Monitor", 450000, 3);

        // Guarda los productos en diferentes posiciones
        matriz[0][0] = p1;
        matriz[0][1] = p2;
        matriz[1][0] = p3;

        // Agrega los productos a la pila
        pila.push(p1);
        pila.push(p2);
        pila.push(p3);

        // Agrega los productos a la cola
        cola.offer(p1);
        cola.offer(p2);
        cola.offer(p3);
    }

    // Recorre y muestra la matriz
    public static void mostrar() {
        System.out.println("--- INVENTARIO ---");

        for (int i = 0; i < 3; i++) { // Recorre las filas
            for (int j = 0; j < 4; j++) { // Recorre columnas

                // Comprueba que la posicion tenga un producto
                if (matriz[i][j] != null) {

                    // Muestra la ubicacion del producto
                    System.out.println("Fila: " + (i + 1)
                            + " Columna: " + (j + 1));

                    matriz[i][j].mostrar(); // Muestra sus datos
                }
            }
        }
    }

    // Busca un producto utilizando su codigo
    public static void buscar(int codigo) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {

                // Comprueba si existe y coincide el codigo
                if (matriz[i][j] != null &&
                    matriz[i][j].codigo == codigo) {

                    System.out.println("Producto encontrado:");
                    matriz[i][j].mostrar();
                    return; // Termina cuando encuentra el producto
                }
            }
        }

        // Se ejecuta cuando no encuentra el codigo
        System.out.println("Producto no encontrado.");
    }

    // Calcula el valor total de los productos
    public static void total() {
        double suma = 0; // Empieza el total en cero

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {

                if (matriz[i][j] != null) {

                    // Multiplica precio por cantidad y suma
                    suma += matriz[i][j].precio
                            * matriz[i][j].cantidad;
                }
            }
        }

        System.out.println("\nValor total: $" + suma);
    }

    // Encuentra el producto con mas unidades
    public static void mayor() {
        Producto p = null; // Todavia no hay un producto elegido

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {

                // Compara las cantidades de los productos
                if (matriz[i][j] != null &&
                    (p == null ||
                     matriz[i][j].cantidad > p.cantidad)) {

                    p = matriz[i][j]; // Guarda el de mayor cantidad
                }
            }
        }

        System.out.println("\nProducto con mayor cantidad:");

        if (p != null) {
            p.mostrar(); // Muestra el producto seleccionado
        }
    }

    // Cuenta las posiciones vacias de la matriz
    public static void vacios() {
        int contador = 0; // Comienza en cero

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {

                if (matriz[i][j] == null) {
                    contador++; // Aumenta si esta vacia
                }
            }
        }

        System.out.println("Posiciones vacias: " + contador);
    }

    // Muestra la pila desde el ultimo producto agregado
    public static void mostrarPila() {
        for (int i = pila.size() - 1; i >= 0; i--) {
            pila.get(i).mostrar();
        }
    }

    // Muestra la cola en orden de llegada
    public static void mostrarCola() {
        for (Producto p : cola) {
            p.mostrar();
        }
    }
}
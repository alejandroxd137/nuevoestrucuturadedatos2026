package Semanaevaluativa1y2;

public class Persona {
    

    // Atributos
    private String identificacion;
    private String nombre;

    // Constructor
    public Persona(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    // Obtener nombre
    public String getNombre() {
        return nombre;
    }

    // Obtener identificacion
    public String getIdentificacion() {
        return identificacion;
    }

    // Mostrar informacion
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificacion: " + identificacion);
    }
}


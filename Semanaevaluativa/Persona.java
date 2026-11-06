package Semanaevaluativa;

public class Persona {

    // Atributos
    private String identificacion;
    private String nombre;
    private int edad;
    private String documento;
    private String correo;

    // Constructor
    public Persona(String identificacion, String nombre, int edad, String documento, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.correo = correo;
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
        System.out.println("Edad: " + edad);
        System.out.println("Documento: " + documento);
        System.out.println("Correo: " + correo);
    }
}

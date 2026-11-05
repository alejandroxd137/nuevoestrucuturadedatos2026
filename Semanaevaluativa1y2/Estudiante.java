public class Estudiante extends Persona {

    // Atributos propios del estudiante
    private int codigo;
    private String carrera;
    private int semestre;
    private double promedio;
    private String estado;

    // Constructor
    public Estudiante(String nombre, int edad, String documento,
            String correo, int codigo, String carrera,
            int semestre, double promedio) {

        super( nombre,edad,documento,correo);

        this.codigo = codigo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.promedio = promedio;
        this.estado = "Activo";
    }

    // Método para mostrar información
    @Override
    public void mostrarInformacion() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Estado: " + estado);
    }
} 
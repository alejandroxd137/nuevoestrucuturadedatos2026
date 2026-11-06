package Semanaevaluativa;

public class Estudiante extends Persona {

    // Atributos propios del estudiante
    private int codigo;
    private String carrera;
    private int semestre;
    private double promedio;
    private String estado; 

    // Constructor
 public Estudiante(String identificacion, String nombre, int edad,
                  String documento, String correo, int codigo,
                  String carrera, int semestre, double promedio) {

        super(identificacion, nombre, edad, documento, correo); {

        this.codigo = codigo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.promedio = promedio;
        this.estado = "Activo" ;  }// Estado inicial del estudiante
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

    // Aqui se agrega el metodo   
    public void mostrarNotasPorSemestre() {
        // Aquí se  debe programar la lógica para mostrar las notas
        System.out.println("Notas del estudiante por semestre...");


    }

    public int getSemestre() {
        return this.semestre;
    }
} 
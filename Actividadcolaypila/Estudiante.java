public class Estudiante {
    // Atributos privados
    private String codigo;
    private String nombre;
    private String programaAcademico;
    private double promedio;

    // Constructor
    public Estudiante(String codigo, String nombre, String programaAcademico, double promedio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.programaAcademico = programaAcademico;
        this.promedio = promedio;
    }

    // Métodos Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getProgramaAcademico() { return programaAcademico; }
    public void setProgramaAcademico(String programaAcademico) { this.programaAcademico = programaAcademico; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    // Método para mostrar la información del estudiante de forma ordenada
    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + 
               " | Programa: " + programaAcademico + " | Promedio: " + promedio;
    }
}
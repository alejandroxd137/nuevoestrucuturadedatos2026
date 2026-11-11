package Semanaevaluativa;

public class Profesor extends Persona {
    private String departamento;

    // Constructor corregido: alineado con los 3 parámetros que exige la superclase Persona
    public Profesor(String id, String nombre, String email, String departamento) {
        super(id, nombre, email); // Llama al constructor de Persona (ID, Nombre, Email)
        this.departamento = departamento;
    }

    // Getter y Setter para mantener el encapsulamiento
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String obtenerInfo() {
        return toString();
    }

    // Polimorfismo por Sobrescritura usando toString() como la clase base Persona
    @Override
    public String toString() {
        return super.toString() + " | Departamento: " + departamento;
    }
}
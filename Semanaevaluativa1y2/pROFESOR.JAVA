package modelo;

public class Profesor extends Persona {

    private String departamento;

    public Profesor(String identificacion, String nombre, String departamento) {
        super(identificacion, nombre);
        this.departamento = departamento;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Identificación: " + getIdentificacion());
        System.out.println("Departamento: " + departamento);
    }
}
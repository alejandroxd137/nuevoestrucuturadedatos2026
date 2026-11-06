package Semanaevaluativa;

public class Profesor extends Persona {

    private String departamento;

    public Profesor(String identificacion, String nombre, int edad, String documento, String correo,
            String departamento) {
        super(identificacion, nombre, edad, documento, correo);
        this.departamento = departamento;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Departamento: " + departamento);
    }
}
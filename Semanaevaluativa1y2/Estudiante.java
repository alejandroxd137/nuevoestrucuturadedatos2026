package modelo;

public class Estudiante extends Persona {

    private String carrera;

    public Estudiante(String identificacion, String nombre, String carrera) {
        super(identificacion, nombre);
        this.carrera = carrera;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Identificación: " + getIdentificacion());
        System.out.println("Carrera: " + carrera);
    }
}
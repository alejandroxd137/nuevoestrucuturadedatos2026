package Semanaevaluativa1y2;

public abstract class Persona {

    private String identificacion;
    private String nombre;

    public Persona(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarInformacion();
}


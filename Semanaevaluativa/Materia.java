
package Semanaevaluativa;

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int creditos;

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.creditos = creditos;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCuposMaximos() { return cuposMaximos; }
    public void setCuposMaximos(int cuposMaximos) { this.cuposMaximos = cuposMaximos; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " (" + creditos + " créditos) - Cupos: " + cuposMaximos;
    }
}

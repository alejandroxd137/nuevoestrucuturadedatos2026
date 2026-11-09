package Semanaevaluativa;
public abstract class Persona {
    // Atributos encapsulados
    private String id;
    private String nombre;
    private String email;

    // Constructor base con los 3 parámetros exactos
    public Persona(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
      // Encapsulamiento
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }

    // Polimorfismo: cada subclase define su propia versión
    public abstract String obtenerInfo();

    // Sobrecarga de métodos (polimorfismo estático)
    public String obtenerInfo(boolean incluirEmail) {
        if (incluirEmail) {
            return obtenerInfo() + " | Email: " + email;
        }
        return obtenerInfo();
    }
}
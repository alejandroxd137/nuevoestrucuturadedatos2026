package Semanaevaluativa;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuarios {

    // HashMap para almacenar usuarios (Key: nombreUsuario, Value: contraseña o
    // credencial)
    private Map<String, String> mapaUsuarios;

    // Constructor
    public RegistroUsuarios() {
        this.mapaUsuarios = new HashMap<>();
        // Agregamos un usuario administrador por defecto para pruebas
        this.mapaUsuarios.put("admin", "admin123");
    }

    // 1. Registrar un nuevo usuario en el sistema
    public boolean registrarUsuario(String usuario, String contrasenia) {
        if (usuario == null || usuario.trim().isEmpty() || contrasenia == null || contrasenia.trim().isEmpty()) {
            System.out.println("Error: El usuario o la contraseña no pueden estar vacíos.");
            return false;
        }

        // Verificamos si el usuario ya existe para no duplicarlo
        if (mapaUsuarios.containsKey(usuario)) {
            System.out.println("Error: El nombre de usuario ya está registrado.");
            return false;
        }

        mapaUsuarios.put(usuario, contrasenia);
        System.out.println("Usuario '" + usuario + "' registrado exitosamente.");
        return true;
    }

    // 2. Autenticar / Validar el inicio de sesión
    public boolean iniciarSesion(String usuario, String contrasenia) {
        // Buscamos la contraseña almacenada directamente usando la clave (usuario)
        String contraseniaGuardada = mapaUsuarios.get(usuario);

        if (contraseniaGuardada != null && contraseniaGuardada.equals(contrasenia)) {
            System.out.println("¡Inicio de sesión exitoso! Bienvenido, " + usuario + ".");
            return true;
        }

        System.out.println("Error: Usuario o contraseña incorrectos.");
        return false;
    }

    // 3. Eliminar un usuario del registro
    public void eliminarUsuario(String usuario) {
        if (mapaUsuarios.remove(usuario) != null) {
            System.out.println("El usuario '" + usuario + "' ha sido eliminado.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }
}
package Actividadejercicios;

public class Sueldopromedio {
    
    public static void main(String[] args) {
        String[] nombres = {"Ana", "Luis", "Carlos", "Marta", "Sofía"};
        double[] sueldos = {1200, 1500, 1300, 1500, 1000};

        // Calcular el promedio
        double suma = 0;
        for (double sueldo : sueldos) {
            suma += sueldo;
        }
        double promedio = suma / sueldos.length;

        // Buscar quiénes tienen el sueldo igual al promedio
        int contador = 0;
        StringBuilder nombresPromedio = new StringBuilder();

        for (int i = 0; i < sueldos.length; i++) {
            if (sueldos[i] == promedio) {
                contador++;
                nombresPromedio.append(nombres[i]).append(" ");
            }
        }

        System.out.println("Sueldo promedio: " + promedio);
        System.out.println("Cantidad de trabajadores con sueldo promedio: " + contador);
        System.out.println("Trabajadores con sueldo promedio: " + nombresPromedio.toString().trim());
    }
}

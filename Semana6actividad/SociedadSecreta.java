package Semana6actividad;

import java.util.*;

public class SociedadSecreta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> cola = new LinkedList<>();
        List<Character> letras = new ArrayList<>();

        System.out.print("Cantidad de nombres: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese un nombre: ");
            String nombre = sc.nextLine();

            cola.offer(nombre);
        }

        while (!cola.isEmpty()) {
            String nombre = cola.poll();
            letras.add(
                Character.toUpperCase(nombre.charAt(0))
            );
        }

        Collections.sort(letras);

        String sociedad = "";

        for (char letra : letras) {
            sociedad += letra;
        }

        System.out.println("Nombre de la sociedad: " + sociedad);

        sc.close();
    }
}
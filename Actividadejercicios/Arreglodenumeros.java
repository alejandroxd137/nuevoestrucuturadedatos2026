package Actividadejercicios;

public class Arreglodenumeros {
       public static void main(String[] args) {
        int[] a = {5, 16, 8, 9, 10, 25, 19, 3, 6, 22, 2};
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + a[a.length - 1 - i];
        }

        for (int i = 0; i < c.length; i++) {
            System.out.println("c[" + i + "] = " + c[i]);
        }
    }
}
package Semana6actividad;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SegundoMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> cola = new LinkedList<>();

        System.out.print("Cantidad de numeros: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Debe ingresar al menos 2 numeros.");
            sc.close();
            return;
        }

        System.out.println("Ingrese los numeros:");

        for (int i = 0; i < n; i++) {
            cola.add(sc.nextInt());
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        while (!cola.isEmpty()) {
            int num = cola.poll();

            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }

        System.out.println("Segundo numero mas grande: " + max2);

        sc.close();
    }
}
package Semana6actividad;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> cola = new LinkedList<>();

        System.out.println("Ingrese exactamente 10 digitos:");

        for (int i = 0; i < 10; i++) {
            int digito = sc.nextInt();

            if (digito < 0 || digito > 9) {
                System.out.println("Error: ingrese un digito del 0 al 9.");
                sc.close();
                return;
            }

            cola.offer(digito);
        }

        if (cola.size() != 10) {
            System.out.println("Error: deben ser 10 digitos.");
            sc.close();
            return;
        }

        String numero = "";

        for (int i = 0; i < 10; i++) {
            numero += cola.poll();
        }

        System.out.println("Numero formateado: ("
                + numero.substring(0, 3) + ") "
                + numero.substring(3, 6) + "-"
                + numero.substring(6, 10));

        sc.close();
    }
}
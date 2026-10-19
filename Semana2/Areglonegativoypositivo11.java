package Semana2;

public class Areglonegativoypositivo11 {
    public static void main(String[] args) {
        int[] arreglo = { 5, -3, 1, -7, 6, -4, 2, -8 };
        int[] arregloPositivo = new int [arreglo.length];
        int[] arregloNegativo = new int [arreglo.length];

        int posIndex = 0;
        int negIndex = 0;

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > 0) {
                arregloPositivo[posIndex] = arreglo[i];
                posIndex++;
              
            } else {
                arregloNegativo[negIndex] = arreglo[i];
                negIndex++; 
 
                System.out.println("Arreglo Positivo: ");
                for (int j = 0; j < posIndex; j++) {
                    System.out.print(arregloPositivo[j] + " ");
                }
                System.out.println("\nArreglo Negativo: ");
                for (int j = 0; j < negIndex; j++) {
                    System.out.print(arregloNegativo[j] + " ");
                }
                
            }
        }
    }
}

                    
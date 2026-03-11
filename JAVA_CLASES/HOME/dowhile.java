package JAVA_CLASES.HOME;

import java.util.Scanner;

public class dowhile {
    public static void main(String[] args) {
        /*
         * Pida al usuario que ingrese un número entre 1 y 10
         * Si el número está fuera de ese rango, que vuelva a pedirlo
         * Cuando el número sea válido, imprima: "Número válido: X"
         */
        Scanner leer = new Scanner(System.in);
        int numero = 0;
        do {
            System.out.println("Ingrese un numero entre el 1 y 10:  ");
            numero = leer.nextInt();
        } while (numero < 1 || numero > 10);
        System.out.println("Numero valido:  " + numero);

    }
}

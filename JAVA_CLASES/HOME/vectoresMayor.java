package JAVA_CLASES.HOME;

import java.util.Scanner;

public class vectoresMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Guardar 5 números en un vector.
        // Mostrar los números.
        // Encontrar el número mayor.

        // 1 CREAR EL VECTOR
        int numero [] = new int[5];

        // 2 LLENAR EL VECTOR CON SCANNER
        for (int i = 0; i < numero.length; i++){
            System.out.println("Digite un numero:  ");  // i es la posicion
            numero[i] = sc.nextInt(); //Guarda el numero en esa posicion
        }

        // 3 MOSTRAR EL VECTOR
        for (int i = 0; i < numero.length; i++){
            System.out.println(numero[i]);
        }

        // 4 ENCONTRAR EL NUMERO MAYOR ENTRE LOS VECTORES

        //! 1. SE CREA UNA VARAIBLE
        int mayor = numero[0]; //AQUI SE SUPONE QUE EL NUMERO MAYOR ES EL PRIMER

        for(int i = 0; i < numero.length; i++){
            if (numero[i] > mayor) {
                mayor = numero[i];
            }
        }
        System.out.println("El numero mayor entre los vectores es:  "  + mayor);
    }
}

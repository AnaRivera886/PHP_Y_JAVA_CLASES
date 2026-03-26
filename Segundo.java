

import java.util.Scanner;


public class Segundo {

    public static void llenarVec (int[] num, Scanner leer){
        System.out.println("Ingresa numeros enteros diferentes ");
        for (int i = 0; i < num.length; i++){
            System.out.println("Numero [" + i + "]");
            num[i] = leer.nextInt();
        }
    }

    public static void Buscarmayor (int [] num){
        int mayor = num[0];
        int posicion = 0;

        for (int i = 0; i < num.length; i++){
            if (num[i] > mayor) {
                mayor = num[i];
                posicion = i;
            }
        }
        System.out.println("El numero mayor es: " + mayor + " Y se encuentra en la posicion: " + posicion);
    }

    public static void sumar(int [] num){
        int suma = 0;
        for (int i = 0; i < num.length; i+=2){
            suma += num[i];
        }
        System.out.println("La suma de los numero pares es " + suma);
    }

    public static void contar(int [] num){
        int contador = 0;
        for (int i = 0; i < num.length; i++){
            if (num[i] > 80 && num[i] < 120) {
                contador++;
            }
        }
        System.out.println("Los numeros que son mayores que 80 y menores que 120, en total son: " + contador);
    }

    public static void multiplos(int [] num){
        int multi7 = 0;
        for (int i = 0; i < num.length; i++){
            if (num[i] % 7 == 0) {
                multi7++;
            }
        }
        System.out.println("La cantidad de numeros que son multiplos de 7 son: " + multi7);
    }

    public static void inversa(int [] num){
        System.out.println("VECTOR INVERSO");
        int i = num.length -1;

        while (i >= 0) {
            System.out.print(num[i] + " ");
            i--;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        /* TENIENDO UN VECTOR DE 144 ELEMENTOS NUMERICOS ENTEROS DIFERENTES, REALICE LO SIGUIENTE:
            - BUSCAR EL ELEMENTO MAYOR Y EN QUE POSICION LO ENCONTRÓ
            - SUMAR LOS ELEMENTOS ALMACENADOS EN LAS POSICIONES PARES Y MOSTRAR LA SUMA
            - BUSCAR CUANTOS ELEMENTOS DEL VECTOR SON MAYORES DE 80 Y MENORES DE 120
            - BUSCAR CUANTOS ELEMENTOS DEL VECTOR SON MULTIPLOS DE 7
            - MOSTRAR LOS ELEMENTOS DEL VECTOR DE FORMA INVERSA
         */

        Scanner leer = new Scanner(System.in);
        int [] num = new int[144];

        llenarVec(num, leer);
        Buscarmayor(num);
        sumar(num);
        contar(num);
        multiplos(num);
        inversa(num);
    }
}

package JAVA_CLASES.HOME;
import java.util.Scanner;

public class vectorTrabajadores {
    public static void main(String[] args) {
        
        // El programa debe:
        // 1. Guardar nombre de 3 empleados
        // 2. Guardar salario de cada empleado
        // 3. Mostrar todos los datos
        // 4. Mostrar quién gana más

        Scanner leer = new Scanner(System.in);

        String nombre[] = new String[3];
        int salario[] = new int[3];

        for (int i = 0; i < nombre.length; i++){
            System.out.println("Ingrese su nombre:  ");
            nombre[i] = leer.nextLine();

            System.out.println("Ingrese su salario:  ");
            salario[i] = leer.nextInt();
            leer.nextLine();
        }

        for (int i = 0; i < nombre.length; i++){
            System.out.println(nombre[i] + "  GANA  " + salario[i]);
        }

        int mayor = salario[0];
        int posicionMayor = 0;
        for (int i = 0; i < nombre.length; i++){
            if (salario[i] > mayor) {
                mayor = salario[i];
                posicionMayor = i;
            }
        }

        System.out.println("El empleado que gana mas es: " + nombre[posicionMayor]);
        System.out.println("Salario: " + mayor);

    }
}

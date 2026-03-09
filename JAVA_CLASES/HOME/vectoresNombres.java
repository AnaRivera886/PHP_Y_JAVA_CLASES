package JAVA_CLASES.HOME;
import java.util.Scanner;

public class vectoresNombres {
    public static void main(String[] args) {
        
        // Guardar 5 nombres en un vector.
        // Pedir al usuario un nombre a buscar.
        // Decir si el nombre está en el vector o no.

            // CREAR VECTORES
        String nombres [] = new String[5];

        Scanner leer = new Scanner(System.in);

        // LLENAR EL VECTOR 
        for (int i = 0; i < nombres.length; i++){
            System.out.println("Ingresa un nombre:  ");
            nombres[i] = leer.nextLine();
        }

        // PEDIR EL NOMBRE A BUSCAR
        System.out.println("Ingrese el nombre a buscar:  ");
        String buscar = leer.nextLine();

        // BUSCAR EL NOMBRE EN EL VECTOR
        //! Crear una variable para saber si se encontró
        boolean encontrado = false;

        // SE RECORRE EL VECTOR PARA BUSCARLO
        for (int i = 0; i < nombres.length; i++){
            if (nombres[i].equals(buscar)) {
                encontrado = true;
            }
        }

        // MOSTRAR RESULTADO
        if (encontrado) {
            System.out.println("El nombre si está en el vector");
        }else{
            System.out.println("El nombre no está en el vector");
        }

    }
}

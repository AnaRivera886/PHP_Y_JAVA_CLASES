package JAVA_CLASES.HOME;
import java.util.Scanner;

public class vectoresNotas {
    public static void main(String[] args) {
        
    //     Guardar el nombre de 5 estudiantes
    //     Guardar la nota de cada estudiante
    //     Mostrar los datos
    //     Calcular el promedio de las notas
        Scanner leerScanner = new Scanner(System.in);

        String nombres[] = new String[5];
        double notas[] = new double[5];

        for(int i = 0; i < nombres.length; i++){
            System.out.println("Ingrse su nombre:  ");
            nombres[i] = leerScanner.nextLine();

            System.out.println("Ingrese su nota:  ");
            notas[i] = leerScanner.nextDouble();
            
            leerScanner.nextLine();
        }

        
        System.out.println("----------------- NOMBRES Y NOTAS -----------------");

        for(int i = 0; i < nombres.length; i++){
            System.out.println("\n" +  nombres[i] + "  su nota es  " + notas[i] );
        }

        System.out.println("----------------------------------");

        double suma = 0;
        for(int i = 0; i < notas.length; i++){
            suma = suma +notas[i];
        }
        double promedio = suma / notas.length;
        System.out.println("El promedio es: " + promedio);
    }
}

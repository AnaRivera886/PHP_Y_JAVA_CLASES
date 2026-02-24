import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String nombre ;
            String lugar;
            int edad;
    
            
            int n1 = 0;
            int n2 = 0;
            int suma = 0;
            int resta = 0;
            int multiplicacion = 0;
            int division = 0;
            double division2 = 0;
    
            Scanner leerlinea = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
    
            System.out.println("Ingrese un número: ");
            n1 = Integer.parseInt(leerlinea.nextLine()); // Leer una línea de texto ingresada por el usuario, convertirla a un número entero y asignarla a la variable n1
    
            System.out.println("Ingrese otro número: ");
            n2 = Integer.parseInt(leerlinea.nextLine()); // Leer una línea de texto ingresada por el usuario, convertirla a un número entero y asignarla a la variable n2
    
            suma = n1 + n2; // Calcular la suma de n1 y n2 y asignarla a la variable suma
            resta = n1 - n2; // Calcular la resta de n1 y n2 y asignarla a la variable resta
            multiplicacion = n1 * n2; // Calcular la multiplicación de n1
            division = n1 / n2; // Calcular la división de n1 entre n2 y asignarla a la variable division
            division2 = (double)n1 / n2; // Calcular el residuo de la división de n1 entre n2 y asignarla a la variable division2
    
            System.out.println("La suma es: " + suma); // Imprimir el resultado de la suma
            System.out.println("La resta es: " + resta); // Imprimir el resultado de la resta
            System.out.println("La multiplicación es: " + multiplicacion); // Imprimir el resultado de la multiplicación
            System.out.println("La división es: " + division); // Imprimir el resultado de la división
            System.out.println("La división con decimales es: " + division2); // Imprimir el resultado de la división con decimales

            // System.out.println("¿Cuál es tu nombre? ");
        // nombre = leerlinea.nextLine(); // Leer una línea de texto ingresada por el usuario y asignarla a la variable nombre


        // System.out.println("¿donde vives? ");
        // lugar = leerlinea.nextLine();


        // System.out.println("¿Cuántos años tienes? ");
        // edad = leerlinea.nextInt();


        // System.out.println("****************************************");
        // System.out.println("Hola, " + nombre + "!"); // Imprimir un saludo personalizado utilizando la variable nombre
        // System.out.println("Vives en " + lugar);
        // System.out.println("Tienes " + edad + " años");
}
}

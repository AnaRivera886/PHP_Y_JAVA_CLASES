package JAVA_CLASES.HOME;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Escribe tu edad: ");
        int edad = scanner.nextInt();

        if (edad >= 18) {
            System.out.println(nombre +  ",Puedes votar");
        }else{
            System.out.println(nombre +  ",No puedes votar recogete");
        }
    }
}

package JAVA_CLASES.HOME;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cual es tu edad?");
        int edad = scanner.nextInt();

        if (edad < 12) {
            System.out.println("Eres un niño");
        }else if (edad >= 12 && edad <= 17){
            System.out.println("Eres un adolecente");
        }else{
            System.out.println("Eres mayor de edad");
        }

    }
}

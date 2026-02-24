
import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 0, factorial = 1;

        System.out.print("ingresa un numero: ");
        num = Integer.parseInt(scanner.nextLine());

        System.out.println("ciclo para : "); 

        // for (int i = 1; i<= num; i++){
        //     factorial = factorial *i;
        // }
        // System.out.println("El factorial de " + num + " es: " + factorial);

        System.out.println("*********************************");

        int i = 1;
        while (i <= num) {
            factorial = factorial * i;
            i++;
        }
        System.out.println("El factorial de " + num + " es: " + factorial);


    }
}


import java.util.Scanner;

public class Primero {
    /* ELABORAR UN ALGORITMO QUE DADO UN VALOR DE X, TERMINE EL VALOR F(x) DEFINIDA POR LA SIGUIENTE FORMULA.
    SI X= 3 POR EJEMPLO, DEBE LLEGAR HASTA EL TERMINO -X/3! Y DEBERIA DAR COMO REULTADO -2 */

    public static double fact (int n){
        double resultado = 1;
        for ( int i = 1; i <= n; i++){
            resultado*=i;
        }
        return resultado;
    }

    public static double termino (int x,  int n){
        double potencia = Math.pow(x, n);
        double fact = fact(n);

        int signo = (n % 2 == 0) ? 1 : -1;

        return signo * potencia / fact;
    }

    public static double calcular (int x){
        double suma = 0;

        for (int n = 0; n <= x; n++){
            suma = suma +termino(x, n);
        }
        return suma;
    }


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el valor de x: ");
        int x = leer.nextInt();
        double resultado = calcular(x);

        System.out.println("F(" + x + ") = " + resultado);
    }

}

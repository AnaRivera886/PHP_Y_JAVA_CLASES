import java.util.Scanner;
public class primero {
    public static void main(String[] args) {
        /*Elaborar un algoritmo que dado un valor de x determine el valor de la funcion f(x) definida por la siguiente serie. SI x es igual 3 por ej, debe llegar al termino -x3 / 3! y debe de dar como reusltado = -2*/
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el valor de x");
        int x = leer.nextInt();
        
        double  rta = 0;
        for (int n = 0; n<= x; n++){
            double fact = 1;
            for (int i = 1; i <= n; i++){
                fact *= i;
            }
            int signo = (n %2 ==0) ? 1 :-1;
            rta += signo * (Math.pow(x, n))/fact;
        }
        System.out.println("f(" + x + ") = " + rta);
    }
    
} 
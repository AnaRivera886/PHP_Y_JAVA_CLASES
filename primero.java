import java.util.Scanner;

public class primero {

    // ─────────────────────────────────────────
    // FUNCIÓN 1: Calcula el factorial de n
    // Ejemplo: factorial(3) → 6
    // ─────────────────────────────────────────
    public static double factorial(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // ─────────────────────────────────────────
    // FUNCIÓN 2: Calcula cada término de la serie
    // Fórmula: signo × x^n / n!
    // Ejemplo: termino(3, 2) → +9/2 = 4.5
    // ─────────────────────────────────────────
    public static double termino(int x, int n) {
        int signo = (n % 2 == 0) ? 1 : -1;
        return signo * Math.pow(x, n) / factorial(n);
    }

    // ─────────────────────────────────────────
    // FUNCIÓN 3: Calcula f(x) recorriendo la serie
    // El for va de n=0 hasta n=x (igual que tu código)
    // ─────────────────────────────────────────
    public static double calcularF(int x) {
        double rta = 0;
        for (int n = 0; n <= x; n++) {
            rta += termino(x, n);
        }
        return rta;
    }

    // ─────────────────────────────────────────
    // MAIN: Lee x e imprime el resultado
    // ─────────────────────────────────────────
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el valor de x");
        int x = leer.nextInt();

        double resultado = calcularF(x);

        System.out.println("f(" + x + ") = " + resultado);
    }
}
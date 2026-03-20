import java.util.Scanner;

public class primero {

    // ─────────────────────────────────────────
    // FUNCIÓN 1: Calcula el factorial de n
    // ─────────────────────────────────────────
    public static double factorial(int n) {
        double resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;  // 1 × 1 × 2 × 3...
        }
        return resultado;
    }

    // ─────────────────────────────────────────
    // FUNCIÓN 2: Calcula un término de la serie
    // ─────────────────────────────────────────
    public static double termino(int x, int n) {
        double potencia = Math.pow(x, n);   // x elevado a n
        double fact     = factorial(n);     // n!
        int    signo    = 1;                // positivo por defecto

        if (n % 2 != 0) {                  // si n es impar → negativo
            signo = -1;
        }

        return signo * potencia / fact;
    }

    // ─────────────────────────────────────────
    // FUNCIÓN 3: Suma todos los términos
    // ─────────────────────────────────────────
    public static double calcularF(int x) {
        double suma = 0;

        for (int n = 0; n <= x; n++) {
            suma = suma + termino(x, n);   // acumula cada término
        }

        return suma;
    }

    // ─────────────────────────────────────────
    // MAIN: Lee x, llama calcularF, imprime
    // ─────────────────────────────────────────
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el valor de x: ");
        int x = leer.nextInt();

        double resultado = calcularF(x);

        System.out.println("f(" + x + ") = " + resultado);
    }
}
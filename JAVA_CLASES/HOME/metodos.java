package JAVA_CLASES.HOME;

public class metodos {

    static boolean esPar(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static void imprimirResultado(int num) {
        if (esPar(num) == true) {
            System.out.println("El numero " + num + " es Par");
        } else {
            System.out.println("El numero " + num + " es Impar");
        }

        // ✅ Más limpio — esPar() ya devuelve true/false, no necesitas compararlo
        //if (esPar(num))

    }

    public static void main(String[] args) {

        /*
         * Crea un programa con dos métodos:
         * esPar(int numero) — que reciba un número y devuelva true si es par, false si
         * es impar.
         * Tip: un número es par si numero % 2 == 0
         * imprimirResultado(int numero) — que reciba un número, llame a esPar() y
         * imprima "X es par" o "X es impar" según corresponda.
         * En el main llama a imprimirResultado con 3 números distintos.
         */

        imprimirResultado(3);
        imprimirResultado(8);
        imprimirResultado(15);
    }
}

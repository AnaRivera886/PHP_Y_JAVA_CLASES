package JAVA_CLASES.HOME;

public class forach {
    public static void main(String[] args) {
        /*
         * Tienes este array:
         * String[] nombres = {"Ana", "Carlos", "María", "Pedro", "Lucía"};
         * Escribe un programa que usando foreach imprima solamente los nombres que
         * tengan más de 4 letras.
         * Tip: en Java puedes saber cuántas letras tiene un String con .length() igual
         * que con arrays pero aplicado al texto.
         * "Ana".length() // 3
         * "Carlos".length() // 6
         */

        String[] nombres = {"Ana", "Carlos", "María", "Pedro", "Lucía"};
        for (String nombre : nombres) {
            if (nombre.length() > 4) {
                System.out.println(nombre);
            }
        }

    }
}

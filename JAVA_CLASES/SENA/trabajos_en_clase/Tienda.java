import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("cuantos productos va a ingresar: ");
        n = Integer.parseInt(scanner.nextLine());
        int[] valor = new int[n];
        
        String[] nombreProducto = new String[n];
        for (int i = 0; i < nombreProducto.length; i++) {
            System.out.println("ingrese el nombre del producto " + (i + 1));
            nombreProducto[i] = scanner.nextLine();
            System.out.println("ingrese el precio del producto " + (i + 1));
            valor[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("******* productos disponibles para la venta *******");
        for (int i = 0; i < valor.length; i++) {
            System.out.println(""+ nombreProducto[i] + " = " + valor[i]*1.19);
        }
        int [] aumento = new int[valor.length];
        int total = 0;
        for (int i = 0; i < valor.length; i++) {
            aumento[i] = (int) (valor[i]*1.19);
            total += aumento[i];
        }
        System.out.println("el total de los productos es: " + total);


        // ! esto es para mostrar lo que he ingresado con su nombre y valor del producto

        System.out.println("******* valor de los productos ingresados *******");
        for (int i = 0; i < valor.length; i++) {
            System.out.println("el producto " + nombreProducto[i] + " tiene un valor de " + valor[i]);
        }


        int [] ganancias = new int[valor.length];
        System.out.println("******* ganancias de los productos ingresados *******");
        for (int i = 0; i < ganancias.length; i++) {
            ganancias[i] = aumento[i] - valor[i];
            System.out.println("el producto " + nombreProducto[i] + " tiene una ganancia de " + ganancias[i]);
        }
        int totalGanancias = 0;
        for (int i = 0; i < ganancias.length; i++) {
            totalGanancias += ganancias[i];
        }
        System.out.println("el total de las ganancias es: " + totalGanancias);


        // ! esto es para mostrar el valor total de los productos ingresados

        // int total = 0;
        // for (int i = 0; i < valor.length; i++) {
        //     total += valor[i];
        // }
        // System.out.println("el total de los productos es: " + total);

        scanner.close();
    }
}

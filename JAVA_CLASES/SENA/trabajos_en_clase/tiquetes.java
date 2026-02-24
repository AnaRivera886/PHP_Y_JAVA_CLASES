import java.util.Scanner;

public class tiquetes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ruta = 0, ruta1 = 0, ruta2 = 0, ruta3 = 0, ruta4 = 0, ruta5 = 0, ruta6 = 0, opcion = 0;
        System.out.print("Bienvenido a la taquilla");
        System.out.println("nuetras rutas son: ");
        System.out.println("1. Medellin - Miami ");
        System.out.println("2. Medellin - Bogota - Roma ");
        System.out.println("3. Medellin - Panama - Los Angeles ");
        System.out.println("4. Medellin - Bogota - Madrid ");
        System.out.println("5. Medellin - Miami - Toronto ");
        System.out.println("6. Medellin - Buenos Aires ");

        for (int i = 0; i <= 10; i++) {
            System.out.println("ingresa el numero de la ruta que deseas: " + i);
            ruta = Integer.parseInt(scanner.nextLine());
            ValidarRuta(ruta);
            switch (ruta) {
                case 1:
                    ruta1++;
                    break;
                case 2:
                    ruta2++;
                    break;
                case 3:
                    ruta3++;
                    break;
                case 4:
                    ruta4++;
                    break;
                case 5:
                    ruta5++;
                    break;
                case 6:
                    ruta6++;
                    break;
                default:
                    System.out.println("ruta no valida");
            }
        }
        System.out.println("Ruta 1: " + ruta1);
        System.out.println("Ruta 2: " + ruta2);
        System.out.println("Ruta 3: " + ruta3);
        System.out.println("Ruta 4: " + ruta4);
        System.out.println("Ruta 5: " + ruta5);
        System.out.println("Ruta 6: " + ruta6);

        scanner.close();
    }

    private static void ValidarRuta(int ruta) {
        boolean rutaValida = false;
        while (rutaValida == false) {
            if (ruta >= 1 && ruta <= 6) {
                rutaValida = true;
            } else {
                System.out.println("Ruta no valida, ingresa una ruta entre 1 y 6");
                Scanner scanner = new Scanner(System.in);
                ruta = Integer.parseInt(scanner.nextLine());
            }
        }
    }
}

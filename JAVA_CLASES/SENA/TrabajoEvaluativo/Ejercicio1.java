package JAVA_CLASES.SENA.TrabajoEvaluativo;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = validarCantidad(sc);

        // Declaración de vectores
        String[] nombre = new String[N];
        int[] codigo = new int[N];
        char[] estadoCivil = new char[N];
        char[] sexo = new char[N];
        double[] valorHora = new double[N];
        int[] horasMes = new int[N];

        double[] salarioBasico = new double[N];
        double[] retencionSS = new double[N];
        double[] retencionImp = new double[N];
        double[] neto = new double[N];

        registrarTrabajadores(sc, nombre, codigo, estadoCivil, sexo,
                valorHora, horasMes, salarioBasico,
                retencionSS, retencionImp, neto);

        mostrarReportes(nombre, codigo, sexo, salarioBasico,
                retencionSS, neto);

        menu(sc, nombre, codigo, estadoCivil, sexo,
                valorHora, horasMes, salarioBasico,
                retencionSS, retencionImp, neto);
    }

    // VALIDAR N

    public static int validarCantidad(Scanner sc) {

        int N;

        do {
            System.out.print("Ingrese cantidad de trabajadores (30-300): ");
            N = sc.nextInt();
        } while (N < 30 || N > 300);

        return N;
    }

    // REGISTOS Y CALCULOS

    public static void registrarTrabajadores(
            Scanner sc,
            String[] nombre,
            int[] codigo,
            char[] estadoCivil,
            char[] sexo,
            double[] valorHora,
            int[] horasMes,
            double[] salarioBasico,
            double[] retencionSS,
            double[] retencionImp,
            double[] neto) {

        for (int i = 0; i < codigo.length; i++) {

            System.out.println("\nTrabajador " + (i + 1));

            // Validar código único
            boolean existe;
            do {
                existe = false;
                System.out.print("Codigo: ");
                codigo[i] = sc.nextInt();

                for (int j = 0; j < i; j++) {
                    if (codigo[i] == codigo[j]) {
                        existe = true;
                        System.out.println("Codigo repetido.");
                        break;
                    }
                }
            } while (existe);

            sc.nextLine();

            System.out.print("Nombre: ");
            nombre[i] = sc.nextLine();

            System.out.print("Estado civil (S/C/U/D/V): ");
            estadoCivil[i] = sc.next().charAt(0);

            System.out.print("Sexo (F/M): ");
            sexo[i] = sc.next().charAt(0);

            System.out.print("Valor hora: ");
            valorHora[i] = sc.nextDouble();

            System.out.print("Horas del mes: ");
            horasMes[i] = sc.nextInt();

            // Cálculos
            salarioBasico[i] = valorHora[i] * horasMes[i];

            if (salarioBasico[i] >= 750000) {
                retencionImp[i] = salarioBasico[i] * 0.05;
                retencionSS[i] = salarioBasico[i] * 0.03;
            } else {
                retencionImp[i] = 0;
                retencionSS[i] = salarioBasico[i] * 0.02;
            }

            neto[i] = salarioBasico[i] - (retencionSS[i] + retencionImp[i]);
        }
    }

    // REPORTES GLOBALES

    public static void mostrarReportes(
            String[] nombre,
            int[] codigo,
            char[] sexo,
            double[] salarioBasico,
            double[] retencionSS,
            double[] neto) {

        int N = codigo.length;

        int mujeres = 0;
        double sumaBasico = 0;
        double totalSS = 0;

        int posMayor = 0;
        int posMenor = 0;

        for (int i = 0; i < N; i++) {

            if (sexo[i] == 'F')
                mujeres++;

            sumaBasico += salarioBasico[i];
            totalSS += retencionSS[i];

            if (neto[i] > neto[posMayor])
                posMayor = i;

            if (neto[i] < neto[posMenor])
                posMenor = i;
        }

        double porcentajeMujeres = (mujeres * 100.0) / N;
        double promedioBasico = sumaBasico / N;

        System.out.println("\n--- REPORTES ---");
        System.out.println("Porcentaje mujeres: " + porcentajeMujeres + "%");
        System.out.println("Promedio salario básico: " + promedioBasico);
        System.out.println("Total seguridad social: " + totalSS);

        System.out.println("\nMayor neto:");
        System.out.println("Codigo: " + codigo[posMayor]);
        System.out.println("Nombre: " + nombre[posMayor]);
        System.out.println("Neto: " + neto[posMayor]);

        System.out.println("\nMenor neto:");
        System.out.println("Codigo: " + codigo[posMenor]);
        System.out.println("Nombre: " + nombre[posMenor]);
        System.out.println("Neto: " + neto[posMenor]);
    }

    // MENNU

    public static void menu(
            Scanner sc,
            String[] nombre,
            int[] codigo,
            char[] estadoCivil,
            char[] sexo,
            double[] valorHora,
            int[] horasMes,
            double[] salarioBasico,
            double[] retencionSS,
            double[] retencionImp,
            double[] neto) {

        int opcion;

        do {

            System.out.println("\nMENU");
            System.out.println("1. Buscar secuencial");
            System.out.println("2. Ordenar por codigo");
            System.out.println("3. Buscar binaria");
            System.out.println("4. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    buscarSecuencial(sc, nombre, codigo, neto);
                    break;

                case 2:
                    ordenarPorCodigo(nombre, codigo, estadoCivil,
                            sexo, valorHora, horasMes,
                            salarioBasico, retencionSS,
                            retencionImp, neto);
                    System.out.println("Ordenado.");
                    break;

                case 3:
                    buscarBinaria(sc, nombre, codigo, neto);
                    break;

            }

        } while (opcion != 4);
    }

    // BUSQUEDA SECUENCIAL

    public static void buscarSecuencial(
            Scanner sc,
            String[] nombre,
            int[] codigo,
            double[] neto) {

        System.out.print("Ingrese codigo a buscar: ");
        int buscar = sc.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < codigo.length; i++) {

            if (codigo[i] == buscar) {

                System.out.println("Encontrado:");
                System.out.println("Codigo: " + codigo[i]);
                System.out.println("Nombre: " + nombre[i]);
                System.out.println("Neto: " + neto[i]);

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Trabajador no encontrado.");
        }
    }

    // ORDAMIENTO BURUBUJA

    public static void ordenarPorCodigo(
            String[] nombre,
            int[] codigo,
            char[] estadoCivil,
            char[] sexo,
            double[] valorHora,
            int[] horasMes,
            double[] salarioBasico,
            double[] retencionSS,
            double[] retencionImp,
            double[] neto) {

        int N = codigo.length;

        for (int i = 0; i < N - 1; i++) {

            for (int j = 0; j < N - 1 - i; j++) {

                if (codigo[j] > codigo[j + 1]) {

                    // intercambio codigo
                    int tempCod = codigo[j];
                    codigo[j] = codigo[j + 1];
                    codigo[j + 1] = tempCod;

                    // intercambio nombre
                    String tempNom = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = tempNom;

                    // intercambio estado civil
                    char tempEst = estadoCivil[j];
                    estadoCivil[j] = estadoCivil[j + 1];
                    estadoCivil[j + 1] = tempEst;

                    // intercambio sexo
                    char tempSexo = sexo[j];
                    sexo[j] = sexo[j + 1];
                    sexo[j + 1] = tempSexo;

                    // intercambio valor hora
                    double tempVH = valorHora[j];
                    valorHora[j] = valorHora[j + 1];
                    valorHora[j + 1] = tempVH;

                    // intercambio horas
                    int tempHoras = horasMes[j];
                    horasMes[j] = horasMes[j + 1];
                    horasMes[j + 1] = tempHoras;

                    // intercambio salario
                    double tempSal = salarioBasico[j];
                    salarioBasico[j] = salarioBasico[j + 1];
                    salarioBasico[j + 1] = tempSal;

                    // intercambio retenciones
                    double tempSS = retencionSS[j];
                    retencionSS[j] = retencionSS[j + 1];
                    retencionSS[j + 1] = tempSS;

                    double tempImp = retencionImp[j];
                    retencionImp[j] = retencionImp[j + 1];
                    retencionImp[j + 1] = tempImp;

                    // intercambio neto
                    double tempNeto = neto[j];
                    neto[j] = neto[j + 1];
                    neto[j + 1] = tempNeto;
                }
            }
        }
    }

    // BUSQUEDA BINARIA

    public static void buscarBinaria(
            Scanner sc,
            String[] nombre,
            int[] codigo,
            double[] neto) {

        System.out.print("Ingrese codigo a buscar: ");
        int buscar = sc.nextInt();

        int inicio = 0;
        int fin = codigo.length - 1;
        int posicion = -1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (codigo[medio] == buscar) {
                posicion = medio;
                break;
            }

            if (buscar < codigo[medio]) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }

        if (posicion != -1) {
            System.out.println("Encontrado:");
            System.out.println("Codigo: " + codigo[posicion]);
            System.out.println("Nombre: " + nombre[posicion]);
            System.out.println("Neto: " + neto[posicion]);
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

}

package JAVA_CLASES.SENA.TrabajoEvaluativo;

import java.util.Scanner;

public class ejercicio2 {

    // ================= BUSQUEDA SECUENCIAL =================
    public static int busquedaSecuencial(int[] id, int N, int buscado) {
        for (int i = 0; i < N; i++) {
            if (id[i] == buscado)
                return i;
        }
        return -1;
    }

    // ================= ORDENAMIENTO (BURBUJA) =================
    public static void ordenarPorId(int[] id, double[] num, int N) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (id[j] > id[j + 1]) {

                    // intercambiar id
                    int auxId = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = auxId;

                    // intercambiar num
                    double auxNum = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = auxNum;
                }
            }
        }
    }

    // ================= BUSQUEDA BINARIA =================
    public static int busquedaBinaria(int[] id, int N, int buscado) {

        int inicio = 0;
        int fin = N - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (id[medio] == buscado)
                return medio;

            if (buscado < id[medio])
                fin = medio - 1;
            else
                inicio = medio + 1;
        }

        return -1;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de numeros (>=50): ");
        int N = sc.nextInt();

        double[] num = new double[N];
        boolean[] esEntero = new boolean[N];
        boolean[] esMult5 = new boolean[N];
        boolean[] esMultK = new boolean[N];
        boolean[] esPositivo = new boolean[N];
        int[] clasRango = new int[N];
        int[] id = new int[N];

        System.out.print("Ingrese K (2-20): ");
        int K = sc.nextInt();

        // ================= CARGA Y CLASIFICACION =================
        for (int i = 0; i < N; i++) {

            id[i] = i + 1;

            System.out.print("Numero " + (i + 1) + ": ");
            num[i] = sc.nextDouble();

            esEntero[i] = (num[i] == (int) num[i]);

            if (esEntero[i] && ((int) num[i] % 5 == 0))
                esMult5[i] = true;
            else
                esMult5[i] = false;

            if (esEntero[i] && ((int) num[i] % K == 0))
                esMultK[i] = true;
            else
                esMultK[i] = false;

            esPositivo[i] = (num[i] > 0);

            // Clasificación por rango (ejemplo)
            if (num[i] < 0)
                clasRango[i] = 1;
            else if (num[i] <= 50)
                clasRango[i] = 2;
            else if (num[i] <= 100)
                clasRango[i] = 3;
            else if (num[i] <= 200)
                clasRango[i] = 4;
            else
                clasRango[i] = 5;
        }

        // ================= RESULTADOS =================

        int contadorMult5 = 0;
        double sumaNoMult5 = 0;
        double sumaTotal = 0;
        int positivos = 0;

        double mayor = num[0];
        double menor = num[0];

        for (int i = 0; i < N; i++) {

            sumaTotal += num[i];

            if (esMult5[i])
                contadorMult5++;
            else
                sumaNoMult5 += num[i];

            if (esPositivo[i])
                positivos++;

            if (num[i] > mayor)
                mayor = num[i];

            if (num[i] < menor)
                menor = num[i];
        }

        // Contar repeticiones
        int contMayor = 0;
        int contMenor = 0;

        for (int i = 0; i < N; i++) {
            if (num[i] == mayor)
                contMayor++;
            if (num[i] == menor)
                contMenor++;
        }

        // Segundo mayor distinto
        double segundoMayor = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < N; i++) {
            if (num[i] > segundoMayor && num[i] < mayor)
                segundoMayor = num[i];
        }

        // Vector auxiliar múltiplos de 5
        double[] multiplos5 = new double[N];
        int pos = 0;

        for (int i = 0; i < N; i++) {
            if (esMult5[i]) {
                multiplos5[pos] = num[i];
                pos++;
            }
        }

        // ================= MOSTRAR RESULTADOS =================
        System.out.println("\n====== RESULTADOS ======");
        System.out.println("Cantidad multiplos de 5: " + contadorMult5);

        System.out.println("Listado multiplos de 5:");
        for (int i = 0; i < pos; i++) {
            System.out.println(multiplos5[i]);
        }

        System.out.println("Suma NO multiplos de 5: " + sumaNoMult5);
        System.out.println("Promedio general: " + (sumaTotal / N));
        System.out.println("Porcentaje positivos: " + (positivos * 100.0 / N) + "%");

        System.out.println("Mayor: " + mayor + " aparece: " + contMayor + " veces");
        System.out.println("Menor: " + menor + " aparece: " + contMenor + " veces");
        System.out.println("Segundo mayor distinto: " + segundoMayor);

        // ================= BUSQUEDAS =================
        System.out.print("\nBuscar por ID (secuencial): ");
        int buscar = sc.nextInt();
        int posSec = busquedaSecuencial(id, N, buscar);

        if (posSec != -1)
            System.out.println("Encontrado: " + num[posSec]);
        else
            System.out.println("No encontrado.");

        ordenarPorId(id, num, N);

        System.out.print("Buscar por ID (binaria): ");
        buscar = sc.nextInt();
        int posBin = busquedaBinaria(id, N, buscar);

        if (posBin != -1)
            System.out.println("Encontrado: " + num[posBin]);
        else
            System.out.println("No encontrado.");

        sc.close();
    }
}
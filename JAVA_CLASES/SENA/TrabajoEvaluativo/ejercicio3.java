package JAVA_CLASES.SENA.TrabajoEvaluativo;

import java.util.Scanner;

public class ejercicio3 {

    // ================= BUSQUEDA SECUENCIAL =================
    public static int busquedaSecuencial(int[] codigo, int N, int buscado) {
        for (int i = 0; i < N; i++) {
            if (codigo[i] == buscado)
                return i;
        }
        return -1;
    }

    // ================= ORDENAMIENTO POR CODIGO =================
    public static void ordenarPorCodigo(int[] codigo, String[] nombre,
                                        int[] lun, int[] mar, int[] mie,
                                        int[] jue, int[] vie, int[] sab, int[] dom,
                                        int N) {

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {

                if (codigo[j] > codigo[j + 1]) {

                    // Intercambiar código
                    int auxCod = codigo[j];
                    codigo[j] = codigo[j + 1];
                    codigo[j + 1] = auxCod;

                    // Intercambiar nombre
                    String auxNom = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = auxNom;

                    // Intercambiar horas de cada día
                    int aux;

                    aux = lun[j]; lun[j] = lun[j+1]; lun[j+1] = aux;
                    aux = mar[j]; mar[j] = mar[j+1]; mar[j+1] = aux;
                    aux = mie[j]; mie[j] = mie[j+1]; mie[j+1] = aux;
                    aux = jue[j]; jue[j] = jue[j+1]; jue[j+1] = aux;
                    aux = vie[j]; vie[j] = vie[j+1]; vie[j+1] = aux;
                    aux = sab[j]; sab[j] = sab[j+1]; sab[j+1] = aux;
                    aux = dom[j]; dom[j] = dom[j+1]; dom[j+1] = aux;
                }
            }
        }
    }

    // ================= BUSQUEDA BINARIA =================
    public static int busquedaBinaria(int[] codigo, int N, int buscado) {

        int inicio = 0;
        int fin = N - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (codigo[medio] == buscado)
                return medio;

            if (buscado < codigo[medio])
                fin = medio - 1;
            else
                inicio = medio + 1;
        }

        return -1;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de obreros (50-200): ");
        int N = sc.nextInt();

        String[] nombre = new String[N];
        int[] codigo = new int[N];

        int[] lun = new int[N];
        int[] mar = new int[N];
        int[] mie = new int[N];
        int[] jue = new int[N];
        int[] vie = new int[N];
        int[] sab = new int[N];
        int[] dom = new int[N];

        int[] totalHoras = new int[N];
        int[] horasExtra = new int[N];
        double[] pago = new double[N];

        // ================= CARGA DE DATOS =================
        for (int i = 0; i < N; i++) {

            System.out.println("\nObrero " + (i+1));

            System.out.print("Codigo: ");
            codigo[i] = sc.nextInt();

            // Validar código único
            for (int j = 0; j < i; j++) {
                if (codigo[i] == codigo[j]) {
                    System.out.println("Codigo repetido. Ingrese otro:");
                    codigo[i] = sc.nextInt();
                    j = -1;
                }
            }

            System.out.print("Nombre: ");
            nombre[i] = sc.next();

            System.out.println("Horas trabajadas Lun Mar Mie Jue Vie Sab Dom:");
            lun[i] = sc.nextInt();
            mar[i] = sc.nextInt();
            mie[i] = sc.nextInt();
            jue[i] = sc.nextInt();
            vie[i] = sc.nextInt();
            sab[i] = sc.nextInt();
            dom[i] = sc.nextInt();

            // Calcular total horas
            totalHoras[i] = lun[i] + mar[i] + mie[i] + jue[i] +
                            vie[i] + sab[i] + dom[i];

            if (totalHoras[i] <= 40) {
                pago[i] = totalHoras[i] * 500;
                horasExtra[i] = 0;
            } else {
                horasExtra[i] = totalHoras[i] - 40;
                pago[i] = (40 * 500) + (horasExtra[i] * 700);
            }
        }

        // ================= REPORTES GLOBALES =================

        double totalEmpresa = 0;
        int sumaExtras = 0;
        int maxExtras = horasExtra[0];
        int posMax = 0;

        int[] totalDia = new int[7];

        for (int i = 0; i < N; i++) {

            totalEmpresa += pago[i];
            sumaExtras += horasExtra[i];

            if (horasExtra[i] > maxExtras) {
                maxExtras = horasExtra[i];
                posMax = i;
            }

            totalDia[0] += lun[i];
            totalDia[1] += mar[i];
            totalDia[2] += mie[i];
            totalDia[3] += jue[i];
            totalDia[4] += vie[i];
            totalDia[5] += sab[i];
            totalDia[6] += dom[i];
        }

        System.out.println("\n====== REPORTES ======");
        System.out.println("Total pagado por la empresa: " + totalEmpresa);
        System.out.println("Promedio horas extra: " + (double)sumaExtras / N);
        System.out.println("Obrero con mas horas extra: " + nombre[posMax]);

        int maxDia = totalDia[0];
        int posDia = 0;

        for (int i = 1; i < 7; i++) {
            if (totalDia[i] > maxDia) {
                maxDia = totalDia[i];
                posDia = i;
            }
        }

        String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

        System.out.println("Dia con mas horas acumuladas: " + dias[posDia]);

        // ================= BUSQUEDAS =================
        System.out.print("\nBuscar obrero por codigo (secuencial): ");
        int buscar = sc.nextInt();

        int pos = busquedaSecuencial(codigo, N, buscar);

        if (pos != -1)
            System.out.println("Encontrado: " + nombre[pos]);
        else
            System.out.println("No encontrado.");

        // Ordenar antes de binaria
        ordenarPorCodigo(codigo, nombre, lun, mar, mie, jue, vie, sab, dom, N);

        System.out.print("Buscar obrero por codigo (binaria): ");
        buscar = sc.nextInt();

        pos = busquedaBinaria(codigo, N, buscar);

        if (pos != -1)
            System.out.println("Encontrado: " + nombre[pos]);
        else
            System.out.println("No encontrado.");

        sc.close();
    }
}

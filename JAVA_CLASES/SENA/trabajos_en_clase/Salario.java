import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        
        System.out.println("Ejercicio 1: ");
        Numero();
        
        System.out.println("**************************************************** ");
        System.out.println("\nEjercicio 2: ");
        Salario();

    }

    // Un empleado trabaja 48 horas en la semana a razón de $5.000 la hora. El
//     // porcentaje de retención en la fuente
//     // es del 12,5% del salario básico. Haga un algoritmo que muestre el salario
//     // básico, la retención en la fuente y el
//     // salario neto del trabajador en un algoritmo. (Nota: El salario básico es lo
//     // que recibe el empleado sin
//     // descuentos; la retención en la fuente es un descuento que se le hace al
//     // empleado sobre su salario básico; el
//     // salario neto es lo que recibe realmente el empleado, es decir, el salario
//     // básico menos lo que se le descuenta.
//     // Tenga en cuenta que el salario básico, generalmente es mensual).


    public static void Salario() {
        
        int horasTrabajadas = 48;
        int valorHora = 5000;
        double porcentajeRetencion = 0.125;
        
        int salarioBasico = horasTrabajadas * valorHora;
        double retencionFuente = salarioBasico * porcentajeRetencion;
        double salarioNeto = salarioBasico - retencionFuente;
        
        System.out.println("Salario Básico: $" + salarioBasico);
        System.out.println("Retención en la Fuente: $" + retencionFuente);
        System.out.println("Salario Neto: $" + salarioNeto);
    }
    
    public static void Numero() {
    
        int numero;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        numero = Integer.parseInt(leer.nextLine());
    
        int positivo = Math.abs(numero);
    
        System.out.println("el numero " + numero + " es " + positivo + " positivo");
    
    }
}

package Proyectos_PO;
import java.util.ArrayList;

abstract class Empleados {

    private String nombre;
    private int id;

    Empleados(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }

    //GETTERS

    String getNombre(){
        return nombre;
    }

    int getId(){
        return id;
    }

    // METODO ABSTRACTO
    abstract double calcularSalario();

    void mostrarInfo(){
        System.out.print("DATOS DEL EMPLEADO");
        System.out.println("\n NOMBRE: " + nombre + "| ID: " + id + "| SALARIO: " + calcularSalario());
    }
}

class EmpleadoTiempoCompleto extends Empleados{

    private double salarioMensual;
    EmpleadoTiempoCompleto(String nombre, int id, double salarioMensual){
        super(nombre, id);
        this.salarioMensual = salarioMensual;
    }
    @Override
    double calcularSalario(){
        return salarioMensual;
    }
}

class EmpleadoPorHoras extends Empleados {

    private int horasTrabajadas;
    private double valorHora;

    EmpleadoPorHoras(String nombre, int id, int horasTrabajadas, double valorHora){
        super(nombre, id);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }
    @Override
    double calcularSalario(){
        return horasTrabajadas * valorHora;
    }
}


public class Medio_proy {
    public static void main(String[] args) {
        ArrayList<Empleados>empleado = new ArrayList<>();
        empleado.add(new EmpleadoPorHoras("Ana", 2, 5, 8000));
        empleado.add(new EmpleadoPorHoras("Denny", 1, 8, 8000));
        empleado.add(new EmpleadoTiempoCompleto("Cora", 0, 200000));
        empleado.add(new EmpleadoTiempoCompleto("Tyler", 4, 800000));

        for (Empleados empleados : empleado) {
            empleados.mostrarInfo();
        }
    }
}


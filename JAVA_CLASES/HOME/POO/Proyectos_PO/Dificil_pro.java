package Proyectos_PO;
import java.util.ArrayList;


interface Mantenible {
    void realizarMantenimiento();
}

abstract class Vehiculo{
    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;

    Vehiculo(String marca, String modelo, int anio, double kilometraje){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
    }

    //GETTERS
    String getMarca(){ 
        return marca;
    }

    String getModelo(){
        return modelo;
    }

    int getAnio(){
        return anio;
    }

    double getKm(){
        return kilometraje;
    }

    //SETTERS
    void setKm(double nuevoKm){
    if (nuevoKm > kilometraje) { 
        this.kilometraje = nuevoKm;
    } else {
        System.out.println("El nuevo kilometraje debe ser mayor al actual");
    }
}

    // METOODO ABSTRACTO
    abstract double calcularCostoOperacion();

    void mostrarInfo(){
        System.out.print("--INFORMACION DEL VEHICULO--");
        System.out.println("\n MARCA: " + marca + " | MODELO: " + modelo + " | AÑO: " + anio + " | KM: " + kilometraje + "km | COSTO DE OPERACION: " + calcularCostoOperacion() );
    }
}

class VehiculoElectrico extends Vehiculo implements Mantenible{
    private double capacidadBateria;
    private double costoPorKwh;

    VehiculoElectrico(String marca, String modelo, int anio, double kilometraje, double capacidadBateria, double costoPorKwh){
        super(marca, modelo, anio, kilometraje);
        this.capacidadBateria = capacidadBateria;
        this.costoPorKwh = costoPorKwh;
    }
    @Override
    double calcularCostoOperacion(){
        return capacidadBateria * costoPorKwh;
    }

    @Override
    public void realizarMantenimiento(){
        System.out.println( getMarca() +"|" + getModelo() +": Revisando bateria y sistemas electricos" );
    }
}

class VehiculoGasolina extends Vehiculo implements Mantenible{
    private double consumoxKm;
    private double precioxLitro;

    VehiculoGasolina(String marca, String modelo, int anio, double kilometraje, double consumoxKm, double precioxLitro){
        super(marca, modelo, anio, kilometraje);
        this.consumoxKm = consumoxKm;
        this.precioxLitro = precioxLitro;
    }

    @Override
    double calcularCostoOperacion() {
        return consumoxKm * precioxLitro * getKm();
    }

    @Override
    public void realizarMantenimiento(){
        System.out.println(getMarca() + "|" + getModelo() + ": Cambiando aceite y revisando motor");
    }
}



public class Dificil_pro {
    public static void main(String[] args) {
        ArrayList<Vehiculo>vehiculo = new ArrayList<>();

        vehiculo.add(new VehiculoElectrico("Yamaha", "Nmax", 2024, 120, 12, 80000));
        vehiculo.add(new VehiculoElectrico("Yamaha", "Bwis", 2020, 110, 10, 60000));
        vehiculo.add(new VehiculoGasolina("Suzuki", "Gixxer", 2025, 380, 25, 16000));
        vehiculo.add(new VehiculoGasolina("Kawasaki", "Ninja", 2013, 150000, 60, 16000));

        for (Vehiculo vehiculos : vehiculo) {
            vehiculos.mostrarInfo();
            ((Mantenible) vehiculos).realizarMantenimiento();
        }

        vehiculo.get(2).setKm(140);

    }
}

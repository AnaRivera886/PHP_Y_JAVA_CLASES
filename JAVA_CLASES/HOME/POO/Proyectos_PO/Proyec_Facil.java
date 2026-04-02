package Proyectos_PO;
import java.util.ArrayList;

class Mascota {
    private String nombre;
    private String especie;
    private int edad;
    private double peso;

    Mascota(String nombre, String especie, int edad, double peso){
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
    }

    // GETTERS 
    String getNombre(){
        return nombre;
    }

    String getEspecie(){
        return especie;
    }

    int getEdad(){
        return edad;
    }

    double getPeso(){
        return peso;
    }

    //SETTERS
    void setPeso(double peso){
        if (peso >0) {
            this.peso = peso;
        }else{
            System.out.println("Peso no valido");
        }
    }

    void mostrarInfo(){
        System.out.print("\n------------DATOS DE LA MASCOTA-----------------");
        System.out.println("Nombre: " + nombre + "\t Especie: " + especie + "\t Edad: " + edad + "\t Peso: " + peso + "Kg");
    }

}

public class Proyec_Facil {
    public static void main(String[] args) {
        ArrayList<Mascota>mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Eren", "Perro", 2, 5));
        mascotas.add(new Mascota("Pepe", "Gato", 1, 2));
        mascotas.add(new Mascota("Pipa", "Loro", 2, 2));
        mascotas.add(new Mascota("Rabulth", "Perro", 2, 7));

        mascotas.add(0, new Mascota("Mikasa", "Perro", 3, 9));

        for (Mascota mascota : mascotas) {
            mascota.mostrarInfo();
        }
        mascotas.get(0).setPeso(-5); 




    }
}

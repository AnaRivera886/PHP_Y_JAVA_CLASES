package JAVA_CLASES.HOME.POO;

class Vehiculo {

    String Marca;
    int velocidadMaxima;

    Vehiculo(String Marca, int velocidadMaxima) {
        this.Marca = Marca;
        this.velocidadMaxima = velocidadMaxima;
    }

    void describir() {
        System.out.println("Marca: " + Marca + ", Velocidad maxima: " + velocidadMaxima + "Km/h");
    }

}

class Moto extends Vehiculo {

    boolean tieneSidecar;

    Moto(String Marca, int velocidadMaxima, boolean tieneSidecar) {
        super(Marca, velocidadMaxima);
        this.tieneSidecar = tieneSidecar;
    }

    void hacerCaballito() {
        System.out.println(Marca + " Está haciendo un caballito!");
    }
}

class Camion extends Vehiculo {
    int capacidadToneladas;

    Camion(String Marca, int velocidadMaxima, int capacidadToneladas) {
        super(Marca, velocidadMaxima);
        this.capacidadToneladas = capacidadToneladas;
    }

    void cargar() {
        System.out.println(Marca + " Puede cargar " + capacidadToneladas + " toneladas");
    }
}

public class Herenci {
    /*
     * Crea una jerarquía de clases para vehículos:
     * Clase padre Vehiculo:
     * Atributos: marca (String), velocidadMaxima (int).Constructor con esos dos
     * atributos
     * Método describir() que imprima
     * "Marca: [marca], Velocidad máxima: [velocidadMaxima] km/h"
     * 
     * Clase hija Moto:
     * Atributo propio: tieneSidecar (boolean)
     * Constructor con los tres atributos
     * Método propio hacerCaballito() que
     * imprima"[marca] está haciendo un caballito!"
     * 
     * Clase hija Camion:
     * Atributo propio: capacidadToneladas (int)
     * Constructor con los tres atributos
     * Método propio cargar() que imprima
     * "[marca] puede cargar [capacidadToneladas] toneladas"
     */

    public static void main(String[] args) {
        Moto h2r = new Moto("Kawasaki", 1000, true);
        h2r.describir();;
        h2r.hacerCaballito();

        Camion camion1 = new Camion("CAT", 950, 2000);
        camion1.cargar();
        camion1.describir();
    }

}

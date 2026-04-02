
interface Dibujable {

    void dibujar();
}

abstract class Figura {
    String color;

    Figura(String color) {
        this.color = color;
    }

    abstract double calcularArea();

    void mostrarColor() {
        System.out.println("Color: " + color);
    }

}

class Circulo extends Figura implements Dibujable {
    double radio; // Atributo

    // CONTRUCTOR
    Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }

    @Override
    double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo de radio " + radio);
    }
}

class Rectangulo extends Figura implements Dibujable {
    double ancho;
    double alto;

    Rectangulo(double ancho, double alto, String color) {
        super(color);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    double calcularArea() {
        return ancho * alto;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo de " + ancho + "x" + alto);
    }
}

public class abstractoYInterfaces {

    public static void main(String[] args) {

        /*
         * Crea este sistema:
         * Interfaz Dibujable:
         * Método dibujar()
         * 
         * Clase abstracta Figura:
         * Atributo color (String)
         * Constructor con color
         * Método abstracto calcularArea() que devuelve double
         * Método normal mostrarColor() que imprime "Color: [color]"
         * 
         * Clase Circulo que extiende Figura e implementa Dibujable:
         * Atributo radio (double)
         * Constructor con color y radio
         * Implementa calcularArea() → Math.PI * radio * radio
         * Implementa dibujar() → imprime "Dibujando un círculo de radio [radio]"
         * 
         * Clase Rectangulo que extiende Figura e implementa Dibujable:
         * Atributos ancho y alto (double)
         * Constructor con color, ancho y alto
         * Implementa calcularArea() → ancho * alto
         * Implementa dibujar() → imprime "Dibujando un rectángulo de [ancho]x[alto]"
         */

        Circulo circulo = new Circulo("Rojo", 10);
        circulo.mostrarColor();
        System.out.println("El area del circulo es: " + circulo.calcularArea());
        circulo.dibujar();

        // RECTANGULO
        Rectangulo rect = new Rectangulo(12, 4, "Negro");
        rect.mostrarColor();
        System.out.println("El area del rectangulo es: " + rect.calcularArea());
        rect.dibujar();

    }
}

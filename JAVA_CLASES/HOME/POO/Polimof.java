import java.util.ArrayList;

interface Dibujable {

    void dibujar();
}

abstract class Figura implements Dibujable {
    String color;

    Figura(String color) {
        this.color = color;
    }

    abstract double calcularArea();

    void mostrarColor() {
        System.out.println("Color: " + color);
    }

    // void dibujar() {
    // } // TUVE QUE IMPLEMENTARLO PORQUE ME SALIA ERROR "EL METODO dibujar() NO ESTÁ
    //   // DEFINIDO PARA EL TIPO Figura()"

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
        System.out.println("\nDibujando un círculo de radio " + radio);
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
        System.out.println("\nDibujando un rectángulo de " + ancho + " x " + alto);
    }
}

class Triangulo extends Figura implements Dibujable {
    double base;
    double altura;

    Triangulo(double base, double altura, String color) {
        super(color);
        this.base = base;
        this.altura = altura;
    }

    @Override
    double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public void dibujar() {
        System.out.println("\nDibujando un triángulo de base " + base + " y altura " + altura);
    }
}

public class Polimof {
    /*
     * Reutiliza las clases Figura, Circulo y Rectangulo del ejercicio anterior y
     * agrégale una clase más:
     * Clase Triangulo que extiende Figura e implementa Dibujable:
     * 
     * Atributos base y altura (double)
     * Constructor con color, base y altura
     * calcularArea() → (base * altura) / 2
     * dibujar() → imprime "Dibujando un triángulo de base [base] y altura [altura]"
     * 
     * Luego en el main:
     * 
     * Crea un ArrayList<Figura> llamado figuras
     * Agrega un Circulo, un Rectangulo y un Triangulo
     * Recorre la lista con foreach y llama a mostrarColor(), calcularArea() y
     * dibujar() para cada figura
     */

    public static void main(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo("Rojo", 10));
        figuras.add(new Rectangulo(5, 2, "Verde"));
        figuras.add(new Triangulo(8, 12, "Morado"));

        for (Figura figura : figuras) {
            figura.mostrarColor();
            System.out.println("Área: " + figura.calcularArea());
            figura.dibujar();
        }
    }
}

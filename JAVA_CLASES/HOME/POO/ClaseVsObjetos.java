// package JAVA_CLASES.HOME.POO;

// class Persona {
//     // ATRIBUTOS
//     String nombre;
//     int edad;
//     String ciudad;

//     // METODOS
//     void saludar() {
//         System.out.println("Hola, soy " + nombre + " y vivo en " + ciudad);
//     }

//     boolean esMayorDeEdad() {
//         if (edad >= 18) {
//             return true;
//         } else {
//             return false;
//         }
//     }
// }

// public class ClaseVsObjetos {
//     /*
//      * Crea una clase Persona con:
//      * Atributos: nombre (String), edad (int), ciudad (String)
//      * Métodos: saludar() — imprime "Hola, soy [nombre] y vivo en [ciudad]"
//      * esMayorDeEdad() — devuelve true si la edad es mayor o igual a 18
//      * En el main crea dos personas distintas y llama a los dos métodos con cada
//      * una.
//      */
//     public static void main(String[] args) {
//         Persona persona1 = new Persona();

//         persona1.nombre = "Ana";
//         persona1.edad = 18;
//         persona1.ciudad = "Valledupar";
//         persona1.saludar();
//         if (persona1.esMayorDeEdad()) {
//             System.out.println(persona1.nombre + " es mayor de edad");
//         } else {
//             System.out.println(persona1.nombre + " es menor de edad");
//         }

//         Persona persona2 = new Persona();

//         persona2.nombre = "Pepe";
//         persona2.edad = 15;
//         persona2.ciudad = "Medellin";
//         persona2.saludar();
//         if (persona2.esMayorDeEdad()) {
//             System.out.println(persona2.nombre + " es mayor de edad");
//         } else {
//             System.out.println(persona2.nombre + " es menor de edad");
//         }
//     }

// }

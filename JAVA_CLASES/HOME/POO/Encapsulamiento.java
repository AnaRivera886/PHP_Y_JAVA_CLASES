class Persona {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private String ciudad;


    //CONSTRUCTOR
    Persona(String nombre, int edad, String ciudad){
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    //GETTERS
    String getNombre(){
        return nombre;
    }
    
    int getEdad(){
        return edad;
    }

    String getCiudad(){
        return ciudad;
    }

    //SETTERS
    void setCiudad(String ciudad){
        if (ciudad.isEmpty()) {
            System.out.println("La ciudad no puede ser vacio");
        }else{
            this.ciudad = ciudad;
        }
    }

    // METODOS
    void saludar() {
        System.out.println("Hola, soy " + nombre + " y vivo en " + ciudad);
    }

    boolean esMayorDeEdad() {
        if (edad >= 18) {
            return true;
        } else {
            return false;
        }
    }
}


public class Encapsulamiento {
    /*
     * Toma la clase Persona de nuevo y aplícale encapsulamiento completo:
     * 
     * Todos los atributos en private
     * Getters para los tres atributos
     * Setter solo para ciudad — con una validación: la ciudad no puede ser un texto vacío ""
     * En el main crea una persona con el constructor, imprime su nombre con el getter, cambia su ciudad con el setter (prueba una vez con ciudad válida y
     * otra con "")
     */

    public static void main(String[] args) {
        Persona persona1 = new Persona("Ana",18, "Valledupar");
        System.out.println(persona1.getNombre());

        persona1.setCiudad("Medellin");
        System.out.println(persona1.getCiudad());

        Persona persona2 = new Persona("Pepee", 25, "Cartagena");
        persona2.setCiudad("");
        
        System.out.println(persona2.getEdad());
    }
}

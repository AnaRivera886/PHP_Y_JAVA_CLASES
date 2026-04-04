package JAVA_CLASES.HOME.BLOQUE3;
import java.util.HashMap;


public class hashma {
    public static void main(String[] args) {
        /*
        Crea un programa que maneje un diccionario de países y capitales:
        
         * Crea un HashMap<String, String> donde la clave es el país y el valor es la
         * capital
         * Agrega 5 países con sus capitales
         * Imprime la capital de Colombia
         * Verifica si "Francia" está en el mapa e imprime un mensaje según corresponda
         * Actualiza la capital de un país (pon cualquier valor incorrecto primero y
         * luego corrígelo)
         * Recorre todo el mapa e imprime "La capital de [país] es [capital]"
         */
        
        HashMap<String, String> pais = new HashMap<>();
        pais.put("Colombia", "Bogotá");
        pais.put("Rusia", "Moscú");
        pais.put("China", "Pekin");
        pais.put("Argentina", "Buenos Aires");
        pais.put("Japon", "Tokio");

        System.out.println(pais.get("Colombia"));

        if (pais.containsKey("Francia")) {
            System.out.println("Francia está en el mapa");
        }else{
            System.out.println("Francia no está en el mapa");
        }



        pais.put("China", "Rio de Janeiro");
        pais.put("China", "Pekin");

        for (String capital : pais.keySet()) {
            System.out.println("La capital de " + capital + " es " + pais.get(capital));
        }
    }
}

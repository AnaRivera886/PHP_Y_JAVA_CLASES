package JAVA_CLASES.HOME.POO;

import java.util.ArrayList;
public class ArrayLi {
    /*
     * Crea un programa que maneje una lista de compras:
    
     * Crea un ArrayList<String> llamado listaCompras
     * Agrega 5 productos
     * Imprime todos los productos con foreach
     * Elimina el producto en la posición 2
     * Imprime cuántos productos quedan con un mensaje: "Productos restantes: X"
     * Verifica si "leche" está en la lista e imprime "La leche está en la lista" o
     * "La leche no está en la lista" según corresponda
     */
    public static void main(String[] args) {
        ArrayList<String>listaCompras = new ArrayList<>();
        // AGG ELEMENTOS
        listaCompras.add("Arroz");
        listaCompras.add("Aceite");
        listaCompras.add("Leche");
        listaCompras.add("Carne");
        listaCompras.add("Papel");

        // RECORRER EL ARRAYLIST
        for (String lista : listaCompras) {
            System.out.println(lista);
        }

        //QUITAR PRODUCTOS
        listaCompras.remove(2);

        // MOSTRAR PRODUCTOS RESTANTES
        System.out.println("Productos restantes " + listaCompras.size());

        // VERIFICAR SI ESTA LA LECHE
        if (listaCompras.contains("Leche")) {
            System.out.println("la leche está en la lista");
        }else{
            System.out.println("La leche no está en la lista");
        }

    }

}

package Primero_DAM.Unidad12.ejercicio6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class ejercicio6 {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();

        //Apartado 1
        int contador = 100;
        while (contador > 0){
            collection.add(new Random().nextInt(1,11));
            contador--;
        }

        System.out.println("Sin eliminar: " + collection);

        //Apartado 2
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()){
            if (iterator.next() == 5){
                iterator.remove();
            }
        }
        //collection.removeIf(integer -> integer == 5);

        System.out.println("Eliminando el 5: " + collection);

        //Apartado 3
        Iterator<Integer> iterator1 = collection.iterator();
        while (iterator1.hasNext()){
            Integer integer = iterator1.next();
            if (integer % 2 == 0){
                iterator1.remove();
            }
        }
        //collection.removeIf(integer -> integer % 2 == 0);

        System.out.println("Eliminando pares: " + collection);

        //Apartado 4
        Collection<Integer> collection1 = new ArrayList<>();
        int contador1 = 30;
        while (contador1 > 0){
            collection1.add(new Random().nextInt(1,11));
            contador1--;
        }

        System.out.println("Sin añadir: " + collection1);
        collection1.addAll(collection);
        System.out.println("Ya añadido: " + collection1);


    }
}

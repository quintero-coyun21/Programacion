package Primero_DAM.Unidad12.ejercicio5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class ejercicio5 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collection<Integer> collection = arrayList;

        int contador = 20;
        while (contador > 0){
            collection.add(random.nextInt(0,11));
            contador--;
        }
        System.out.println(collection);

        ArrayList<Integer> listaSinRepetidos = new ArrayList<>();
        for (var numero : collection) {
            if (!listaSinRepetidos.contains(numero)){
                listaSinRepetidos.add(numero);
            }
        }
        System.out.println(listaSinRepetidos);
    }
}

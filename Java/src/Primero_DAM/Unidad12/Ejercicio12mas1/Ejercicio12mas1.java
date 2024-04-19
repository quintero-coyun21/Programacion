package Primero_DAM.Unidad12.Ejercicio12mas1;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Ejercicio12mas1 {
    public static void main(String[] args) {
        Random rand = new Random();
        LinkedHashSet<Integer> conjunto1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> conjunto2 = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            conjunto1.add(rand.nextInt(10));
            conjunto2.add(rand.nextInt(10));
        }
        System.out.println(conjunto1);
        System.out.println(conjunto2);
    }

    static <E> Set<E> union(Set<E> conjunto1, Set<E> conjunto2){
        LinkedHashSet<E> union = new LinkedHashSet<>(conjunto1);
        union.addAll(conjunto2);
        return union;
    }
    static <E> Set<E> interseccion(Set<E> conjunto1, Set<E> conjunto2){
        LinkedHashSet<E> intersec = new LinkedHashSet<>(conjunto1);
        intersec.retainAll(conjunto2);

//        Set<E> intersec2 = new LinkedHashSet<>();
//        for (E cont : conjunto1) {
//            intersec2.add(cont);
//        }
        return intersec;
    }
}

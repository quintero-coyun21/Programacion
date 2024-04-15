package Primero_DAM.Unidad12.Ejercicio10;

import java.util.*;

public class Ejercicio10 {
    public static void main(String[] args) {
        LinkedHashSet<Cliente> cliente = new LinkedHashSet<>();
        cliente.add(new Cliente("Alejandro", 19));
        cliente.add(new Cliente("Sergio", 25));
        cliente.add(new Cliente("Manuel", 23));
        cliente.add(new Cliente("Ángela", 21));
        cliente.add(new Cliente("José", 15));

        System.out.println("Sin ordenar " + cliente);

        TreeSet<Cliente> clienteTreeSet = new TreeSet<>(cliente);
        System.out.println("Ordenado por la edad: " + clienteTreeSet);

        TreeSet<Cliente> clienteTreeSet1 = new TreeSet<>(Cliente::compareTo){
            @Override
            public Comparator<? super Cliente> comparator() {
                return super.comparator();
            }
        };
        TreeSet<Cliente> clienteSet = new TreeSet<>( new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });

        System.out.println("Ordenado por el nombre: " + clienteSet);
    }
}

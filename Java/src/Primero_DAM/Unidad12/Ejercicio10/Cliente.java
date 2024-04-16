package Primero_DAM.Unidad12.Ejercicio10;

import java.util.Comparator;

public class Cliente implements Comparable<Cliente>{
    String nombre;
    int edad;

    public Cliente(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\n Cliente " + "nombre:" + nombre + '\'' + ", edad: " + edad;
    }

    @Override
    public int compareTo(Cliente o) {
        return getEdad() - o.edad;
    }

//    @Override
//    public int compare(Cliente o1, Cliente o2) {
//        return o1.getNombre().compareTo(o2.getNombre());
//    }
}

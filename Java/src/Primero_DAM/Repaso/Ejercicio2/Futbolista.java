package Primero_DAM.Repaso.Ejercicio2;

public class Futbolista implements Comparable{
    String dni, nombre;
    int edad, nGoles;

    public Futbolista(String dni, String nombre, int edad, int nGoles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.nGoles = nGoles;
    }


    @Override
    public int compareTo(Object o) {
        Futbolista futbolista = (Futbolista) o;
        return this.dni.compareTo(futbolista.dni);
    }

    @Override
    public String toString() {
        return dni + nombre + edad + nGoles;
    }

    @Override
    public boolean equals(Object obj) {
        Futbolista futbolista = (Futbolista) obj;
        return this.dni.equals(futbolista.dni);
    }
}

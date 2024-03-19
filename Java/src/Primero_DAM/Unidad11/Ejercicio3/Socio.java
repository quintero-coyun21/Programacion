package Primero_DAM.Unidad11.Ejercicio3;

import java.io.Serializable;

public class Socio implements Serializable {
    private String nombre, apellido;
    private int edad;

    public Socio(String nombre, String apellido, int edad) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Apellido: " + getApellido() + " Edad: " + getEdad();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

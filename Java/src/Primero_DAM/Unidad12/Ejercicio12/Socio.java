package Primero_DAM.Unidad12.Ejercicio12;

import java.util.Date;
import java.util.Objects;

public class Socio implements Comparable<Socio>{
    String dni, nombre;
    Date fechaAlta;

    public Socio(String s, Date date) {
    }

    public Socio(String dni, String nombre, Date fechaAlta) {
        setDni(dni);
        setNombre(nombre);
        setFechaAlta(fechaAlta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(nombre, socio.nombre) && Objects.equals(dni, socio.dni) && Objects.equals(fechaAlta, socio.fechaAlta);
    }

    @Override
    public String toString() {
        return "\n Cliente " + "dni: " + getDni() + "nombre: " + getNombre() + ", fecha alta: " + getFechaAlta();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, fechaAlta);
    }

    @Override
    public int compareTo(Socio o) {
        return getDni().compareTo(o.getDni());
    }
}

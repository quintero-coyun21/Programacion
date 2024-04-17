package Primero_DAM.Unidad12.Ejercicio12;

import java.io.Serial;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Objects;

public class Socio implements Serializable, Comparable<Socio>{
    @Serial
    private static final long serialVersionUID = 1L;
    String dni, nombre, fechaAlta;

    public Socio(String dni, String nombre, String fechaAlta) {
        setDni(dni);
        setNombre(nombre);
        setFechaAlta(fechaAlta);
    }

    public LocalDate getFechaAltaAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(fechaAlta, formatter);
    }

    public void setFechaAltaFromLocalDate(LocalDate fechaAlta) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       setFechaAlta(fechaAlta.format(formatter));
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

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
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
        return "\n Cliente " + "dni: " + getDni() + ", nombre: " + getNombre() + ", fecha alta: " + getFechaAlta();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni, fechaAlta);
    }

    @Override
    public int compareTo(Socio o) {
        int dniActual = Integer.parseInt(getDni());
        int dniSocio = Integer.parseInt(o.getDni());
        return Integer.compare(dniActual, dniSocio);
    }

    static Comparator<Socio> compararAntiguedad = new Comparator<Socio>() {
     @Override
        public int compare(Socio o1, Socio o2) {
         try {
            LocalDate fechaAlta1 = LocalDate.parse(o1.getFechaAlta(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            LocalDate fechaAlta2 = LocalDate.parse(o2.getFechaAlta(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            return fechaAlta1.compareTo(fechaAlta2);
         } catch (DateTimeParseException e) {
            System.err.println("Error al analizar la fecha de alta: " + e.getMessage());
            return 0; // Sin son iguales o no se pueda determinar
         }
        }
     };
}

package Primero_DAM.Unidad12.Ejercicio15;

import Primero_DAM.Unidad12.Ejercicio12.Socio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;

public class Registro implements Serializable {
    String temperatura;

    public Registro(String temperatura) {
        setTemperatura(temperatura);
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Registro: " + "temperatura: " + temperatura;
    }

    //    static Comparator<Socio> compararAntiguedad = new Comparator<Socio>() {
//        @Override
//        public int compare(Socio o1, Socio o2) {
//            try {
//                LocalDate fechaAlta1 = LocalDate.parse(o1.getFechaAlta(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//                LocalDate fechaAlta2 = LocalDate.parse(o2.getFechaAlta(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//                return fechaAlta1.compareTo(fechaAlta2);
//            } catch (DateTimeParseException e) {
//                System.err.println("Error al analizar la fecha de alta: " + e.getMessage());
//                return 0; // Sin son iguales o no se pueda determinar
//            }
//        }
//    };
//
//    @Override
//    public int compareTo(Registro o) {
//        return 0;
//    }
}

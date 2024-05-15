package Primero_DAM.Practica5.Ejercicio2;

import java.io.Serializable;

public class Aldeano implements Serializable {
    private String nombre;
    private String profesion;
    private int romanosDerrotados;

    public Aldeano(String nombre, String profesion, int romanosDerrotados) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.romanosDerrotados = romanosDerrotados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public int getRomanosDerrotados() {
        return romanosDerrotados;
    }
}


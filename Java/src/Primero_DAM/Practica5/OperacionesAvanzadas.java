package Primero_DAM.Practica5;

import java.util.List;

public interface OperacionesAvanzadas extends OperacionesBasicas {
    int calcularCantidadPrimos(List<Double> lista);
    int calcularSumaDigitos(List<Double> lista);
    double calcularMediana(List<Double> lista);
    double calcularModa(List<Double> lista);
}

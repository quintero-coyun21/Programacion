package Primero_DAM.Practica5;

import java.util.ArrayList;
import java.util.List;

public class ListaNumerica implements OperacionesAvanzadas{

    List<Double> lista = new ArrayList<Double>();

    public void generarLista(){}
    public void agregarElementosLista(Double numero){
        lista.add(numero);
    }
    public void borrarElementosLista(Double numero){
        lista.remove(numero);
    }
    public void ordenarListaAscendente(){}
    public void ordenarListaDescendente(){}
    public void mostrarListaElementos(){}

    /* ---- */

    @Override
    public void contarPrimos() {

    }

    @Override
    public void sumaDigitos() {

    }

    @Override
    public void mediana() {

    }

    @Override
    public void moda() {

    }

    /* ---- */

    @Override
    public double sumaElementos() {
        Double suma = 0.0;
        for (var numero : lista) {
            suma += numero;
        }
        return suma;
    }

    @Override
    public void promedioElementos() {
        int contador = 0;
        for (var ignored : lista) {
            contador++;
        }
        System.out.println(contador);
        double promedio = sumaElementos() / lista.size();
        System.out.println("El promedio de la lista es: " + promedio);
    }

    @Override
    public void maxElemento() {
    }

    @Override
    public void minElemento() {

    }
}

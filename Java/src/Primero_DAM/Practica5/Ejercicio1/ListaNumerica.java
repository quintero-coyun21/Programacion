package Primero_DAM.Practica5.Ejercicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ListaNumerica implements OperacionesAvanzadas {
    private List<Double> lista;

    public ListaNumerica(int numero) {
        lista = new ArrayList<>();
        generarListaAleatoria(numero);
    }

    private void generarListaAleatoria(int numero) {
        Random rand = new Random();
        for (int i = 0; i < numero; i++) {
            lista.add(rand.nextDouble(100));
        }
    }

    public void mostrarLista() {
        System.out.println(lista);
    }

    @Override
    public double calcularSuma(List<Double> lista) {
        double suma = 0;
        for (double num : lista) {
            suma += num;
        }
        return suma;
    }

    @Override
    public double calcularPromedio(List<Double> lista) {
        return calcularSuma(lista) / lista.size();
    }

    @Override
    public double encontrarMaximo(List<Double> lista) {
        return Collections.max(lista);
    }

    @Override
    public double encontrarMinimo(List<Double> lista) {
        return Collections.min(lista);
    }

    @Override
    public int calcularCantidadPrimos(List<Double> lista) {
        int count = 0;
        for (double num : lista) {
            if (esPrimo((int) num)) {
                count++;
            }
        }
        return count;
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int calcularSumaDigitos(List<Double> lista) {
        int sumaDigitos = 0;
        for (double num : lista) {
            int numeroEntero = (int) num;
            while (numeroEntero != 0) {
                sumaDigitos += numeroEntero % 10;
                numeroEntero /= 10;
            }
        }
        return sumaDigitos;
    }

    @Override
    public double calcularMediana(List<Double> lista) {
        lista.sort(null);
        int tamanio = lista.size();
        if (tamanio % 2 == 0) {
            return (lista.get(tamanio / 2 - 1) + lista.get(tamanio / 2)) / 2.0;
        } else {
            return lista.get(tamanio / 2);
        }
    }

    public double calcularModa(List<Double> datos) {
        Map<Double, Integer> conteo = new HashMap<>();

        for (double dato : datos) {
            conteo.put(dato, conteo.getOrDefault(dato, 0) + 1);
        }

        int moda = -1;
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : conteo.entrySet()) {
            int frecuencia = entry.getValue();
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = entry.getKey().intValue();
            }
        }
        return moda;
    }

    void guardarListaEnArchivo() {
        String horaFormateada = LocalTime.now().format(DateTimeFormatter.ofPattern("HHmm"));

        try (FileWriter fileWriter = new FileWriter("Java/src/Primero_DAM/Practica5/Ejercicio1/listas" + horaFormateada + ".txt");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (double elemento : lista) {
                printWriter.println(elemento);
            }
            System.out.println("Lista guardada en archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la lista en archivo: " + e.getMessage());
        }
    }

    public List<Double> getLista() {
        return lista;
    }

}
package Primero_DAM.Practica5.Ejercicio1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ListaNumerica implements OperacionesAvanzadas {
    private List<Double> lista;

    public ListaNumerica(int N) {
        lista = new ArrayList<>();
        generarListaAleatoria(N);
    }

    private void generarListaAleatoria(int N) {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            lista.add(rand.nextDouble() * 100);
        }

    }

    public void agregarElemento(double elemento) {
        lista.add(elemento);
    }

    public void borrarElemento(double elemento) {
        lista.remove(elemento);
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
        double suma = calcularSuma(lista);
        return suma / lista.size();
    }

    @Override
    public double encontrarMaximo(List<Double> lista) {
        double maximo = Double.MIN_VALUE;
        for (double num : lista) {
            if (num > maximo) {
                maximo = num;
            }
        }
        return maximo;
    }

//    @Override
//    public double encontrarMaximo(List<Double> lista) {
//        if (lista.isEmpty()) {
//            throw new IllegalArgumentException("La lista está vacía");
//        }
//
//        double maximo = lista.get(0);
//
//        for (int i = 1; i < lista.size(); i++) {
//            double num = lista.get(i);
//
//            if (num > maximo) {
//                maximo = num;
//            }
//        }
//
//        return maximo;
//    }

    @Override
    public double encontrarMinimo(List<Double> lista) {
        double minimo = Double.MAX_VALUE;
        for (double num : lista) {
            if (num < minimo) {
                minimo = num;
            }
        }
        return minimo;
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
        // Divide hasta la raíz cuadrada del número dado, con que salga 0 en alguna division de los valores entre 2 y la raíz, automáticamente devuelve false, ya que habría otro divisor además de 1 y el propio número
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

//    @Override
//    public double calcularModa(List<Double> lista) {
//        int maxCount = 0;
//        double moda = -1;
//        for (double num : lista) {
//            int count = 0;
//            for (double elemento : lista) {
//                if (elemento == num) {
//                    count++;
//                }
//            }
//            if (count > maxCount) {
//                maxCount = count;
//                moda = num;
//            }
//        }
//        return moda;
//    }

    @Override
    public double calcularModa(List<Double> lista) {
        Map<Integer, Integer> conteo = new HashMap<>();

        int maxCount = 0;
        double moda = -1;

        for (double num : lista) {
            int numEntero = (int) num;
            int count = conteo.getOrDefault(numEntero, 0) + 1;
            conteo.put(numEntero, count);

            if (count >= maxCount) {
                maxCount = count;
                moda = numEntero;
            }
        }

        if (maxCount > 1) {
            return moda;
        } else {
            return -1;
        }
    }

//    @Override
//    public double calcularModa(List<Double> lista) {
//        Map<Integer, Integer> conteo = new HashMap<>();
//
//        int maxCount = 0;
//        double moda = -1;
//
//        for (double num : lista) {
//            int numEntero = (int) num;
//
//            if (conteo.containsKey(numEntero)) {
//                int count = conteo.get(numEntero) + 1;
//                conteo.put(numEntero, count);
//
//                if (count > maxCount) {
//                    maxCount = count;
//                    moda = numEntero;
//                }
//            } else {
//                conteo.put(numEntero, 1);
//            }
//        }
//
//        if (maxCount > 1) {
//            return moda;
//        } else {
//            return -1;
//        }
//    }

    void guardarListaEnArchivo() {
        //LocalTime horaActual = LocalTime.now();
        //DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HHmm");
        //String horaFormateada = horaActual.format(formatoHora);
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

    public void setLista(List<Double> lista) {
        this.lista = lista;
    }
}
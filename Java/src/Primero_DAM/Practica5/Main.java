package Primero_DAM.Practica5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaNumerica listaNumerica = new ListaNumerica(10);

        Scanner scanner = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Mostrar lista");
            System.out.println("2. Realizar operaciones básicas");
            System.out.println("3. Realizar operaciones avanzadas");
            System.out.println("4. Guardar lista en archivo");
            System.out.println("5. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listaNumerica.mostrarLista();
                    break;
                case 2:
                    realizarOperacionesBasicas(listaNumerica);
                    break;
                case 3:
                    realizarOperacionesAvanzadas(listaNumerica);
                    break;
                case 4:
                    guardarListaEnArchivo(listaNumerica);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
        scanner.close();
    }

    private static void realizarOperacionesBasicas(ListaNumerica listaNumerica) {
        System.out.println("\n--- Operaciones Básicas ---");
        System.out.println("Suma: " + listaNumerica.calcularSuma(listaNumerica.getLista()));
        System.out.println("Promedio: " + listaNumerica.calcularPromedio(listaNumerica.getLista()));
        System.out.println("Máximo: " + listaNumerica.encontrarMaximo(listaNumerica.getLista()));
        System.out.println("Mínimo: " + listaNumerica.encontrarMinimo(listaNumerica.getLista()));
    }

    private static void realizarOperacionesAvanzadas(ListaNumerica listaNumerica) {
        System.out.println("\n--- Operaciones Avanzadas ---");
        System.out.println("Cantidad de primos: " + listaNumerica.calcularCantidadPrimos(listaNumerica.getLista()));
        System.out.println("Suma de dígitos: " + listaNumerica.calcularSumaDigitos(listaNumerica.getLista()));
        System.out.println("Mediana: " + listaNumerica.calcularMediana(listaNumerica.getLista()));
        System.out.println("Moda: " + listaNumerica.calcularModa(listaNumerica.getLista()));
    }

    private static void guardarListaEnArchivo(ListaNumerica listaNumerica) {
        listaNumerica.guardarListaEnArchivo();
    }

}





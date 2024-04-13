package Primero_DAM.Unidad12.ejercicio9;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        //Parte 1
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Integer numero;

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Introduce un número entero positivo (para salir introduce un entero negativo): ");
                numero = scanner.nextInt();
                if (numero >= 0) {
                    integerArrayList.add(numero);
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.next();
            }
        }

        //Parte 2
        int contador = 0;
        for (var entero : integerArrayList) {
            if (entero % 2 == 0){
                System.out.println("El índice de " + entero + " es " + contador + " x100 es: " + entero*100);
            }
            contador++;
        }
    }

}

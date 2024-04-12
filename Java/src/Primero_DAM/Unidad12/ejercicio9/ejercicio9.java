package Primero_DAM.Unidad12.ejercicio9;

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int numero = 0;
        while (numero > 0){
            System.out.println("Introduce un número entero positivo: ");
            numero = scanner.nextInt();
            for (var indice : integerArrayList) {
                integerArrayList.add(numero);
            }
        }
    }
}

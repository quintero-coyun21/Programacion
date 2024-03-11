package Primero_DAM.Repaso.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base, altura;
        System.out.println("Base");
        base = scanner.nextDouble();
        System.out.println("Altura");
        altura = scanner.nextDouble();

        Poligono p = new Triangulo(base, altura);
        System.out.println(p.area());

        p = new Rectangulo(base, altura);
        System.out.println(p.area());
    }
}

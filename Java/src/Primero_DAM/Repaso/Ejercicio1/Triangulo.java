package Primero_DAM.Repaso.Ejercicio1;

public class Triangulo extends Poligono{
    Triangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    double area() {
        return (getBase()*getAltura())/2;
    }
}
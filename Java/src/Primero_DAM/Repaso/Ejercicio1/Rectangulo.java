package Primero_DAM.Repaso.Ejercicio1;

public class Rectangulo extends Poligono{
    Rectangulo(double base, double altura) {
        super(base, altura);
    }

    @Override
    double area() {
        return getBase()*getAltura();
    }
}
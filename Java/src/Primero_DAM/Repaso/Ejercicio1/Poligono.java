package Primero_DAM.Repaso.Ejercicio1;

public abstract class Poligono {
    private double base, altura;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Poligono(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    abstract double area();
}

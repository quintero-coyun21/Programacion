package Primero_DAM.Unidad12.Ejercicio16;

import java.io.Serializable;

public class Producto implements Serializable{
    private String codigo;
    private String nombre;
    private String descripcion;
    private int stock;

    public Producto(String codigo, String nombre, String descripcion, int stock) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
        setStock(stock);
    }

    public void actualizarStock(int cantidad) {
        setStock(getStock() + cantidad);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Código: " + getCodigo() +
                ", Nombre: " + getNombre() +
                ", Descripción: " + getDescripcion() +
                ", Stock: " + getStock();
    }
}

package Primero_DAM.Unidad12.Ejercicio16;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tienda implements Serializable {
    private Map<String, Producto> inventario;

    public Tienda() {
        setInventario(new HashMap<>());
        cargarDatos();
    }

    public Map<String, Producto> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, Producto> inventario) {
        this.inventario = inventario;
    }

    public void darDeAlta(Producto producto) {
        inventario.put(producto.getCodigo(), producto);
        System.out.println("Producto: " + producto.getNombre() + " dado de alta");
    }


    public void darDeBaja(String codigo) {
        inventario.remove(codigo);
        System.out.println("Producto: " + inventario.get(codigo).getNombre() + " dado de baja");
    }

    public void actualizarStock(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null) {
            producto.actualizarStock(cantidad);
            System.out.println("Producto: " + producto.getNombre() + " actualizado");
        }else {
            System.out.println("No existe el producto");
        }
    }

    public void guardarDatos() {
        try (FileOutputStream fileOut = new FileOutputStream("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio16\\\\datos.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(inventario);
            System.out.println("Datos guardados en el archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }

    public void guardarDatosTexto() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio16\\\\datos.txt"))) {
            for (Producto producto : inventario.values()) {
                writer.println(producto.getCodigo() + ";" +
                        producto.getNombre() + ";" +
                        producto.getDescripcion() + ";" +
                        producto.getStock());
            }
            System.out.println("Datos guardados en el archivo");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    //@SuppressWarnings("unchecked")

    //Intento para leer txt y pasar a objeto tras leer
//    private void cargarDatos() {
//        try (FileInputStream fileIn = new FileInputStream("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio16\\\\datos.dat");
//             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
//            inventario = (Map<String, Producto>) objectIn.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void cargarDatos() {
        File archivo = new File("Java/src/Primero_DAM/Unidad12/Ejercicio16/datos.dat");

        if (!archivo.exists()) {
            System.out.println("El archivo datos.dat no existe. Se creará uno nuevo.");
            inventario = new HashMap<>(); // Inicializar el inventario vacío
            return; // Salir del método sin intentar cargar datos
        }

        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio16\\\\datos.dat"))) {
            inventario = (Map<String, Producto>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void cargarDatosTexto() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio16\\\\datos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                Producto producto = new Producto(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]));
                inventario.put(producto.getCodigo(), producto);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public void mostrarProductos() {
        System.out.println("--- Productos en stock ---");
        for (Producto producto : inventario.values()) {
            System.out.println(
                    "Código: " + producto.getCodigo() +
                            ", Nombre: " + producto.getNombre() +
                            ", Descripción: " + producto.getDescripcion() +
                            ", Stock: " + producto.getStock());
        }
    }
}
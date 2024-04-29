package Primero_DAM.Unidad12.Ejercicio16;

import java.io.IOException;
import java.util.Scanner;

import static Primero_DAM.Unidad12.Ejercicio15.Registro.*;

public class Ejercicio16 {
    static Tienda tienda = new Tienda();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            Scanner scanner = new Scanner(System.in);
            String opcion;
            while (true) {
                System.out.println("""
                    ╔══════════════════════════════════════════════╗
                    ║               Menú Principal                 ║
                    ╠══════════════════════════════════════════════╣
                    ║ A. Dar de alta                               ║
                    ║ B. Dar de baja                               ║
                    ║ C. Actualizar el número de unidades en stock ║
                    ║ D. Guardar los datos y salir                 ║
                    ╚══════════════════════════════════════════════╝
                    """);
                System.out.print("Seleccione una opción: ");
                opcion = scanner.next();
                scanner.nextLine();

                switch (opcion.toLowerCase()) {
                    case "a":
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Código: ");
                        String codigo = sc.nextLine();
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Descripcion: ");
                        String descripcion = sc.nextLine();
                        System.out.println("Stock: ");
                        int stock = sc.nextInt();
                        tienda.darDeAlta(new Producto(codigo,nombre,descripcion,stock));
                        break;
                    case "b":
                        System.out.println("Introduce el código de producto: ");
                        String codigoProducto = scanner.nextLine();
                        tienda.darDeBaja(codigoProducto);
                        break;
                    case "c":
                        System.out.println("Introduce el código de producto: ");
                        String codigoProducto2 = scanner.nextLine();
                        System.out.println("Cantidad, si va a disminuir el stock inserte el valor en negativo: ");
                        int cantidad = scanner.nextInt();
                        tienda.actualizarStock(codigoProducto2,cantidad);
                        break;
                    case "d":
                        tienda.guardarDatos();
                        System.out.println("Saliendo del programa...");
                        return;
                    case "e":
                        tienda.mostrarProductos();
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
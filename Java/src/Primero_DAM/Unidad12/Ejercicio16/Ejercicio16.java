package Primero_DAM.Unidad12.Ejercicio16;

import java.io.IOException;
import java.util.Scanner;

import static Primero_DAM.Unidad12.Ejercicio15.Registro.*;

public class Ejercicio16 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        cargarRegistros();
        Scanner scanner = new Scanner(System.in);
        String opcion;
        while (true) {
            System.out.println("""
                    ╔══════════════════════════════════════════════╗
                    ║               Menú Principal                 ║
                    ╠══════════════════════════════════════════════╣
                    ║ A. Nuevo registro                            ║
                    ║ B. Listar registros                          ║
                    ║ C. Mostrar estadísticas                      ║
                    ║ D. Salir                                     ║
                    ╚══════════════════════════════════════════════╝
                    """);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.next();
            scanner.nextLine();

            switch (opcion) {
                case "a", "A":
//                    nuevoRegistro();
                    break;
                case "b", "B":
//                    listarRegistros();
                    break;
                case "c", "C":
//                    mostrarRegistros();
                    break;
                case "d", "D":
//                    guardarRegistro();
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}

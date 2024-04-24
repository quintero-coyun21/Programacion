package Primero_DAM.Unidad12.Ejercicio15;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import static Primero_DAM.Unidad12.Ejercicio15.Registro.*;

public class Ejercicio15 {
//    static LocalDate localDate = LocalDate.now();
//    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
//    static String extension = ".dat";
//    static String fecha = localDate.format(formatter);
//    static String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio15\\registros"+fecha+extension;
    //static final String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio15\\registros";
    static Registro registros = new Registro();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        cargarRegistros();
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
                    nuevoRegistro();
                    break;
                case "b", "B":
                    listarRegistros();
                    break;
                case "c", "C":
//                    modificarSocio();
                    break;
                case "d", "D":
                    guardarRegistro();
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

//    static void nuevoRegistro() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese la temperatura:");
//        String temperatura = scanner.nextLine();
//        Registro registro = new Registro(temperatura);
//    }

//    static void listarRegistros() {
//        System.out.println("Listado:");
//        System.out.println(registros);
//    }

//    static void guardarRegistro(){
//
//        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ruta))){
//            outputStream.writeObject(registros);
//        }catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    static void cargarRegistros() throws IOException, ClassNotFoundException {
//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ruta))) {
//            registros = (Registro) inputStream.readObject();
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}

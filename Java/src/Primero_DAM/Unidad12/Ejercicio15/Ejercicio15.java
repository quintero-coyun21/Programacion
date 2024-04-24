package Primero_DAM.Unidad12.Ejercicio15;

import Primero_DAM.Unidad12.Ejercicio12.Socio;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio15 {
    static final String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio15\\registros";
    static HashSet<Registro> registros = new HashSet<>();

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
//        do {
//
//        } while (!opcion.equals("d")||!opcion.equals("D"));
    }

    static void nuevoRegistro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la temperatura:");
        String temperatura = scanner.nextLine();
        registros.add(new Registro(temperatura));
    }

    static void listarRegistros() {
        System.out.println("Listado:");
        System.out.println(registros);
    }

    static void guardarRegistro(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String extension = ".dat";
        final String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio15\\registros"+formatter+extension;
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ruta))){
            outputStream.writeObject(registros);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void cargarRegistros() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ruta))) {
            //TreeSet<Socio> sociosLeidos = (TreeSet<Socio>) inputStream.readObject();
            //socios.addAll(sociosLeidos);
            registros = (HashSet<Registro>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            registros.clear();
        }
    }
}

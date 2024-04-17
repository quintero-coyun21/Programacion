package Primero_DAM.Unidad12.Ejercicio12;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio12 {
    static final String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio12\\socios.dat";
    static TreeSet<Socio> socios = new TreeSet<>();
    static TreeSet<Socio> sociosAntiguedad = new TreeSet<>(Socio.compararAntiguedad);


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        cargarSocios();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("""
                    ╔══════════════════════════════════════════════╗
                    ║               Menú Principal                 ║
                    ╠══════════════════════════════════════════════╣
                    ║ 1. Alta de Socio                             ║
                    ║ 2. Baja de Socio                             ║
                    ║ 3. Modificación de Socio                     ║
                    ║ 4. Listado de Socios por DNI                 ║
                    ║ 5. Listado de Socios por Antigüedad          ║
                    ║ 6. Salir                                     ║
                    ╚══════════════════════════════════════════════╝
                    """);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarSocio();
                    break;
                case 2:
                    bajaSocio();
                    break;
                case 3:
                    modificarSocio();
                    break;
                case 4:
                    listadoPorDNI();
                    break;
                case 5:
                    listadoAntiguedad();
                    break;
                case 6:
                    guardarSocios();
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 6);
    }

    static void guardarSocios(){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ruta))){
            outputStream.writeObject(socios);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    static void cargarSocios(){
//        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ruta))) {
//            TreeSet<Socio> sociosLeidos = (TreeSet<Socio>) inputStream.readObject();
//            for (Socio socio : sociosLeidos) {
//                System.out.println(socio);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    static void cargarSocios() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ruta))) {
            //TreeSet<Socio> sociosLeidos = (TreeSet<Socio>) inputStream.readObject();
            //socios.addAll(sociosLeidos);
            socios = (TreeSet<Socio>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            socios.clear();
        }
    }

//    static void cargarSocios() throws IOException, ClassNotFoundException {
//        File archivo = new File(ruta);
//        if (archivo.exists()) {
//            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ruta))) {
//                socios = (TreeSet<Socio>) inputStream.readObject();
//            }
//        } else {
//            socios = new TreeSet<>();
//        }
//    }

    static void agregarSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del nuevo socio:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el nombre del nuevo socio:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la fecha actual (yyyy/MM/dd):");
        String fecha = scanner.nextLine();
        socios.add(new Socio(dni, nombre, fecha));
    }

//    static Socio solicitarDatosSocio() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el DNI del nuevo socio:");
//        String dni = scanner.nextLine();
//        System.out.println("Ingrese el nombre del nuevo socio:");
//        String nombre = scanner.nextLine();
//
//        //Para pedir la fecha
//        System.out.println("Ingrese la fecha actual:");
//        String fecha = scanner.nextLine();
//
//        return new Socio(dni, nombre, fecha);
//
//        //Para establecer una fecha por defecto
//        //return new Socio(dni, nombre, "2023/05/15");
//
//        //Para tener en cuenta la fecha real
//        //LocalDate fechaActual = LocalDate.now();
//        //return new Socio(dni, nombre, fechaActual.toString());
//    }

    static void listadoAntiguedad(){
        sociosAntiguedad.addAll(socios);
        System.out.println("Listado por antiguedad:");
        System.out.println(sociosAntiguedad);
    }

    static void listadoPorDNI() {
        System.out.println("Listado por DNI");
        System.out.println(socios);
    }

    static void bajaSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del socio a dar de baja:");
        String dni = scanner.nextLine();
        Socio socioBuscado = new Socio(dni, "", "");

        if (socios.contains(socioBuscado)) {
            socios.remove(socioBuscado);
            System.out.println("El socio con DNI " + dni + " ha sido dado de baja correctamente.");
        } else {
            System.out.println("No se encontró ningún socio con el DNI " + dni + ".");
        }
    }

    static void modificarSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del socio a modificar:");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Socio socio : socios) {
            if (socio.getNombre().equals(nombre)) {
                encontrado = true;
                System.out.println("Ingrese el nuevo DNI del socio:");
                String nuevoDni = scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre del socio:");
                String nuevoNombre = scanner.nextLine();

                socio.setDni(nuevoDni);
                socio.setNombre(nuevoNombre);

                System.out.println("Los datos del socio con nombre " + nombre + " han sido modificados correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún socio con el nombre " + nombre + ".");
        }
    }


//    static void bajaSocio() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el Nombre del socio a dar de baja:");
//        String dni = scanner.nextLine();
//        Socio socioBuscado = new Socio("", dni, "");
//        boolean encontrado = false;
//        for (Socio socio : socios) {
//            if (socio.equals(socioBuscado)) {
//                socios.remove(socio);
//                encontrado = true;
//                break;
//            }
//        }
//        if (encontrado) {
//            System.out.println("El socio con nombre " + dni + " ha sido dado de baja correctamente.");
//        } else {
//            System.out.println("No se encontró ningún socio con el nombre " + dni + ".");
//        }
//    }

//    static void bajaSocio() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el Nombre del socio a dar de baja:");
//        String nombre = scanner.nextLine();
//        boolean encontrado = false;
//        for (Socio socio : socios) {
//            if (socio.getNombre().equals(nombre)) {
//                socios.remove(socio);
//                encontrado = true;
//                System.out.println("El socio con nombre " + nombre + " ha sido dado de baja correctamente.");
//                break;
//            }
//        }
//
//        if (!encontrado) {
//            System.out.println("No se encontró ningún socio con el nombre " + nombre + ".");
//        }
//    }

//    static void bajaSocio() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese el Nombre del socio a dar de baja:");
//        String nombre = scanner.nextLine();
//        boolean encontrado = false;
//
//        Iterator<Socio> iterador = socios.iterator();
//        while (iterador.hasNext()) {
//            Socio socio = iterador.next();
//            if (socio.getNombre().equals(nombre)) {
//                iterador.remove();
//                encontrado = true;
//                System.out.println("El socio con nombre " + nombre + " ha sido dado de baja correctamente.");
//            }
//        }
//
//        if (!encontrado) {
//            System.out.println("No se encontró ningún socio con el nombre " + nombre + ".");
//        }
//    }

//    static void bajaSocio() {
//        System.out.println("Ingrese el DNI del socio a dar de baja:");
//        String dniBaja = scanner.nextLine();
//
//        boolean encontrado = false;
//
//        Iterator<Socio> iter = socios.iterator();
//        while (iter.hasNext()) {
//            Socio socio = iter.next();
//            if (socio.getDni().equals(dniBaja)) {
//                iter.remove();
//                encontrado = true;
//                break;
//            }
//        }
//
//        if (encontrado) {
//            System.out.println("Socio dado de baja correctamente.");
//        } else {
//            System.out.println("No se encontró ningún socio con el DNI proporcionado.");
//        }
//    }
}

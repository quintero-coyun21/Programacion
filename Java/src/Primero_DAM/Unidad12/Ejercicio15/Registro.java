package Primero_DAM.Unidad12.Ejercicio15;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Registro implements Serializable {

    static LocalDate localDate = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    static String extension = ".dat";
    static String fecha = localDate.format(formatter);
    static String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio15\\registros"+fecha+extension;

    String temperatura;

    public Registro(String temperatura) {
        setTemperatura(temperatura);
    }
    public Registro() {}

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Registro: " + "temperatura: " + temperatura;
    }

    static HashSet<Registro> registros = new HashSet<>();

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

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ruta))){
            outputStream.writeObject(registros);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void cargarRegistros() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ruta))) {
            //registros = (Registro) inputStream.readObject();
            registros = (HashSet<Registro>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //    static Comparator<Socio> compararAntiguedad = new Comparator<Socio>() {
//        @Override
//        public int compare(Socio o1, Socio o2) {
//            try {
//                LocalDate fechaAlta1 = LocalDate.parse(o1.getFechaAlta(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//                LocalDate fechaAlta2 = LocalDate.parse(o2.getFechaAlta(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//                return fechaAlta1.compareTo(fechaAlta2);
//            } catch (DateTimeParseException e) {
//                System.err.println("Error al analizar la fecha de alta: " + e.getMessage());
//                return 0; // Sin son iguales o no se pueda determinar
//            }
//        }
//    };
//
//    @Override
//    public int compareTo(Registro o) {
//        return 0;
//    }
}

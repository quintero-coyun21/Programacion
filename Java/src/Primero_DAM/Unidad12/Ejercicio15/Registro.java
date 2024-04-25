package Primero_DAM.Unidad12.Ejercicio15;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Registro implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;
    static LocalDate localDate = LocalDate.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    static String extension = ".dat";
    static String fecha = localDate.format(formatter);
    static String ruta = "Java\\src\\Primero_DAM\\Unidad12\\Ejercicio15\\registros"+fecha+extension;

    String temperatura;

    public Registro(String temperatura) {
        setFecha(obtenerFecha());
        setTemperatura(temperatura);
        setFecha(fecha);
    }
    public Registro() {}

    static String obtenerFecha(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter1);
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        Registro.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Temperatura: " + temperatura + " ºC" + "\nFecha: " + obtenerFecha() + "\n";
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

    static void max(){
        System.out.println("Valor máximo: ");
        System.out.println(Collections.max(registros, new Comparator<Registro>() {

            @Override
            public int compare(Registro o1, Registro o2) {
                return o1.getTemperatura().compareTo(o2.getTemperatura());
            }
        }));
    }

    static void min(){
        System.out.println("Valor mínimo: ");
        System.out.println(Collections.min(registros, new Comparator<Registro>() {

            @Override
            public int compare(Registro o1, Registro o2) {
                return o1.getTemperatura().compareTo(o2.getTemperatura());
            }
        }));
    }

//    static void media(){
//        System.out.println(Collections.);
//    }

    static void mostrarRegistros(){
        System.out.println("Registros:");
        max();
        min();
    }
}

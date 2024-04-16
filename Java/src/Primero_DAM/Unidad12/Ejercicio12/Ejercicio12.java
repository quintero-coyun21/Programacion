package Primero_DAM.Unidad12.Ejercicio12;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio12 {
    public static void main(String[] args) throws IOException {
        TreeSet<Socio> socios = new TreeSet<>();
        socios.add(new Socio( "1", "Socio 1", new Date(2024, 10, 10)));
        socios.add(new Socio("4", "Socio 4", new Date(2024, 7, 1)));
        socios.add(new Socio("2", "Socio 2", new Date(2024, 10, 19)));
        //System.out.println(socios);

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio12\\\\socios.dat"))){
            outputStream.writeObject(socios);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

//        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Java\\\\src\\\\Primero_DAM\\\\Unidad12\\\\Ejercicio12\\\\socios.dat"))) {
//            Socio nuevoSocio = (Socio) inputStream.readObject();
//            System.out.println(nuevoSocio);
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}

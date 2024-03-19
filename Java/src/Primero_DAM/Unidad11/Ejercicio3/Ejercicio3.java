package Primero_DAM.Unidad11.Ejercicio3;

import java.io.*;
import java.util.Arrays;

public class Ejercicio3{
    public static void main(String[] args){
        Socio[] socios = {
                new Socio("José","Ortega",29),
                new Socio("Manuel","Ramos",25),
                new Socio("Alejandro","Gómez",18),
                new Socio("Sergio","Castillo",25)
        };

        System.out.println("Muestro los socios antes de almacenarlos");
        System.out.println(Arrays.deepToString(socios));
        System.out.println();

        //Escribimos
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Java\\src\\Primero_DAM\\Unidad11\\Ficheros\\socios.dat"))){
            out.writeObject(socios);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Socio[] nuevoSocio;
        System.out.println("Voy a recuperar los datos");
        System.out.println();


        //Leemos
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Java\\src\\Primero_DAM\\Unidad11\\Ficheros\\socios.dat"))){
            nuevoSocio = (Socio[]) in.readObject();
            System.out.println("Recuperando...");
            System.out.println();
            System.out.println("Ya recuperé los datos, voy a mostrarlos");
            System.out.println();
            for (Socio socio : nuevoSocio) {
                System.out.println(socio);
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        System.out.println("Ya recuperé los datos, voy a mostrarlos");
//        System.out.println(Arrays.deepToString(nuevoSocio));
    }
}

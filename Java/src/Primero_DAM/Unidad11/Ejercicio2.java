package Primero_DAM.Unidad11;

import java.io.*;

public class Ejercicio2 implements Serializable {
    public static void main(String[] args) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Java\\src\\Primero_DAM\\Unidad11\\Ficheros\\himnoDeAndalucia.dat"))) {
            String cadena = "La bandera blanca y verde\n" +
                    "vuelve, tras siglos de guerra,\n" +
                    "a decir paz y esperanza\n" +
                    "bajo el sol de nuestra tierra.\n";
            
            outputStream.writeObject(cadena);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Java\\src\\Primero_DAM\\Unidad11\\Ficheros\\himnoDeAndalucia.dat"))){
            String cadena = (String) inputStream.readObject();
            System.out.println(cadena);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

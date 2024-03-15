package Primero_DAM.Unidad11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\Ficheros\\datos.dat"));
            int[] enteros = new int[]{1,2,3,4,5,6,7,8,9,10};
            out.writeObject(enteros);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

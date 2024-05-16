package Primero_DAM.Practica5.Ejercicio2;

import java.io.*;
import java.util.*;

public class Aldea {
    Map<Integer, Aldeano> habitantes;

    public Aldea() {
        this.habitantes = new HashMap<>();
        cargarDatosDesdeArchivoBinario();

    }

    public void agregarHabitante(int id, Aldeano aldeano) {
        habitantes.put(id, aldeano);
    }

    public void eliminarHabitante(String nombre) {
        for (Iterator<Map.Entry<Integer, Aldeano>> iterator = habitantes.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<Integer, Aldeano> entry = iterator.next();
            if (entry.getValue().getNombre().equals(nombre)) {
                iterator.remove();
            }
        }
    }

    public void ordenarLista(int metodoDeOrdenacion) {
        List<Map.Entry<Integer, Aldeano>> lista = new ArrayList<>(habitantes.entrySet());

        switch (metodoDeOrdenacion) {
            case 0:
                // No es necesario hacer nada, ya que el mapa se almacena internamente por clave
                System.out.println("Lista de Habitantes ordenada por clave");
                break;
            case 1:
                lista.sort(new Comparator<Map.Entry<Integer, Aldeano>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Aldeano> entry1, Map.Entry<Integer, Aldeano> entry2) {
                        return entry1.getValue().getNombre().compareTo(entry2.getValue().getNombre());
                    }
                });
                System.out.println("Lista de Habitantes ordenada por nombre");
                break;
            case 2:
                lista.sort(new Comparator<Map.Entry<Integer, Aldeano>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Aldeano> entry1, Map.Entry<Integer, Aldeano> entry2) {
                        return entry1.getValue().getProfesion().compareTo(entry2.getValue().getProfesion());
                    }
                });
                System.out.println("Lista de Habitantes ordenada por profesión");
                break;
            case 3:
                lista.sort(new Comparator<Map.Entry<Integer, Aldeano>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Aldeano> entry1, Map.Entry<Integer, Aldeano> entry2) {
                        return Integer.compare(entry1.getValue().getRomanosDerrotados(), entry2.getValue().getRomanosDerrotados());
                    }
                });
                System.out.println("Lista de Habitantes ordenada por romanos derrotados");
                break;
            default:
                System.out.println("Método de ordenación no válido.");
                return;
        }

        Map<Integer, Aldeano> nuevoMapa = new LinkedHashMap<>();
        for (Map.Entry<Integer, Aldeano> entry : lista) {
            nuevoMapa.put(entry.getKey(), entry.getValue());
        }

        habitantes = nuevoMapa;
    }

    public void buscarHabitantePorNombre(String nombre) {
        for (Map.Entry<Integer, Aldeano> entry : habitantes.entrySet()) {
            if (entry.getValue().getNombre().equals(nombre)) {
                System.out.println("Profesión de " + nombre + ": " + entry.getValue().getProfesion());
                return;
            }
        }
        System.out.println("No se encontró ningún habitante con ese nombre.");
    }

    public void buscarHabitantePorProfesion(String profesion) {
        boolean encontrado = false;
        for (Map.Entry<Integer, Aldeano> entry : habitantes.entrySet()) {
            if (entry.getValue().getProfesion().equals(profesion)) {
                System.out.println("Nombre del habitante con profesión " + profesion + ": " + entry.getValue().getNombre());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún habitante con esa profesión.");
        }
    }

    public void mostrarListadoDeHabitantes() {
        for (Map.Entry<Integer, Aldeano> entry : habitantes.entrySet()) {
            Aldeano aldeano = entry.getValue();
            System.out.println("Nombre: " + aldeano.getNombre() + ", Profesión: " + aldeano.getProfesion() + ", Romanos Derrotados: " + aldeano.getRomanosDerrotados());
        }
    }

    public void expulsarAGenteAleatoriamenteDeLaAldea(int cantidad) {
        if (cantidad >= habitantes.size()) {
            System.out.println("No se puede expulsar a más habitantes de los que hay en la aldea.");
            return;
        }

        Random rand = new Random();
        List<Integer> keys = new ArrayList<>(habitantes.keySet());

        for (int i = 0; i < cantidad; i++) {
            int randomIndex = rand.nextInt(keys.size());
            int keyToRemove = keys.get(randomIndex);
            habitantes.remove(keyToRemove);
            keys.remove(randomIndex);
        }
    }

    public void guardarDatosEnArchivoBinario() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Java/src/Primero_DAM/Practica5/Ejercicio2/aldea.dat"))) {
            salida.writeObject(habitantes);
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDatosDesdeArchivoBinario() {
        File file = new File("Java/src/Primero_DAM/Practica5/Ejercicio2/aldea.dat");
        if (!file.exists() || file.length()==0) {
            System.out.println("Archivo de datos no encontrado. Creando nuevo archivo...");
            habitantes = new HashMap<>();
            return;
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))) {
            habitantes = (Map<Integer, Aldeano>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}


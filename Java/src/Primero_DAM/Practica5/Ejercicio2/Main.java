package Primero_DAM.Practica5.Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aldea aldea = new Aldea();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.println("""
                        
                        ╔═════════════════════════ Menú Aldea ═════════════════════════╗
                        ║""" + ConsoleColors.green(" 1. Agregar habitante") + """ 
                                                                 ║
                        ║""" + ConsoleColors.red(" 2. Eliminar habitante")  + """ 
                                                                ║
                        ║""" + ConsoleColors.red(" 2. Eliminar habitante")  + """
                                                                ║
                        ║ 3. Ordenar lista de habitantes                               ║
                        ║ 4. Buscar habitante por nombre                               ║
                        ║ 5. Buscar habitante por profesión                            ║
                        ║ 6. Mostrar lista de habitantes                               ║
                        ║ 7. Expulsar habitante aleatoriamente                         ║
                        ║ 0. Salir                                                     ║
                        ╠══════════════════════════════════════════════════════════════╣
                        ║ Seleccione una opción del programa                           ║
                        ╚══════════════════════════════════════════════════════════════╝
                        """);
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del habitante: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese la profesión del habitante: ");
                        String profesion = scanner.next();
                        System.out.print("Ingrese la cantidad de romanos derrotados: ");
                        int romanos = scanner.nextInt();
                        aldea.agregarHabitante(aldea.habitantes.size() + 1, new Aldeano(nombre, profesion, romanos));
                        break;
                    case 2:
                        System.out.print("Ingrese el nombre del habitante a eliminar: ");
                        String nombreEliminar = scanner.next();
                        aldea.eliminarHabitante(nombreEliminar);
                        break;
                    case 3:
                        System.out.print("Ingrese el método de ordenación (0-3): ");
                        int metodoOrdenacion = scanner.nextInt();
                        aldea.ordenarLista(metodoOrdenacion);
                        break;
                    case 4:
                        System.out.print("Ingrese el nombre del habitante a buscar: ");
                        String nombreBuscar = scanner.next();
                        aldea.buscarHabitantePorNombre(nombreBuscar);
                        break;
                    case 5:
                        System.out.print("Ingrese la profesión a buscar: ");
                        String profesionBuscar = scanner.next();
                        aldea.buscarHabitantePorProfesion(profesionBuscar);
                        break;
                    case 6:
                        aldea.mostrarListadoDeHabitantes();
                        break;
                    case 7:
                        System.out.print("Ingrese la cantidad de habitantes a expulsar: ");
                        int cantidadExpulsar = scanner.nextInt();
                        aldea.expulsarAGenteAleatoriamenteDeLaAldea(cantidadExpulsar);
                        break;
                    case 8:
                        aldea.guardarDatosEnArchivoBinario();
                        break;
                    case 9:
                        aldea.cargarDatosDesdeArchivoBinario();
                        break;
                    case 0:
                        aldea.guardarDatosEnArchivoBinario();
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero.");
                scanner.next();
                opcion = -1;
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
                opcion = -1;
            }
        } while (opcion != 0);
        scanner.close();
    }
}

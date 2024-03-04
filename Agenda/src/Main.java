import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (salir) {
            System.out.println("""
                    1. Nuevo contacto.
                    2. Buscar por nombre.
                    3. Mostrar todos.
                    4. Salir y guardar.
                    """);
            String opcion = scanner.nextLine().trim().toLowerCase();
//            switch (opcion){
//                case "1", "nuevo contacto" -> Contactos.nuevoContacto();
//                case "2", "buscar", "buscar por nombre" -> Contactos.buscarPorNombre();
//                case "3", "mostrar", "mostrar todos" -> Contactos.mostrarTodos();
//                case "4", "salir", "salir y guardar" -> Contactos.salirGuardar();
//            }
        }
    }
}

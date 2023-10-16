import Clases.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Mensajeria mensajeria;
    private Usuario remitente;

    private List<String> contraseñas;

    public Menu(Mensajeria mensajeria, Usuario remitente) {
        scanner = new Scanner(System.in);
        contraseñas = new ArrayList<>();
        this.mensajeria = mensajeria;
        this.remitente = remitente;
    }

    // Menú de opciones para Empleado
    public void menuEmpleado() {
        System.out.println("Menú de opciones para empleado:");
        System.out.println("1. Bandeja de entrada");
        System.out.println("2. Leídos");
        System.out.println("3. Borradores");
        System.out.println("4. Redactar nuevo mensaje");
        System.out.println("0. Salir");
    }

    // Menú de opciones para Administrador
    public void menuAdmin() {
        System.out.println("Menú de opciones para administrador:");
        System.out.println("1. Bandeja de entrada");
        System.out.println("2. Leídos");
        System.out.println("3. Borradores");
        System.out.println("4. Redactar nuevo mensaje");
        System.out.println("5. Agregar usuario");
        System.out.println("6. Eliminar usuario");
        System.out.println("7. Editar usuario");
        System.out.println("0. Salir");
    }

    // Método para obtener la opción del usuario
    public int obtenerOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    // Método para limpiar el búfer de entrada
    public void limpiarBuffer() {
        scanner.nextLine();
    }

    // Método para cerrar el escáner
    public void cerrarEscanner() {
        scanner.close();
    }

    public void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                // Lógica para la opción 1
                break;
            case 2:
                // Lógica para la opción 2
                break;
            case 3:
                break;
            case 4:
                //mensajeria.enviarMensaje(remitente);
                break;
            case 5:
                manejoUsuario.agregarUsuario(contraseñas);
                break;
            case 6:
                manejoUsuario.eliminarUsuario(contraseñas);
                break;
            case 7:
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                mensajeria.escribirArchivos();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}

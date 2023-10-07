import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    // Menú de opciones para Empleado
    public void menuEmpleado() {
        System.out.println("Menú de opciones para usuario:");
        System.out.println("1. Bandeja de entrada");
        System.out.println("2. Leídos");
        System.out.println("3. Borradores");
        System.out.println("4. Enviar mensaje");
        System.out.println("0. Salir");
    }

    // Menú de opciones para Administrador 
    public void menuAdmin() {
        System.out.println("Menú de opciones para administrador:");
        System.out.println("1. Bandeja de entrada");
        System.out.println("2. Leídos");
        System.out.println("3. Borradores");
        System.out.println("4. Enviar mensaje");
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
}

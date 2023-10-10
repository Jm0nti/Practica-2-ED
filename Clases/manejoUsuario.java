package Clases;
import java.io.*;
import java.util.*;

public class manejoUsuario {

    public static void agregarUsuario(List<String> contraseñas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del nuevo usuario: ");
        String Id_nuevo = scanner.nextLine();

        System.out.print("Ingrese la contraseña del nuevo usuario: ");
        String Contraseña_nueva = scanner.nextLine();

        System.out.print("Ingrese el tipo de usuario del nuevo usuario: ");
        String Tipo_nuevo = scanner.nextLine();

        // Agrega el nuevo usuario a la lista
        String nuevaEntrada = Id_nuevo + " " + Contraseña_nueva + " " + Tipo_nuevo;
        contraseñas.add(nuevaEntrada);

        // Actualiza el txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Password.txt", true))) {
            writer.newLine();
            writer.write(nuevaEntrada);
            System.out.println("Usuario añadido exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al añadir el usuario.");
        }
    }

    public static void eliminarUsuario(List<String> contraseñas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        String idEliminar = scanner.nextLine();


        boolean usuarioEncontrado = false;
        List<String> contraseñasActualizadas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Archivos/Password.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(" ");
                if (partes.length == 3 && partes[0].equals(idEliminar)) {
                    usuarioEncontrado = true;
                } else {
                    contraseñasActualizadas.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de contraseñas.");
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        // Sobreescribe el txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Password.txt"))) {
            for (String entrada : contraseñasActualizadas) {
                writer.write(entrada);
                writer.newLine();
            }
            System.out.println("Usuario eliminado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de contraseñas.");
        }
    }

/* //MÉTODO EDITAR USUARIO (casi listo)
    public static void editarUsuario(List<String> contraseñas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario cuya contraseña desea cambiar: ");
        String idEditar = scanner.nextLine().trim(); // Quitamos espacios en blanco adicionales

        boolean usuarioEncontrado = false;
        List<String> contraseñasActualizadas = new ArrayList<>();

        for (String linea : contraseñas) {
            String[] partes = linea.split("\\s+");
            if (partes.length == 3) {
                String idUsuario = partes[0].trim();
                System.out.println("ID del archivo: " + idUsuario);
                if (idUsuario.equals(idEditar)) {
                    usuarioEncontrado = true;
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaContraseña = scanner.nextLine();
                    String nuevaEntrada = idUsuario + " " + nuevaContraseña + " " + partes[2];
                    contraseñasActualizadas.add(nuevaEntrada);
                    System.out.println("Contraseña del usuario actualizada con éxito.");
                } else {
                    contraseñasActualizadas.add(linea);
                }
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        // Sobrescribir el archivo "Password.txt" con las contraseñas actualizadas
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Password.txt"))) {
            for (String entrada : contraseñasActualizadas) {
                writer.write(entrada);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de contraseñas.");
        }
    }
*/

}

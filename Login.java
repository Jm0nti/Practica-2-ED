import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Map<String, String[]> usuarios = cargarUsuariosDesdeArch("password.txt");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su número de identificación: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();
        
        if (usuarios.containsKey(cedula)) {
            String[] usuario = usuarios.get(cedula);
            String contrasenaGuardada = usuario[0];
            String tipoUsuario = usuario[1];
            
            if (contrasena.equals(contrasenaGuardada)) {
                Menu menu = new Menu();
                
                if (tipoUsuario.equals("empleado")) {
                    // Menú para empleado
                    int opcion;
                    do {
                        menu.menuEmpleado();
                        opcion = menu.obtenerOpcion();
                        
                        switch (opcion) {
                            case 1:
                                // Lógica para Bandeja de entrada
                                System.out.println("Bandeja de entrada de empleado");
                                break;
                            case 2:
                                // Lógica para Leídos
                                System.out.println("Leídos de empleado");
                                break;
                            case 3:
                                // Lógica para Borradores
                                System.out.println("Borradores de empleado");
                                break;
                            case 4:
                                // Lógica para Enviar mensaje
                                System.out.println("Enviar mensaje de empleado");
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (opcion != 0);
                } else if (tipoUsuario.equals("administrador")) {
                    // Menú para administrador
                    int opcion;
                    do {
                        menu.menuAdmin();
                        opcion = menu.obtenerOpcion();
                        
                        switch (opcion) {
                            case 1:
                                // Lógica para Bandeja de entrada
                                System.out.println("Bandeja de entrada de administrador");
                                break;
                            case 2:
                                // Lógica para Leídos
                                System.out.println("Leídos de administrador");
                                break;
                            case 3:
                                // Lógica para Borradores
                                System.out.println("Borradores de administrador");
                                break;
                            case 4:
                                // Lógica para Enviar mensaje
                                System.out.println("Enviar mensaje de administrador");
                                break;
                            case 5:
                                // Lógica para Agregar usuario 
                                System.out.println("Agregar usuario");  
                                break;
                            case 6:
                                // Lógica para Eliminar usuario
                                System.out.println("Eliminar usuario");
                                break;
                            case 7:
                                // Lógica para Editar usuario
                                System.out.println("Editar usuario");
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (opcion != 0);
                }
                
                menu.cerrarEscanner();
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Cédula no encontrada");
        }
        
        scanner.close();
    }

    private static Map<String, String[]> cargarUsuariosDesdeArch(String archivo) {
        Map<String, String[]> usuarios = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                if (partes.length == 3) {
                    String cedula = partes[0];
                    String contrasena = partes[1];
                    String tipoUsuario = partes[2];
                    usuarios.put(cedula, new String[]{contrasena, tipoUsuario});
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return usuarios;
    }
    // Resto del código...
}

import Clases.*;
import Estructuras.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Mensajeria mensajeria = new Mensajeria();
        //Importar los archivos
        mensajeria.importarArchivos();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese su número de identificación: ");
            String idIngresada = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contraseñaIngresada = scanner.nextLine();

            // Verificar estado de Login y estado de empleado
            boolean VerificarLogin = false;
            boolean SuperUser = false;

            List<String> contraseñas = new ArrayList<>();
            
            DoubleList usuarios = mensajeria.getEmpleados();
            Usuario remitente = null;

            DoubleNode currentDoubleNodeU = usuarios.first();

            DoubleNode currentDoubleNode = mensajeria.getContraseñas().first();



            while (currentDoubleNode != null) {
                Object[] data = (Object[]) currentDoubleNode.getData();
                if (data.length == 3 && data[0] instanceof String && data[1] instanceof String) {
                    String contraseña = (String) data[0] + " " + (String) data[1] + " " + (String) data[2];
                    contraseñas.add(contraseña);
                }
                currentDoubleNode = currentDoubleNode.getNext();
            }
            

            for (String contraseña : contraseñas) {
                String[] partes = contraseña.split(" ");
                if (partes.length == 3 && partes[0].equals(idIngresada) && partes[1].equals(contraseñaIngresada)) {
                    VerificarLogin = true;
                    SuperUser = partes[2].equals("administrador");
                    break;
                }
            }

            while (currentDoubleNodeU != null) {
                Usuario usuario = (Usuario) currentDoubleNodeU.getData();
                String contraseña = usuario.getId() + " " + usuario.getNombre() + " " + usuario.getEmail();

                if (contraseña.equals(idIngresada + " " + contraseñaIngresada + " administrador")) {
                    VerificarLogin = true;
                    SuperUser = true;
                    remitente = usuario;
                    break;
                } else if (contraseña.equals(idIngresada + " " + contraseñaIngresada + " empleado")) {
                    System.out.println("Hola Munda");
                    VerificarLogin = true;
                    remitente = usuario;
                    break;
                }

                currentDoubleNodeU = currentDoubleNodeU.getNext();
            }

            if (VerificarLogin) {
                System.out.println("Inicio de sesión exitoso, eres " + (SuperUser ? "administrador" : "empleado"));

                Menu menu = new Menu(mensajeria, remitente);

                while(true){
                if (SuperUser) {
                    menu.menuAdmin();
                } else {
                    menu.menuEmpleado();
                }
                int opcion = menu.obtenerOpcion();
                menu.manejarOpcion(opcion);
                if(opcion == 0){
                    mensajeria.escribirArchivos();
                    break;
                }
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }
    }
}
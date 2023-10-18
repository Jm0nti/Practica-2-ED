import Clases.*;
import Estructuras.*;
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
            
            DoubleList usuarios = mensajeria.getEmpleados();
            Usuario remitente = null;

            DoubleNode currentDoubleNodeU = usuarios.first();

            DoubleNode currentDoubleNode = mensajeria.getContraseñas().first();


            while (currentDoubleNode != null) {
                String[] userData = (String[]) currentDoubleNode.getData();
                String userId = userData[0];
                String userContraseña = userData[1];
                String userTipo = userData[2];

                if (userId.equals(idIngresada) && userContraseña.equals(contraseñaIngresada)) {
                    VerificarLogin = true;
                    SuperUser = userTipo.equals("administrador");
                }
                currentDoubleNode = currentDoubleNode.getNext();
            }


            while (currentDoubleNodeU != null) {
                Usuario usuario = (Usuario) currentDoubleNodeU.getData();
                Long id = usuario.getId();

                Long idIngresadaLong = Long.parseLong(idIngresada);
            
                if (id.equals(idIngresadaLong)) {
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
                    break;
                }
                }
            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }
    }
}
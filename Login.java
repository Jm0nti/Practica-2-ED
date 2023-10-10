import Clases.*;

public class Login {
    public static void main(String[] args) {
        Mensajeria mensajeria = new Mensajeria();
        //Importar los empleados
        mensajeria.importarEmpleados();
        //Importar Contraseñas
        mensajeria.importarContraseñas();
        //Dejo ejemplo de como funciona la importacion, toca primero instanciar la clase usuario para poder
        //usar los metodos que tiene adentro
        Usuario usuarioPrueba = (Usuario) mensajeria.getEmpleados().first().getNext().getData();
        System.out.println(usuarioPrueba.getNombre());
        String[] contraseñaPrueba = (String[]) mensajeria.getContraseñas().first().getData();
        System.out.println(contraseñaPrueba[1]);
       
     

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su número de identificación: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        // Falta corregir el login teniendo en cuenta como fueron ingresados los datos
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
                                System.out.println("Redactar nuevo mensaje de empleado");
                                mensajeria.enviarMensaje(usuarioPrueba);
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
                                System.out.println("Redactar mensaje de administrador");
                                mensajeria.enviarMensaje(usuarioPrueba);
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
        scanner.close();*/
    }
}

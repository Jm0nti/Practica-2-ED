package Clases;
import Estructuras.DoubleList;
import Estructuras.DoubleNode;

import java.io.*;
import java.util.*;

public class manejoUsuario {

    public static void agregarUsuario(Mensajeria mensajeria) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del nuevo usuario: ");
        String Id_nuevo = scanner.nextLine();

        // Verificar si el usuario ya existe en contraseñas
        DoubleList contraseñas = mensajeria.getContraseñas();
        DoubleNode currentNode = contraseñas.first();
        boolean usuarioExistente = false;

        while (currentNode != null) {
            String[] userData = (String[]) currentNode.getData();
            String userId = userData[0];

            if (userId.equals(Id_nuevo)) {
                usuarioExistente = true;
                break;
            }

            currentNode = currentNode.getNext();
        }

        if (usuarioExistente) {
            System.out.println("Usuario ya existe dentro del sistema!");
        } else {
            // El usuario no existe, continuar con la entrada de datos
            System.out.print("Ingrese el nombre del nuevo Usuario: ");
            String nombre_nuevoU = scanner.nextLine();


            System.out.print("Ingrese la contraseña del nuevo usuario: ");
            String Contraseña_nueva = scanner.nextLine();

            System.out.print("Ingrese el tipo de usuario del nuevo usuario: ");
            String Tipo_nuevo = scanner.nextLine();

            System.out.print("Ingrese la fecha de nacimiento del nuevo Usuario (dd/mm/aaaa)\nDía: ");
            int dia_nuevoU = scanner.nextInt();
            scanner.nextLine();  // Consumir carácter de nueva línea

            System.out.print("Mes: ");
            int mes_nuevoU = scanner.nextInt();
            scanner.nextLine();  // Consumir carácter de nueva línea

            System.out.print("Año: ");
            int año_nuevoU = scanner.nextInt();
            scanner.nextLine();  // Consumir carácter de nueva línea

            System.out.print("Ingrese la ciudad de nacimiento del nuevo usuario: ");
            String ciudadN_nuevoU = scanner.nextLine();

            System.out.print("Ingrese el telefono del nuevo Usuario: ");
            long tel_nuevoU = scanner.nextLong();
            scanner.nextLine();  // Consumir carácter de nueva línea

            System.out.print("Ingrese email del nuevo Usuario: ");
            String email_nuevoU = scanner.nextLine();

            System.out.print("Ingrese la dirección del nuevo Usuario\nCalle: ");
            String calle_nuevoU = scanner.nextLine();

            System.out.print("Nomenclatura: ");
            String nomenclatura_nuevoU = scanner.nextLine();

            System.out.print("Barrio: ");
            String barrio_nuevoU = scanner.nextLine();

            System.out.print("Ciudad: ");
            String ciudad_nuevoU = scanner.nextLine();

            System.out.print("Urbanización: ");
            String urbanizacion_nuevoU = scanner.nextLine();

            System.out.print("No. Apto: ");
            String noApto_NuevoU = scanner.nextLine();

            String nuevaEntrada_empleados = nombre_nuevoU.replace(" ", "-") + " " + Id_nuevo + " " + dia_nuevoU + " " + mes_nuevoU + " " + año_nuevoU + " " + ciudadN_nuevoU.replace(" ","-") + " " + tel_nuevoU + " " + email_nuevoU + " " + calle_nuevoU.replace(" ", "-") + " " + nomenclatura_nuevoU.replace(" ", "-") + " " + barrio_nuevoU.replace(" ","-") + " " + ciudad_nuevoU.replace(" ","-") + " " + urbanizacion_nuevoU.replace(" ", "-") + " " + noApto_NuevoU;
            String nuevaEntrada_contraseñas = Id_nuevo + " " + Contraseña_nueva + " " + Tipo_nuevo;


            // Actualiza ambos txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Empleados.txt", true))) {
                writer.newLine();
                writer.write(nuevaEntrada_empleados);
            } catch (IOException e) {
                System.out.println("Error al añadir el usuario.");
            }


            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Password.txt", true))) {
                writer.newLine();
                writer.write(nuevaEntrada_contraseñas);
            } catch (IOException e) {
                System.out.println("Error al añadir el usuario.");
            }

            System.out.println("Usuario añadido exitosamente");
        }


    }


    public static void eliminarUsuarioE(Mensajeria mensajeria, String idAEliminar) {
        DoubleList empleados = mensajeria.getEmpleados();
        DoubleNode currentNode = empleados.first();

        boolean usuarioEncontrado = false;

        while (currentNode != null) {
            Usuario usuario = (Usuario) currentNode.getData();

            if (String.valueOf(usuario.getId()).equals(idAEliminar)) {
                empleados.remove(currentNode); // Eliminamos el nodo que contiene el usuario
                usuarioEncontrado = true;
                break; // Detenemos la búsqueda
            }

            currentNode = currentNode.getNext();

        }

        if (usuarioEncontrado) {
            System.out.println("Usuario con ID " + idAEliminar + " eliminado exitosamente.");
            // Sobrescribir el archivo .txt con la lista actualizada
            ActualizarEmpleados(empleados);
            // Devolvemos el índice del usuario encontrado
        } else {
            System.out.println("Usuario no encontrado.");// Puedes elegir un valor específico, como -1, para indicar que el usuario no se encontró.
        }
    }


    private static void ActualizarEmpleados(DoubleList empleados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Empleados.txt"))) {
            DoubleNode currentNode = empleados.first();
            while (currentNode != null) {
                Usuario usuario = (Usuario) currentNode.getData();
                // Escribe la información del usuario en el archivo
                writer.write(usuario.toString()); // Asumiendo que la clase Usuario tiene un método toString()
                writer.newLine();
                currentNode = currentNode.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo de empleados.");
        }
    }


    public static void eliminarUsuarioC(Mensajeria mensajeria, String idAEliminar) {
        DoubleList contraseñas = mensajeria.getContraseñas();
        DoubleNode currentNode = contraseñas.first();

        while (currentNode != null) {
            String[] userData = (String[]) currentNode.getData();
            String userId = userData[0];

            if (userId.equals(idAEliminar)) {
                // Eliminamos el nodo que contiene el usuario
                contraseñas.remove(currentNode);
                // System.out.println("Usuario con ID " + idAEliminar + " eliminado de contraseñas.");
                break; // Detenemos la búsqueda
            }

            currentNode = currentNode.getNext();
        }

        // Actualizamos el archivo Password.txt
        ActualizarContraseñas(contraseñas);
    }


    public static void editarContraseña(Mensajeria mensajeria, String idEditar, String Nuevacontraseña) {
        DoubleList contraseñas = mensajeria.getContraseñas();
        DoubleNode currentNode = contraseñas.first();

        while (currentNode != null) {
            String[] userData = (String[]) currentNode.getData();
            String userId = userData[0];

            if (userId.equals(idEditar)) {
                // Actualizamos la contraseña en el nodo que contiene el usuario
                userData[1] = Nuevacontraseña;
                System.out.println("Contraseña del usuario con ID " + idEditar + " actualizada.");
                break; // Detenemos la búsqueda
            }

            currentNode = currentNode.getNext();
        }

        // Actualizamos el archivo Password.txt
        ActualizarContraseñas(contraseñas);
    }


    private static void ActualizarContraseñas(DoubleList contraseñas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Archivos/Password.txt"))) {
            DoubleNode currentNode = contraseñas.first();
            while (currentNode != null) {
                String[] userData = (String[]) currentNode.getData();
                String userDataString = String.join(" ", userData);
                writer.write(userDataString);
                writer.newLine();
                currentNode = currentNode.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo de contraseñas.");
        }
    }



}

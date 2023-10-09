package Clases;

import Estructuras.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Mensajeria {
        private DoubleList empleados = new DoubleList();
        private DoubleList contraseñas = new DoubleList();
        private Scanner scanner = new Scanner(System.in);


        public DoubleList getEmpleados(){
            return this.empleados;
        }
        
        public DoubleList getContraseñas(){
            return this.contraseñas;
        }

        public void importarEmpleados() {
        try {
            FileReader Empleados = new FileReader("Archivos/Empleados.txt");
            BufferedReader lector = new BufferedReader(Empleados);
            if (Empleados.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(" ");
                    Fecha fecha = new Fecha(Integer.valueOf(data[2]), Integer.valueOf(data[3]),
                            Integer.valueOf(data[4]));
                    Direccion direccion = new Direccion(data[8], data[9], data[10], data[11], data[12], data[13]);
                    Usuario usuario = new Usuario(data[0], Long.parseLong(data[1]), fecha, data[5],
                            Long.parseLong(data[6]), data[7], direccion);
                    empleados.addLast(usuario);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void importarContraseñas() {
        try {
            FileReader Password = new FileReader("Archivos/Password.txt");
            BufferedReader lector = new BufferedReader(Password);
            if (Password.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(" ");
                    contraseñas.addLast(data);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




    public void enviarMensaje(Usuario remitente) {
        System.out.print("Ingrese la cédula del destinatario: ");
        long destinatarioCedula = scanner.nextLong();
        scanner.nextLine();

        // Buscar destinatario
        Usuario destinatario = buscarUsuario(destinatarioCedula);

        if (destinatario != null) {
            System.out.print("Ingrese el título del mensaje: ");
            String titulo = scanner.nextLine();

            System.out.print("Ingrese el contenido del mensaje: ");
            String contenido = scanner.nextLine();

            // Crear mensaje
            Mensaje mensaje = new Mensaje(remitente, destinatario, titulo, contenido);

            // Opciones punto seis
            System.out.println("Opciones:");
            System.out.println("1. Guardar como borrador");
            System.out.println("2. Descartar");
            System.out.println("3. Enviar mensaje");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    remitente.agregarBorrador(mensaje);
                    System.out.println("Mensaje guardado como borrador.");
                    break;
                case 2:
                    System.out.println("Mensaje descartado.");
                    break;
                case 3:
                    destinatario.agregarMensajeBandejaEntrada(mensaje);
                    System.out.println("Mensaje enviado a " + destinatario.getNombre() + ".");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } else {
            System.out.println("Destinatario no encontrado.");
        }
    }

    private Usuario buscarUsuario(long cedula) {
        DoubleNode currentNode = empleados.first();
        while (currentNode != null) {
            Usuario usuario = (Usuario) currentNode.getData();
            if (usuario.getId() == cedula) {
                return usuario;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

}
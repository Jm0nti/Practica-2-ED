package Clases;

import Estructuras.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Mensajeria {
    private DoubleList empleados = new DoubleList();
    private DoubleList contraseñas = new DoubleList();
    private DoubleList bandejaEntrada = new DoubleList();
    private StackList borradores = new StackList();
    private QueueList mensajesLeidos = new QueueList();
    private Scanner scanner = new Scanner(System.in);

    // GETTERS Y SETTERS
    public DoubleList getEmpleados() {
        return this.empleados;
    }

    public DoubleList getContraseñas() {
        return this.contraseñas;
    }

    // CARGAR ARCHIVOS

    public void importarArchivos() {
        importarEmpleados();
        importarContraseñas();
        importarBandejaEntrada();
        importarBorradores();
        importarMensajesLeidos();
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

    public void importarBandejaEntrada() {
        try {
            FileReader bandejaE = new FileReader("Archivos/bandejaEntrada.txt");
            BufferedReader lector = new BufferedReader(bandejaE);
            if (bandejaE.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(",");
                    String remitenteAux[] = data[0].split(" ");
                    Fecha fecha1 = new Fecha(Integer.valueOf(remitenteAux[2]), Integer.valueOf(remitenteAux[3]),
                            Integer.valueOf(remitenteAux[4]));
                    Direccion direccion1 = new Direccion(remitenteAux[8], remitenteAux[9], remitenteAux[10],
                            remitenteAux[11], remitenteAux[12], remitenteAux[13]);
                    Usuario remitente = new Usuario(remitenteAux[0], Long.parseLong(remitenteAux[1]), fecha1,
                            remitenteAux[5],
                            Long.parseLong(remitenteAux[6]), remitenteAux[7], direccion1);
                    String destinatarioAux[] = data[1].split(" ");
                    Fecha fecha2 = new Fecha(Integer.valueOf(destinatarioAux[2]), Integer.valueOf(destinatarioAux[3]),
                            Integer.valueOf(destinatarioAux[4]));
                    Direccion direccion2 = new Direccion(destinatarioAux[8], destinatarioAux[9], destinatarioAux[10],
                            destinatarioAux[11], destinatarioAux[12], destinatarioAux[13]);
                    Usuario destinatario = new Usuario(destinatarioAux[0], Long.parseLong(destinatarioAux[1]), fecha2,
                            destinatarioAux[5],
                            Long.parseLong(destinatarioAux[6]), destinatarioAux[7], direccion2);
                    Mensaje mensaje = new Mensaje(remitente, destinatario, data[2], data[3]);
                    mensaje.setFecha(data[4]);
                    bandejaEntrada.addLast(mensaje);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("La bandeja de entrada no se pudo cargar correctamente.");
            e.printStackTrace();
        }
    }

    public void importarBorradores() {
        try {
            FileReader Borradores = new FileReader("Archivos/Borradores.txt");
            BufferedReader lector = new BufferedReader(Borradores);
            if (Borradores.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(",");
                    String remitenteAux[] = data[0].split(" ");
                    Fecha fecha1 = new Fecha(Integer.valueOf(remitenteAux[2]), Integer.valueOf(remitenteAux[3]),
                            Integer.valueOf(remitenteAux[4]));
                    Direccion direccion1 = new Direccion(remitenteAux[8], remitenteAux[9], remitenteAux[10],
                            remitenteAux[11], remitenteAux[12], remitenteAux[13]);
                    Usuario remitente = new Usuario(remitenteAux[0], Long.parseLong(remitenteAux[1]), fecha1,
                            remitenteAux[5],
                            Long.parseLong(remitenteAux[6]), remitenteAux[7], direccion1);
                    String destinatarioAux[] = data[1].split(" ");
                    Fecha fecha2 = new Fecha(Integer.valueOf(destinatarioAux[2]), Integer.valueOf(destinatarioAux[3]),
                            Integer.valueOf(destinatarioAux[4]));
                    Direccion direccion2 = new Direccion(destinatarioAux[8], destinatarioAux[9], destinatarioAux[10],
                            destinatarioAux[11], destinatarioAux[12], destinatarioAux[13]);
                    Usuario destinatario = new Usuario(destinatarioAux[0], Long.parseLong(destinatarioAux[1]), fecha2,
                            destinatarioAux[5],
                            Long.parseLong(destinatarioAux[6]), destinatarioAux[7], direccion2);
                    Mensaje mensaje = new Mensaje(remitente, destinatario, data[2], data[3]);
                    mensaje.setFecha(data[4]);
                    borradores.push(mensaje);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Los borradores no se pudieron cargar correctamente.");
            e.printStackTrace();
        }
    }

    public void importarMensajesLeidos() {
        try {
            FileReader Borradores = new FileReader("Archivos/Borradores.txt");
            BufferedReader lector = new BufferedReader(Borradores);
            if (Borradores.ready()) {
                String dataAux;
                while ((dataAux = lector.readLine()) != null) {
                    String data[] = dataAux.split(",");
                    String remitenteAux[] = data[0].split(" ");
                    Fecha fecha1 = new Fecha(Integer.valueOf(remitenteAux[2]), Integer.valueOf(remitenteAux[3]),
                            Integer.valueOf(remitenteAux[4]));
                    Direccion direccion1 = new Direccion(remitenteAux[8], remitenteAux[9], remitenteAux[10],
                            remitenteAux[11], remitenteAux[12], remitenteAux[13]);
                    Usuario remitente = new Usuario(remitenteAux[0], Long.parseLong(remitenteAux[1]), fecha1,
                            remitenteAux[5],
                            Long.parseLong(remitenteAux[6]), remitenteAux[7], direccion1);
                    String destinatarioAux[] = data[1].split(" ");
                    Fecha fecha2 = new Fecha(Integer.valueOf(destinatarioAux[2]), Integer.valueOf(destinatarioAux[3]),
                            Integer.valueOf(destinatarioAux[4]));
                    Direccion direccion2 = new Direccion(destinatarioAux[8], destinatarioAux[9], destinatarioAux[10],
                            destinatarioAux[11], destinatarioAux[12], destinatarioAux[13]);
                    Usuario destinatario = new Usuario(destinatarioAux[0], Long.parseLong(destinatarioAux[1]), fecha2,
                            destinatarioAux[5],
                            Long.parseLong(destinatarioAux[6]), destinatarioAux[7], direccion2);
                    Mensaje mensaje = new Mensaje(remitente, destinatario, data[2], data[3]);
                    mensaje.setFecha(data[4]);
                    mensaje.setLeido(true);
                    mensajesLeidos.enqueue(mensaje);
                }
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Los mensajes leidos no se pudieron cargar correctamente.");
            e.printStackTrace();
        }
    }

    // Escribir archivos
    public void escribirArchivos() {
        escribirBandejaEntrada();
        escribirBorradores();
        escribirMensajesLeidos();
    }

    public void escribirBandejaEntrada() {
        String texto = "";
        for (int i = 0; i < bandejaEntrada.size(); i++) {
            Mensaje mensaje = (Mensaje) bandejaEntrada.get(i);

            if (i == 0) {
                texto = mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getId() + " "
                        + mensaje.getRemitente().getFechaNac().getDd() + " "
                        + mensaje.getRemitente().getFechaNac().getMm() + " "
                        + mensaje.getRemitente().getFechaNac().getAa() + " " + mensaje.getRemitente().getCiudadNac()
                        + " " + mensaje.getRemitente().getTel() + " " + mensaje.getRemitente().getEmail() + " "
                        + mensaje.getRemitente().getDir().getCalle() + " "
                        + mensaje.getRemitente().getDir().getNomenclatura() + " "
                        + mensaje.getRemitente().getDir().getBarrio() + " "
                        + mensaje.getRemitente().getDir().getCiudad() + " "
                        + mensaje.getRemitente().getDir().getUrbanizacion() + " "
                        + mensaje.getRemitente().getDir().getnoApartamento() + ","
                        + mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getId() + " "
                        + mensaje.getDestinatario().getFechaNac().getDd() + " "
                        + mensaje.getDestinatario().getFechaNac().getMm() + " "
                        + mensaje.getDestinatario().getFechaNac().getAa() + " "
                        + mensaje.getDestinatario().getCiudadNac()
                        + " " + mensaje.getDestinatario().getTel() + " " + mensaje.getDestinatario().getEmail() + " "
                        + mensaje.getDestinatario().getDir().getCalle() + " "
                        + mensaje.getDestinatario().getDir().getNomenclatura() + " "
                        + mensaje.getDestinatario().getDir().getBarrio() + " "
                        + mensaje.getDestinatario().getDir().getCiudad() + " "
                        + mensaje.getDestinatario().getDir().getUrbanizacion() + " "
                        + mensaje.getDestinatario().getDir().getnoApartamento() + "," + mensaje.getTitulo() + ","
                        + mensaje.getContenido() + "," + mensaje.getFechaEnvio() + "," + mensaje.isLeido();
            } else {
                texto = texto + "\n" + mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getId() + " "
                        + mensaje.getRemitente().getFechaNac().getDd() + " "
                        + mensaje.getRemitente().getFechaNac().getMm() + " "
                        + mensaje.getRemitente().getFechaNac().getAa() + " " + mensaje.getRemitente().getCiudadNac()
                        + " " + mensaje.getRemitente().getTel() + " " + mensaje.getRemitente().getEmail() + " "
                        + mensaje.getRemitente().getDir().getCalle() + " "
                        + mensaje.getRemitente().getDir().getNomenclatura() + " "
                        + mensaje.getRemitente().getDir().getBarrio() + " "
                        + mensaje.getRemitente().getDir().getCiudad() + " "
                        + mensaje.getRemitente().getDir().getUrbanizacion() + " "
                        + mensaje.getRemitente().getDir().getnoApartamento() + ","
                        + mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getId() + " "
                        + mensaje.getDestinatario().getFechaNac().getDd() + " "
                        + mensaje.getDestinatario().getFechaNac().getMm() + " "
                        + mensaje.getDestinatario().getFechaNac().getAa() + " "
                        + mensaje.getDestinatario().getCiudadNac()
                        + " " + mensaje.getDestinatario().getTel() + " " + mensaje.getDestinatario().getEmail() + " "
                        + mensaje.getDestinatario().getDir().getCalle() + " "
                        + mensaje.getDestinatario().getDir().getNomenclatura() + " "
                        + mensaje.getDestinatario().getDir().getBarrio() + " "
                        + mensaje.getDestinatario().getDir().getCiudad() + " "
                        + mensaje.getDestinatario().getDir().getUrbanizacion() + " "
                        + mensaje.getDestinatario().getDir().getnoApartamento() + "," + mensaje.getTitulo() + ","
                        + mensaje.getContenido() + "," + mensaje.getFechaEnvio() + "," + mensaje.isLeido();
            }
        }

        try {
            FileWriter bandejaE = new FileWriter("Archivos/bandejaEntrada.txt");
            bandejaE.write(texto);
            bandejaE.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error escribiendo la bandeja de entrada");
            e.printStackTrace();
        }

    }

    public void escribirBorradores() {
        List borradoresAux = borradores.getData();
        String texto = "";
        for (int i = 0; i < borradoresAux.size(); i++) {
            Mensaje mensaje = (Mensaje) borradoresAux.get(i);

            if (i == 0) {
                texto = mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getId() + " "
                        + mensaje.getRemitente().getFechaNac().getDd() + " "
                        + mensaje.getRemitente().getFechaNac().getMm() + " "
                        + mensaje.getRemitente().getFechaNac().getAa() + " " + mensaje.getRemitente().getCiudadNac()
                        + " " + mensaje.getRemitente().getTel() + " " + mensaje.getRemitente().getEmail() + " "
                        + mensaje.getRemitente().getDir().getCalle() + " "
                        + mensaje.getRemitente().getDir().getNomenclatura() + " "
                        + mensaje.getRemitente().getDir().getBarrio() + " "
                        + mensaje.getRemitente().getDir().getCiudad() + " "
                        + mensaje.getRemitente().getDir().getUrbanizacion() + " "
                        + mensaje.getRemitente().getDir().getnoApartamento() + ","
                        + mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getId() + " "
                        + mensaje.getDestinatario().getFechaNac().getDd() + " "
                        + mensaje.getDestinatario().getFechaNac().getMm() + " "
                        + mensaje.getDestinatario().getFechaNac().getAa() + " "
                        + mensaje.getDestinatario().getCiudadNac()
                        + " " + mensaje.getDestinatario().getTel() + " " + mensaje.getDestinatario().getEmail() + " "
                        + mensaje.getDestinatario().getDir().getCalle() + " "
                        + mensaje.getDestinatario().getDir().getNomenclatura() + " "
                        + mensaje.getDestinatario().getDir().getBarrio() + " "
                        + mensaje.getDestinatario().getDir().getCiudad() + " "
                        + mensaje.getDestinatario().getDir().getUrbanizacion() + " "
                        + mensaje.getDestinatario().getDir().getnoApartamento() + "," + mensaje.getTitulo() + ","
                        + mensaje.getContenido() + "," + mensaje.getFechaEnvio() + "," + mensaje.isLeido();
            } else {
                texto = texto + "\n" + mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getId() + " "
                        + mensaje.getRemitente().getFechaNac().getDd() + " "
                        + mensaje.getRemitente().getFechaNac().getMm() + " "
                        + mensaje.getRemitente().getFechaNac().getAa() + " " + mensaje.getRemitente().getCiudadNac()
                        + " " + mensaje.getRemitente().getTel() + " " + mensaje.getRemitente().getEmail() + " "
                        + mensaje.getRemitente().getDir().getCalle() + " "
                        + mensaje.getRemitente().getDir().getNomenclatura() + " "
                        + mensaje.getRemitente().getDir().getBarrio() + " "
                        + mensaje.getRemitente().getDir().getCiudad() + " "
                        + mensaje.getRemitente().getDir().getUrbanizacion() + " "
                        + mensaje.getRemitente().getDir().getnoApartamento() + ","
                        + mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getId() + " "
                        + mensaje.getDestinatario().getFechaNac().getDd() + " "
                        + mensaje.getDestinatario().getFechaNac().getMm() + " "
                        + mensaje.getDestinatario().getFechaNac().getAa() + " "
                        + mensaje.getDestinatario().getCiudadNac()
                        + " " + mensaje.getDestinatario().getTel() + " " + mensaje.getDestinatario().getEmail() + " "
                        + mensaje.getDestinatario().getDir().getCalle() + " "
                        + mensaje.getDestinatario().getDir().getNomenclatura() + " "
                        + mensaje.getDestinatario().getDir().getBarrio() + " "
                        + mensaje.getDestinatario().getDir().getCiudad() + " "
                        + mensaje.getDestinatario().getDir().getUrbanizacion() + " "
                        + mensaje.getDestinatario().getDir().getnoApartamento() + "," + mensaje.getTitulo() + ","
                        + mensaje.getContenido() + "," + mensaje.getFechaEnvio() + "," + mensaje.isLeido();
            }
        }

        try {
            FileWriter borradoresAuxE = new FileWriter("Archivos/Borradores.txt");
            borradoresAuxE.write(texto);
            borradoresAuxE.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error escribiendo los borradores");
            e.printStackTrace();
        }
    }

    public void escribirMensajesLeidos() {
        List mensajesLeidosAux = mensajesLeidos.getData();
        String texto = "";
        for (int i = 0; i < mensajesLeidosAux.size(); i++) {
            Mensaje mensaje = (Mensaje) mensajesLeidosAux.get(i);

            if (i == 0) {
                texto = mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getId() + " "
                        + mensaje.getRemitente().getFechaNac().getDd() + " "
                        + mensaje.getRemitente().getFechaNac().getMm() + " "
                        + mensaje.getRemitente().getFechaNac().getAa() + " " + mensaje.getRemitente().getCiudadNac()
                        + " " + mensaje.getRemitente().getTel() + " " + mensaje.getRemitente().getEmail() + " "
                        + mensaje.getRemitente().getDir().getCalle() + " "
                        + mensaje.getRemitente().getDir().getNomenclatura() + " "
                        + mensaje.getRemitente().getDir().getBarrio() + " "
                        + mensaje.getRemitente().getDir().getCiudad() + " "
                        + mensaje.getRemitente().getDir().getUrbanizacion() + " "
                        + mensaje.getRemitente().getDir().getnoApartamento() + ","
                        + mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getId() + " "
                        + mensaje.getDestinatario().getFechaNac().getDd() + " "
                        + mensaje.getDestinatario().getFechaNac().getMm() + " "
                        + mensaje.getDestinatario().getFechaNac().getAa() + " "
                        + mensaje.getDestinatario().getCiudadNac()
                        + " " + mensaje.getDestinatario().getTel() + " " + mensaje.getDestinatario().getEmail() + " "
                        + mensaje.getDestinatario().getDir().getCalle() + " "
                        + mensaje.getDestinatario().getDir().getNomenclatura() + " "
                        + mensaje.getDestinatario().getDir().getBarrio() + " "
                        + mensaje.getDestinatario().getDir().getCiudad() + " "
                        + mensaje.getDestinatario().getDir().getUrbanizacion() + " "
                        + mensaje.getDestinatario().getDir().getnoApartamento() + "," + mensaje.getTitulo() + ","
                        + mensaje.getContenido() + "," + mensaje.getFechaEnvio() + "," + mensaje.isLeido();
            } else {
                texto = texto + "\n" + mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getId() + " "
                        + mensaje.getRemitente().getFechaNac().getDd() + " "
                        + mensaje.getRemitente().getFechaNac().getMm() + " "
                        + mensaje.getRemitente().getFechaNac().getAa() + " " + mensaje.getRemitente().getCiudadNac()
                        + " " + mensaje.getRemitente().getTel() + " " + mensaje.getRemitente().getEmail() + " "
                        + mensaje.getRemitente().getDir().getCalle() + " "
                        + mensaje.getRemitente().getDir().getNomenclatura() + " "
                        + mensaje.getRemitente().getDir().getBarrio() + " "
                        + mensaje.getRemitente().getDir().getCiudad() + " "
                        + mensaje.getRemitente().getDir().getUrbanizacion() + " "
                        + mensaje.getRemitente().getDir().getnoApartamento() + ","
                        + mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getId() + " "
                        + mensaje.getDestinatario().getFechaNac().getDd() + " "
                        + mensaje.getDestinatario().getFechaNac().getMm() + " "
                        + mensaje.getDestinatario().getFechaNac().getAa() + " "
                        + mensaje.getDestinatario().getCiudadNac()
                        + " " + mensaje.getDestinatario().getTel() + " " + mensaje.getDestinatario().getEmail() + " "
                        + mensaje.getDestinatario().getDir().getCalle() + " "
                        + mensaje.getDestinatario().getDir().getNomenclatura() + " "
                        + mensaje.getDestinatario().getDir().getBarrio() + " "
                        + mensaje.getDestinatario().getDir().getCiudad() + " "
                        + mensaje.getDestinatario().getDir().getUrbanizacion() + " "
                        + mensaje.getDestinatario().getDir().getnoApartamento() + "," + mensaje.getTitulo() + ","
                        + mensaje.getContenido() + "," + mensaje.getFechaEnvio() + "," + mensaje.isLeido();
            }
        }

        try {
            FileWriter mensajesLeidosAuxE = new FileWriter("Archivos/mensajesLeidos.txt");
            mensajesLeidosAuxE.write(texto);
            mensajesLeidosAuxE.close();
        } catch (IOException e) {
            System.out.println("Ocurrio un error escribiendo la bandeja de entrada");
            e.printStackTrace();
        }
    }

    // BANDEJA DE ENTRADA
    public void mostrarBandejaEntrada(Usuario remitente) {
        System.out.println("Bandeja de entrada:");

        // Recorrer la bandeja de entrada y mostrar mensajes no leídos
        for (int i = 0; i < bandejaEntrada.size(); i++) {
            Mensaje mensaje = (Mensaje) bandejaEntrada.get(i);

            // Verificar que el destinatario sea el usuario en sesión y que el mensaje no
            // esté leído
            if (mensaje.getDestinatario().getId() == remitente.getId() && !mensaje.isLeido()) {
                System.out.println("Fecha de recepción: " + mensaje.getFechaEnvio());
                System.out.println("Remitente: " + mensaje.getRemitente().getNombre());
                System.out.println("Título del mensaje: " + mensaje.getTitulo());
                System.out.println("------------------------------");
            }
        }

        // Seleccionar y leer un mensaje específico
        System.out.print("Seleccione el número del mensaje que desea leer (0 para salir): ");
        int opcionMensaje = scanner.nextInt();

        if (opcionMensaje > 0 && opcionMensaje <= bandejaEntrada.size()) {
            Mensaje mensajeSeleccionado = (Mensaje) bandejaEntrada.get(opcionMensaje - 1);

            // Marcar el mensaje como leído
            mensajeSeleccionado.setLeido(true);
            agregarMensajeLeido(mensajeSeleccionado);

            // Leer el contenido del mensaje
            System.out.println("Contenido del mensaje:");
            System.out.println(mensajeSeleccionado.getContenido());
        } else if (opcionMensaje == 0) {
            System.out.println("Volviendo al menú principal.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // ENVIAR MENSAJE
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
                    agregarBorrador(mensaje);
                    System.out.println("Mensaje guardado como borrador.");
                    break;
                case 2:
                    // Eliminar el mensaje creado si se selecciona "Descartar"
                    System.out.println("Mensaje descartado.");
                    break;
                case 3:
                    agregarMensajeBandejaEntrada(mensaje);
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

    // MENSAJES LEIDOS
    public void mostrarMensajesLeidos(Usuario remitente) {
        System.out.println("Mensajes leídos:");

        // Recorrer la cola de mensajes leídos y mostrar los mensajes del remitente
        // actual
        for (Mensaje mensaje : mensajesLeidos) {
            if (mensaje.getDestinatario().getId() == remitente.getId()) {
                System.out.println("Fecha de recepción: " + mensaje.getFechaEnvio());
                System.out.println("Remitente: " + mensaje.getRemitente().getNombre());
                System.out.println("Título del mensaje: " + mensaje.getTitulo());
                System.out.println("------------------------------");
            }
        }

        // Seleccionar y mostrar un mensaje específico
        System.out.print("Seleccione el número del mensaje que desea ver (0 para salir): ");
        int opcionMensaje = scanner.nextInt();

        if (opcionMensaje > 0 && opcionMensaje <= mensajesLeidos.size()) {
            Mensaje mensajeSeleccionado = (Mensaje) mensajesLeidos.toArray()[opcionMensaje - 1];

            System.out.println("Contenido del mensaje:");
            System.out.println(mensajeSeleccionado.getContenido());
        } else if (opcionMensaje == 0) {
            System.out.println("Volviendo al menú principal.");
        } else {
            System.out.println("Opción no válida.");
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

    public void agregarMensajeBandejaEntrada(Mensaje mensaje) {
        bandejaEntrada.addLast(mensaje);
    }

    public void agregarMensajeLeido(Mensaje mensaje) {
        mensajesLeidos.enqueue(mensaje);
    }

    public Mensaje obtenerMensajeLeido() {
        return (Mensaje) mensajesLeidos.dequeue();
    }

    public void agregarBorrador(Mensaje mensaje) {
        borradores.push(mensaje);
    }

    public Mensaje obtenerBorrador() {
        if (!borradores.isEmpty()) {
            return (Mensaje) borradores.pop();
        } else {
            System.out.println("No hay borradores disponibles.");
            return null;
        }
    }

}

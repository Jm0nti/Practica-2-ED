package Clases;

import Estructuras.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


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
    public DoubleList getBandejaEntrada(){
        return this.bandejaEntrada;
    }
    public StackList getBorradores(){
        return this.borradores;
    }
    public QueueList getMensajesLeidos(){
        return this.mensajesLeidos;
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
            DoubleList importarBorradores = new DoubleList();
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
                    importarBorradores.addLast(mensaje);
                }
                borradores.setData(importarBorradores);
            }
            lector.close();
        } catch (Exception e) {
            System.out.println("Los borradores no se pudieron cargar correctamente.");
            e.printStackTrace();
        }
    }

    public void importarMensajesLeidos() {
        try {
            FileReader MensajesLeidos = new FileReader("Archivos/mensajesLeidos.txt");
            BufferedReader lector = new BufferedReader(MensajesLeidos);
            if (MensajesLeidos.ready()) {
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
        DoubleList borradoresAux = borradores.getData();
        String texto = "";
        for (int i = 0; i < borradoresAux.size(); i++) {
            Mensaje mensaje = (Mensaje) borradoresAux.get(i);
            System.out.println();
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
        DoubleNode current = bandejaEntrada.first();
        int index = 1;
        while (current != null) {
            Mensaje mensaje = (Mensaje) current.getData();

            // Verificar que el destinatario sea el usuario en sesión y que el mensaje no esté leído
            if (mensaje.getDestinatario().getId() == remitente.getId() && !mensaje.isLeido()) {
                System.out.println("Número de mensaje: " + index);
                System.out.println("Fecha de recepción: " + mensaje.getFechaEnvio());
                System.out.println("Remitente: " + mensaje.getRemitente().getNombre());
                System.out.println("Título del mensaje: " + mensaje.getTitulo());
                System.out.println("------------------------------");
            }

            current = current.getNext();
            index++;
        }

        // Seleccionar y leer un mensaje específico
        System.out.print("Seleccione el número del mensaje que desea leer (0 para salir): ");
        int opcionMensaje = scanner.nextInt();

        if (opcionMensaje > 0 && opcionMensaje <= bandejaEntrada.size()) {
            // Encontrar el nodo que contiene el mensaje seleccionado
            DoubleNode mensajeNode = getNodeAtIndex(bandejaEntrada, opcionMensaje - 1);

            Mensaje mensajeSeleccionado = (Mensaje) mensajeNode.getData();

            // Marcar el mensaje como leído
            mensajeSeleccionado.setLeido(true);
            agregarMensajeLeido(mensajeSeleccionado);

            // Eliminar el mensaje de la lista doble
            bandejaEntrada.remove(mensajeNode);

            // Leer el contenido del mensaje
            System.out.println("Contenido del mensaje:");
            System.out.println(mensajeSeleccionado.getContenido());
        } else if (opcionMensaje == 0) {
            System.out.println("Volviendo al menú principal.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    //StackOverflow se pone la 10
    private DoubleNode getNodeAtIndex(DoubleList doubleList, int index) {
        if (index < 0 || index >= doubleList.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        DoubleNode current = doubleList.first();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }
    

    public void mostrarBorradores(Usuario remitente){
        System.out.println("Borradores: \n");
        DoubleList borradoresRemitente = buscarBorradoresRemitente(remitente).getData();
        Scanner borradoresScanner = new Scanner(System.in);
        if(!borradoresRemitente.isEmpty()){
            for(int i = 0;i<borradoresRemitente.size();i++){
                System.out.println("Borrador "+(i+1)+":");
                Mensaje mensajeBorrador = (Mensaje) borradoresRemitente.get(i);
                System.out.println("Destinatario: "+mensajeBorrador.getDestinatario().getId());
                System.out.println("Titulo: "+mensajeBorrador.getTitulo());
                System.out.println("Contenido: "+mensajeBorrador.getContenido());
                System.out.println("-------------------");
            }
            System.out.println("Seleccione la opcion del borrador que desee modificar: ");
            int opcionBorradores = borradoresScanner.nextInt();
            opcionBorradores = opcionBorradores-1; 
            if(opcionBorradores == 0){
                System.out.println("Seleccione lo que desea hacer con el borrador: ");
                System.out.println("1. Enviar Mensaje");
                System.out.println("2. Descartar Mensaje");
                System.out.println("3. Salir");
                int opcionAux = borradoresScanner.nextInt();
                switch(opcionAux){
                    case 1:
                        Mensaje borradorEnviar = (Mensaje) borradoresRemitente.first().getData();
                        DoubleList borradorLista = (DoubleList) borradores.getData();
                        agregarMensajeBandejaEntrada(borradorEnviar);
                        borradorLista.remove(obtenerMensajeNodo(borradorEnviar));
                        borradores.setData(borradorLista);
                        System.out.println("El mensaje fue enviado con exito a "+borradorEnviar.getDestinatario().getId()+".");
                        break;
                    case 2:
                        Mensaje mensajeDescartar = (Mensaje) borradoresRemitente.first().getData();
                        DoubleList listamensajesDescartar = borradores.getData();
                        listamensajesDescartar.remove(obtenerMensajeNodo(mensajeDescartar));
                        borradores.setData(listamensajesDescartar);
                        System.out.println("El mensaje fue descartado con exito.");
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                }
            }else{
                System.out.println("Solo puede acceder al primer borrador, para acceder a uno distinto,"
                +"por favor termine de realizar sus tareas con el primero.");
            }
        }else{
            System.out.println("No tiene borradores pendientes.");
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
    public void mostrarMensajesLeidos(QueueList mensajesLeidos, Usuario remitente) {
        System.out.println("Mensajes leídos:");
    
        QueueList tempQueue = new QueueList();
    
        // Recorrer la cola de mensajes leídos
        int index = 1;
        while (!mensajesLeidos.isEmpty()) {
            Mensaje mensaje = (Mensaje) mensajesLeidos.dequeue();
    
            if (mensaje.getDestinatario().getId() == remitente.getId()) {
                System.out.println("Número de mensaje: " + index);
                System.out.println("Fecha de recepción: " + mensaje.getFechaEnvio());
                System.out.println("Remitente: " + mensaje.getRemitente().getNombre());
                System.out.println("Título del mensaje: " + mensaje.getTitulo());
                System.out.println("------------------------------");
            }
    
            // Almacena el mensaje en la cola temporal
            tempQueue.enqueue(mensaje);
            index++;
        }
    
        // Restaura la cola original
        mensajesLeidos.setData(tempQueue.getData());
    
    
        System.out.print("Seleccione el número del mensaje que desea ver (0 para salir): ");
        int opcionMensaje = scanner.nextInt();
    
        if (opcionMensaje > 0 && opcionMensaje <= index - 1) {
            Mensaje mensajeSeleccionado = obtenerMensajeEnCola(mensajesLeidos, opcionMensaje - 1);
    
            // Muestra el contenido del mensaje seleccionado
            System.out.println("Contenido del mensaje:");
            System.out.println(mensajeSeleccionado.getContenido());
        } else if (opcionMensaje == 0) {
            System.out.println("Volviendo al menú principal.");
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
    private Mensaje obtenerMensajeEnCola(QueueList mensajesLeidos, int posicion) {
        QueueList tempQueue = new QueueList();
        Mensaje mensajeSeleccionado = null;
    
        int index = 0;
    
        while (!mensajesLeidos.isEmpty()) {
            Mensaje mensaje = (Mensaje) mensajesLeidos.dequeue();
    
            if (index == posicion) {
                mensajeSeleccionado = mensaje;
            }
    
            tempQueue.enqueue(mensaje);
            index++;
        }
    
        // Restaura la cola original
        mensajesLeidos.setData(tempQueue.getData());
    
        return mensajeSeleccionado;
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
    public StackList buscarBorradoresRemitente(Usuario remitente){
        StackList borradoresRemitente = new StackList();
        DoubleList lista = (DoubleList) borradores.getData();
        DoubleList listaBorradoresRemitente = new DoubleList();
        for(int i =0;i<lista.size();i++){
            Mensaje mensajeBorrador = (Mensaje) lista.get(i);
            Usuario usuarioBorrador = (Usuario) mensajeBorrador.getRemitente();
            if(usuarioBorrador.getId() == remitente.getId()){
                listaBorradoresRemitente.addLast(mensajeBorrador);
            }
            borradoresRemitente.setData(listaBorradoresRemitente);
        }
        return borradoresRemitente;
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
    public DoubleNode obtenerMensajeNodo(Mensaje mensaje){
        DoubleList lista = borradores.getData();
        for(int i=0;i<borradores.size();i++){
            if(mensaje == lista.get(i)){
                return lista.getNodo(i);
            }
        }
        return null;
    }

    public void agregarBorrador(Mensaje mensaje) {
        borradores.push(mensaje);
    }
}

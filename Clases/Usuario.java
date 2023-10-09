package Clases;
import java.util.Stack;

import Estructuras.DoubleList;

public class Usuario {
    private String nombre;
    private long id;
    private Fecha fechaNac;
    private String ciudadNac;
    private long tel;
    private String email;
    private Direccion dir;
    private DoubleList bandejaEntrada;
    private Stack<Mensaje> borradores;

    public Usuario(String nombre, long id, Fecha fechaNac, String ciudadNac, long tel, String email, Direccion dir) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNac = fechaNac;
        this.ciudadNac = ciudadNac;
        this.tel = tel;
        this.email = email;
        this.dir = dir;
        this.bandejaEntrada = new DoubleList();
        this.borradores = new Stack<>();
    }


    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public String getCiudadNac() {
        return ciudadNac;
    }

    public Direccion getDir() {
        return dir;
    }

    public long getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }


    
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setCiudadNac(String ciudadNac) {
        this.ciudadNac = ciudadNac;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void agregarMensajeBandejaEntrada(Mensaje mensaje) {
        bandejaEntrada.addLast(mensaje);
    }

    public Mensaje obtenerBandejaEntrada() {
        return (Mensaje) bandejaEntrada.removeFirst();
    }

    public void agregarBorrador(Mensaje mensaje) {
        borradores.push(mensaje);
    }

    public Mensaje obtenerBorrador() {
        if (!borradores.isEmpty()) {
            return borradores.pop();
        } else {
            System.out.println("No hay borradores disponibles.");
            return null;
        }
    }
    
}


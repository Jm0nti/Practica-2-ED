package Clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {

    private Usuario remitente;
    private Usuario destinatario;
    private String titulo;
    private String contenido;
    private String fecha;
    private boolean leido;

    public Mensaje(Usuario remitente, Usuario destinatario, String titulo, String contenido) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = getFechaAct();
        this.leido = false;
    }

    public String getFechaAct() {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter Formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fecha.format(Formato);
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public long getRemitenteId() {
        return remitente.getId();
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getFechaEnvio() {
        return fecha;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
}
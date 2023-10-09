package Clases;

import java.time.LocalDateTime;

public class Mensaje {

    private Usuario remitente;
    private Usuario destinatario;
    private String titulo;
    private String contenido;
    private LocalDateTime fecha;
    
    public Mensaje(Usuario remitente, Usuario destinatario, String titulo, String contenido) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = LocalDateTime.now();
    }

    public Usuario getRemitente() {
        return remitente;
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

    public LocalDateTime getFechaEnvio() {
        return fecha;
    }
}
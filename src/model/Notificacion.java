package model;

import enums.EstadoNotif;
import enums.TipoNotificacion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Notificacion {

    private String codigo;
    private String destinatario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private EstadoNotif estado;
    private TipoNotificacion tipo;

    public Notificacion(String codigo, String destinatario, String mensaje, TipoNotificacion tipo) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.estado = EstadoNotif.PENDIENTE;
        this.fechaEnvio = LocalDateTime.now();
    }

    // Métodos abstractos que cada canal implementa a su manera
    public abstract void enviar();
    public abstract void registrar();

    public void mostrarInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("  Código       : " + codigo);
        System.out.println("  Destinatario : " + destinatario);
        System.out.println("  Tipo         : " + tipo.getDescripcion());
        System.out.println("  Mensaje      : " + mensaje);
        System.out.println("  Fecha envío  : " + fechaEnvio.format(fmt));
        System.out.println("  Estado       : " + estado);
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public EstadoNotif getEstado() { return estado; }
    public void setEstado(EstadoNotif estado) { this.estado = estado; }

    public TipoNotificacion getTipo() { return tipo; }
    public void setTipo(TipoNotificacion tipo) { this.tipo = tipo; }
}

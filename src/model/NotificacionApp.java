package model;

import enums.EstadoNotif;
import enums.TipoNotificacion;

public class NotificacionApp extends Notificacion {

    private String dispositivoId;
    private String plataforma;   // "Android", "iOS"
    private String icono;
    private boolean requiereConfirmacion;

    public NotificacionApp(String codigo, String destinatario, String mensaje,
                           TipoNotificacion tipo, String dispositivoId,
                           String plataforma, String icono, boolean requiereConfirmacion) {
        super(codigo, destinatario, mensaje, tipo);
        this.dispositivoId = dispositivoId;
        this.plataforma = plataforma;
        this.icono = icono;
        this.requiereConfirmacion = requiereConfirmacion;
    }

    @Override
    public void enviar() {
        System.out.println("[APP] Enviando notificación push a dispositivo: " + dispositivoId);
        System.out.println("      Plataforma : " + plataforma);
        System.out.println("      Ícono      : " + icono);
        registrarDispositivo();
        setEstado(EstadoNotif.ENVIADO);
        System.out.println("[APP] Notificación enviada exitosamente.");
        if (requiereConfirmacion) {
            System.out.println("[APP] En espera de confirmación de lectura del usuario.");
        }
    }

    @Override
    public void registrar() {
        System.out.println("[APP] Registro en log de push → " + getCodigo()
                + " | Estado: " + getEstado());
    }

    public void registrarDispositivo() {
        System.out.println("      Dispositivo registrado en el servidor de push.");
    }

    public void confirmarRecepcion() {
        System.out.println("[APP] Recepción confirmada por el usuario para: " + getCodigo());
    }

    // Getters y Setters
    public String getDispositivoId() { return dispositivoId; }
    public void setDispositivoId(String dispositivoId) { this.dispositivoId = dispositivoId; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }

    public boolean isRequiereConfirmacion() { return requiereConfirmacion; }
    public void setRequiereConfirmacion(boolean requiereConfirmacion) {
        this.requiereConfirmacion = requiereConfirmacion;
    }
}

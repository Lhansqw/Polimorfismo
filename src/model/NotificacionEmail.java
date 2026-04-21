package model;

import enums.EstadoNotif;
import enums.TipoNotificacion;

public class NotificacionEmail extends Notificacion {

    private String asunto;
    private String emailDestino;
    private String copiaCC;
    private boolean tieneAdjunto;

    public NotificacionEmail(String codigo, String destinatario, String mensaje,
                             TipoNotificacion tipo, String asunto,
                             String emailDestino, String copiaCC, boolean tieneAdjunto) {
        super(codigo, destinatario, mensaje, tipo);
        this.asunto = asunto;
        this.emailDestino = emailDestino;
        this.copiaCC = copiaCC;
        this.tieneAdjunto = tieneAdjunto;
    }

    @Override
    public void enviar() {
        if (validarEmail()) {
            System.out.println("[EMAIL] Enviando correo a: " + emailDestino);
            System.out.println("        Asunto : " + asunto);
            if (copiaCC != null && !copiaCC.isEmpty()) {
                System.out.println("        CC     : " + copiaCC);
            }
            if (tieneAdjunto) {
                adjuntarArchivo();
            }
            setEstado(EstadoNotif.ENVIADO);
            System.out.println("[EMAIL] Correo enviado exitosamente.");
        } else {
            setEstado(EstadoNotif.FALLIDO);
            System.out.println("[EMAIL] Error: dirección de correo inválida.");
        }
    }

    @Override
    public void registrar() {
        System.out.println("[EMAIL] Registro en log de correos → " + getCodigo()
                + " | Estado: " + getEstado());
    }

    public void adjuntarArchivo() {
        System.out.println("        Adjunto: archivo incluido en el correo.");
    }

    public boolean validarEmail() {
        return emailDestino != null && emailDestino.contains("@") && emailDestino.contains(".");
    }

    // Getters y Setters
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getEmailDestino() { return emailDestino; }
    public void setEmailDestino(String emailDestino) { this.emailDestino = emailDestino; }

    public String getCopiaCC() { return copiaCC; }
    public void setCopiaCC(String copiaCC) { this.copiaCC = copiaCC; }

    public boolean isTieneAdjunto() { return tieneAdjunto; }
    public void setTieneAdjunto(boolean tieneAdjunto) { this.tieneAdjunto = tieneAdjunto; }
}

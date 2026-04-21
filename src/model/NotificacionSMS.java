package model;

import enums.EstadoNotif;
import enums.TipoNotificacion;

public class NotificacionSMS extends Notificacion {

    private static final int MAX_CARACTERES = 160;

    private String numeroTelefono;
    private String operador;
    private int caracteres;

    public NotificacionSMS(String codigo, String destinatario, String mensaje,
                           TipoNotificacion tipo, String numeroTelefono, String operador) {
        super(codigo, destinatario, mensaje, tipo);
        this.numeroTelefono = numeroTelefono;
        this.operador = operador;
        this.caracteres = contarCaracteres();
    }

    @Override
    public void enviar() {
        if (validarNumero()) {
            if (caracteres > MAX_CARACTERES) {
                System.out.println("[SMS] Advertencia: mensaje excede " + MAX_CARACTERES
                        + " caracteres (" + caracteres + "). Se dividirá en partes.");
            }
            System.out.println("[SMS] Enviando mensaje a: " + numeroTelefono
                    + " (Operador: " + operador + ")");
            System.out.println("      Caracteres usados: " + caracteres + "/" + MAX_CARACTERES);
            setEstado(EstadoNotif.ENVIADO);
            System.out.println("[SMS] Mensaje enviado exitosamente.");
        } else {
            setEstado(EstadoNotif.FALLIDO);
            System.out.println("[SMS] Error: número de teléfono inválido.");
        }
    }

    @Override
    public void registrar() {
        System.out.println("[SMS] Registro en log de mensajes → " + getCodigo()
                + " | Estado: " + getEstado());
    }

    public boolean validarNumero() {
        return numeroTelefono != null && numeroTelefono.matches("\\+?[0-9]{7,15}");
    }

    public int contarCaracteres() {
        return getMensaje() == null ? 0 : getMensaje().length();
    }

    // Getters y Setters
    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }

    public int getCaracteres() { return caracteres; }
}

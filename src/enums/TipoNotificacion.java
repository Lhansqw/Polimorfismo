package enums;

public enum TipoNotificacion {
    PUBLICACION_CALIFICACIONES("Publicación de calificaciones"),
    RECORDATORIO_PAGO("Recordatorio de pago de matrícula"),
    CANCELACION_CLASE("Aviso de cancelación de clase"),
    CONFIRMACION_INSCRIPCION("Confirmación de inscripción a evento académico");

    private final String descripcion;

    TipoNotificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

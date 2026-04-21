import enums.TipoNotificacion;
import model.NotificacionApp;
import model.NotificacionEmail;
import model.NotificacionSMS;
import service.GestorNotificaciones;

public class Main {

    public static void main(String[] args) {

        GestorNotificaciones gestor = new GestorNotificaciones();

        // --- Notificación 1: Email de calificaciones ---
        NotificacionEmail email1 = new NotificacionEmail(
                "NOT-001",
                "Juan Pérez",
                "Sus calificaciones del período 2025-1 ya están disponibles en el portal.",
                TipoNotificacion.PUBLICACION_CALIFICACIONES,
                "Publicación de calificaciones - Período 2025-1",
                "juan.perez@universidad.edu.co",
                "secretaria@universidad.edu.co",
                false
        );

        // --- Notificación 2: SMS de pago ---
        NotificacionSMS sms1 = new NotificacionSMS(
                "NOT-002",
                "María García",
                "Recuerde que el pago de matrícula vence el 30/04/2026.",
                TipoNotificacion.RECORDATORIO_PAGO,
                "+573001234567",
                "Claro"
        );

        // --- Notificación 3: App de cancelación ---
        NotificacionApp app1 = new NotificacionApp(
                "NOT-003",
                "Carlos López",
                "La clase de Cálculo III del martes 22/04 ha sido cancelada.",
                TipoNotificacion.CANCELACION_CLASE,
                "DEVICE-A1B2C3",
                "Android",
                "bell_icon",
                false
        );

        // --- Notificación 4: Email de inscripción a evento ---
        NotificacionEmail email2 = new NotificacionEmail(
                "NOT-004",
                "Ana Torres",
                "Confirmamos su inscripción al Seminario de Investigación 2026.",
                TipoNotificacion.CONFIRMACION_INSCRIPCION,
                "Confirmación de inscripción - Seminario Investigación 2026",
                "ana.torres@universidad.edu.co",
                "",
                true
        );

        // --- Notificación 5: App de pago con confirmación ---
        NotificacionApp app2 = new NotificacionApp(
                "NOT-005",
                "Pedro Ruiz",
                "Quedan 5 días para el pago de su matrícula. Evite recargos.",
                TipoNotificacion.RECORDATORIO_PAGO,
                "DEVICE-X9Y8Z7",
                "iOS",
                "warning_icon",
                true
        );

        // Agregar al gestor
        gestor.agregarNotificacion(email1);
        gestor.agregarNotificacion(sms1);
        gestor.agregarNotificacion(app1);
        gestor.agregarNotificacion(email2);
        gestor.agregarNotificacion(app2);

        // Enviar todas
        gestor.enviarTodas();

        // Listar con info completa
        gestor.listarNotificaciones();

        // Buscar por código
        System.out.println("\n===== BÚSQUEDA POR CÓDIGO =====");
        var encontrada = gestor.buscarPorCodigo("NOT-003");
        if (encontrada != null) {
            System.out.println("Encontrada:");
            encontrada.mostrarInfo();
        }

        // Filtrar por estado ENVIADO
        System.out.println("\n===== NOTIFICACIONES ENVIADAS =====");
        var enviadas = gestor.filtrarPorEstado(enums.EstadoNotif.ENVIADO);
        enviadas.forEach(n -> System.out.println("  - " + n.getCodigo()
                + " (" + n.getClass().getSimpleName() + ")"));

        System.out.println("\nTotal notificaciones gestionadas: " + gestor.totalNotificaciones());
    }
}

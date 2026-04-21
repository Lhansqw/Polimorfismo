package service;

import enums.EstadoNotif;
import model.Notificacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorNotificaciones {

    private List<Notificacion> notificaciones;

    public GestorNotificaciones() {
        this.notificaciones = new ArrayList<>();
    }

    public void agregarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
        System.out.println("Notificación " + notificacion.getCodigo() + " agregada al gestor.");
    }

    public void enviarTodas() {
        System.out.println("\n===== ENVIANDO TODAS LAS NOTIFICACIONES =====");
        for (Notificacion n : notificaciones) {
            System.out.println("\n--- " + n.getCodigo() + " ---");
            n.enviar();
            n.registrar();
        }
        System.out.println("\n===== ENVÍO COMPLETADO =====");
    }

    public Notificacion buscarPorCodigo(String codigo) {
        return notificaciones.stream()
                .filter(n -> n.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Notificacion> filtrarPorEstado(EstadoNotif estado) {
        return notificaciones.stream()
                .filter(n -> n.getEstado() == estado)
                .collect(Collectors.toList());
    }

    public void listarNotificaciones() {
        System.out.println("\n===== LISTADO DE NOTIFICACIONES =====");
        if (notificaciones.isEmpty()) {
            System.out.println("No hay notificaciones registradas.");
            return;
        }
        for (Notificacion n : notificaciones) {
            System.out.println("\n[" + n.getClass().getSimpleName() + "]");
            n.mostrarInfo();
        }
    }

    public int totalNotificaciones() {
        return notificaciones.size();
    }
}

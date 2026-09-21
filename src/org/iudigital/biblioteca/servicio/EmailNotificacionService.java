package org.iudigital.biblioteca.servicio;

public class EmailNotificacionService implements NotificacionService {
    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        System.out.println("[EMAIL enviado a " + destinatario + "]: " + mensaje);
    }
}
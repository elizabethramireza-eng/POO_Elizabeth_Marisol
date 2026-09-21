package org.iudigital.biblioteca.servicio;

import org.iudigital.biblioteca.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class GestionPrestamosService {
    private List<Libro> catalogo = new ArrayList<>(); // Polimorfismo
    private List<Prestamo> prestamos = new ArrayList<>();
    private NotificacionService notificador; // DIP: Depende de la interfaz

    public GestionPrestamosService(NotificacionService notificador) {
        this.notificador = notificador;
    }

    public void registrarLibro(Libro libro) {
        catalogo.add(libro);
    }

    public void mostrarCatalogo() {
        System.out.println("\n=== CATÁLOGO DE LA BIBLIOTECA (Polimorfismo) ===");
        for (Libro l : catalogo) {
            System.out.println(l.obtenerInformacion() + " | Disponible: " + l.estaDisponible());
        }
    }

    public Prestamo realizarPrestamo(String idPrestamo, Usuario usuario, Libro libro) {
        if (!libro.estaDisponible()) {
            System.out.println("Error: El libro '" + libro.getTitulo() + "' no se encuentra disponible.");
            return null;
        }
        Prestamo p = new Prestamo(idPrestamo, usuario, libro, 2000.0);
        prestamos.add(p);
        notificador.enviarNotificacion(usuario.getEmail(), "Préstamo registrado exitosamente para el libro: " + libro.getTitulo());
        return p;
    }
}
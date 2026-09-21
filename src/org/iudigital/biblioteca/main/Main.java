package org.iudigital.biblioteca.main;

import org.iudigital.biblioteca.modelo.*;
import org.iudigital.biblioteca.servicio.*;

public class Main {
    public static void main(String[] args) {
        NotificacionService notificador = new EmailNotificacionService();
        GestionPrestamosService sistema = new GestionPrestamosService(notificador);

        // Autores
        Autor autor1 = new Autor("A01", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A02", "Robert C. Martin", "Estadounidense");

        // Polimorfismo: Objetos subclases asignados a la abstracción Libro
        Libro libro1 = new LibroFisico("978-0307474728", "Cien Años de Soledad", 1967, autor1, "Estante A-3", "Excelente");
        Libro libro2 = new LibroDigital("978-0132350884", "Clean Code", 2008, autor2, "PDF", 12.5, "https://biblioteca.digital/cleancode.pdf");

        // Registrar en sistema
        sistema.registrarLibro(libro1);
        sistema.registrarLibro(libro2);

        // Mostrar Catálogo
        sistema.mostrarCatalogo();

        // Crear Usuario
        Usuario usuario = new Usuario("U100", "Elizabeth Ramírez", "elizabeth@iudigital.edu.co");

        // Transacción de préstamo
        System.out.println("\n=== REGISTRANDO PRÉSTAMO ===");
        Prestamo prestamo1 = sistema.realizarPrestamo("P001", usuario, libro1);

        // Intento de prestamo duplicado
        sistema.realizarPrestamo("P002", usuario, libro1);

        // Estado del catálogo tras el préstamo
        sistema.mostrarCatalogo();
    }
}
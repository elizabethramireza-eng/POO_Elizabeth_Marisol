package org.iudigital.biblioteca.modelo;

import java.util.Date;
import java.util.Calendar;

public class Prestamo {
    private String idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucionEsperada;
    private Date fechaDevolucionReal;
    private Usuario usuario;
    private Libro libro;
    private DetallePrestamo detalle; // Composición

    public Prestamo(String idPrestamo, Usuario usuario, Libro libro, double tarifaMultaDiaria) {
        this.idPrestamo = idPrestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = new Date();
        
        int dias = libro.calcularDiasPrestamo();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaPrestamo);
        cal.add(Calendar.DAY_OF_MONTH, dias);
        this.fechaDevolucionEsperada = cal.getTime();

        // Se compone de DetallePrestamo
        this.detalle = new DetallePrestamo(dias, tarifaMultaDiaria);
        this.libro.cambiarEstadoDisponibilidad(false);
    }

    public void registrarDevolucion() {
        this.fechaDevolucionReal = new Date();
        this.libro.cambiarEstadoDisponibilidad(true);
    }

    public boolean estaVencido() {
        Date comparacion = (fechaDevolucionReal != null) ? fechaDevolucionReal : new Date();
        return comparacion.after(fechaDevolucionEsperada);
    }

    public double calcularMulta() {
        if (!estaVencido()) return 0.0;
        Date comparacion = (fechaDevolucionReal != null) ? fechaDevolucionReal : new Date();
        long diferenciaMillis = comparacion.getTime() - fechaDevolucionEsperada.getTime();
        int diasRetraso = (int) (diferenciaMillis / (1000 * 60 * 60 * 24));
        return detalle.calcularSubtotal(diasRetraso);
    }

    public String getIdPrestamo() { return idPrestamo; }
    public Usuario getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }
    public DetallePrestamo getDetalle() { return detalle; }
}
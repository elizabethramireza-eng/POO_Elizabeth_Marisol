package org.iudigital.biblioteca.modelo;

public class LibroFisico extends Libro {
    private String ubicacionEstante;
    private String estadoConservacion;

    public LibroFisico(String isbn, String titulo, int anioPublicacion, Autor autor, String ubicacionEstante, String estadoConservacion) {
        super(isbn, titulo, anioPublicacion, autor);
        this.ubicacionEstante = ubicacionEstante;
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public String obtenerInformacion() {
        return "Libro Físico [ISBN: " + getIsbn() + ", Título: " + getTitulo() + 
               ", Estante: " + ubicacionEstante + ", Estado: " + estadoConservacion + "]";
    }

    @Override
    public int calcularDiasPrestamo() {
        return 15; // Regla de negocio para libros físicos
    }

    public String getUbicacionEstante() { return ubicacionEstante; }
    public String getEstadoConservacion() { return estadoConservacion; }
}
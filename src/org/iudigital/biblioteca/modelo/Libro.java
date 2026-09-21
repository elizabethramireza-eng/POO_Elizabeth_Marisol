package org.iudigital.biblioteca.modelo;

public abstract class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private boolean disponible;
    private Autor autor;

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
        this.autor = autor;
        if (autor != null) {
            autor.agregarLibroEscrito(this);
        }
    }

    // Método abstracto (Forzado para Polimorfismo)
    public abstract String obtenerInformacion();
    public abstract int calcularDiasPrestamo();

    // Sobrecarga de método
    public void cambiarEstadoDisponibilidad(boolean estado) {
        this.disponible = estado;
    }

    public void cambiarEstadoDisponibilidad(boolean estado, String motivo) {
        this.disponible = estado;
        System.out.println("Disponibilidad de '" + titulo + "' cambiada a " + estado + ". Motivo: " + motivo);
    }

    public boolean estaDisponible() { return disponible; }
    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public Autor getAutor() { return autor; }
}
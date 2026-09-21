package org.iudigital.biblioteca.modelo;

public class LibroDigital extends Libro {
    private String formatoArchivo;
    private double tamanoMB;
    private String urlDescarga;

    public LibroDigital(String isbn, String titulo, int anioPublicacion, Autor autor, String formatoArchivo, double tamanoMB, String urlDescarga) {
        super(isbn, titulo, anioPublicacion, autor);
        this.formatoArchivo = formatoArchivo;
        this.tamanoMB = tamanoMB;
        this.urlDescarga = urlDescarga;
    }

    @Override
    public String obtenerInformacion() {
        return "Libro Digital [ISBN: " + getIsbn() + ", Título: " + getTitulo() + 
               ", Formato: " + formatoArchivo + " (" + tamanoMB + " MB)]";
    }

    @Override
    public int calcularDiasPrestamo() {
        return 30; // Regla de negocio para descargas digitales
    }

    public void descargar() {
        System.out.println("Iniciando descarga desde: " + urlDescarga);
    }

    public String getFormatoArchivo() { return formatoArchivo; }
    public double getTamanoMB() { return tamanoMB; }
    public String getUrlDescarga() { return urlDescarga; }
}
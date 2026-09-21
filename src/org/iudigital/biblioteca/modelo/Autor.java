package org.iudigital.biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String idAutor;
    private String nombre;
    private String nacionalidad;
    private List<Libro> obras; // Agregación: Los libros existen de forma independiente

    public Autor(String idAutor, String nombre, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.obras = new ArrayList<>();
    }

    public void agregarLibroEscrito(Libro libro) {
        this.obras.add(libro);
    }

    public List<Libro> obtenerObraCompleta() {
        return obras;
    }

    public String getIdAutor() { return idAutor; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }
}
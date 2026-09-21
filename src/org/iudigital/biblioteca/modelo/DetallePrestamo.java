package org.iudigital.biblioteca.modelo;

public class DetallePrestamo {
    private int diasConcedidos;
    private double tarifaDiariaMulta;

    public DetallePrestamo(int diasConcedidos, double tarifaDiariaMulta) {
        this.diasConcedidos = diasConcedidos;
        this.tarifaDiariaMulta = tarifaDiariaMulta;
    }

    public double calcularSubtotal(int diasRetraso) {
        if (diasRetraso <= 0) return 0.0;
        return diasRetraso * tarifaDiariaMulta;
    }

    public int getDiasConcedidos() { return diasConcedidos; }
    public double getTarifaDiariaMulta() { return tarifaDiariaMulta; }
}
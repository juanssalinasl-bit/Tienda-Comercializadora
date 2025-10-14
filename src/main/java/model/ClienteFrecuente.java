package model;

import java.util.ArrayList;

public class ClienteFrecuente extends Cliente {

    private int puntosFidelidad;

    public ClienteFrecuente(int cedula, String nombre, String direccion, ArrayList<Factura> listaFactura, int puntosFidelidad) {
        super(cedula, nombre, direccion,  listaFactura);
        this.puntosFidelidad = puntosFidelidad;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    @Override
    public double calcularDescuento(double valor) {
        return valor * 0.05;
    }

    @Override
    public String toString() {
        return "Cliente Corporativo: " +nombre+ "[Cedula: " +cedula+ ", Direccion: " +direccion+ ", Puntos de Fidelidad: " +puntosFidelidad+ "]";
    }
}

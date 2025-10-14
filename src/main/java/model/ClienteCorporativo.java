package model;

import java.util.ArrayList;

public class ClienteCorporativo extends Cliente {

    private String nit;
    private double descuento;

    public ClienteCorporativo(int cedula, String nombre, String direccion, String nit, ArrayList<Factura> listaFactura, double descuento) {
        super(cedula, nombre, direccion, listaFactura);
        this.nit = nit;
        this.descuento = descuento;
    }

    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcularDescuento(double valor) {
        return valor * descuento;
    }

    @Override
    public String toString() {
        return "Cliente Corporativo: " +nombre+ "[Cedula: " +cedula+ ", Direccion: " +direccion+ ", NIT: " +nit+ ", Descuento: " +descuento + "]";
    }
}

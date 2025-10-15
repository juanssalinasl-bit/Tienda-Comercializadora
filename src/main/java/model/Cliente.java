package model;

import java.util.ArrayList;

public abstract class Cliente {
    protected int cedula;
    protected String nombre;
    protected String direccion;
    protected ArrayList<Factura> listaFactura;

    public Cliente(int cedula, String nombre, String direccion, ArrayList<Factura> listaFactura) {
            if(nombre.isBlank() || direccion.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaFactura = new ArrayList<>();
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(ArrayList<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public abstract double calcularDescuento(double valor);

}

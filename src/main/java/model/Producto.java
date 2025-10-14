package model;

import java.util.ArrayList;

public class Producto {
    protected String codigo;
    protected String nombre;
    protected double precioUnitario;
    protected int cantidad;
    protected ArrayList<DetalleFactura> listaDetalleFactura;

    public Producto(String codigo, String nombre, double precioUnitario, int cantidad, ArrayList<DetalleFactura> listaDetalleFactura) {
        if(codigo.isBlank() || nombre.isBlank() ||  precioUnitario <= 0) {
            throw new IllegalArgumentException("Datos ivalidos.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.listaDetalleFactura = listaDetalleFactura;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public ArrayList<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(ArrayList<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }
}

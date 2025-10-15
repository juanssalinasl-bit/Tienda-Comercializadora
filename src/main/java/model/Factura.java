package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {

    protected String codigo;
    protected LocalDate fecha;
    protected double total;
    protected Cliente cliente;
    protected ArrayList<DetalleFactura> listaDetalleFactura;

    public Factura(String codigo, LocalDate fecha, double total, Cliente cliente, ArrayList<DetalleFactura> listaDetalleFactura) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.listaDetalleFactura = listaDetalleFactura != null ? listaDetalleFactura : new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(ArrayList<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public double calcularTotal() {
        double totalSinDescuento = 0;
        for (DetalleFactura m : listaDetalleFactura) {
            double subtotal = m.calcularSubTotal();
            totalSinDescuento += subtotal;
        }
        double descuento = cliente.calcularDescuento(totalSinDescuento);
        total = totalSinDescuento - descuento;
        return total;
    }

    @Override
    public String toString() {
        return "Factura: " + codigo + " [Fecha: " + fecha + ", Cliente: " + cliente.getNombre() +
                ", Total: $" + total + "]";
    }
}

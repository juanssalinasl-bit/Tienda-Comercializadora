package model;

public class DetalleFactura {

    private int cantidadComprada;
    private double subTotal;
    private Producto producto;
    private Factura ownedByFactura;

    public DetalleFactura(int cantidadComprada, double subTotal, Producto producto,  Factura ownedByFactura) {
        this.cantidadComprada = cantidadComprada;
        this.subTotal = subTotal;
        this.producto = producto;
        this.ownedByFactura = ownedByFactura;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getOwnedByFactura() {
        return ownedByFactura;
    }

    public void setOwnedByFactura(Factura ownedByFactura) {
        this.ownedByFactura = ownedByFactura;
    }

    public double calcularSubTotal() {
        Producto producto = getProducto();
        double precio = producto.getPrecioUnitario();
        return  precio * cantidadComprada;
    }
}

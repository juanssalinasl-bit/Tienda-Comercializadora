package model;

import java.util.ArrayList;

public class ProductoElectrodomestico extends Producto {

    private int garantia;

    public ProductoElectrodomestico(String codigo, String nombre, double precioUnitario, int cantidad, ArrayList<DetalleFactura> listaDetalleFactura, int garantia) {
        super(codigo, nombre, precioUnitario, cantidad, listaDetalleFactura);
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return "Producto Electrodomestico: " +nombre+ "[Código: " +codigo+ ", Precio Unitario: " +precioUnitario+ ", Cantidad Disponible: " +cantidad+ ", Garantia (en meses): " +garantia+ "]";
    }
}

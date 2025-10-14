package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductoAlimenticio extends Producto {

    private LocalDate fechaVencimiento;

    public ProductoAlimenticio(String codigo, String nombre, double precioUnitario, int cantidad, ArrayList<DetalleFactura> listaDetalleFactura, LocalDate fechaVencimiento) {
        super(codigo, nombre, precioUnitario, cantidad, listaDetalleFactura);
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Producto Alimenticio: " +nombre+ "[Código: " +codigo+ ", Precio Unitario: " +precioUnitario+ ", Cantidad Disponible: " +cantidad+ ", Fecha de Vencimiento: " +fechaVencimiento+ "]";
    }
}

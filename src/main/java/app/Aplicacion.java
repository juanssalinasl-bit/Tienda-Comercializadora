package app;

import model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacion {

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Tienda Comercializadora", "67346734", "Carrera 15 #12N",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        precargarDatos(empresa);
        int opcionPrincipal;
        do {
            opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog("""
                    === MENU TIENDA COMERCIALIZADORA ===
                    1. Gestion Clientes
                    2. Gestion Productos
                    3. Gestion Facturas
                    4. Salir
                    """));

            switch (opcionPrincipal) {
                case 1 -> menuClientes(empresa);
                case 2 -> menuProductos(empresa);
                case 3 -> menuFacturas(empresa);
                case 4 -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (opcionPrincipal != 4);
    }

    //datos quemados
    public static void precargarDatos(Empresa empresa) {
        Cliente c1 = new ClienteFrecuente(1185858535, "Juan Sebastian", "Calle 15", new ArrayList<>(), 180);
        Cliente c2 = new ClienteFrecuente(1185487455, "Maria Antonieta", "Av. Santiago", new ArrayList<>(), 40);
        Cliente c3 = new ClienteCorporativo(1058785885, "Compucenter S.A", "Zona Comercial", "98548488949", new ArrayList<>(), 0.15);
        Cliente c4 = new ClienteCorporativo(1757858551, "SuperMercado Zapatoca", "Carrera Septima", "984848484", new ArrayList<>(), 0.05);
        Cliente c5 = new ClienteFrecuente(1115637889, "Peter Aguila", "Barrio Manantiales", new ArrayList<>(), 250);

        empresa.registrarCliente(c1);
        empresa.registrarCliente(c2);
        empresa.registrarCliente(c3);
        empresa.registrarCliente(c4);
        empresa.registrarCliente(c5);

        Producto p1 = new ProductoAlimenticio("P1", "Arroz", 14000, 30, new ArrayList<>(), LocalDate.of(2026, 5, 1));
        Producto p2 = new ProductoAlimenticio("P2", "Harina", 7500, 150, new ArrayList<>(), LocalDate.of(2026, 11, 31));
        Producto p3 = new ProductoAlimenticio("P3", "Pollo", 10500, 50, new ArrayList<>(), LocalDate.of(2026, 1, 10));
        Producto p4 = new ProductoElectrodomestico("P4", "Microhondas", 120000, 8, new ArrayList<>(), 30);
        Producto p5 = new ProductoElectrodomestico("P5", "Nevera", 1400000, 7, new ArrayList<>(), 20);

        empresa.registrarProducto(p1);
        empresa.registrarProducto(p2);
        empresa.registrarProducto(p3);
        empresa.registrarProducto(p4);
        empresa.registrarProducto(p5);

        ArrayList<DetalleFactura> detalles1 = new ArrayList<>();
        detalles1.add(new DetalleFactura(2, 0, p1, null));
        Factura f1 = new Factura("F001", LocalDate.now(), 0, c1, detalles1);
        f1.calcularTotal();
        empresa.registrarFactura(f1);

        ArrayList<DetalleFactura> detalles2 = new ArrayList<>();
        detalles2.add(new DetalleFactura(3, 0, p3, null));
        Factura f2 = new Factura("F002", LocalDate.now(), 0, c2, detalles2);
        f2.calcularTotal();
        empresa.registrarFactura(f2);

        ArrayList<DetalleFactura> detalles3 = new ArrayList<>();
        detalles3.add(new DetalleFactura(10, 0, p2, null));
        Factura f3 = new Factura("F003", LocalDate.now(), 0, c3, detalles3);
        f3.calcularTotal();
        empresa.registrarFactura(f3);

        ArrayList<DetalleFactura> detalles4 = new ArrayList<>();
        detalles4.add(new DetalleFactura(8, 0, p4, null));
        Factura f4 = new Factura("F004", LocalDate.now(), 0, c4, detalles4);
        f4.calcularTotal();
        empresa.registrarFactura(f4);

        ArrayList<DetalleFactura> detalles5 = new ArrayList<>();
        detalles5.add(new DetalleFactura(5, 0, p5, null));
        Factura f5 = new Factura("F005", LocalDate.now(), 0, c5, detalles5);
        f5.calcularTotal();
        empresa.registrarFactura(f5);
    }

    //clientes
    public static void menuClientes(Empresa empresa) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    === MENU CLIENTES ===
                    1. Registrar cliente
                    2. Buscar cliente
                    3. Actualizar cliente
                    4. Eliminar cliente
                    5. Mostrar todos los clientes
                    6. Volver
                    """));
            switch (opcion) {
                case 1 -> {
                    try {
                        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula:"));
                        String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
                        String direccion = JOptionPane.showInputDialog("Ingrese direccion:");
                        String[] opciones = {"Frecuente", "Corporativo"};
                        int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de cliente:",
                                "Tipo de cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, opciones, opciones[0]);

                        Cliente cliente;
                        if (tipo == 0) { //frecuente
                            int puntos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los puntos de fidelidad:"));
                            cliente = new ClienteFrecuente(cedula, nombre, direccion, new ArrayList<>(), puntos);
                        } else if (tipo == 1) { //corporativo
                            String nit = JOptionPane.showInputDialog("Ingrese NIT:");
                            double descuento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese descuento (ej: 0.10 para 10%):"));
                            cliente = new ClienteCorporativo(cedula, nombre, direccion, nit, new ArrayList<>(), descuento);
                        } else {
                            JOptionPane.showMessageDialog(null, "Operacion cancelada");
                            break;
                        }

                        JOptionPane.showMessageDialog(null, empresa.registrarCliente(cliente));
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Entrada invalida");
                    } catch (IllegalArgumentException iae) {
                        JOptionPane.showMessageDialog(null, "Error: " + iae.getMessage());
                    }
                }
                case 2 -> {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula a buscar:"));
                    Cliente c = empresa.buscarCliente(cedula);
                    JOptionPane.showMessageDialog(null, (c != null) ? c.toString() : "No encontrado");
                }
                case 3 -> {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del cliente:"));
                    Cliente c = empresa.buscarCliente(cedula);
                    if (c != null) {
                        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:");
                        String nuevaDireccion = JOptionPane.showInputDialog("Nueva dirección:");
                        JOptionPane.showMessageDialog(null, empresa.actualizarCliente(c, nuevoNombre, nuevaDireccion));
                    } else JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                }
                case 4 -> {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del cliente a eliminar:"));
                    JOptionPane.showMessageDialog(null, empresa.eliminarCliente(cedula));
                }
                case 5 -> JOptionPane.showMessageDialog(null, empresa.mostrarClientes());
                case 6 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (opcion != 6);
    }

    //productos
    public static void menuProductos(Empresa empresa) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    === MENU PRODUCTOS ===
                    1. Registrar producto
                    2. Buscar producto
                    3. Actualizar producto
                    4. Eliminar producto
                    5. Mostrar todos los productos
                    6. Volver
                    """));
            switch (opcion) {
                case 1 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese código:");
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio unitario:"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad:"));
                    String[] tipos = {"Alimenticio", "Electrodomestico"};
                    int tipo = JOptionPane.showOptionDialog(null, "Seleccione tipo de producto:",
                            "Tipo de producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, tipos, tipos[0]);
                    Producto p = null;
                    if (tipo == 0) {
                        String fechaStr = JOptionPane.showInputDialog("Ingrese fecha de vencimiento (YYYY-MM-DD):");
                        LocalDate fecha = LocalDate.parse(fechaStr);
                        p = new ProductoAlimenticio(codigo, nombre, precio, cantidad, new ArrayList<>(), fecha);
                    } else if (tipo == 1) {
                        int garantia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese meses de garantía:"));
                        p = new ProductoElectrodomestico(codigo, nombre, precio, cantidad, new ArrayList<>(), garantia);
                    }
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, empresa.registrarProducto(p));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se creó el producto");
                    }
                }
                case 2 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese codigo a buscar:");
                    Producto p = empresa.buscarProducto(codigo);
                    JOptionPane.showMessageDialog(null, (p != null) ? p.toString() : "No encontrado");
                }
                case 3 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese codigo del producto:");
                    Producto p = empresa.buscarProducto(codigo);
                    if (p != null) {
                        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));
                        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad:"));
                        JOptionPane.showMessageDialog(null, empresa.actualizarProducto(p, nuevoPrecio, nuevaCantidad));
                    } else JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
                case 4 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese codigo del producto a eliminar:");
                    Producto p = empresa.buscarProducto(codigo);
                    if (p != null) JOptionPane.showMessageDialog(null, empresa.eliminarProducto(p));
                    else JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
                case 5 -> JOptionPane.showMessageDialog(null, empresa.mostrarProductos());
                case 6 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (opcion != 6);
    }

    //facturas
    public static void menuFacturas(Empresa empresa) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                === MENU FACTURAS ===
                1. Registrar factura
                2. Buscar factura
                3. Actualizar factura
                4. Eliminar factura
                5. Mostrar todas las facturas
                6. Volver
                """));
            switch (opcion) {
                case 1 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese codigo de la factura:");
                    int cedulaCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del cliente:"));
                    Cliente cliente = empresa.buscarCliente(cedulaCliente);
                    if (cliente == null) {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado || Regístrelo primero");
                        break;
                    }

                    ArrayList<DetalleFactura> detalles = new ArrayList<>();
                    boolean agregarMas;

                    do {
                        String codigoProducto = JOptionPane.showInputDialog("Ingrese código del producto:");
                        Producto producto = empresa.buscarProducto(codigoProducto);
                        if (producto == null) {
                            JOptionPane.showMessageDialog(null, "Producto no encontrado || Regístrelo primero");
                            break;
                        }

                        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad comprada:"));
                        if (cantidad > producto.getCantidad()) {
                            JOptionPane.showMessageDialog(null, "No hay suficiente inventario de ese producto");
                            break;
                        }

                        DetalleFactura detalle = new DetalleFactura(cantidad, 0, producto, null);
                        detalles.add(detalle);

                        producto.setCantidad(producto.getCantidad() - cantidad); // disminuir inventario

                        int continuar = JOptionPane.showConfirmDialog(null, "¿Agregar otro producto?", "Detalle factura", JOptionPane.YES_NO_OPTION);
                        agregarMas = (continuar == JOptionPane.YES_OPTION);
                    } while (agregarMas);

                    if (!detalles.isEmpty()) {
                        Factura factura = new Factura(codigo, LocalDate.now(), 0, cliente, detalles);
                        factura.calcularTotal();
                        JOptionPane.showMessageDialog(null, empresa.registrarFactura(factura));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se registraron detalles, factura cancelada.");
                    }
                }

                case 2 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese código de factura:");
                    Factura f = empresa.buscarFactura(codigo);
                    if (f != null) {
                        StringBuilder info = new StringBuilder("=== FACTURA ===\n")
                                .append("Código: ").append(f.getCodigo()).append("\n")
                                .append("Cliente: ").append(f.getCliente().getNombre()).append("\n")
                                .append("Fecha: ").append(f.getFecha()).append("\n")
                                .append("Total: $").append(f.getTotal()).append("\n\n")
                                .append("--- DETALLES ---\n");
                        for (DetalleFactura d : f.getListaDetalleFactura()) {
                            info.append("- Producto: ").append(d.getProducto().getNombre())
                                    .append(" | Cantidad: ").append(d.getCantidadComprada())
                                    .append(" | Subtotal: $").append(d.calcularSubTotal()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, info.toString());
                    } else JOptionPane.showMessageDialog(null, "Factura no encontrada");
                }

                case 3 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese código de la factura a actualizar:");
                    Factura f = empresa.buscarFactura(codigo);
                    if (f != null) {
                        StringBuilder mensaje = new StringBuilder("Factura actual:\n");
                        for (DetalleFactura d : f.getListaDetalleFactura()) {
                            mensaje.append(d.getProducto().getNombre()).append(" (Cant: ")
                                    .append(d.getCantidadComprada()).append(")\n");
                        }
                        JOptionPane.showMessageDialog(null, mensaje.toString());

                        String codigoProducto = JOptionPane.showInputDialog("Ingrese código del producto a modificar:");
                        DetalleFactura detalleEncontrado = null;
                        for (DetalleFactura d : f.getListaDetalleFactura()) {
                            if (d.getProducto().getCodigo().equalsIgnoreCase(codigoProducto)) {
                                detalleEncontrado = d;
                                break;
                            }
                        }

                        if (detalleEncontrado != null) {
                            int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad comprada:"));
                            detalleEncontrado.setCantidadComprada(nuevaCantidad);
                            f.calcularTotal();
                            JOptionPane.showMessageDialog(null, "Detalle actualizado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Producto no encontrado en la factura.");
                        }
                    } else JOptionPane.showMessageDialog(null, "Factura no encontrada");
                }

                case 4 -> {
                    String codigo = JOptionPane.showInputDialog("Ingrese código de factura a eliminar:");
                    Factura f = empresa.buscarFactura(codigo);
                    if (f != null) {
                        JOptionPane.showMessageDialog(null, empresa.eliminarFactura(f));
                    } else JOptionPane.showMessageDialog(null, "Factura no encontrada");
                }

                case 5 -> {
                    StringBuilder listado = new StringBuilder("=== TODAS LAS FACTURAS ===\n");
                    for (Factura f : empresa.getListaFacturas()) {
                        listado.append("\nFactura ").append(f.getCodigo())
                                .append(" | Cliente: ").append(f.getCliente().getNombre())
                                .append(" | Total: $").append(f.getTotal()).append("\n");
                        for (DetalleFactura d : f.getListaDetalleFactura()) {
                            listado.append("   → ").append(d.getProducto().getNombre())
                                    .append(" (x").append(d.getCantidadComprada())
                                    .append(") = $").append(d.calcularSubTotal()).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, listado.toString());
                }

                case 6 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 6);
    }
}

package model;

import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String nit;
    private String direccion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Factura> listaFacturas;

    public Empresa(String nombre, String nit, String direccion, ArrayList<Cliente> listaClientes, ArrayList<Producto> listaProductos, ArrayList<Factura> listaFacturas) {
        if(nombre == null || nombre.isEmpty() || nit == null || nit.isEmpty()) {
            throw  new IllegalArgumentException("El nombre del empleado es obligatorio");
        }
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaFacturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public String registrarCliente(Cliente cliente) {
        Cliente existente = buscarCliente(cliente.getCedula());
        if (existente == null) {
            listaClientes.add(cliente);
            return "Cliente registrado:\n" + cliente.toString();
        } else {
            return "El cliente ya existe.";
        }
    }

    public Cliente buscarCliente(int cedula) {
        for (Cliente m : listaClientes) {
            if (m.getCedula() == cedula) {
                return m;
            }
        }
        return null;
    }

    public String actualizarCliente(Cliente cliente, String nuevoNombre, String nuevaDireccion) {
        Cliente a = buscarCliente(cliente.getCedula());
        if (a != null) {
            a.setNombre(nuevoNombre);
            a.setDireccion(nuevaDireccion);
            return "Cliente actualizado:\n" + a.toString();
        }
        return "El cliente no existe";
    }

    public String eliminarCliente(int cedula) {
        Cliente a = buscarCliente(cedula);
        if (a != null) {
            listaClientes.remove(a);
            return "Cliente eliminado:\n" + a.toString();
        }
        return "El cliente no existe";
    }

    public String mostrarClientes() {
        if (listaClientes.isEmpty()) return "No hay clientes registrados";
        StringBuilder sb = new StringBuilder("=== LISTA DE CLIENTES ===\n");
        for (Cliente m : listaClientes) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }

    public String registrarProducto(Producto producto) {
        Producto existente = buscarProducto(producto.getCodigo());
        if (existente == null) {
            listaProductos.add(producto);
            return "Producto registrado:\n" + producto.toString();
        } else {
            return "El producto ya existe";
        }
    }

    public Producto buscarProducto(String codigo) {
        for (Producto m : listaProductos) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public String actualizarProducto(Producto producto, double nuevoPrecioUnitario, int nuevaCantidad) {
        Producto a = buscarProducto(producto.getCodigo());
        if (a != null) {
            a.setPrecioUnitario(nuevoPrecioUnitario);
            a.setCantidad(nuevaCantidad);
            return "Producto actualizado:\n" + a.toString();
        }
        return "El producto no existe";
    }

    public String eliminarProducto(Producto producto) {
        Producto a = buscarProducto(producto.getCodigo());
        if (a != null) {
            listaProductos.remove(a);
            return "Producto eliminado:\n" + a.toString();
        }
        return "El producto no existe";
    }

    public String mostrarProductos() {
        if (listaProductos.isEmpty()) return "No hay productos registrados.";
        StringBuilder sb = new StringBuilder("=== LISTA DE PRODUCTOS ===\n");
        for (Producto p : listaProductos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public String registrarFactura(Factura factura) {
        Factura existente = buscarFactura(factura.getCodigo());
        if (existente == null) {
            listaFacturas.add(factura);
            return "Factura registrada:\n" + factura.toString();
        } else {
            return "La factura ya existe";
        }
    }

    public Factura buscarFactura(String codigo) {
        for (Factura m : listaFacturas) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }

    public String actualizarFactura(Factura factura, double nuevoTotal, int nuevaCantidadComprada) {
        Factura a = buscarFactura(factura.getCodigo());
        if (a != null) {
            a.setTotal(nuevoTotal);
            for (DetalleFactura m : a.getListaDetalleFactura()) {
                m.setCantidadComprada(nuevaCantidadComprada);
            }
            return "Factura actualizada:\n" + a.toString();
        }
        return "La factura no existe";
    }

    public String eliminarFactura(Factura factura) {
        Factura a = buscarFactura(factura.getCodigo());
        if (a != null) {
            listaFacturas.remove(a);
            return "Factura eliminada:\n" + a.toString();
        }
        return "La factura no existe";
    }

    public String mostrarFacturas() {
        if (listaFacturas.isEmpty()) return "No hay facturas registradas";
        StringBuilder sb = new StringBuilder("=== LISTA DE FACTURAS ===\n");
        for (Factura e : listaFacturas) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}

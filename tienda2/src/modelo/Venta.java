package modelo;

import java.sql.Date;

public class Venta {
    private int ventaID;
    private int clienteID;
    private int empleadoID;
    private Date fechaVenta;
    private double montoTotal;
    private String metodoPago;

    public Venta(int ventaID, int clienteID, int empleadoID, Date fechaVenta, double montoTotal, String metodoPago) {
        this.ventaID = ventaID;
        this.clienteID = clienteID;
        this.empleadoID = empleadoID;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
    }

    public int getVentaID() {
        return ventaID;
    }

    public void setVentaID(int ventaID) {
        this.ventaID = ventaID;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}


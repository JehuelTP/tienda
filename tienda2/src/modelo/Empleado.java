package modelo;

import java.sql.Timestamp;

public class Empleado {
    private int empleadoID;
    private String nombre;
    private String apellido;
    private String puesto;
    private String telefono;
    private String email;
    private Timestamp fechaContratacion;

    public Empleado(int empleadoID, String nombre, String apellido, String puesto, String telefono, String email, Timestamp fechaContratacion) {
        this.empleadoID = empleadoID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.telefono = telefono;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Timestamp fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}


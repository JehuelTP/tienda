package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private Connection conexion;

    public EmpleadoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Obtener todos los empleados
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";

        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Empleado empleado = new Empleado(
                        resultSet.getInt("EmpleadoID"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Apellido"),
                        resultSet.getString("Puesto"),
                        resultSet.getString("Telefono"),
                        resultSet.getString("Email"),
                        resultSet.getTimestamp("FechaContratacion")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los empleados: " + e.getMessage(), e);
        }
        return empleados;
    }

    // Agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO Empleado (Nombre, Apellido, Puesto, Telefono,  Email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(5, empleado.getPuesto());
            stmt.setString(4, empleado.getTelefono());
            stmt.setString(3, empleado.getEmail());
            stmt.executeUpdate();
        }
    }
}
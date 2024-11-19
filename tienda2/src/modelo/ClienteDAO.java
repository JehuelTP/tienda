package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("ClienteID"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Apellido"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telefono"),
                        resultSet.getString("Direccion"),
                        resultSet.getTimestamp("FechaRegistro")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los clientes: " + e.getMessage(), e);
        }
        return clientes;
    }

    // Agregar un nuevo cliente
    public void agregarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (Nombre, Apellido, Email, Telefono, Direccion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.executeUpdate();
        }
    }
}


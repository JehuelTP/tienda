package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private Connection conexion;

    public VentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Registrar una venta
    public void registrarVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO Venta (ClienteID, EmpleadoID, FechaVenta, MontoTotal, MetodoPago) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, venta.getClienteID());
            stmt.setInt(2, venta.getEmpleadoID());
            stmt.setDate(3, venta.getFechaVenta());
            stmt.setDouble(4, venta.getMontoTotal());
            stmt.setString(5, venta.getMetodoPago());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venta.setVentaID(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Obtener todas las ventas
    public List<Venta> obtenerVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Venta";

        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Venta venta = new Venta(
                        resultSet.getInt("VentaID"),
                        resultSet.getInt("ClienteID"),
                        resultSet.getInt("EmpleadoID"),
                        resultSet.getDate("FechaVenta"),
                        resultSet.getDouble("MontoTotal"),
                        resultSet.getString("MetodoPago")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener las ventas: " + e.getMessage(), e);
        }
        return ventas;
    }
}


package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {
    private Connection conexion;

    public PeliculaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Obtener todas las películas
    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM Pelicula";

        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula(
                        resultSet.getInt("PeliculaID"),
                        resultSet.getString("Titulo"),
                        resultSet.getString("Genero"),
                        resultSet.getInt("AñoLanzamiento"),
                        resultSet.getString("Clasificación"),
                        resultSet.getInt("Duracion"),
                        resultSet.getDouble("PrecioVenta"),
                        resultSet.getInt("Stock")
                );
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener las películas: " + e.getMessage(), e);
        }
        return peliculas;
    }

    // Agregar una nueva película
    public void agregarPelicula(Pelicula pelicula) throws SQLException {
        String sql = "INSERT INTO Pelicula (Titulo, Genero, AñoLanzamiento, Clasificación, Duracion, PrecioVenta, Stock) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, pelicula.getTitulo());
            stmt.setString(2, pelicula.getGenero());
            stmt.setInt(3, pelicula.getAñoLanzamiento());
            stmt.setString(4, pelicula.getClasificacion());
            stmt.setInt(5, pelicula.getDuracion());
            stmt.setDouble(6, pelicula.getPrecioVenta());
            stmt.setInt(7, pelicula.getStock());
            stmt.executeUpdate();
        }
    }

    // Actualizar el stock de una película
    public void actualizarStock(int peliculaID, int nuevoStock) throws SQLException {
        String sql = "UPDATE Pelicula SET Stock = ? WHERE PeliculaID = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, nuevoStock);
            stmt.setInt(2, peliculaID);
            stmt.executeUpdate();
        }
    }
}



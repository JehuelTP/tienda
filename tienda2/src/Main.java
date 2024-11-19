import controlador.PeliculaControlador;
import database.ConexionDB;
import modelo.PeliculaDAO;
import vista.PeliculaVista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionDB.getConnection();

            PeliculaDAO peliculaDAO = new PeliculaDAO(conexion);
            PeliculaVista peliculaVista = new PeliculaVista();
            PeliculaControlador peliculaControlador = new PeliculaControlador(peliculaDAO, peliculaVista);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== Menú de Gestión de Películas ===");
                System.out.println("1. Mostrar películas");
                System.out.println("2. Agregar película");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        peliculaControlador.listarPeliculas();
                        break;
                    case 2:
                        peliculaControlador.agregarPelicula();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } while (opcion != 0);

            ConexionDB.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package controlador;

import modelo.Pelicula;
import modelo.PeliculaDAO;
import vista.PeliculaVista;

import java.sql.SQLException;
import java.util.Scanner;

public class PeliculaControlador {
    private PeliculaDAO peliculaDAO;
    private PeliculaVista peliculaVista;

    public PeliculaControlador(PeliculaDAO peliculaDAO, PeliculaVista peliculaVista) {
        this.peliculaDAO = peliculaDAO;
        this.peliculaVista = peliculaVista;
    }

    public void listarPeliculas() {
        peliculaVista.mostrarPeliculas(peliculaDAO.obtenerPeliculas());
    }

    public void agregarPelicula() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el género: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese el año de lanzamiento: ");
        int año = scanner.nextInt();

        System.out.print("Ingrese la clasificación: ");
        String clasificacion = scanner.next();

        System.out.print("Ingrese la duración (en minutos): ");
        int duracion = scanner.nextInt();

        System.out.print("Ingrese el precio de venta: ");
        double precioVenta = scanner.nextDouble();

        System.out.print("Ingrese el stock: ");
        int stock = scanner.nextInt();

        Pelicula nuevaPelicula = new Pelicula(0, titulo, genero, año, clasificacion, duracion, precioVenta, stock);
        peliculaDAO.agregarPelicula(nuevaPelicula);
        System.out.println("Película agregada con éxito.");
    }
}




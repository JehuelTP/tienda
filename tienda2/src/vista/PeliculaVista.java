package vista;

import modelo.Pelicula;

import java.util.List;

public class PeliculaVista {
    public void mostrarPeliculas(List<Pelicula> peliculas) {
        System.out.println("\n*** Lista de Películas ***");
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            System.out.printf("%-5s %-25s %-15s %-10s %-10s %-10s %-5s\n",
                    "ID", "TITULO", "GENERO", "AÑO", "CLASIF.", "PRECIO V.", "STOCK");
            for (Pelicula pelicula : peliculas) {
                System.out.printf("%-5d %-25s %-15s %-10d %-10s %-10.2f %-5d\n",
                        pelicula.getPeliculaID(), pelicula.getTitulo(), pelicula.getGenero(),
                        pelicula.getAñoLanzamiento(), pelicula.getClasificacion(),
                        pelicula.getPrecioVenta(), pelicula.getStock());
            }
        }
    }
}


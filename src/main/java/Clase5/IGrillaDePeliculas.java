package Clase5;

public interface IGrillaDePeliculas {
    Pelicula getPelicula(String nombre) throws PeliculaNoHabilitadaException;
}

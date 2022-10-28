package Clase5;

public class PeliculaNoHabilitadaException extends Exception{
    public PeliculaNoHabilitadaException() {
        super("La pelicula no esta habilitada en tu pais");
    }
}

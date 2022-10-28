package Clase5;

public class GrillaDePeliculasProxy implements IGrillaDePeliculas{
    private IP ip;
    private final GrillaDePeliculas grillaDePeliculas;

    enum paises {
        ARGENTINA,
        BRASIL,
        COLOMBIA
    }

    public GrillaDePeliculasProxy(IP ip, GrillaDePeliculas grillaDePeliculas) {
        this.ip = ip;
        this.grillaDePeliculas = grillaDePeliculas;
    }

    @Override
    public Pelicula getPelicula(String nombre) throws PeliculaNoHabilitadaException {
        paises paisActual = paises.ARGENTINA;
        if(ip.primero() < 50){
            paisActual = paises.ARGENTINA;
        }
        else if(ip.primero() < 100){
            paisActual = paises.BRASIL;
        }
        else if(ip.primero() < 150){
            paisActual = paises.COLOMBIA;
        }

        if(grillaDePeliculas.getPelicula(nombre).pais().equals(paisActual.toString())){
            return grillaDePeliculas.getPelicula(nombre);
        }
        else if(grillaDePeliculas.getPelicula(nombre)==null){
            return null;
        }
        else{
            throw new PeliculaNoHabilitadaException();
        }
    }
}

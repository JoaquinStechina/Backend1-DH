package Clase5;

import java.util.ArrayList;

public class GrillaDePeliculas implements IGrillaDePeliculas{
    private ArrayList<Pelicula> grilla;

    public GrillaDePeliculas(ArrayList<Pelicula> grilla) {
        this.grilla = grilla;
    }

    @Override
    public Pelicula getPelicula(String nombre) {
        for (Pelicula a: grilla) {
            if(a.nombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }
}

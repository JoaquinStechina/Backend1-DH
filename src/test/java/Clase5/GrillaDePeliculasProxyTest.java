package Clase5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrillaDePeliculasProxyTest {

    @Test
    void getPelicula() throws PeliculaNoHabilitadaException {
        //GIVEN
        var arraicin = new ArrayList<Pelicula>();
        arraicin.add(new Pelicula("lucas rojo","ARGENTINA","asdf"));
        arraicin.add(new Pelicula("lucas azul","ARGENTINA","asdf"));
        arraicin.add(new Pelicula("lucas celeste","BRASIL","asdf"));
        arraicin.add(new Pelicula("lucas amarillo","COLOMBIA","asdf"));
        var ipcin = new IP(40,40,40,40);
        var grillin = new GrillaDePeliculas(arraicin);
        var grillinProxy = new GrillaDePeliculasProxy(ipcin,grillin);

        //WHEN
        var aux = grillinProxy.getPelicula("lucas rojo");
        //THEN
        assertEquals(grillinProxy.getPelicula("lucas rojo"),aux);
    }
}
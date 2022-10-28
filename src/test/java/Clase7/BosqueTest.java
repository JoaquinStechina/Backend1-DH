package Clase7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BosqueTest {

    @Test
    void bosque() {
        var bosque = new Bosque();

        for (var i = 0; i < 500000; i++){
            Arbol arbol = ArbolFactory.getArbol("Frutal");
            bosque.agregarArbol(arbol);
        }
        for (var i = 0; i < 500000; i++){
            Arbol arbol = ArbolFactory.getArbol("Ornamental");
            bosque.agregarArbol(arbol);
        }

        System.out.println("El bosque tiene "+bosque.getBosque().size()+" arboles");

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
package Clase7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolTest {
    @Test
    void arbol(){
        var arbol1 = new Arbol(100,100,"Rojo","Prueba");
        var arbol2 = new Arbol(100,100,"Rojo","Prueba");

        assertEquals(arbol1,arbol2);
    }
}
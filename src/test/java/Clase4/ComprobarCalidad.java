package Clase4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComprobarCalidad {

    @Test
    @DisplayName("Validando calidad en todos los procesos")
    void validarCalidadDelProducto() {
        var aux = new Articulo("Backend",1500,1250,"sano");
        AnalistaDeCalidad analista = new Lote();
        analista.validarCalidadDelProducto(aux);
    }

    @Test
    void getSigProceso() {
    }

    @Test
    void setSigProceso() {
    }
}
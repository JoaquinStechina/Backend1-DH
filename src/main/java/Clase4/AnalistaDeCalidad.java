package Clase4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AnalistaDeCalidad {
    private AnalistaDeCalidad sigProceso;
    public abstract void validarCalidadDelProducto(Articulo aux);
}

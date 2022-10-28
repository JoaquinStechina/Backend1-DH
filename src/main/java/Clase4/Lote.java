package Clase4;

public class Lote extends AnalistaDeCalidad{
    @Override
    public void validarCalidadDelProducto(Articulo aux) {
        if(aux.lote() >= 1000 && aux.lote() <= 2000){
            System.out.println("Proceso de lote pasado con exito");
            this.setSigProceso(new Peso());
            this.getSigProceso().validarCalidadDelProducto(aux);
        }
        else{
            System.out.println("El lote es incorrecto");
        }
    }
}

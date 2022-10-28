package Clase4;

public class Peso extends AnalistaDeCalidad{
    @Override
    public void validarCalidadDelProducto(Articulo aux) {
        if(aux.peso() >= 1200 && aux.peso() <= 1300){
            System.out.println("Proceso de peso pasado con exito");
            this.setSigProceso(new Envase());
            this.getSigProceso().validarCalidadDelProducto(aux);
        }
        else{
            System.out.println("El peso es incorrecto");
        }
    }
}

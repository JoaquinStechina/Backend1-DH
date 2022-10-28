package Clase4;

public class Envase extends AnalistaDeCalidad{
    private boolean finish = false;
    @Override
    public void validarCalidadDelProducto(Articulo aux) {
        if(aux.envase().equals("sano") || aux.envase().equals("casi sano")){
            this.finish = true;
            System.out.println("Todos los procesos fueron pasados con exito");
        }
        else{
            System.out.println("El envase es incorrecto");
        }
    }

    public boolean getFinish(){return this.finish;}
}

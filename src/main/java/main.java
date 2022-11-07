import Facade.ContactoFacade;
import Model.Contactos;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        var cf = new ContactoFacade();
        var aux1 = new Contactos("Pablo","pussydestroyer@gmail.com",42069);
        var aux2 = new Contactos("Matias","aplanalp@hotmail.com",1212);
        var aux3 = new Contactos("Joaquin","asdf@yopmail.com",9009);
        var aux4 = new Contactos("Tucho","tuchoDH@DHH.com",80085);

        ArrayList contactos = new ArrayList<>();

        contactos.add(aux1);
        contactos.add(aux2);
        contactos.add(aux3);
        contactos.add(aux4);

        cf.guardarContactos(contactos);
        cf.traerContactos("contactos.txt");
    }
}

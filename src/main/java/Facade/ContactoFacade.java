package Facade;

import Model.Contactos;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.List;

@NoArgsConstructor
public class ContactoFacade {
    public void guardarContactos(List<Contactos> contactos) throws FileNotFoundException {
        try(var fo = new FileOutputStream("contactos.txt");
            var oos = new ObjectOutputStream(fo)) {
            oos.writeObject(contactos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void traerContactos(String nombre_archivo){
        try(var fi = new FileInputStream(nombre_archivo);
            var ois = new ObjectInputStream(fi)){
            System.out.println(ois.readObject());
        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

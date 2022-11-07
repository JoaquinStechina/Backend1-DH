package Model;

import java.io.*;

public record Contactos(String nombre, String mail, int telefono) implements Serializable {
}

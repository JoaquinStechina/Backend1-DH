package Clase14.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Medicamento {
    private String codigo_numerico, nombre, lab;
    private int cant;
    private double precio;
    private long id;
    public Medicamento(String codigo_numerico, String nombre, String lab) {
        this.codigo_numerico=codigo_numerico;
        this.nombre = nombre;
        this.lab = lab;
        this.id=1000;
        this.cant = 1;
        this.precio = 99.99;
    }
}

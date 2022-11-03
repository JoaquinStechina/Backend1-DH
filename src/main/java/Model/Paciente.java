package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
public class Paciente {
    private long id;
    private String apellido;
    private String nombre;
    private String DNI;
    private Date fecha_ingreso;
    private Domicilio domicilio;
}

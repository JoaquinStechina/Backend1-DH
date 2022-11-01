package Clase14.DAO.impl;

import Clase14.model.Medicamento;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoDAOH2Test {

    @Test
    void registrar() {
        Medicamento auxMedicamento = null;
        var PatronDAOH2 = new MedicamentoDAOH2();

        assertThrows(SQLException.class,()->PatronDAOH2.registrar(auxMedicamento));
    }

    @Test
    void buscar() {
        //Falta crear tabla
        var auxMedicamento = new Medicamento("1234","AriRework","DH");

        var PatronDAOH2 = new MedicamentoDAOH2();

         assertEquals(auxMedicamento,PatronDAOH2.buscar("1234"));
    }
}
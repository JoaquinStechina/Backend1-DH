package Clase14.DAO;

import Clase14.model.Medicamento;

public interface MedicamentoDAO {
    void registrar(Medicamento med);
    Medicamento buscar(String cod_num);
}

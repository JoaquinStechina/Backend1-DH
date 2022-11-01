package Clase14.services;

import Clase14.DAO.MedicamentoDAO;
import Clase14.model.Medicamento;

public class MedicamentoService {
    private MedicamentoDAO medicamentoDAO;

    public MedicamentoService(MedicamentoDAO medicamentoDAO) {
        this.medicamentoDAO = medicamentoDAO;
    }

    public MedicamentoDAO getMedicamentoDAO() {
        return medicamentoDAO;
    }

    public void setMedicamentoDAO(MedicamentoDAO medicamentoDAO) {
        this.medicamentoDAO = medicamentoDAO;
    }

    public void RegistrarMedicamento(Medicamento medicamento){
        this.getMedicamentoDAO().registrar(medicamento);
    }

    public Medicamento buscarMedicamento(String codigo_numerico){
        return this.getMedicamentoDAO().buscar(codigo_numerico);
    }
}

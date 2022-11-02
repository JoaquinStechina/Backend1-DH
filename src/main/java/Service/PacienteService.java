package Service;

import DAO.Impl.DomicilioDAOH2;
import DAO.Impl.PacienteDAOH2;
import Model.Domicilio;
import Model.Paciente;

public class PacienteService {
    private final PacienteDAOH2 pacienteDAO = new PacienteDAOH2();
    private final DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

    public void darAltaPaciente(Paciente paciente, Domicilio domicilio){
        pacienteDAO.darAltaPaciente(paciente);
        domicilioDAOH2.darAltaPaciente(domicilio);
    }

    public Paciente buscarPaciente(long id){
        return pacienteDAO.buscar(id);
    }

    public void eliminarPaciente(long id){
        pacienteDAO.eliminar(id);
        domicilioDAOH2.eliminar(id);
    }

    public void modificarPaciente(Paciente paciente){
        pacienteDAO.modificar(paciente);
    }
}

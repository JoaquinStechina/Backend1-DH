package DAO.Impl;

import DAO.PatronDAO;
import Model.Domicilio;
import Model.Paciente;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PacienteDAOH2 implements PatronDAO<Paciente> {
    private static final String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    private static final Logger logger = LogManager.getLogger(PacienteDAOH2.class);
    private static final DomicilioDAOH2 DOMICILIO_DAOH2 = new DomicilioDAOH2();

    @Override
    public void darAltaPaciente(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //1-Conectarme
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Sentenciar
            preparedStatement = connection.prepareStatement("INSERT INTO pacientes VALUES(?,?,?,?,?,?)");
            preparedStatement.setLong(1,paciente.getId());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3,paciente.getNombre());
            preparedStatement.setString(4,paciente.getDNI());
            preparedStatement.setDate(5,paciente.getFecha_ingreso());
            preparedStatement.setLong(6,paciente.getDomicilio().id());

            //3-Ejecutar
            preparedStatement.executeUpdate();
            logger.info("Se ha dado de alta con exito un paciente");
            preparedStatement.close();

        }catch (SQLException e){
            logger.error("Hubo un error al dar de alta: "+e.getMessage());
        }
    }

    @Override
    public Paciente buscar(long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente auxiliar = null;

        try{
            //1-Conectarme
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Sentenciar
            preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE id=?");
            preparedStatement.setLong(1,id);

            //3-Guardar
            ResultSet resultSet = preparedStatement.executeQuery();

            //4-Recorrer los resultados
            while(resultSet.next()){
                long id_paciente = resultSet.getLong(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String DNI = resultSet.getString(4);
                Date fecha_ingreso = resultSet.getDate(5);
                long id_domicilio = resultSet.getLong(6);

                auxiliar.setId(id_paciente);
                auxiliar.setApellido(apellido);
                auxiliar.setNombre(nombre);
                auxiliar.setDNI(DNI);
                auxiliar.setFecha_ingreso(fecha_ingreso);
            }

            logger.info("Se ha encontrado el paciente: "+auxiliar.getId()+" "+auxiliar.getApellido());

        }catch (SQLException e){
            logger.error("Hubo un error al buscar el paciente: "+e.getMessage());
        }

        return auxiliar;
    }

    @Override
    public void eliminar(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //1-Conectarme
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Sentenciar
            preparedStatement = connection.prepareStatement("DELETE FROM pacientes WHERE id=?");
            preparedStatement.setLong(1,id);

            //3-Guardar
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Hubo un error al eliminar el paciente: "+e.getMessage());
        }
    }

    @Override
    public void modificar(Paciente paciente) {

    }
}

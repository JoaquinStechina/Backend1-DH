package DAO.Impl;

import DAO.PatronDAO;
import Model.Domicilio;
import Model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DomicilioDAOH2 implements PatronDAO<Domicilio> {
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    private static final Logger logger = LogManager.getLogger(DomicilioDAOH2.class);
    @Override
    public void darAltaPaciente(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1-Conectarse a la BD
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Preparar la Query
            preparedStatement = connection.prepareStatement("INSERT INTO DOMICILIO VALUES(?,?,?,?,?)");
            preparedStatement.setLong(1,domicilio.id());
            preparedStatement.setString(2,domicilio.calle());
            preparedStatement.setInt(3,domicilio.numero());
            preparedStatement.setString(4,domicilio.localidad());
            preparedStatement.setString(5,domicilio.provincia());

            //3-Ejecutar
            preparedStatement.executeUpdate();

            //4-Cerrar conexion
            connection.close();

        }catch (SQLException e){
            logger.error("Error al agregar el domicilio del paciente: "+e.getMessage());
        }
    }

    @Override
    public Domicilio buscar(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio auxiliar_domicilio = null;

        try{
            //1-Conectarme
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Sentenciar
            preparedStatement = connection.prepareStatement("SELECT * FROM DOMICILIO WHERE ID=?");
            preparedStatement.setLong(1,id);

            //3-Guardar
            ResultSet resultSet = preparedStatement.executeQuery();

            //4-Recorrer los resultados
            while(resultSet.next()){
                long id_domicilio = resultSet.getLong(1);
                String calle = resultSet.getString(2);
                int numero = resultSet.getInt(3);
                String localidad = resultSet.getString(4);
                String provincia = resultSet.getString(5);

                //Construyo domicilio
                auxiliar_domicilio = new Domicilio(id_domicilio,calle,numero,localidad,provincia);
            }

            //5-Cierro la conexion
            connection.close();

        }catch (SQLException e){
            logger.error("Hubo un error al buscar el domicilio: "+e.getMessage());
        }

        return auxiliar_domicilio;
    }

    @Override
    public void eliminar(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //1-Conectarme
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Sentenciar
            preparedStatement = connection.prepareStatement("DELETE FROM domicilio WHERE id=?");
            preparedStatement.setLong(1,id);

            //3-Guardar
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Hubo un error al eliminar el domicilio: "+e.getMessage());
        }
    }

    @Override
    public void modificar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //1-Conectarme
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);

            //2-Sentenciar
            preparedStatement = connection.prepareStatement("UPDATE domicilio SET calle=?, numero=?, localidad=?, provincia=? WHERE id=?");
            preparedStatement.setString(1,domicilio.calle());
            preparedStatement.setInt(2,domicilio.numero());
            preparedStatement.setString(3,domicilio.localidad());
            preparedStatement.setString(4,domicilio.provincia());
            preparedStatement.setLong(5,domicilio.id());

            //3-Guardar
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Hubo un error al modificar el domicilio: "+e.getMessage());
        }
    }
}

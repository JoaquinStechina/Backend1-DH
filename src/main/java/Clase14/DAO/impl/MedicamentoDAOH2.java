package Clase14.DAO.impl;

import Clase14.DAO.MedicamentoDAO;
import Clase14.model.Medicamento;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.*;

public class MedicamentoDAOH2 implements MedicamentoDAO {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
    private final static Logger logger = LogManager.getLogger(MedicamentoDAOH2.class);

    @Override
    public void registrar(Medicamento med) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //1 Levantar el driver y Conectarnos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)");
            preparedStatement.setLong(1,med.getId());
            preparedStatement.setString(2,med.getCodigo_numerico());
            preparedStatement.setString(3,med.getNombre());
            preparedStatement.setString(4,med.getLab());
            preparedStatement.setInt(5,med.getCant());
            preparedStatement.setDouble(6,med.getPrecio());

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            logger.error("Error al registrar el medicamento: "+e.getMessage());
        }
    }

    @Override
    public Medicamento buscar(String cod_num) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento med = null;

        try{
            //1 Levantar el driver y Conectarnos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT codigo_numerico,nombre,lab FROM MEDICAMENTOS where codigo_numerico = ?");
            preparedStatement.setString(1,cod_num);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                String codigo_numerico = result.getString("codigo_numerico");
                String nombre = result.getString("nombre");
                String lab = result.getString("lab");
                med = new Medicamento(codigo_numerico, nombre, lab);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Error al buscar el medicamento: "+e.getMessage());
        }

        return med;
    }
}

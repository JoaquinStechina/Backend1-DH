package Clase12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class main {
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";
    static String addEmpleado(Empleado aux){
        String addEmpleados = "INSERT INTO EMPLEADO VALUES("+aux.id()+",'"+aux.nombre()+"','"+aux.apellido()+"','"+aux.puesto()+"','"+aux.email()+"')";
        return addEmpleados;
    }

    public static void main(String[] args) throws Exception {

        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);

        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:~/Clase11.test", "sa", "");
        Logger logger = LogManager.getLogger(main.class);
        Statement stmt = con.createStatement();

        String createSql = "DROP TABLE IF EXISTS EMPLEADO;\n" +
                "CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NOMBRE VARCHAR(255),APELLIDO VARCHAR(255),PUESTO VARCHAR(255), EMAIL VARCHAR(255))";
        stmt.execute(createSql);

        Empleado e1 = new Empleado(1,"Rodrigo","Batista","PO","asdf@gmail.com");
        Empleado e2 = new Empleado(2,"Mauro","Diaz","DevOps","9898@gmail.com");
        Empleado e3 = new Empleado(2,"Seba","Masero","Backend","sbm@yopmail.com");
        Empleado e4 = new Empleado(4,"Winsley","Jeune","Frontend","qwer@gmail.com");

        stmt.execute(addEmpleado(e1));
        stmt.execute(addEmpleado(e4));

        //Inciso 2
        try{
            stmt.execute(addEmpleado(e2));
            stmt.execute(addEmpleado(e3));
        }catch (Exception e){
            logger.error("Hay dos ID repetidos");
        }

        //Inciso 3
        String updateEmpleado = "UPDATE EMPLEADO SET PUESTO='Testing' WHERE ID=4";
        stmt.executeUpdate(updateEmpleado);

        ResultSet rd = stmt.executeQuery("SELECT * FROM EMPLEADO WHERE ID=4");
        while(rd.next()){
            logger.debug(rd.getInt(1)+rd.getString(2)+rd.getString(3)+rd.getString(4)+rd.getString(5));
        }

        //Inciso 4
        String deleteEmpleado = "DELETE FROM EMPLEADO WHERE ID=2";

        ResultSet rd1 = stmt.executeQuery("SELECT * FROM EMPLEADO WHERE ID=2");
        while (rd1.next()){
            logger.info(rd1.getInt(1)+rd1.getString(2)+rd1.getString(3)+rd1.getString(4)+rd1.getString(5));
        }
        stmt.execute(deleteEmpleado);

        //Inciso 5
        String deleteEmpleado2 = "DELETE FROM EMPLEADO WHERE NOMBRE='Rodrigo'";

        ResultSet rd2 = stmt.executeQuery("SELECT * FROM EMPLEADO WHERE ID=1");
        while (rd2.next()){
            logger.info(rd2.getInt(1)+rd2.getString(2)+rd2.getString(3)+rd2.getString(4)+rd2.getString(5));
        }
        stmt.execute(deleteEmpleado2);
    }
}

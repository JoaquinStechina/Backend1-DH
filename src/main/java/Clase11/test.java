package Clase11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    static String addFigura(Figura aux){
        String addFiguras = "INSERT INTO FIGURA VALUES("+aux.id()+",'"+aux.tipoFigura()+"','"+aux.color()+"')";
        return addFiguras;
    }

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:~/Clase11.test", "sa", "");
        Statement stmt = con.createStatement();

        Figura f1 = new Figura(1,"CIRCULO","AMARILLO");
        Figura f2 = new Figura(2,"CIRCULO","ROJO");
        Figura f3 = new Figura(3,"CIRCULO","ROJO");
        Figura f4 = new Figura(4,"CUADRADO","ROJO");
        Figura f5 = new Figura(5,"CUADRADO","ROJO");

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS FIGURA;\n" +
                "CREATE TABLE FIGURA(ID INT PRIMARY KEY, TIPO VARCHAR(255),COLOR VARCHAR(255));\n";
        stmt.execute(createSql);

        stmt.execute(addFigura(f1));
        stmt.execute(addFigura(f2));
        stmt.execute(addFigura(f3));
        stmt.execute(addFigura(f4));
        stmt.execute(addFigura(f5));

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from FIGURA WHERE TIPO ='CIRCULO' AND COLOR='ROJO' ";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while(rd.next()) {
            System.out.println(rd.getInt(1) +" "+ rd.getString(2)+" "+ rd.getString(3));
        }
    }
}

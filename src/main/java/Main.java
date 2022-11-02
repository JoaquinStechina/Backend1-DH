import Model.Domicilio;
import Model.Paciente;
import Service.PacienteService;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    private final static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void main(String[] args) throws IOException {
        startLogger();

        Date aux = new Date(2022,11,2);

        var service = new PacienteService();
        var paciente = new Paciente(1,"Stechina","Joaquin","123456", aux,
                new Domicilio(1,"111",222,"Tierra","Mundo"));

        service.darAltaPaciente(paciente,paciente.getDomicilio());
    }

    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null, source);
    }
}

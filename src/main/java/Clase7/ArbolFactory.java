package Clase7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class ArbolFactory {
    public static final HashMap<String, Arbol> arFac = new HashMap<>();
    public static final Logger logger = LogManager.getLogger(ArbolFactory.class);
    public static Arbol getArbol(String tipoArbol){
        var clave = "key:"+tipoArbol;

        if(!arFac.containsKey(clave)){
            switch (tipoArbol){
                case "Ornamental":
                    Arbol aux = new Arbol(200,400,"Verde","Ornamental");
                    arFac.put(clave,aux);
                    logger.info("Se creo un arbol ornamental");
                    return arFac.get(clave);
                case "Frutal":
                    Arbol aux1 = new Arbol(100,300,"Rojo","Frutal");
                    arFac.put(clave,aux1);
                    logger.info("Se creo un arbol frutal");
                    return arFac.get(clave);
                case "Floral":
                    Arbol aux2 = new Arbol(100,200,"Celeste","Floral");
                    arFac.put(clave,aux2);
                    logger.info("Se creo un arbol floral");
                    return arFac.get(clave);
                default:
                    return null;
            }
        }
        return arFac.get(clave);
    }
}

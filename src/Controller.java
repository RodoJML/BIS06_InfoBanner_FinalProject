
import java.sql.SQLException;

/**
 * @author Rodolfo Meneses Leal.
 */

public class Controller {
    
    // Instancia un objeto de tipo Model y otro View, para poder acceder a sus metodos.
    Model   banner  = new Model();
    View    view    = new View(banner);
    
    // Metodo que da inicio al programa.
    void starts() throws SQLException{
      
        // Solicita la ruta de la base de datos y se hace la conexion a la misma.
        banner.connect(view.dbPathRequest());
        
        // Una vez cargada la BD se procede a desplegar el banner principal con parametros vacios
        // Para ejecutar en "Modo Default" ver Manual de Usuario para mas detalles.
        view.notificationBar(banner.getLOBs(), "", "", null); 
    }
}


import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodolfo Javier Meneses Leal
 */
public class Tester {
    
    public static void main(String args[]) throws SQLException{
        
        // Se crea un objeto de tipo Controller y se inicializa el metodo start.
        // Para iniciar el programa
        
        Controller c = new Controller();
        
        //Inicia el programa
        c.starts();
    }
   
}

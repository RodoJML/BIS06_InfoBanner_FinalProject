
// Se importan las librerias necesarias para luego conectarse a SQLite
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Rodolfo Javier Meneses Leal
 */

// Clase Modelo, del la estructura Modelo Vista Controlador
// Aqui se encontraran aquellos metodos lógicos que requieren operacion o
// la manipulacion de datos.
public class Model {
    
    // Atributo Connection de la libreria java.sql.Connection;
    // Se inicializa Null sin ninguna informacion.
    Connection con = null;

    // Metodo que hace la conexion con la base de datos.
    // Observe que el metodo toma un parametro de tipo String
    // dbpath es la ruta de la base de datos que provea el usuario.
    void connect(String dbpath){
        
        // Encerramos en un try catch el intento de conexion
        // para asi poder capturar algun error en la conexion.
        try{
            
            // Por convencion de jdbc siempre debe escribirse "jdbc:sqlite:"
            // antes de la ruta de acceso a la base de datos.
            String url = "jdbc:sqlite:" + dbpath;
            
            // Hacemos referencia al atributo de esta clase, de tipo Connection.
            // Establecemos conexion haciendo uso del URL proporcionado por el usuario.
            this.con = DriverManager.getConnection(url);
            
            // Si la conexion es exitosa imprimimos en consola lo siguiente.
            System.out.println("Connection to SQLite has been established.");
            
  
        }
        // Se captura algun error encontrado al intentar conectar y lo muestra en consola
        catch(SQLException ex){
            
            System.out.println(ex.getMessage());
            
        }
    }
    
    // Metodo que lee desde la base de datos las lineas de negocio existentes en las tablas sql
    String[] getLOBs() throws SQLException{
        
        //Consulta
        String query = "select * from LOB";
        
        // Array de caracteres que contendra las lineas de negocio en la base de datos
        String[] LOB = new String[20];
        
        // Haciendo uso del atributo de clase, accedemos al metodo createStatement
        Statement stmt = con.createStatement();
        
        // Indice que se utilizara luego para asignar valores en el array.
        int index = 0;
        
        // se ejecuta el statement
        try(stmt){
            
            // se ejecuta la consulta
            ResultSet rs = stmt.executeQuery(query);
            
            // Mientras alla informacion en la consulta, se guarda en la variable array LOB
            while(rs.next()){
                LOB[index] = rs.getString("NombreLOB");
                index ++;
            }
        }
        catch(SQLException e){
        }
        
        // La funcion devuelve el array de caracteres una vez leidos desde la base de datos
        return LOB;
    }
    
    
    // Metodo que lee desde la base de datos las noticias existentes 
    String getNews(String selectedLOB) throws SQLException{
        
        // Aqui se almacenara el ID en numero, del LOB seleccionado por el usuario.
        // Dicho numero se obtendra despues de consultar una tabla de la BD
        int idLOB = 0;
        
        // Array de caracteres que contendra todas las noticias en la base de datos
        String[] news = new String[10];
        
        // Mensaje por defecto que mostrara el banner si no hay informacion en BD
        // o si la ruta de la BD proporcionada al inicio del programa es incorrecta.
        String newsText = "Base de datos vacia o ruta ingresada incorrecta, "
                        + "reiniciar la aplicacion y intentar de nuevo";
        
        // Indice para asignar valores al array una vez realizada la consulta
        int index = 0;
        
        // Consulta en String
        String query0 = "select idLOB "
                + "     from LOB"
                + "     where NombreLOB = " + "'" + selectedLOB + "'";
        
        // / Haciendo uso del atributo de clase, accedemos al metodo createStatement
        Statement stmt = con.createStatement();
        
        // se ejecuta el statement
        try(stmt){
            
            // se ejecuta la consulta
            ResultSet rs0 = stmt.executeQuery(query0);
            
            // Mientras alla informacion en la consulta, se guarda en la variable idLOB
            while(rs0.next()){
                idLOB = rs0.getInt("idLOB");
            }
            
            // Consulta en String
            String query1 = "select News"
                + "         from newsUpdates"
                + "         where LOBs = " + idLOB;
            
             // se ejecuta la consulta
            ResultSet rs1 = stmt.executeQuery(query1);
            
            // Mientras alla informacion en la consulta, se guarda en la variable newsText
            while(rs1.next()){
                newsText = "";
                news[index] = rs1.getString("News");
                index++;
            }
            
            // Ell array de noticias tiene un tamaño maximo de 10 campos
            // se recorre el array para pasar todo el texto a un solo String
            for(int i = 0; i <= 9; i++){
                
                if(news[i] != null){

                    newsText = newsText + news[i] + "       |       ";
                }
                    
            }

        }
        catch(SQLException e){
            
        }
        // Retornamos 1 solo string de caracteres con toda la informacion
        // esto luego la clasevista lo utilizara para desplegar la informacion
        return newsText; 
    }
    
    String[] getMetrics(String selectedLOB) throws SQLException{
        
        int idLOB  = 0; // Despues de la consulta aqui se almacenara el ID del LOB basado en el parametro de la funcion
        int index  = 0; // Se utilizara luego en un For loop para incrementar el indice y recorrer un array
        
        String[] qaMetrics_query1   = new String[20]; // Se almacenaran las metricas de QA que hay en la base de datos
        String[] opsMetrics_query2  = new String[20]; // Se almacenaran las metricas de OPS que hay en la base de datos
        
        // Este array contendra en solo 2 indices, toda la informacion de tipo string
        // En el indice 0 todas las metricas de calidad
        // En el inidce 1 todas las metricas operacionales
        String[] metrics            = {"Base de datos vacia o ruta ingresada incorrecta, reiniciar la aplicacion y intentar de nuevo",
                                        "Base de datos vacia o ruta ingresada incorrecta, reiniciar la aplicacion y intentar de nuevo"};  // This is the final string we will return as part of this function             
        
        Statement stmt = con.createStatement();       // Here we open the connection with SQL Database    
        
        try(stmt){
            
            // ---- Query 0: Based on the TextName of the selected LOB, we will extract its NumberID
            /**/ String query0 = "select idLOB "                                                         
            /**/ + "              from LOB"                                                              
            /**/ + "              where NombreLOB = " + "'" + selectedLOB + "'";                         
            /**/ 
            /**/ ResultSet rs0 = stmt.executeQuery(query0); // Here we excecute the query string on SQLITE
            /**/
            /**/ while(rs0.next())
            /**/    idLOB = rs0.getInt("idLOB");            // The result of the query is assigned to our variable
            // --------------------------------------------------------------------------------------
            
            
            // ---- Query 1: Here we will extract all the set of QA Metrics that later will be convert into single String
            /**/ String query1 = "Select mc.NombreAtributo, smqa.score "
            /**/                + "From SetMetricasQA smqa, MetricasCalidad mc "
            /**/                + "Where smqa.LineOfBis = " + idLOB + " "
            /**/                + "And smqa.Atributo = mc.idMetricaQA;";
            /**/
            /**/ ResultSet rs1 = stmt.executeQuery(query1);
            /**/
            /**/ while(rs1.next()){
            /**/    qaMetrics_query1[index] = rs1.getString("NombreAtributo")  + " : " + rs1.getString("score") + "%";
            /**/    index++;
            /**/ }
            // ------------------------------------------------------------------------------------
            
            index = 0;
            
            // ---- Query 2: Here we will extract all the set of OPS Metrics that later will be convert into single String
            /**/ String query2 = "Select mo.NombreMetrica, smops.score "
            /**/                + "From SetMetricasOps smops, MetricasOperacionales mo "
            /**/                + "Where smops.LineOfBis = " + idLOB + " "
            /**/                + "And smops.Metrica = mo.idMetricaOps;";
            /**/
            /**/ ResultSet rs2 = stmt.executeQuery(query2);
            /**/
            /**/ while(rs2.next()){
            /**/    opsMetrics_query2[index] = rs2.getString("NombreMetrica")  + " : " + rs2.getString("score") + "%";
            /**/    index++;
            /**/ }
            // ------------------------------------------------------------------------------------
            
            
            // Ell array de metricas tiene un tamaño maximo de 20 campos
            // se recorre el array para pasar todo el texto a un solo String
            for(int i = 0; i <= 19; i++){
                
                // Si la consulta en el indice i no estaba vacia entonces guardamos 
                // ese dato en el espacio 0 del array metrics.
                if(qaMetrics_query1[i] != null){
                    if(i == 0){
                        metrics[0] = "";
                    }
                    metrics[0] = metrics[0] + qaMetrics_query1[i] + "       |       ";
                }
                    
                // Si la consulta en el indice i no estaba vacia entonces guardamos 
                // ese dato en el espacio 1 del array metrics.
                if(opsMetrics_query2[i] != null){
                    if(i == 0){
                        metrics[1] = "";
                    }
                    metrics[1] = metrics[1] + opsMetrics_query2[i] + "      |       ";
                }
                    
            }
            
            
        }
        catch(SQLException e){
        }
        
        // devolvemos el array de 2 indices con toda la informacion de: 
        // metricas de QA (0) y metricas operacionales (1)
        return metrics; 
    }
}



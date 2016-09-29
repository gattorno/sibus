/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseConectar;

import static ClaseConectar.Conectar.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author sierra
 */
public class Conexion {
    private static final  String driver = "org.postgresql.Driver";
    private static final  String base = "sibus";
    private static final  String user = "ti";
    private static final  String password = "arigato";
    private static final  String server = "jdbc:postgresql://localhost:5432/" + base ;
    
    public Conexion() {
    
    }
    public Connection  getConexion(){
        Connection conexion = null;
        try {
            /* Instanciar la base de datos*/
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection( server, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Imposible conectarse al servidor de datos " + e.getMessage(), "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            e.printStackTrace();
        }
        
        
        return conexion;
            
    }
    
    public void desconectar() {
        try {
            conexion.close();
        
        } 
        catch (SQLException exepcionSql)
        {
                exepcionSql.printStackTrace();
        } 
    
    }
        
    
}

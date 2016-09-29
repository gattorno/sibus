
package ClaseConectar;
import java.sql.*;
import javax.swing.*;



public class Conectar {

    public static PreparedStatement prepareStatement(String eli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Connection conect = null;
    
    public static Connection conexion = null;
    //private static final  String base = "ActivosFijos";  //Nombre de base de datos
    private static final  String base = "ActivosFijos";  //Nombre de base de datos
    //private static final  String user = "ti"; // Usuario de conexiòn del servidor sql
    private static final  String user = "postgres"; // Usuario de conexiòn del servidor sql
    //private static final  String password = "arigato"; // Clave de la conexion del servidor sql
    private static final  String password = "arigato"; // Clave de la conexion del servidor sql
    private static final  String driver = "org.postgresql.Driver"; // Driver para conectarse al servidor sql
    //private static final  String server = "jdbc:postgresql://192.168.15.31:5432/" + base; // Nombre del servidor sql
    private static final  String server = "jdbc:postgresql://localhost:5432/" + base; // Nombre del servidor sql
    
    public  void conectar() 
    {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(server, user, password);
            
        
        } catch (ClassNotFoundException | SQLException e) {
      
            JOptionPane.showMessageDialog(null,  "Imposible conectarse al servidor de datos " + e.getMessage(), "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            e.printStackTrace();
        } 
        
    
    }

    public void desconectar()
    {
        try {
            conexion.close();
        
        } 
        catch (SQLException exepcionSql)
        {
                exepcionSql.printStackTrace();
        } 
    
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    

    public Statement conexion() {
        Statement st = null;
        try{
            st = conexion.createStatement();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,  "Imposible conectarse a la base de datos", "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            //e.printStackTrace();
        
        }
        return st;
    }
    
    public  ResultSet slqConsulta (Statement st, String cadena) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(cadena);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,  "Error en instruccion sql" + e.getMessage() + cadena, "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            //e.printStackTrace();
        } catch (Exception ex) {
            System.out.print("No es una exepcion SQLException");
        }
        return rs;
    }
    
    
    public  int slqActualiza (Statement st, String cadena) {
        int rs = -1;
        try {
            rs = st.executeUpdate(cadena);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,  "Error en instruccion sql" + e.getMessage() + cadena, "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            //e.printStackTrace();
        } 
        return rs;
    }
    
    public  void cerrar(ResultSet rs) {
        if (rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,  "No es posible cerrar la consulta" + e.getMessage(), "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
        
            }   
        }
    }
    
    public  void cerrar(java.sql.Statement st) {
        if (st != null){
            try{
                st.close();
                
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "No es posible cerrar la conexion" + e.getMessage(), "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
        
            }
        }
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
       
}



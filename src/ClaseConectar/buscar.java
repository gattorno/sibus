/**
 * 
 */
package ClaseConectar;

import java.sql.*;

/**
 * @author Tomato
 *
 */
public class buscar {

	/**Objeto para conexi�n con la base de datos*/
	Connection conexion = null;
	/**Objeto para ejecuci�n de consultas sql, y retorno de resultados que estas produzcan*/
	Statement sentencia;
	/**Objeto para obtener las filas que retorne la ejecuci�n de la consulta sql*/
	ResultSet resultado;
	
	/**URL de la localizaci�n de la base de datos (jdbc:postgresql://host/basededatos)*/
	String url = "jdbc:postgresql://localhost/ActivosFijos";
	/**Usuario que se conectar� con la base de datos*/
    String usuario = "postgres";
    /**Contrase�a del usuario*/
    String contrasena = "cybinw";
	
	/**
	 * @param args
	 */
	
    /*public static void main(String[] args) {
		JBDPostgreSQL jbdps = new JBDPostgreSQL();
	    String hola=jbdps.consultar("1");
            System.out.print(hola);
	}*/

	
	public String consultar(String con){
	String valor=null;	
            try {
			/*Cargando el controlador postgresql y registrandolo al JDBC*/
			Class.forName("org.postgresql.Driver");
			
			/*obteniendo una instancia del JDBC y conectando a la base de datos*/
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			
			/*Iniciando el objeto para realizar consultas a la base de datos*/
			sentencia = conexion.createStatement();
			
			/*Realizando la consulta, y obteniendo las filas con los resultados que esta produzca*/
			resultado = sentencia.executeQuery("SELECT descripcion FROM activos where codigoactivo="+con);
			
			/*Si la consulta no produjo resultados, no se entrara al while*/
			while (resultado.next()) {
				//System.out.print(resultado.getString(1));
                             valor=resultado.getString(1);
                            
                        }
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			/*Cerrando resultados, sentencias y la conexi�n a la base de datos*/
            try {
                if (resultado != null) {
                	resultado.close();
                }
                if (sentencia != null) {
                	sentencia.close();
                }
                if (conexion != null) {
                	conexion.close();
                }

            } catch (SQLException ex) {
            	ex.printStackTrace();
            }
		}
	//return resultado.getString(1);
          return valor;
       
        }
 public buscar() { 
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modGeneral;
import ClaseConectar.Conexion;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author jhsgattorno
 */
public class gnr_EmpresasDAO {
    Conexion myConexion ;
    gnr_empresas empresa = null;
    PreparedStatement ps = null;
    String cSQL = "";
    
    public gnr_EmpresasDAO () {
        myConexion = new Conexion();
    }

    public void gnr_EmpresaDAO (gnr_empresas empresa) throws SQLException{
        this.empresa = empresa;
        Connection accesoDB = myConexion.getConexion();
        
        
        cSQL = " UPDATE gnr_empresas "
                + " SET empresa_id = ? "
                + " , nombre_empresa = ? "
                + " , rt = ? "
                + " , direccion = ? "
                + " , telefono_1 = ? "
                + " , telefono_2 = ? "
                + " , fax = ? "
                + " , email = ? "
                + " , contacto = ? "
                + " WHERE empresa_id = ? ;" ;

         try {
            ps = accesoDB.prepareStatement(cSQL);
            ps.setString(1, empresa.getcEmpresa_Id());
            ps.setString(2, empresa.getcNombre_Empresa());
            ps.setString(3, empresa.getcRt());
            ps.setString(4, empresa.getcDireccion());
            ps.setString(5, empresa.getcTelefono_1());
            ps.setString(6, empresa.getcTelefono_2());
            ps.setString(7, empresa.getcFax());
            ps.setString(8, empresa.getcEmail());
            ps.setString(9, empresa.getcContacto());
            ps.setString(10, empresa.getcEmpresa_Id()); /*Esto va en el WHERE*/
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Error en instruccion sql" + e.getMessage() + cSQL, "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            ps.close();
            accesoDB.close();
        } 
        
        
        cSQL = "INSERT INTO gnr_empresas "
             + "SELECT ? AS empresa_id "
             + " ,? AS nombre_empresa"
             + " ,? AS rt"
             + " ,? AS direccion"
             + " ,? AS telefono_1"
             + " ,? AS telefono_2"
             + " ,? AS fax"
             + " ,? AS email"
             + " ,? AS contato"
             + " WHERE NOT EXISTS (SELECT * FROM gnr_empresas "
             + "     WHERE empresa_id = ? );" ;
               
        try {
            ps = accesoDB.prepareStatement(cSQL);
            ps.setString(1, empresa.getcEmpresa_Id());
            ps.setString(2, empresa.getcNombre_Empresa());
            ps.setString(3, empresa.getcRt());
            ps.setString(4, empresa.getcDireccion());
            ps.setString(5, empresa.getcTelefono_1());
            ps.setString(6, empresa.getcTelefono_2());
            ps.setString(7, empresa.getcFax());
            ps.setString(8, empresa.getcEmail());
            ps.setString(9, empresa.getcContacto());
            ps.setString(10, empresa.getcEmpresa_Id()); /*Esto va en el WHERE*/
            
              
            ps.executeUpdate();
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,  "Error en instruccion sql" + e.getMessage() + cSQL, "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
           ps.close();
           accesoDB.close();
         
        } finally {
            if(ps != null || ps != null) {
                ps.close();
                accesoDB.close();
            }            
        }
        
        
        
    }
    public gnr_empresas buscar(String empresa_id)  throws SQLException {
        
        Connection accesoDB = myConexion.getConexion();
        cSQL = "SELECT * FROM gnr_Empresas "
                + "WHERE empresa_id = '"+ empresa_id +"'";
        
        try {
            Statement st = accesoDB.createStatement();
            ResultSet rs = st.executeQuery(cSQL);
            if(rs.next()){
                empresa.setcEmpresa_Id(rs.getString(1));
                empresa.setcNombre_Empresa(rs.getString(2));
                empresa.setcRt(rs.getString(3));
                empresa.setcDireccion(rs.getString(4));
                empresa.setcTelefono_1(rs.getString(5));
                empresa.setcTelefono_2(rs.getString(6));
                empresa.setcFax(rs.getString(7));
                empresa.setcEmail(rs.getString(8));
                empresa.setcContacto(rs.getString(9));
                return empresa;
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Error en instruccion sql" + e.getMessage() + cSQL, "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            ps.close();
            accesoDB.close();
         } finally {
            if(ps != null || ps != null) {
                ps.close();
                accesoDB.close();
            }            
        }
         
        return empresa;
         
    }
    
     public gnr_empresas primerRegistro(gnr_empresas myEmpresa)  throws SQLException {
        this.empresa = myEmpresa;
        Connection accesoDB = myConexion.getConexion();
        cSQL = " SELECT * FROM gnr_Empresas "
                + " WHERE empresa_id != '' "
                + " ORDER BY empresa_id "
                + " LIMIT 1";
        
        try {
            Statement st = accesoDB.createStatement();
            ResultSet rs = st.executeQuery(cSQL);
            if(rs.next()){
                empresa.setcEmpresa_Id(rs.getString(1));
                empresa.setcNombre_Empresa(rs.getString(2));
                empresa.setcRt(rs.getString(3));
                empresa.setcDireccion(rs.getString(4));
                empresa.setcTelefono_1(rs.getString(5));
                empresa.setcTelefono_2(rs.getString(6));
                empresa.setcFax(rs.getString(7));
                empresa.setcEmail(rs.getString(8));
                empresa.setcContacto(rs.getString(9));
                return empresa;
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "Error en instruccion sql" + e.getMessage() + cSQL, "Error de conexion", JOptionPane.INFORMATION_MESSAGE );
            ps.close();
            accesoDB.close();
         } finally {
            if(ps != null || ps != null) {
                ps.close();
                accesoDB.close();
            }            
        }
         
        return empresa;
         
    }
}

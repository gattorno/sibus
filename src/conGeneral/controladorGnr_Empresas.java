/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conGeneral;

import modGeneral.gnr_EmpresasDAO;
import modGeneral.gnr_empresas;
import visGeneral.visGnr_empresas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import validaciones.validarTexto;

/**
 *
 * @author jhsgattorno
 */
public class controladorGnr_Empresas implements ActionListener  {
    private final visGnr_empresas vistaEmpresa ;
    private final gnr_EmpresasDAO modeloEmpresas = new gnr_EmpresasDAO();
    private final gnr_empresas empresa = new gnr_empresas();

    private final JTextField txtEmpresa_id;
    private final JTextField txtNombre_empresa;
    private final JTextField txtRt;
    private final JTextField txtDireccion;
    private final JTextField txtTelefono_1;
    private final JTextField txtTelefono_2;
    private final JTextField txtFax;
    private final JTextField txtEmail;
    private final JTextField txtContacto;
    
    public validarTexto validar = new validarTexto();
    
   
    public controladorGnr_Empresas(visGnr_empresas vistaEmpresa){
        this.vistaEmpresa = vistaEmpresa;
       
        txtEmpresa_id = vistaEmpresa.getTxtEmpresa_id();
        txtNombre_empresa = vistaEmpresa.getTxtNombre_Empresa();
        txtRt = vistaEmpresa.getTxtRt();
        txtDireccion = vistaEmpresa.getTxtDireccion();
        txtTelefono_1 = vistaEmpresa.getTxtTelefono_1();
        txtTelefono_2 = vistaEmpresa.getTxtTelefono_2();
        txtFax = vistaEmpresa.getTxtFax();
        txtEmail = vistaEmpresa.getTxtEmail();
        txtContacto = vistaEmpresa.getTxtContacto();
        
        limpiar();
        addListener();
        
        validar.soloNumeros(txtEmpresa_id,15);
        validar.limitarTexto(txtNombre_empresa, 150);
        validar.limitarTexto(txtDireccion, 150);
        validar.soloNumeros(txtTelefono_1, 20);
        validar.soloNumeros(txtTelefono_2, 20);
        validar.soloNumeros(txtFax, 20);
        validar.limitarTexto(txtEmail, 150);
        validar.limitarTexto(txtContacto, 100);
        
        cargarPrimerRegistro();
         
    }

    private void addListener(){
        vistaEmpresa.getBtnGuardar().addActionListener(this);
        vistaEmpresa.getBtnLimpiar().addActionListener(this);
        vistaEmpresa.getBtnSalir().addActionListener(this);
        vistaEmpresa.getTxtEmpresa_id().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == vistaEmpresa.getBtnGuardar()){
            guardar();
        }else if (ae.getSource() == vistaEmpresa.getBtnLimpiar()) {
            limpiar();
        }else if (ae.getSource() == vistaEmpresa.getBtnSalir()){
            vistaEmpresa.dispose();
        }else if (ae.getSource() == vistaEmpresa.getTxtEmpresa_id()) {
             
        }
        
                
    }
          
    private void limpiar(){
       
        txtEmpresa_id.setText("");
        txtNombre_empresa.setText("");
        txtRt.setText("");
        txtDireccion.setText("");
        txtTelefono_1.setText("");
        txtTelefono_2.setText("");
        txtFax.setText("");
        txtEmail.setText("");
        txtContacto.setText("");

    }
    
    private void guardar(){
        empresa.setcEmpresa_Id(vistaEmpresa.getTxtEmpresa_id().getText());
        empresa.setcNombre_Empresa(vistaEmpresa.getTxtNombre_Empresa().getText());
        empresa.setcRt(vistaEmpresa.getTxtRt().getText());
        empresa.setcDireccion(vistaEmpresa.getTxtDireccion().getText());
        empresa.setcTelefono_1(vistaEmpresa.getTxtTelefono_1().getText());
        empresa.setcTelefono_2(vistaEmpresa.getTxtTelefono_2().getText());
        empresa.setcFax(vistaEmpresa.getTxtFax().getText());
        empresa.setcEmail(vistaEmpresa.getTxtEmail().getText());
        empresa.setcContacto(vistaEmpresa.getTxtContacto().getText());

        try {
            modeloEmpresas.gnr_EmpresaDAO(empresa);
        } catch (SQLException ex) {
            Logger.getLogger(controladorGnr_Empresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void cargarPrimerRegistro(){
        try {
            modeloEmpresas.primerRegistro(empresa);
        } catch (SQLException ex) {
            Logger.getLogger(controladorGnr_Empresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtEmpresa_id.setText(empresa.getcEmpresa_Id());
        txtNombre_empresa.setText(empresa.getcNombre_Empresa());
        txtRt.setText(empresa.getcRt());
        txtDireccion.setText(empresa.getcDireccion());
        txtTelefono_1.setText(empresa.getcTelefono_1());
        txtTelefono_2.setText(empresa.getcTelefono_2());
        txtFax.setText(empresa.getcFax());
        txtEmail.setText(empresa.getcEmail());
        txtContacto.setText(empresa.getcContacto());
    }
    
}

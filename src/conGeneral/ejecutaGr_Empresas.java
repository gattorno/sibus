/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conGeneral;
import visGeneral.visGnr_empresas;
import conGeneral.controladorGnr_Empresas;


/**
 *
 * @author jhsgattorno
 */
public class ejecutaGr_Empresas {
    public static void main(String[] args) {
        
        visGnr_empresas miVista = new visGnr_empresas(null, true);
        new controladorGnr_Empresas(miVista);
        miVista.pack();
        miVista.setLocationRelativeTo(null);
        miVista.setVisible(true);

    }
            
}

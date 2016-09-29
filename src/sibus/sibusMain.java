/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sibus;
import visGeneral.frmPrincipal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author sierra
 */
public class sibusMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmPrincipal Menu = new frmPrincipal();
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        Menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Menu.setVisible(true);
        
    }
    
}

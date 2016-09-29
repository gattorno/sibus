/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JTextField;

/**
 *
 * @author jhsga
 */
public class validarTexto {
    
  
    public void validarTexto() throws IOException{
        
    }
    
    public void soloNumeros (JTextField texto) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent eve){
                char caracter = eve.getKeyChar();
                if(Character.isLetter(caracter)){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
            }
        });
    }
    
    public void soloNumeros (JTextField texto, int limite) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent eve){
                char caracter = eve.getKeyChar();
                if(Character.isLetter(caracter)){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
                if(texto.getText().length() == limite ){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
            }
        });
    }
    
    public void soloLetras (JTextField texto)  {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent eve){
                char caracter = eve.getKeyChar();
                if(Character.isDigit(caracter)){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
                
            }
        });
    }
  
        public void soloLetras (JTextField texto, int limite)  {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent eve){
                char caracter = eve.getKeyChar();
                if(Character.isDigit(caracter)){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
                if(texto.getText().length() == limite ){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
            }
        });
    }
    
    public void limitarTexto (JTextField texto, int limite) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent eve){
                
                if(texto.getText().length() == limite ){
                    Toolkit.getDefaultToolkit().beep();
                    eve.consume();
                }
            }
        });
    }
    
    
}

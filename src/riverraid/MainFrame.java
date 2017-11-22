/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import riverraid.EscenarioJuego.Fondo;

/**CLASE QUE MANDA EL NOMBRE DE LA VENTANA*/

public class MainFrame {
   
    public MainFrame(JFrame frame){
        /**SE MANDA NOMBRE DE LA VENTANA Y FRAME*/
        EscenarioJuego ej=new EscenarioJuego("River Raid",frame);
        /**se hace visible la ventana de juego*/
       ej.setVisible(true);
 
        
        
        
     
        
        
    }

    

    
}
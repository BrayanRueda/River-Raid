package riverraid;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;


public class Misil extends JLabel{
  public int x,y,h,w;
  public ImageIcon icon;

   Misil(int x, int y) {
      
        this.x = x;
        this.y = y;
          
        ///////////////////////SE CREA EL MISIL
        Crear();
    } 

    /**RECIBO LA IMAGEN QUE VAA POSEER EL JLABEL DEL MISIL Y LE DOY TAMAÑO Y POSICION */ 
  public void Crear(){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.misil);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
  }
  
  
  /**RETORNO LAS CORDENADAS Y TAMAÑO DEL MISIL*/
    public Rectangle getRectanguloMisil(){
        return getBounds();
    }
    
    /**Enviar el Avion  */
    public JLabel getMisil(){
        return this;}
    
    /**SET COORDENADAS DE ANCHO Y ALTO*/
    public void setXM(int x) {
    setBounds(x,y,w,h);
    this.x=x;
    }
    public void setY(int y) {
     setBounds(x,y,w,h);
    this.y=y;
    }
    public void seth(int h) {
        this.h = h;}
    public void setw(int w) {
        this.w = w;}
}

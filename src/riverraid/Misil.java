package riverraid;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;

/**CLASE QUE CREA LOS MISILES*/
public class Misil extends JLabel{
  public int x,y,h,w;
  public ImageIcon icon;

    Misil(int x, int y) {
      
        this.x = x;
        this.y = y;
          
        Crear();
    } 

    /**METODO QUE RECIBE LA IMAGEN QUE VA A POSEER EL JLABEL DEL MISIL Y LE DA TAMAÑO Y POSICION */ 
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
  
  
    /**METODO QUE RETORNA LAS CORDENADAS Y TAMAÑO DEL MISIL*/
    public Rectangle getRectanguloMisil(){
        return getBounds();
    }
    
    /**METODO QUE ENVIA EL MISIL  */
    public JLabel getMisil(){
        return this;}
    
    /**METODO QUE RECIBE POSICION EN X*/
    public void setXM(int x) {
    setBounds(x,y,w,h);
    this.x=x;
    }
    /**METODO QUE RECIBE POSICION EN Y*/
    public void setY(int y) {
     setBounds(x,y,w,h);
    this.y=y;
    }
    /**METODO QUE RECIBE ANCHO DEL MISIL*/
    public void seth(int h) {
        this.h = h;}
    /**METODO QUE RECIBE ALTO DEL MISIL*/
    public void setw(int w) {
        this.w = w;}
}

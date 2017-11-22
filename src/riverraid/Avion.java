package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;

/**CLASE DONDE SE CREA EL AVION*/
public class Avion extends JLabel{
  public int x,y,h,w;
  public ImageIcon icon;
    
    /**CONSTRUCTOR PARAMETRICO QUE RECIBE POSICION EN X y Y*/
    Avion(int x, int y) {
      
        this.x = x;
        this.y = y;
          
        ////SE CREA EL AVION
        Crear();
    }   

    /**METODO QUE RECIBE LA IMAGEN QUE VA A POSEER EL JLABEL DEL AVION Y LE DA TAMAÑO Y POSICION */ 
    public void Crear(){
      
      //////////////////////////////////////////////CARGO LA IMAGEN DEL AVION
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.Avion);
      
      ////////////////////////////////DOY TAMAÑO Y COORDENADAS
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      ////////////////////////////////////////////////DOY TAMAÑO Y LAS CORDENADAS AL JLABEL DEL AVION
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
    }
 
    /**METODO QUE ENVIA LA POSICION Y TAMAÑO DEL AVION PARA LAS COLICIONES*/
    public Rectangle getRectanguloAvion(){
        return getBounds();
    }
    
    /**METODO QUE ENVIA EL AVION*/
    public JLabel getAvion(){
        return this;}
    
    /**METODO QUE RECIBE LA POSICION EN X DEL AVION*/ 
    public void setXa(int x) {
        setBounds(x,y,w,h);}
    
    /**METODO QUE RECIBE LA POSICION EN Y DEL AVION*/
    public void setY(int y) {
        this.y = y;}
    
    /**METODO QUE RECIBE ALTO DEL AVION*/
    public void setH(int h) {
        this.h = h;}
    
    /**METODO QUE RECIBE ANCHO DEL AVION*/
    public void setW(int w) {
        this.w = w;}
    
    /**METODO QUE RECIBE PARAMETROS DEL AVION*/
    void setAx() {
       setBounds(300,600, w, h);
    }
}

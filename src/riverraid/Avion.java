package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;


public class Avion extends JLabel{
  public int x,y,h,w;
  public ImageIcon icon;

   Avion(int x, int y) {
      
        this.x = x;
        this.y = y;
          
        Crear();
    } 

       
  public void Crear(){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.Avion);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
  }
  
  
  
    public Rectangle getRectanguloAvion(){
        return getBounds();
    }
    /**Enviar el Avion  */
    public JLabel getAvion(){
        return this;}
    /**Set de coordenadas y ancho y alto   */ 
    public void setXa(int x) {
        setBounds(x,y,w,h);}
    public void setY(int y) {
        this.y = y;}
    public void setH(int h) {
        this.h = h;}
    public void setW(int w) {
        this.w = w;}

    void setAx() {
       setBounds(300,600, w, h);
    }
}

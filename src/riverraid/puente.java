
package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;

public class puente extends JLabel{
  public int x,y,h,w,n;
  public ImageIcon icon;

   puente(int x, int y,int n) {
      
        this.x = x;
        this.y = y;
        this.n = n;  
        Crear();
    } 

       
  public void Crear(){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      if(n==1){
      icon=loader.getImagen(ImageLoader.puente1);
      w=icon.getIconWidth();
      h=icon.getIconHeight();
      setIcon(icon);
      setBounds(new Rectangle(x,y,w,h));
      setBounds(x, y, w, h);
      }
      
      if(n==2){
      icon=loader.getImagen(ImageLoader.puente2);
      setIcon(icon);
      w=icon.getIconWidth();
      h=icon.getIconHeight();
      setBounds(new Rectangle(x,y,icon.getIconWidth(),icon.getIconHeight()));
      setBounds(x, y, w, h);
      }  
       
      
  }
  
    /**Enviar el puente  */
    public JLabel getPuente(){
        return this;}
    /**Set de coordenadas y ancho y alto   */ 
    public void setX(int x) {
        setBounds(x,y,w,h);}
    public void setY(int y) {
        this.y = y;}
    public void setH(int h) {
        this.h = h;}
    public void setW(int w) {
        this.w = w;}

      
}

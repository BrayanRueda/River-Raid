package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;


public class enemigos extends JLabel{
  public int x,y,h,w,n;
  public ImageIcon icon;

    enemigos() { 
    } 
   enemigos(int x, int y,int n) {
      
        this.x = x;
        this.y = y;
        this.n = n;
          
        Crear();
    } 

       
  public void Crear(){
      
      if(n==1){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.barco1);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
      }
      if(n==2){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.barco2);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
      }
      if(n==3){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.H1);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
      }
      if(n==4){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
      icon=loader.getImagen(ImageLoader.H2);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
      }
      
      
  }
  
  
  
    public Rectangle getRectanguloAvion(){
        return getBounds();
    }
    /**Enviar el Avion  */
    public JLabel getenemigos(){
        return this;}
    /**Set de coordenadas y ancho y alto   */ 
    public void setXe(int x) {
        setBounds(x,y,w,h);}
    public void setYe(int y) {
        this.y = y;}
    public void setHe(int h) {
        this.h = h;}
    public void setWe(int w) {
        this.w = w;}
    public void setene(int n) {
        this.n = n;}
    public int getene() {
        return n;}
}

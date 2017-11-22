package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;

/**CLASE QUE CREA LOS ENEMIGOS*/
public class Enemigos extends JLabel{
  public int x,y,h,w,n;
  public ImageIcon icon;
    
    /**CONSTRUCTOR POR DEFECTO*/
    Enemigos() { 
    } 
    
    /**CONSTRUCTOR PARAMETRICO QUE RECIBE POSION EN X y Y ADEMAS DEL TIPO DE ENEMIGO*/
    Enemigos(int x, int y,int n) {
      
        this.x = x;
        this.y = y;
        this.n = n;
          
        Crear();
    } 

  /**METODO QUE CREA UN ENEMIGO (HELICOPTERO O BARCO) SEGUN EL VALOR QUE SE RECIBA DE N Y LO UBICA*/     
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
    /**METODO QUE ENVIA LAS COORDENADAS DEL ENEMIGO*/
    public Rectangle getRectanguloAvion(){
        return getBounds();
    }
    /**METODO QUE ENVIA EL ENEMIGO*/
    public JLabel getenemigos(){
        return this;}
    
    /**METODO QUE RECIBE LA POSICION EN X DEL ENEMIGO*/ 
    public void setXe(int x) {
        setBounds(x,y,w,h);}
    
    /**METODO QUE RECIBE LA POSICION EN Y DEL ENEMIGO*/ 
    public void setYe(int y) {
        this.y = y;}
    
    /**METODO QUE RECIBE EL ALTO DEL ENEMIGO*/ 
    public void setHe(int h) {
        this.h = h;}
    
    /**METODO QUE RECIBE EL ANCHO DEL ENEMIGO*/ 
    public void setWe(int w) {
        this.w = w;}
        
    /**METODO QUE RECIBE EL VALOR DE N PARA GENERAR EL TIPO ENEMIGO*/ 
    public void setene(int n) {
        this.n = n;}
    
    /**METODO QUE ENVIA EL VALOR DE N DEL ENEMIGO*/ 
    public int getene() {
        return n;}
}
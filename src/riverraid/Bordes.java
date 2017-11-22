package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import riverraid.ImageLoader;
import static riverraid.ImageLoader.*;

/**CRECION DE LOS BORDES DEL RIO*/

public class Bordes extends JLabel{
  public int x,y,h,w,n;
  public ImageIcon icon;
    
  /////////////////CONSTRUCTOR POR DEFECTO
  Bordes() { 
      
    } 
    
    /**CONSTRUCTOR PARAMETRICO RECIBE CORDENADAS Y NUMERO RESPECTIVO DEL*/
    /**TIPO DE BORDE (O MONTAÑA CAGADA EN LAS IMAGENES)*/
   Bordes(int x, int y,int n) {
      
        this.x = x;
        this.y = y;
        this.n = n;
        
        ////////////////SE CREA LA MONTAÑA
        Crear();
    } 

       
  public void Crear(){
      ImageLoader loader =ImageLoader.getInstance();
      ImageIcon icon; 
     
      
      
      /**DEPENDIENDO DEL VALOR DE N EL JLABEL VA A CARGAR UNA IMAGEN DIFERENTE DE MONTAÑA(O PARED)*/
      /**Y LA UBICARA EN LAS CORDENADAS RECIBIDAS*/
      if(n==1){
      
      icon=loader.getImagen(ImageLoader.pd1);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
      }
      if(n==2){
      
      icon=loader.getImagen(ImageLoader.pd2);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(x, y, w, h);
      }
      if(n==3){
      
      icon=loader.getImagen(ImageLoader.pd3);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x,y,w,h);
      setBounds(x, y, w, h);
      }
      if(n==4){
      
      icon=loader.getImagen(ImageLoader.pd4);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x,y,w,h);
      setBounds(x, y, w, h);
      
      }
      
      if(n==5){
      
      icon=loader.getImagen(ImageLoader.pi1);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
      setBounds(700-w, y, w, h);
      }
      if(n==6){
      
      icon=loader.getImagen(ImageLoader.pi2);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
          
      setBounds(700-w, y, w, h);
      }
      if(n==7){
      
      icon=loader.getImagen(ImageLoader.pi3);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x, y,w,h);
          setBounds(700-w, y, w, h);
      }
      if(n==8){
      
      icon=loader.getImagen(ImageLoader.pi4);
      this.w=icon.getIconWidth();
      this.h=icon.getIconHeight();
      setIcon(icon);
      new Rectangle(x,y,w,h);
      setBounds(700-w, y, w, h);
      
      }
      
  }
     
    
  /**SEA CUAL SEA LA IMAGEN QUE SE CARGUE EN LA PARED, SE LE AGREGAN LAS RESPECTIVAS
     MEDIDAS A SU RECTANGULO*/
  
    public Rectangle getRectanguloAvion(){
        return getBounds();
    }
    /**Enviar el Avion  */
    public JLabel getborde(){
        return this;}
    /**Set de coordenadas y ancho y alto   */ 
    public void setXb(int x) {
        setBounds(x,y,w,h);}
    public void setYb(int y) {
        this.y = y;}
    public void setHb(int h) {
        this.h = h;}
    public void setWb(int w) {
        this.w = w;}
    public void setb(int n) {
        this.n = n;}
}


package riverraid;

import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;

/**CLASE QUE CREA LOS PUENTES*/
public class Puente extends JLabel{
  public int x,y,h,w,n;
  public ImageIcon icon;
  
   /**CONSTRUCTOR PARAMETRICO QUE RECIBE POSCION EN X y Y ADEMAS DEL TIPO DE PUENTE (DESTRUIDO O EN BUEN ESTADO)*/
   Puente(int x, int y,int n) {
      
        this.x = x;
        this.y = y;
        this.n = n;  
        Crear();
    } 

    /**CLASE QUE CARGA LA IMAGEN SEGUN EL VALOR DE N PARA EL PUENTE EN BUEN ESTADO O DAÑADO*/   
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
  
    /**METODO QUE ENVIA EL PUENTE*/
    public JLabel getPuente(){
        return this;}
    
    /**METODO QUE RECIBE POSICION EN X DEL PUENTE*/
    public void setX(int x) {
        setBounds(x,y,w,h);}
    
    /**METODO QUE RECIBE POSICION EN Y DEL PUENTE*/
    public void setY(int y) {
        this.y = y;}
    
    /**METODO QUE RECIBE ANCHO DEL PUENTE*/
    public void setH(int h) {
        this.h = h;}
    
    /**METODO QUE RECIBE ALTO DEL PUENTE*/
    public void setW(int w) {
        this.w = w;}

      
}

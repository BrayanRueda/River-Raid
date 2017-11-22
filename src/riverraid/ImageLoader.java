package riverraid;

import java.net.URL;
import javax.swing.ImageIcon;
/**CLASE QUE CARGA TODAS LAS IMAGENES A SER MOSTRADAS EN EL JUEGO*/

/**CADA VALOR REPRESENTA UNA IMAGEN EN ESPECIFICA QUE VA A SER CARGADA EN EL VECTOR*/
public class ImageLoader {
     private static ImageLoader instance=null;
    
     public static final int TOTAL_IMAGES=37;
     public static final int Avion=0;
     public static final int vida0=1;
     public static final int Fondo=2;
     public static final int barra=3;
     public static final int gasolina=4;
     public static final int barra1=5;
     public static final int vida1=6;
     public static final int vida2=7;
     public static final int barco1=8;
     public static final int barco2=9;
     public static final int misil=10;
     public static final int G1=11;
     public static final int G2=12;
     public static final int G3=13;
     public static final int G4=14;
     public static final int G5=15;
     public static final int G6=16;
     public static final int G7=17;
     public static final int H1=18;
     public static final int H2=19;
     public static final int E1=20;
     public static final int E2=21;
     public static final int E3=22;
     public static final int E4=23;
     public static final int E5=24;
     public static final int E6=25;
     public static final int pd1=26;
     public static final int pd2=27;
     public static final int pd3=28;
     public static final int pi1=29;
     public static final int pi2=30;
     public static final int pi3=31;
     public static final int puente1=32;
     public static final int puente2=33;
     public static final int pi4=34;
     public static final int pd4=35;
     public static final int logo=36;
     
     
     
     
     
     private ImageIcon images[];
     
     /** constructor de la clase en la cual se guardan las URL de las imagenes */
     private ImageLoader() {
     
        String nombres[]=new String[]{"Avion.png", "vida.png","Fondo.png","barra.png","gasolina.png","barra1.png","vida1.png","vida2.png",
        "barco.png","barco1.png","misil.png","G1.png","G2.png","G3.png","G4.png","G5.png","G6.png","G7.png","heplicotero.png","heplicotero2.png","exp1.png",
        "exp2.png","exp3.png","exp4.png","exp5.png","exp6.png","pd1.png","pd2.png","pd3.png","pi1.png","pi2.png","pi3.png","p1.png","p2.png",
        "pi4.png","pd4.png","logo.png"};
        
        /**LLENA EL VECTOR CON LAS RUTAS DE LAS IMAGENES PARA MOSTRARLAS*/
        images = new ImageIcon[TOTAL_IMAGES];
        for(int i=0;i<TOTAL_IMAGES;i++){
            URL url = this.getClass().getResource("image/"+nombres[i]);
            images[i] = new ImageIcon(url);
        }
    }
     
     /** para que haya solo 1 instancia  */
     public static ImageLoader getInstance(){
         if(instance==null)
          instance = new ImageLoader();
         
         return instance ;
     }
     
     /** retorna la imagen */
     public ImageIcon getImagen(int imageId){
     if(imageId<0 || imageId>=TOTAL_IMAGES)
            return null;
        
        return images[imageId];
     }
}

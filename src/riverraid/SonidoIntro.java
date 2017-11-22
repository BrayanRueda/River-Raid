/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;
import java.applet.AudioClip;
import java.net.URL;
/**
 *CLASE QUE EJECUTA EL SONIDO DE AMBIENTACION DEL JUEGO
 * @author CHIRLY
 */
public class SonidoIntro {
    public static AudioClip sonido;
    /**CONSTRUCTOR QUE CARGA LA CANCION DEL JUEGO*/
    public SonidoIntro(){
        URL url = getClass().getResource("sonido/Crawling.mid");
        sonido= java.applet.Applet.newAudioClip(url);
        
    }
    
    /**METODO PARA REPRODUCIR LA CANCION*/
    public void PlaySonido(){
        sonido.play();
    }
    /**METODO PARA DETENER LA CANCION*/
    public void StopSonido(){
        sonido.play();
    }
    
}

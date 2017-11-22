/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;
import java.applet.AudioClip;
import java.net.URL;
/**
 *INTRO DEL JUEGO, SONIDO DE AMBIENTACION
 * @author CHIRLY
 */
public class SonidoIntro {
    public static AudioClip sonido;
    /**CARGO LA CANCION PARA AMBIENTAR EL JUEGO*/
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

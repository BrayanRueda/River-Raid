/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.net.URL;
import static riverraid.SonidoExplosion.sonido2;

/**CLASE QUE EJECUTA EL SONIDO DEL MOTOR DEL AVION
 *
 * @author CHIRLY
 */
public class SonidoAvion {
    public static AudioClip sonido3;
    
    /**CONSTRUCTOR QUE CARGA EL AUDIO DEL AVION*/
    SonidoAvion(){
        URL url = getClass().getResource("sonido/avion.wav");
        sonido3= java.applet.Applet.newAudioClip(url);
    }
    
    /**METODO PARA REPRODUCIR EL SONIDO DEL AVION*/
    public void PlaySonido3(){
        sonido3.play();
    }
    /**METODO PARA DETENER EL SONIDO DEL AVION*/
    public void StopSonido3(){
        sonido3.stop();
    }
}

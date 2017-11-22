/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.net.URL;
import static riverraid.SonidoExplosion.sonido2;

/**EFECTO DE SONIDO DEL MOTOR DEL AVION
 *
 * @author CHIRLY
 */
public class SonidoAvion {
    public static AudioClip sonido3;
    
    /**CARGO EL SONIDO QUE HACE EL AVION EN SU TRAYECTORIA*/
    SonidoAvion(){
        URL url = getClass().getResource("sonido/avion.wav");
        sonido3= java.applet.Applet.newAudioClip(url);
    }
    
    /**METODO PARA REPRODUCIR EL SONIDO*/
    public void PlaySonido3(){
        sonido3.play();
    }
    /**METODO PARA DETENER EL SONIDO*/
    public void StopSonido3(){
        sonido3.stop();
    }
}

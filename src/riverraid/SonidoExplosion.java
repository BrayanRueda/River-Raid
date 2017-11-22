/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.net.URL;
import static riverraid.SonidoIntro.sonido;

/**CLASE QUE EJECUTA EL SONIDO DE LAS EXPLOSIONES
 *
 * @author CHIRLY
 */
public class SonidoExplosion {
    public static AudioClip sonido2;
    
    /**CONSTRUCTOR QUE CARGA EL AUDIO DE EXPLOSION*/
    SonidoExplosion(){
        URL url = getClass().getResource("sonido/explosion.wav");
        sonido2= java.applet.Applet.newAudioClip(url);
    }
    /**METODO QUE REPRODUCE EL SONIDO DE EXLPLOSION*/
    public void PlaySonido2(){
        sonido2.play();
    }
    /**METODO QUE DETIENE EL SONIDO DE EXPLOSION*/
    public void StopSonido2(){
        sonido2.stop();
    }
}

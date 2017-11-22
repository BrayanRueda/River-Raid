/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.net.URL;
import static riverraid.SonidoIntro.sonido;

/**EFECTO DE SONIDO QUE SE EJECUTA CADA VEZ QUE HAY UNA COLICION ENTRE EL AVION CON OTROS OBJETOS O LOS MISILES CON SUS OBJETIVOS
 *
 * @author CHIRLY
 */
public class SonidoExplosion {
    public static AudioClip sonido2;
    
    /**CARGO EL SONIDO DE EXPLOSION*/
    SonidoExplosion(){
        URL url = getClass().getResource("sonido/explosion.wav");
        sonido2= java.applet.Applet.newAudioClip(url);
    }
    /**SE REPRODUCE EL SONIDO*/
    public void PlaySonido2(){
        sonido2.play();
    }
    /**SE DETIENE EL SONIDO*/
    public void StopSonido2(){
        sonido2.stop();
    }
}

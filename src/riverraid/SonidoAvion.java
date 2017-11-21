/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.net.URL;
import static riverraid.SonidoExplosion.sonido2;

/**
 *
 * @author CHIRLY
 */
public class SonidoAvion {
    public static AudioClip sonido3;
    SonidoAvion(){
        URL url = getClass().getResource("sonido/avion.wav");
        sonido3= java.applet.Applet.newAudioClip(url);
    }
    
    public void PlaySonido3(){
        sonido3.play();
    }
    public void StopSonido3(){
        sonido3.stop();
    }
}

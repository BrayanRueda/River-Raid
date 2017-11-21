/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;

import java.applet.AudioClip;
import java.net.URL;
import static riverraid.SonidoIntro.sonido;

/**
 *
 * @author CHIRLY
 */
public class SonidoExplosion {
    public static AudioClip sonido2;
    SonidoExplosion(){
        URL url = getClass().getResource("sonido/explosion.wav");
        sonido2= java.applet.Applet.newAudioClip(url);
    }
    
    public void PlaySonido2(){
        sonido2.play();
    }
    public void StopSonido2(){
        sonido2.stop();
    }
}

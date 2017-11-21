/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riverraid;
import java.applet.AudioClip;
import java.net.URL;
/**
 *
 * @author CHIRLY
 */
public class SonidoIntro {
    public static AudioClip sonido;
    
    public SonidoIntro(){
        URL url = getClass().getResource("sonido/Crawling.mid");
        sonido= java.applet.Applet.newAudioClip(url);
        
    }
    
    public void PlaySonido(){
        sonido.play();
    }
    public void StopSonido(){
        sonido.play();
    }
    
}

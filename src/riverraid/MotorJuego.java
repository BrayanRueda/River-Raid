package riverraid;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import riverraid.EscenarioJuego.Fondo;
import sun.swing.plaf.synth.SynthIcon;
import sun.tools.jar.resources.jar;

/** CLASE DONDE SE INICIA EL TIEMPO Y LOS MOVIMIENTOS DE LOS OBJETOS ASI COMO LAS COLICIONES*/
public class MotorJuego extends EscenarioJuego{
    private JLabel vida,puntaje,gasolina;
    private JLabel gas,exp,tiempo,etiqueta;
    public JLabel[] ma;
     public Avion av;
     public Fondo fn;
     public Enemigos[] ene;
     public Bordes[] bor;
     public Puente[] puentes;
     int ff=5,con=0,z=0;
     int G,vidas,min=0,seg=0,t=0,t_sa=0,seg_sa=0;
     int contT,contS,conM,banV=0,expp=0,banexp, nn[], Dir=-1,banB,rany=0,rb[],posYa=100,posYb=100,py=-1760;;
     private String tiemp,tmin,tseg,puntos,usuario[];
     public Frame menu;
     public EscenarioJuego ej;
    //variables para Score
    private int score,cont,band_s;
    private Timer timerJuego;
    public static String nombre;
    public  static SonidoIntro s= new SonidoIntro();
    public static SonidoExplosion se= new SonidoExplosion();
    public static SonidoAvion sa= new SonidoAvion();
    /**
     *
     */
    
    
    /** Constructor de la clase donde se inician los elementos (vidas,gasolina,score.etc) */
    public MotorJuego() {
        vidas=3;banB=0; G=1205;score=0;
        puntos=String.format("%05d", score);
        puntaje=new JLabel(puntos);
        puntaje.setForeground(Color.YELLOW);
        puntaje.setFont(new Font("Tahoma",Font.BOLD,18));
        puntaje.setBounds(565,0,80,30);
        ImageLoader loader =ImageLoader.getInstance();
        ImageIcon icon;
        icon=loader.getImagen(ImageLoader.G1);
        gasolina=new JLabel(icon);
        gasolina.setBounds(new Rectangle(545,672,icon.getIconWidth(),icon.getIconHeight()));
        icon=loader.getImagen(ImageLoader.gasolina);
        gas=new JLabel(icon);
        gas.setBounds(new Rectangle(300,100,icon.getIconWidth(),icon.getIconHeight()));
        icon=loader.getImagen(ImageLoader.vida0);
        vida=new JLabel(icon);
        vida.setBounds(new Rectangle(50,672,icon.getIconWidth(),icon.getIconHeight()));
        icon=loader.getImagen(ImageLoader.E1);
        exp=new JLabel(icon);
        exp.setBounds(new Rectangle(-100,400,icon.getIconWidth(),icon.getIconHeight()));
        tiempo= new JLabel(tiemp);
        tiempo.setForeground(Color.YELLOW);
        tiempo.setFont(new Font("Tahoma",Font.BOLD,22));
        tiempo.setBounds(340,672,100,30);
        etiqueta= new JLabel("Tiempo");
        etiqueta.setBounds(240,672,100,30);
        etiqueta.setForeground(Color.YELLOW);
        etiqueta.setFont(new Font("Tahoma",Font.BOLD,22));
    }
    
    /**Metodo que recibe el nombre que el usuario ingresa*/
    public void setNom(String nom){
        this.nombre= nom;
    }
    
    /**Metodo donde se reciben los objetos (avion,enemigo, etc) */
    public void iniciar(Avion a,Fondo f,JLabel[] m,Enemigos[] e,Bordes[] b,Puente[] p,Frame frame,EscenarioJuego ejj){
    timerJuego =new Timer(80,new TimerJuego());
    timerJuego.start();
    menu=frame;  menu.setVisible(false);
    av=a;fn=f;ma=m;ene=e;bor=b;puentes=p;ej=ejj;
        
        nn=new int[ene.length];
    for (int  y = 0;  y < ene.length;  y++) {
            if(ene[y].getene()==1||ene[y].getene()==3){
            nn[y]=5;
            }
        }
    
        
    }
    
    /** Metodo que retorna JLabel tiempo*/
    public JLabel getTiempo(){
    return tiempo;
    }
    
    /** Metodo que retorna JLabel etiqueta de tiempo*/
    public JLabel getEtiqueta(){
    return etiqueta;
    }
    
    /** Metodo que retorna JLabel puntos*/
    public JLabel getPuntos(){
    return puntaje;
    }
    
    /** Metodo que retorna JLabel explocion*/
    public JLabel getexp() {
        return exp;
    }
    
    /** Metodo que retorna JLabel vida*/
    public JLabel getVida() {
        return vida;
    }
    
    /** Metodo que retorna JLabel Gasolina*/
    public JLabel getGas() {
        return gas;
    }
    
    /** Metodo que retorna JLabel medidor de gasolina*/
    public JLabel getGasolina() {
        return gasolina;
    }
    
    /** etodo que cambia la velocidad del juego */
    public void setT(int T){
      timerJuego.setDelay(T);
    }
    
    /**Metodo que inicia el tiempo */
    public void StartT(){
      timerJuego.start();
    }
    
    /**Metodo que detiene el tiempo */
    public void StopT(){
        timerJuego.stop();
    }
    
    /**Clase Timer que implementa action Listener para la animacion el juego*/
    class TimerJuego implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            t_sa++;/**contador para el momento en que el sonido del avion acabe*/        
            
            if(band_s==0){
                band_s=1;
                s.PlaySonido();
                sa.PlaySonido3();
            }
            if(band_s==2){
                s.StopSonido();
                sa.StopSonido3();
                band_s=0;
            }            
            
            EscenarioJuego es=new EscenarioJuego();/**se crea instancia de EscenarioJuego*/
            
            boolean a;/**variable para validar las cliciones*/
            banV=0;
            
            /*colicion con puentes*/
            for (int  i = 0;  i < puentes.length;  i+=2) {
                
                if(i<puentes.length){
                puentes[i].setBounds(puentes[i].getX(),puentes[i].getY()+5,puentes[i].getWidth(),puentes[i].getHeight());
                puentes[i+1].setBounds(puentes[i+1].getX(),puentes[i+1].getY()+5,puentes[i+1].getWidth(),puentes[i+1].getHeight());
                a=false;
                a=av.getBounds().intersects(puentes[i].getBounds());
                if(a==true){
                    se.PlaySonido2();
                        exp.setBounds(av.getX(),av.getY(),exp.getWidth(),exp.getHeight());
                        av.setBounds(+900,av.getY(),av.getWidth(),av.getHeight());
                        expp=1;banexp=1;
                //banV++;
                
                 puentes[i+1].setBounds(puentes[i].getX(),puentes[i+1].getY()+5,puentes[i+1].getWidth(),puentes[i+1].getHeight());
                 puentes[i].setBounds(puentes[i].getX()-5000,puentes[i].getY()+5,puentes[i].getWidth(),puentes[i].getHeight());   
                score-=100;
                }
                a=false;
                a=puentes[i].getBounds().intersects(gas.getBounds());
                if(a==true){
                gas.setBounds(gas.getX(),gas.getY()-10,gas.getWidth(),gas.getHeight());
                }
                
                
                    for (int  j = 0;  j < ma.length;  j++) {
                         a=false;
                         a=ma[j].getBounds().intersects(puentes[i].getBounds());
                         if(a==true){
                            score+=150;
                         ma[j].setBounds(ma[j].getX()-6000, ma[j].getY()-15,ma[j].getWidth(),ma[j].getHeight());
                         //
                         se.PlaySonido2();
                         exp.setBounds(puentes[i].getX()+350, puentes[i].getY(), exp.getWidth(), exp.getHeight());
                         expp=1;//
                         puentes[i+1].setBounds(puentes[i].getX(),puentes[i+1].getY()+5,puentes[i+1].getWidth(),puentes[i+1].getHeight());
                         puentes[i].setBounds(puentes[i].getX()-5000,puentes[i].getY()+5,puentes[i].getWidth(),puentes[i].getHeight());
                         }
                        a=false;
                         a=ene[j].getBounds().intersects(puentes[i].getBounds());
                         if(a==true){    
                         ene[j].setBounds(ene[j].getX()-7000, ene[j].getY()-15,ene[j].getWidth(),ene[j].getHeight());
                         }
                        a=false;
                         a=ene[j].getBounds().intersects(puentes[i+1].getBounds());
                         if(a==true){   
                         ene[j].setBounds(ene[j].getX()-7000, ene[j].getY()-15,ene[j].getWidth(),ene[j].getHeight());
                         }
                    } 
                }   
            }
            
            /**movimiento de los enemigos con relacion al tiempo*/
            if(timerJuego.getDelay()==80){
            t+=1.5; G-=3;
               for (int  i = 0;  i < ene.length;  i++) {
                if(ene[i].getene()==1||ene[i].getene()==3){
                   ene[i].setBounds(ene[i].getX()+nn[i],ene[i].getY(),ene[i].getWidth(),ene[i].getHeight());
                 }
               }  
            }
            if(timerJuego.getDelay()==50){
            t+=1; G-=2;
                for (int  i = 0;  i < ene.length;  i++) {
                if(ene[i].getene()==1||ene[i].getene()==3){
                   ene[i].setBounds(ene[i].getX()+nn[i]/2,ene[i].getY(),ene[i].getWidth(),ene[i].getHeight());    
                }
                }
            }
            
            ImageLoader loader =ImageLoader.getInstance();
            ImageIcon icon;
             
           /**movimiento fondo, gasolina*/
           ff+=5;
            fn.setY(ff);
            puntos=String.format("%05d", score);
            puntaje.setText(puntos);
            
            /**movimiento gasolina*/
            gas.setBounds(gas.getX(),gas.getY()+5,gas.getWidth(),gas.getHeight());
            
            /**colicion avion gasolina*/
            a=av.getBounds().intersects( gas.getBounds());
            if(a==true){
                con++;
                if(G<1001&&con>2){
                G=1200;con=0;}
            };
            if(gas.getY()>700){z=2;}
            
            /**coliccion misiles con otros*/
            for(int j=0;j<ma.length;j++){   
                ma[j].setBounds(ma[j].getX(), ma[j].getY()-15,ma[j].getWidth(),ma[j].getHeight());
                if(ma[j].getY()<20){
                ma[j].setBounds(ma[j].getX()+5000, ma[j].getY(),ma[j].getWidth(),ma[j].getHeight());
                }
                a=false;
                a=ma[j].getBounds().intersects( gas.getBounds());
                if(a==true){
                    se.PlaySonido2();
                    score-=5;
                    z=2;
                    exp.setBounds(gas.getX(), gas.getY(), gas.getWidth(), gas.getHeight());
                    expp=1;
                    ma[j].setBounds(-100, ma[j].getY()-10,ma[j].getWidth(),ma[j].getHeight());
                }
            }
            
            /**coliciones enemigos con (varios)*/
            for(int j=0;j<ene.length;j++){
                ene[j].setBounds(ene[j].getX(),ene[j].getY()+5,ene[j].getWidth(),ene[j].getHeight());
                //colicion avion con enemigos
                a=false;
                a=av.getBounds().intersects(ene[j].getBounds());
                    if (a==true){
                    se.PlaySonido2();
                        exp.setBounds(av.getX(),av.getY(),exp.getWidth(),exp.getHeight());
                        av.setBounds(+900,av.getY(),av.getWidth(),av.getHeight());
                        expp=1;banexp=1;
                    //banV++;
                    }
                a=false;
                a=gas.getBounds().intersects(ene[j].getBounds());
                    if(a==true){
                    gas.setBounds(gas.getX(),gas.getY()-10,gas.getWidth(),gas.getHeight());
                    }
                    //enemigos 
                    if(ene[j].getY()>700&&ene[j].getY()<1000){
                    ene[j].setBounds(-100,1001,ene[j].getWidth(),ene[j].getHeight());
                    }
            }
            
            /**coliccion misiles con enemigos*/
            for(int i=0;i<ma.length;i++){
                for(int j=0;j<ene.length;j++){
                a=false;
                a=ma[i].getBounds().intersects( ene[j].getBounds());
                if(a==true){
                    se.PlaySonido2();
                    int x=ene[j].getX(),y=ene[j].getY();
                ene[j].setBounds(-100,ene[j].getY()+5,ene[j].getWidth(),ene[j].getHeight());
                ma[i].setBounds(-200, ma[i].getY()-10,ma[i].getWidth(),ma[i].getHeight());
                score+=25;
                exp.setBounds(x, y,exp.getWidth(),exp.getHeight());
                expp=1;
                }
                }
            }
            
            /**Bordes (movimiento y colicion)*/
            for (int i = 0; i < bor.length; i++) {
                    bor[i].setBounds(bor[i].getX(),bor[i].getY()+5,bor[i].getWidth(),bor[i].getHeight());
                        //avion coliciona con bordes
                        a=false;
                        a=av.getBounds().intersects(bor[i].getBounds());
                        if(a==true){
                        se.PlaySonido2();
                        exp.setBounds(av.getX(),av.getY(),exp.getWidth(),exp.getHeight());
                        av.setBounds(+900,av.getY(),av.getWidth(),av.getHeight());
                        expp=1;banexp=1;
                        }
                        
                        //gasolina con bordes
                        if(i<bor.length){
                        a=false;
                        a=gas.getBounds().intersects(bor[i].getBounds());
                            if(a==true){
                            gas.setBounds(gas.getX()+50,gas.getY(),gas.getWidth(),gas.getHeight());
                            }
                        }
                        if(i>=bor.length){
                        a=false;
                        a=gas.getBounds().intersects(bor[i].getBounds());
                            if(a==true){
                            gas.setBounds(gas.getX()-50,gas.getY(),gas.getWidth(),gas.getHeight());
                            }
                        }//fin gasolina con bordes
                        
                /**enemigo bordes*/ 
                if(banB==0){
                        for(int j=0;j<ene.length;j++){
                            if(i<bor.length/2){
                                a=false;
                                a=bor[i].getBounds().intersects(ene[j].getBounds());
                                if(a==true){
                                ene[j].setBounds(ene[j].getX()+200,ene[j].getY(),ene[j].getWidth(),ene[j].getHeight());
                                }
                            }
                            if(i>=bor.length/2){
                                a=false;
                                a=bor[i].getBounds().intersects(ene[j].getBounds());
                                if(a==true){
                                ene[j].setBounds(ene[j].getX()-200,ene[j].getY(),ene[j].getWidth(),ene[j].getHeight());
                                }
                            }
                        }
                }
                for(int j=0;j<ene.length;j++){
                    if(ene[j].getY()<0){   
                        if(i<bor.length/2){
                        a=false;
                        a=bor[i].getBounds().intersects(ene[j].getBounds());
                            if(a==true){
                            ene[j].setBounds(ene[j].getX()+200,ene[j].getY(),ene[j].getWidth(),ene[j].getHeight());
                            }
                        }
                        if(i>=bor.length/2){
                        a=false;
                        a=bor[i].getBounds().intersects(ene[j].getBounds());
                            if(a==true){
                            ene[j].setBounds(ene[j].getX()-200,ene[j].getY(),ene[j].getWidth(),ene[j].getHeight());
                            }
                        }
                    }
                }//enemigo bordes
                
            }banB=1;
            
            /**Gasolina*/
            if(z==2){
            int x=(int)(Math.random()*500);
            gas.setBounds(x+100,-50,gas.getWidth(),gas.getHeight());
            z=0;
            }
            
            /**movimiento de enemigos*/
            for (int  i = 0;  i < ene.length;  i++) {
                if(ene[i].getene()==1||ene[i].getene()==3){
                   for (int j = 0; j < bor.length; j++) {
                   a=false;
                   a=ene[i].getBounds().intersects(bor[j].getBounds());
                   if(a==true){
                       nn[i]=nn[i]*Dir;
                        if(nn[i]==5){
                            if(ene[i].getene()==1){
                            icon=loader.getImagen(ImageLoader.barco1);
                            ene[i].setIcon(icon);
                            }
                            if(ene[i].getene()==3){
                            icon=loader.getImagen(ImageLoader.H1);
                            ene[i].setIcon(icon);
                            }  
                        }
                        if(nn[i]==-5){
                          if(ene[i].getene()==1){
                            icon=loader.getImagen(ImageLoader.barco2);
                            ene[i].setIcon(icon);
                            }
                            if(ene[i].getene()==3){
                            icon=loader.getImagen(ImageLoader.H2);
                            ene[i].setIcon(icon);
                            }  
                        }
                    }
                   }  
                }  
            }//fin movimiento de enemigos
            
            /**vidad*/
            if(vidas==3){
            loader =ImageLoader.getInstance();
            icon=loader.getImagen(ImageLoader.vida0);
            vida.setIcon(icon);
            }
            if(vidas==2){
            loader =ImageLoader.getInstance();
            icon=loader.getImagen(ImageLoader.vida1);
            vida.setIcon(icon);
            }
            if(vidas==1){
             loader =ImageLoader.getInstance();
            icon=loader.getImagen(ImageLoader.vida2);
            vida.setIcon(icon);
            }
            if(vidas==0){
            loader =ImageLoader.getInstance();
            icon=loader.getImagen(ImageLoader.vida1);
            vida.setBounds(-1000, 0, icon.getIconWidth(),icon.getIconHeight() );
            }
            
            /**explocion*/
            if(expp==1){
            icon=loader.getImagen(ImageLoader.E2);
            exp.setIcon(icon);
            expp++;}
            if(expp==3){
            icon=loader.getImagen(ImageLoader.E3);
            exp.setIcon(icon);
            expp++;}
            if(expp==5){
            icon=loader.getImagen(ImageLoader.E4);
            exp.setIcon(icon);
            expp++;}
            if(expp==7){
            icon=loader.getImagen(ImageLoader.E5);
            exp.setIcon(icon);
            expp++;}
            if(expp==9){
            icon=loader.getImagen(ImageLoader.E6);
            exp.setIcon(icon);
            expp++;}
            if(expp==11){   
            exp.setBounds(-100,0,exp.getWidth(),exp.getHeight());
            if(banexp==1){
            banV++;banexp=0;
            }
            }
            if(expp==2||expp==4||expp==6||expp==8||expp==10){
            expp++;
            }
            
            /**gasolina*/
            if(G<=1220&&G>1000){
            loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G1));
            }
            if(G<999&&G>800){
            loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G2));
            }
            if(G<800&&G>600){
            loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G3));
            }
            if(G<600&&G>400){
            loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G4));
            }
            if(G<400&&G>200){
             loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G5));
            }
            if(G<=200&&G>10){
            loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G6));
            }
            if(G<=10){
             loader =ImageLoader.getInstance();
            gasolina.setIcon(loader.getImagen(ImageLoader.G7));
            banV=1;
            G=1210;
            }//fin gasolina
            
            /**perder vidad*/
            if(banV==1){
            
                av.setBounds(300,600,av.getWidth(),av.getHeight());
                vidas--;
                if(vidas>0){
                    band_s=2;
                    JOptionPane.showMessageDialog(null,"Vidas Restantes= "+vidas);
                }
                av.setAx();
                gas.setBounds(gas.getX(),gas.getY()-250,gas.getWidth(),gas.getHeight());
                for(int j=0;j<ene.length;j++){
                    ene[j].setBounds(ene[j].getX(),ene[j].getY()-250,ene[j].getWidth(),ene[j].getHeight());
                    ma[j].setBounds(ma[j].getX(), ma[j].getY()-500,ma[j].getWidth(),ma[j].getHeight());
                    banB=0;G=1210;
                }
            }
            
            /**se cuenta el Tiempo*/
                tmin= String.format("%02d", min);
                tseg= String.format("%02d", seg);
                tiemp= "("+tmin+":"+tseg+")";
                tiempo.setText(tiemp);
                if(t>20){
                    seg++;
                    t=0;
                }
                if(seg==60){
                    seg=0;
                    min++;
                } 
                
                /**se acabo el juego*/
                if(min==1||vidas==0){
                    score+=vidas*1000;
                    seg++;min++;
                    puntos=String.format("%05d", score);
                    puntaje.setText(puntos);
                    
                    if(vidas>0){
                        cont=0;
                        String arch= "puntuaciones.txt";
                        FileReader fr;
                        BufferedReader br;
                        String linea;
                        
                        try {
                            fr= new FileReader(arch);
                            br= new BufferedReader(fr);
                            while((linea=br.readLine())!=null){
                                cont++;
                            }
                            System.out.println(cont);
                            br.close();
                            
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(MotorJuego.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MotorJuego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        usuario= new String[cont+1];
                        try {
                            fr= new FileReader(arch);
                            br= new BufferedReader(fr);
                            linea= br.readLine();
                            for(int i=0;i<cont;i++){
                                String[] token= linea.split("-");
                                String nom= token[0];
                                String punt= token[1];
                                usuario[i]=nom+"-"+punt;
                                
                                linea=br.readLine();
                            }
                            br.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(MotorJuego.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(MotorJuego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                        usuario[cont]=nombre+"-"+puntos;
                                                
                        for(int j=0;j<cont+1;j++){
                            for(int i=0;i<cont+1;i++){
                                String aux;
                                    if(i<cont){ 
                                    String token1[]= usuario[i].split("-");
                                    String token2[]= usuario[i+1].split("-");
                                    int n= Integer.parseInt(token1[1]);
                                    int m= Integer.parseInt(token2[1]);
                                    if(n<=m){
                                        aux=usuario[i];
                                        usuario[i]= usuario[i+1];
                                        usuario[i+1]=aux;
                                    }
                                }
                            }
                        }
                        for(int i=0;i<cont;i++){
                            System.out.println(usuario[i]);
                        }
                        
                        FileWriter fw;
                        BufferedWriter bw;
                        PrintWriter salArch;
                        
                        try {
                            fw=new FileWriter(arch);
                            bw= new BufferedWriter(fw);
                            salArch= new PrintWriter(bw);
                            for(int i=0;i<cont;i++){
                                salArch.print(usuario[i]);
                                salArch.println();
                            }
                            salArch.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MotorJuego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        

                    }//condicion para crear el archivo con las puntuaciones
                    
                JOptionPane.showMessageDialog(null,"JUEGO TERMINADO \n\nPuntos= "+puntos+"   "+"Tiempo= "+tiemp+"");
                
                /**SE REINCIA TODOS LOS CONTADORES DE VIDA Y LAS POSCIONES Y ENEMIGOS PARA EL CASO DE QUE SE 
                    RINICIE EL JUEGO ENSEGUIDA*/
                
                for (int  i = 0;  i < puentes.length;  i+=2) {
                    puentes[i].setBounds(0,py,puentes[i].getWidth(),puentes[i].getHeight());
                    puentes[i+1].setBounds(-5000,py,puentes[i+1].getWidth(),puentes[i+1].getHeight());
                    py-=2460;
                }   
                vidas=3;score=0;
                seg=0;min=0;
                av.setBounds(300,600,av.getWidth(),av.getHeight());
                av.setAx();
                    int ranx,ranE;
                    for(int i=0;i<ene.length;i++){
                        ranx=(int)(Math.random()*500)+100;
                        rany-=100;
                        ranE=(int)(Math.random()*4)+1;
                        ene[i].setBounds(ranx,rany,ene[i].getWidth(),ene[i].getHeight());
                    } 
                    rany=0;
                    int rang=(int)(Math.random()*4)+1;
                gas.setBounds(rang*100,100,gas.getWidth(),gas.getHeight()); 
                            posYa=700;
                            posYb=700;
                           for(int y=0;y<bor.length/2;y++){
                           if(y==4||y==9||y==14||y==19){
                               posYa-=60;
                               bor[y].setBounds(0,posYa,bor[y].getWidth(),bor[y].getHeight());
                           }else{
                               posYa-=600; 
                             bor[y].setBounds(0,posYa,bor[y].getWidth(),bor[y].getHeight());
                           }   
                           }
                          for(int y=bor.length/2;y<bor.length;y++){
                           if(y==24||y==29||y==34||y==39){
                                posYb-=60;
                               bor[y].setBounds(700-bor[y].getWidth(),posYb,bor[y].getWidth(),bor[y].getHeight());
                           }else{
                           posYb-=600;
                           bor[y].setBounds(700-bor[y].getWidth(),posYb,bor[y].getWidth(),bor[y].getHeight());
                           }
                           }
                    ff+=(fn.getY()+10800)*-1;
                     py=-1760;
                        banB=0; 
                        
                     menu.setVisible(true);
                     s.PlaySonido();
                     sa.StopSonido3();
                     ej.setVisible(false);
                     timerJuego.stop();
                }//game over o win
                
                if(t_sa==12){
                    seg_sa++;
                    t_sa=0;
                }
                if(seg_sa==30){
                    sa.PlaySonido3();
                    seg_sa=0;
                }
                
        }//action events 
    }//timerJuego
 
}

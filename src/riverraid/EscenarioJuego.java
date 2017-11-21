package riverraid;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import static riverraid.ImageLoader.*;

public class EscenarioJuego extends JFrame{
        public int hF,wF,yf=0,hB,wB,xa=300,ya=500,q1=1,qa=0,c,d,rany=200,posYa=700,posYb=700,py=-1760;
        public JLabel m[],e[],p;
        public Bordes bor[];
        public enemigos ene[];
        public Frame M,MF;
        public int[] rb;
        public int band=0;
        public Avion a;
        public puente puentes[];
        public static SonidoAvion sa1= new SonidoAvion();
        public static SonidoExplosion se1= new SonidoExplosion();
        /** contrutor por defecto*/
        public EscenarioJuego(){
        
        }
        /** contrutor por defecto donde se le pone nombre de la ventana */
        public EscenarioJuego(String nombre,Frame frame){
        super(nombre);
        Image icon = new ImageIcon(getClass().getResource("image/logo.png")).getImage();
        this.setIconImage(icon);
        M=frame;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(new WindowsEvents());
        iniciar(frame);
        }
        /**metodo donde se agregan todos los componentes al JFrame */
        public void iniciar(Frame frame){
        ImageLoader loader =ImageLoader.getInstance();
        ImageIcon icon;
        this.getContentPane().setLayout(null);
        m=new JLabel[100];
        ene=new enemigos[100];
        bor=new Bordes[40];
        puentes=new puente[16];
        final MotorJuego mj=new MotorJuego();
        a = new Avion(300,600);
        this.getContentPane().add(a.getAvion());
        
        this.getContentPane().add(mj.getPuntos());
        this.getContentPane().add(mj.getGasolina());
        this.getContentPane().add(mj.getVida());
        this.getContentPane().add(mj.getTiempo());
        this.getContentPane().add(mj.getEtiqueta());
        Barra b[];
        b=new Barra[2];
        b[0]=new Barra();
        b[1]=new Barra();
        this.getContentPane().add(b[0].getB1());
        this.getContentPane().add(b[1].getB2());
        this.getContentPane().add(mj.getexp());
        
        
        
            for (int  i = 0;  i < puentes.length;  i+=2) {
                if(i<puentes.length){
                puentes[i]=new puente(0,py,1);
                this.getContentPane().add(puentes[i]);
                puentes[i+1]=new puente(-5000,py,2);
                this.getContentPane().add(puentes[i+1]);
                py-=2460;
                }
            }
        rb=new int[bor.length/2];
        for(int y=0;y<bor.length/2;y++){
             if(y==4||y==9||y==14||y==19){
             posYa-=60;
             rb[y]=4;
             bor[y]=new Bordes(0,posYa,rb[y]);
             this.getContentPane().add(bor[y]);
             }
                else{posYa-=600;
                rb[y]=(int)(Math.random()*3)+1;
                bor[y]=new Bordes(0,posYa,rb[y]);
                this.getContentPane().add(bor[y]);
                }
        }
       for(int y=bor.length/2;y<bor.length;y++){
            if(y==24||y==29||y==34||y==39){
                 posYb-=60;
                 rb[y-bor.length/2]=8;
                bor[y]=new Bordes(0,posYb,rb[y-bor.length/2]);
                 this.getContentPane().add(bor[y]);
                 }
                    else{
                    posYb-=600;
                    rb[y-bor.length/2]+=4;
                    bor[y]=new Bordes(0,posYb,rb[y-bor.length/2]);
                    this.getContentPane().add(bor[y]);
                    }
        }
        icon=loader.getImagen(ImageLoader.misil);
        int w=icon.getIconWidth(),h=icon.getIconHeight();
        for(int i=0;i<m.length;i++){
        m[i]=new JLabel(icon);
        m[i].setBounds(-100, 100,w ,h);
        this.getContentPane().add(m[i]);
        }   
        
        this.getContentPane().add(mj.getGas());
        c=a.getX()+27; d=a.getY()-46;
        int ranx,ranE;
        for(int i=0;i<ene.length;i++){
        ranx=(int)(Math.random()*500)+100;
        rany-=100;
        ranE=(int)(Math.random()*4)+1;
        ene[i]=new enemigos(ranx,rany,ranE);
        this.getContentPane().add(ene[i].getenemigos());
        }  
        Fondo f=new Fondo();
        this.getContentPane().add(f.getF());
        setResizable(false);
        mj.iniciar(a,f,m,ene,bor,puentes,frame,this);
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==e.VK_UP){ 
                    if(a.getY()>0)
                        mj.setT(50);
                    a.setBounds(a.getX(),a.getY(), a.getWidth(), a.getHeight());
                    c=a.getX()+27; d=a.getY()-46;
                  }   
                if(e.getKeyCode()==e.VK_LEFT) 
                  if(a.getY()>0){
                    a.setBounds(a.getX()-10,a.getY(), a.getWidth(), a.getHeight());
                    c=a.getX()+27; d=a.getY()-46;
                  }
                if(e.getKeyCode()==e.VK_RIGHT){ 
                  if(a.getY()>0){
                      a.setBounds(a.getX()+10,a.getY(), a.getWidth(), a.getHeight());
                      c=a.getX()+27; d=a.getY()-46;
                  }
                }
                if(e.getKeyCode()==e.VK_ENTER){
                    mj.StartT();
                    sa1.PlaySonido3();
                    se1.PlaySonido2();
                }
                
                if(e.getKeyCode()==e.VK_P){
                        mj.StopT();
                        sa1.StopSonido3();
                        se1.StopSonido2();
                }
                
                if(e.getKeyCode()==e.VK_SPACE){ 
                     a.setBounds(a.getX(),a.getY(), a.getWidth(), a.getHeight());
                      c=a.getX()+27; d=a.getY()-46;
                    if(q1-1>=1){
                    if(m[q1-2].getY()<500){
                    m[qa].setBounds(c,d,m[qa].getWidth(),m[qa].getHeight());
                    m[qa].setBounds(c,d,m[qa].getWidth(),m[qa].getHeight());
                    q1++;
                    if(qa==99){
                    q1=1;
                    qa=0;
                    }
                    qa++;
                    }
                    }
                    if(q1-1==0){
                    m[qa].setBounds(c,d,m[qa].getWidth(),m[qa].getHeight());
                    m[qa].setBounds(c,d,m[qa].getWidth(),m[qa].getHeight());
                      q1++; qa++;
                    }
                }
            }
            public void keyReleased(KeyEvent e){
             if(e.getKeyCode()==e.VK_UP)
                  { 
                      mj.setT(80);
                  }
             }
        });
        }
    /**  Clase donde se carga el Fondo*/       
        public class Fondo extends JLabel{
      
        Fondo(){
        ImageLoader loader =ImageLoader.getInstance();
        ImageIcon icon=loader.getImagen(ImageLoader.Fondo);
         setIcon(icon);
         int yy=-10800;
         wF=icon.getIconWidth();
         hF=icon.getIconHeight();
         new Rectangle(0,0,wF,hF);
         setBounds(10,yy,wF,hF);
         yf=yy;
        }
        
        public void setY(int y) {
        setBounds(100,yf+y,wF,hF);}
        
        public JLabel getF(){
        return this;
        }
        
        }//fin Fondo
     /**  Clase donde se carga las barras*/ 
        public class Barra extends JLabel{
      
        Barra(){
        }
        
        public JLabel getB1(){
        ImageLoader loader =ImageLoader.getInstance();
        ImageIcon icon;
         
        icon = loader.getImagen(ImageLoader.barra);
        setIcon(icon);
        wB=icon.getIconWidth();
        hB=icon.getIconHeight();
        
        new Rectangle(0,0,wB,hB);
        setBounds(0,0,wB,hB);
        return this;
        }
        public JLabel getB2(){
        ImageLoader loader =ImageLoader.getInstance();
        ImageIcon icon;
        icon=loader.getImagen(ImageLoader.barra1);
        setIcon(icon);
        wB=icon.getIconWidth();
        hB=icon.getIconHeight();
        
        new Rectangle(0,0,wB,hB);
        setBounds(0,672,wB,hB);
        return this;
        }
        }//fin barra
        /**  Clase donde se le da tamaño al JFrame*/ 
    class WindowsEvents extends WindowAdapter{
        @Override
        public void windowOpened(WindowEvent e) {
            Insets inset = getInsets();
            setSize(700+inset.left+inset.right,700+inset.bottom+inset.top); //Adecuar el tamaño de la ventana a abrir tomando en cuenta 
                                                                            //las dimensiones de la imagen de fondo y de los 4 bordes
            setLocationRelativeTo(null); //Para centrar la ventana en la pantalla
        }
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
        
    }
    
    
    
     
}

package riverraid;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *DESDE AQUI SE CONTROLA EL JUEGO
 * @author CHIRLY
 */
public class Menu {
    JFrame frame,frame1,frame2,frame3,nombre;
    JLabel fondo,jugar,instruc,punt,credi,salir,regresar;
    JTextField jugador;
    public static String nomJug;
    int cont=0;
    String usuario[];
    MotorJuego obj= new MotorJuego();
    public  static SonidoIntro sound= new SonidoIntro();
    
    public Menu(){/**CONTRUCTOR POR DEFECTO*/
        
    }
    
    /**se relizan las opciones del menu*/
    public void Jugar(){
        
        /**se crea la ventana principal del juego y sus opciones*/
        frame= new JFrame("River Rider 1.0");
        Container container= frame.getContentPane();
        container.setLayout(null);
                
        fondo= new JLabel(new ImageIcon(getClass().getResource("image/fondoo.png")));
        fondo.setBounds(0, 0, 690, 665);
        container.add(fondo);
        
        jugar= new JLabel(new ImageIcon(getClass().getResource("image/jugar.png")));
        jugar.setBounds(275, 300, 150, 30);
        fondo.add(jugar);
        
        instruc= new JLabel(new ImageIcon(getClass().getResource("image/instrucciones.png")));
        instruc.setBounds(275, 350, 150, 30);
        fondo.add(instruc);
        
        punt= new JLabel(new ImageIcon(getClass().getResource("image/puntuaciones.png")));
        punt.setBounds(275, 400, 150, 30);
        fondo.add(punt);
        
        credi= new JLabel(new ImageIcon(getClass().getResource("image/creditos.png")));
        credi.setBounds(275, 450, 150, 30);
        fondo.add(credi);
        
        salir= new JLabel(new ImageIcon(getClass().getResource("image/salir.png")));
        salir.setBounds(275, 500, 150, 30);
        fondo.add(salir);
                
        /**ACCIONES A REALIZAR SI EL USUARIO PRESIONA LA OPCION JUGAR*/
        jugar.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                jugar.setIcon(new ImageIcon(getClass().getResource("image/jugar2.png")));
            }
            public void mouseExited(MouseEvent e){
                jugar.setIcon(new ImageIcon(getClass().getResource("image/jugar.png")));
            }
            public void mousePressed(MouseEvent e){
                
                /**SE CREA UNA VENTANA DONDE SE INGRESA NOMBRE DE USUARIO*/
                nombre= new JFrame("");
                Container container1= nombre.getContentPane();
                container1.setLayout(null);
                container1.setBackground(Color.red.darker());
                
                JLabel etiq= new JLabel("Ingrese Nombre");
                etiq.setFont(new Font("Tahoma",Font.BOLD,24));
                etiq.setForeground(Color.yellow);
                etiq.setBounds(50, 0, 250, 30);
                container1.add(etiq);
                
                JLabel etiq2= new JLabel("Presione ENTER");
                etiq2.setFont(new Font("Tahoma",Font.BOLD,15));
                etiq2.setForeground(Color.GRAY);
                etiq2.setBounds(90, 95, 200, 20);
                container1.add(etiq2);
                
                jugador= new JTextField(8);
                jugador.setFont(new Font("Tahoma", 0, 24));
                jugador.setBounds(90, 50, 120, 30);
                container1.add(jugador);
                
                jugador.addActionListener(new ActionListener(){
                    public void actionPerformed( ActionEvent event ){
                        
                        /**se valida que el nombre de jugador no sea mayor a 8 caracteres ni menor a 4*/
                        if(jugador.getText().length()<4){
                           JOptionPane.showMessageDialog(null, "El nombre debe ser mayor a 4 caracteres","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else if(jugador.getText().length()>8){
                           JOptionPane.showMessageDialog(null, "El nombre debe ser menor a 8 caracteres","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            
                            /**EL JUEGO INICIA*/
                            nomJug= jugador.getText();
                            nombre.setVisible(false);
                            frame.setVisible(false);
                            obj.setNom(nomJug);
                            MainFrame m=new MainFrame(frame);
                            sound.StopSonido();
                            
                        }
                    }
                });
                
                /**PARAMETROS DE LA VENTANA DONDE SE INGRESA EL NOMBRE*/
                nombre.setBounds(0, 0, 300, 150);
                Image icon = new ImageIcon(getClass().getResource("image/logo.png")).getImage();
                nombre.setIconImage(icon);
                nombre.setLocationRelativeTo(null);
                nombre.setVisible(true);
                nombre.setResizable(false);
            }
        } );/**ACCIONES DE JUGAR*/
        

        instruc.addMouseListener(new MouseAdapter(){/**ACCIONES A REALIZAR SI EL USUARIO PRESIONA LA OPCION INSTRUCCIONES*/
            public void mouseEntered(MouseEvent e){
                instruc.setIcon(new ImageIcon(getClass().getResource("image/instrucciones2.png")));
            }
            public void mouseExited(MouseEvent e){
                instruc.setIcon(new ImageIcon(getClass().getResource("image/instrucciones.png")));
            }
            
            public void mousePressed(MouseEvent e){
                frame1= new JFrame("River Raid 1.0");
                JLabel fondo1,disparo,direccion,acelerar,pausa;
                JLabel info1, info2, info3, info4,descrip1,descrip2,descrip3;
                
                Container container1=frame1.getContentPane();
                container1.setLayout(null);
                                                 
                fondo1= new JLabel(new ImageIcon(getClass().getResource("image/panel.png")));
                fondo1.setBounds(0, 0, 690, 665);
                frame1.add(fondo1);
                
                descrip1= new JLabel("El juego consiste en avanzar rio arriba en una avion mientras");
                descrip1.setForeground(Color.black);
                descrip1.setFont(new Font("Tahoma",Font.BOLD,18));
                descrip1.setBounds(85, 235, 700, 30);
                fondo1.add(descrip1);
                descrip2= new JLabel("esquivas o eliminas a los diferentes enemigos que pueden aparecer");
                descrip2.setForeground(Color.black);
                descrip2.setFont(new Font("Tahoma",Font.BOLD,18));
                descrip2.setBounds(45, 255, 700, 30);
                fondo1.add(descrip2);
                descrip3= new JLabel("(barcos, helicopteros).Si llegas a mar abierto ganas.Los controles son:");
                descrip3.setForeground(Color.black);
                descrip3.setFont(new Font("Tahoma",Font.BOLD,18));
                descrip3.setBounds(35, 280, 700, 30);
                fondo1.add(descrip3);
                
                disparo= new JLabel(new ImageIcon(getClass().getResource("image/espacio.png")));
                disparo.setBounds(60, 350, 241, 50);
                fondo1.add(disparo);
                
                direccion= new JLabel(new ImageIcon(getClass().getResource("image/direccion.png")));
                direccion.setBounds(201, 415, 100, 50);
                fondo1.add(direccion);
                                               
                acelerar= new JLabel(new ImageIcon(getClass().getResource("image/velocidad.png")));
                acelerar.setBounds(251, 480, 50, 100);
                fondo1.add(acelerar);
                
                pausa= new JLabel(new ImageIcon(getClass().getResource("image/pausa.png")));
                pausa.setBounds(251, 590, 50, 50);
                fondo1.add(pausa);
                
                regresar= new JLabel(new ImageIcon(getClass().getResource("image/menu.png")));
                regresar.setBounds(520, 590, 150,30);
                fondo1.add(regresar);
                
                info1= new JLabel("Disparar");
                info1.setForeground(Color.black);
                info1.setFont(new Font("Tahoma",Font.BOLD,20));
                info1.setBounds(321, 350, 100, 50);
                fondo1.add(info1);
                
                info2= new JLabel("Direccion izquierda/derecha");
                info2.setForeground(Color.black);
                info2.setFont(new Font("Tahoma",Font.BOLD,20));
                info2.setBounds(321, 415, 300, 50);
                fondo1.add(info2);
                
                info3= new JLabel("Acelerar/Desacelerar");
                info3.setForeground(Color.black);
                info3.setFont(new Font("Tahoma",Font.BOLD,20));
                info3.setBounds(321, 480, 300, 50);
                fondo1.add(info3);
                
                info4= new JLabel("Pausar");
                info4.setForeground(Color.black);
                info4.setFont(new Font("Tahoma",Font.BOLD,20));
                info4.setBounds(321, 590, 100, 50);
                fondo1.add(info4);
                
               /**SI EL USUARIO PRECIONA LA OPCION MENU DENTRO DE LA VENTANA DE INSTRUCCIONES SE VUELVE A MOSTRAR EL MENU PRINCIPAL*/
                regresar.addMouseListener(new MouseAdapter(){
                    public void mouseEntered(MouseEvent e){
                        regresar.setIcon(new ImageIcon(getClass().getResource("image/menu2.png")));
                    }
                    public void mouseExited(MouseEvent e){
                        regresar.setIcon(new ImageIcon(getClass().getResource("image/menu.png")));
                    }
                    public void mousePressed(MouseEvent e){
                        frame1.setVisible(false);
                        frame.setVisible(true);   
                    }
                } );///ACCIONES PARA REGRESAR AL MENU PRINCIPAL
            
            /**PARAMETROS DE LA VENTANA INSTRUCCIONES*/
            frame1.setBounds(350, 100, 700, 700);
            Image icon = new ImageIcon(getClass().getResource("image/logo.png")).getImage();
            frame1.setIconImage(icon);
            frame1.setVisible(true);
            frame.setVisible(false);
            frame1.setResizable(false);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        } );//ACCIONES DE INSTRUCCCION
        
        punt.addMouseListener(new MouseAdapter(){/**ACCIONES A REALIZAR SI EL USUARIO PRESIONA LA OPCION PUNTUACION*/

            public void mouseEntered(MouseEvent e){
                punt.setIcon(new ImageIcon(getClass().getResource("image/puntuaciones2.png")));
            }
            public void mouseExited(MouseEvent e){
                punt.setIcon(new ImageIcon(getClass().getResource("image/puntuaciones.png")));
            }
            
            public void mousePressed(MouseEvent e){
                                              
                /**MANEJO DE PUNTAJES*/
                int cont=0;
                String arch= "puntuaciones.txt";
                FileReader fr;
                BufferedReader br;
                String linea;
                
                try {
                    fr = new FileReader(arch);
                    br =  new BufferedReader(fr);
                    
                    while((linea=br.readLine())!=null){
                        cont++;
                    }
                    br.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                usuario= new String[cont];
                                
                try {
                    fr= new FileReader(arch);
                    br= new BufferedReader(fr);
                    
                    linea= br.readLine();
                    for(int i=0;i<cont;i++){
                        String[] token= linea.split("-");
                        String nom= token[0];
                        String punt= token[1];
                        usuario[i]=nom+"-"+punt;
                        
                        linea= br.readLine();
                    }
                    br.close(); 
                   
                    /**SE ACOMODAN LOS PUNTAJES CON SU RESPECTIVO USUARIO DE MAYOR A MENOR*/
                    for(int j=0;j<cont;j++){
                        for(int i=0;i<cont;i++){
                        String aux;
                            if(i<cont-1){ 
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
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /**MENU DE PUNTUACIONES*/
                frame2= new JFrame("River Raid 1.0");
                JLabel fondo1,puntajes[],etiqueta;
                puntajes= new JLabel[10];

                Container container1=frame2.getContentPane();
                container1.setLayout(null);
                                                 
                fondo1= new JLabel(new ImageIcon(getClass().getResource("image/panel.png")));
                fondo1.setBounds(0, 0, 690, 665);
                frame2.add(fondo1);
                etiqueta= new JLabel("MEJORES PUNTAJES");
                etiqueta.setFont(new Font("Tahoma",Font.BOLD,36));
                etiqueta.setForeground(Color.yellow);
                etiqueta.setBounds(170, 225, 500, 36);
                fondo1.add(etiqueta);
                
                //////////////////////////SE AGREGAN LOS PUNTAJES AL MENU
                int punty=275;
                for(int i=0;i<puntajes.length;i++){
                    puntajes[i]= new JLabel(usuario[i]);
                    puntajes[i].setFont(new Font("Tahoma",Font.BOLD,24));
                    puntajes[i].setForeground(Color.black);
                    puntajes[i].setBounds(200, punty, 250, 25);
                    fondo1.add(puntajes[i]);
                    punty+=30;
                }
                
                
                regresar= new JLabel(new ImageIcon(getClass().getResource("image/menu.png")));
                regresar.setBounds(520, 590, 150,30);
                fondo1.add(regresar);
                
                /**SI EL USUARIO PRECIONA LA OPCION MENU DENTRO DE LA VENTANA DE PUNTUACIONES VUELVE A MOSTRAR EL MENU PRINCIPAL*/
                regresar.addMouseListener(new MouseAdapter(){
                    public void mouseEntered(MouseEvent e){
                        regresar.setIcon(new ImageIcon(getClass().getResource("image/menu2.png")));
                    }
                    public void mouseExited(MouseEvent e){
                        regresar.setIcon(new ImageIcon(getClass().getResource("image/menu.png")));
                    }
                    public void mousePressed(MouseEvent e){
                    frame2.setVisible(false);
                    frame.setVisible(true);

                    }
                } );
            
            /**SE CREA UN FRAME QUE MIUESTRE LAS PUNTUACIONES Y SE OCULTA EL MENU PRINCIPAL MOMENTANEAMENTE*/
            frame2.setBounds(350, 100, 700, 700);
            Image icon = new ImageIcon(getClass().getResource("image/logo.png")).getImage();
            frame2.setIconImage(icon);
            frame2.setVisible(true);
            frame.setVisible(false);
            frame2.setResizable(false);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }
        } );
        
        
        /**ACCIONES SI EL USUARIO PRESIONA LA OPCION CREDITOS*/
        credi.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                credi.setIcon(new ImageIcon(getClass().getResource("image/creditos2.png")));
            }
            public void mouseExited(MouseEvent e){
                credi.setIcon(new ImageIcon(getClass().getResource("image/creditos.png")));
            }
            public void mousePressed(MouseEvent e){
                frame3= new JFrame("River Raid 1.0");
                JLabel fondo1,titulo,autores,nombre1,nombre2,prof,nombre3;
                
                //SE CREA UNA VENTANA QUE MUESTRA LA INFORMACION DE LOS AUTORES
                Container container1=frame3.getContentPane();
                container1.setLayout(null);
                                                 
                fondo1= new JLabel(new ImageIcon(getClass().getResource("image/panel.png")));
                fondo1.setBounds(0, 0, 690, 665);
                frame3.add(fondo1);
                
                regresar= new JLabel(new ImageIcon(getClass().getResource("image/menu.png")));
                regresar.setBounds(520, 590, 150,30);
                fondo1.add(regresar);
                
                titulo= new JLabel("RIVER RAID");
                titulo.setForeground(Color.yellow);
                titulo.setFont(new Font("Tahoma",Font.BOLD,30));
                titulo.setBounds(260, 250, 200, 30);
                fondo1.add(titulo);
                
                autores= new JLabel("AUTORES");
                autores.setForeground(Color.yellow);
                autores.setFont(new Font("Tahoma",Font.BOLD,30));
                autores.setBounds(280, 300, 200, 30);
                fondo1.add(autores);
                
                nombre1= new JLabel("Kevin Duran");
                nombre1.setForeground(Color.black);
                nombre1.setFont(new Font("Tahoma",Font.BOLD,24));
                nombre1.setBounds(279, 335, 200, 30);
                fondo1.add(nombre1);
                
                nombre2= new JLabel("Brayan Rueda");
                nombre2.setForeground(Color.black);
                nombre2.setFont(new Font("Tahoma",Font.BOLD,24));
                nombre2.setBounds(268, 370, 200, 30);
                fondo1.add(nombre2);
                
                prof= new JLabel("PROFESOR");
                prof.setForeground(Color.yellow);
                prof.setFont(new Font("Tahoma",Font.BOLD,30));
                prof.setBounds(270, 420, 360, 30);
                fondo1.add(prof);
                
                nombre3= new JLabel("Yeniffer Peña");
                nombre3.setForeground(Color.black);
                nombre3.setFont(new Font("Tahoma",Font.BOLD,24));
                nombre3.setBounds(268, 455, 200, 30);
                fondo1.add(nombre3);
                
                /**SI EL USUARIO PRECIONA LA OPCION MENU DENTRO DE LA VENTANA DE CREDITOS VUELVE A MOSTRAR EL MENU PRINCIPAL*/
                regresar.addMouseListener(new MouseAdapter(){
                    public void mouseEntered(MouseEvent e){
                        regresar.setIcon(new ImageIcon(getClass().getResource("image/menu2.png")));
                    }
                    public void mouseExited(MouseEvent e){
                        regresar.setIcon(new ImageIcon(getClass().getResource("image/menu.png")));
                    }
                    public void mousePressed(MouseEvent e){
                        frame3.setVisible(false);
                        frame.setVisible(true);

                    }
                } );///ACCIONES PARA REGRESAR AL MENU PRINCIPAL
                
                
                /**PARAMETROS DE LA VENTANA CREDITOS*/
                frame3.setBounds(350, 100, 700, 700);
                Image icon = new ImageIcon(getClass().getResource("image/logo.png")).getImage();
                frame3.setIconImage(icon);
                frame3.setVisible(true);
                frame.setVisible(false);
                frame3.setResizable(false);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        } );///ACCIONES DE VENTANA CREDITOS
        
        /**EL JUEGO SE CIERRA POR COMPLETO*/
        salir.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                salir.setIcon(new ImageIcon(getClass().getResource("image/salir2.png")));
            }
            public void mouseExited(MouseEvent e){
                salir.setIcon(new ImageIcon(getClass().getResource("image/salir.png")));
            }
            public void mousePressed(MouseEvent e){
                System.exit(0);
            }
        } );///////
        
        /**TAMAÑO Y SONIDO DE LA VENTANA PRINCIPAL*/
        sound.PlaySonido();
        Image icon = new ImageIcon(getClass().getResource("image/logo.png")).getImage();
        frame.setIconImage(icon);
        frame.setBounds(350, 100, 700, 700);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

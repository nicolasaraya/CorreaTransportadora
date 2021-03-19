package GUI;
import CosasMoviles.Correa;
import CosasMoviles.DetMetales;
import CosasMoviles.Elementos;
import CosasMoviles.Recipiente;
import CosasMoviles.Rueda;
import CosasMoviles.Segmento;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import Matematica.HolderVelocidad;
/**
 * Esta clase instancia todas las del paquete CosasMoviles, esta extiende a JPanel que funciona como un contenedor que "almacena" las clases y permite que sean visibles para el cliente.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Naturaleza extends JPanel implements ActionListener {
    private Polygon trazo;
    private int xa,ya,i;
    private Correa correa;
    private ArrayList<Elementos> objetos;
    private Rueda r1, r2;
    private Elementos bmover;
    private DetMetales det;
    private Recipiente recipiente, mesita;
    private HolderVelocidad velocidad;
    public Image imagenfondo;
    public URL fondo;
    /**
    * Constructor que instancia los eventos del mouse, un timer que tendra el programa, la iagen de fondo y las demas clases, además instaura sus posiciones, sus tamaños y utiliza el random para que el tipo de elemento aparezca de manera aleatoria en el entorno.  
    */       
    public Naturaleza(){
        super();
        EventosMouse em = new EventosMouse();
        this.addMouseListener(em);
        this.addMouseMotionListener(em);
        det = new DetMetales(150,250,false);
        Timer t = new Timer(20,this);
        t.start();
        r1 = new Rueda(150, 450, 100);
        r2 = new Rueda(670, 450, 100);
        correa = new Correa(r1, r2);
        velocidad = HolderVelocidad.getHolder();
        i = 0;
        while (i<correa.getLong()-40){
            correa.addSegmento(new Segmento(correa, i,velocidad));
            i = i+51;
        }
        objetos = new ArrayList<Elementos> ();
        for(int i=0; i<10; i++){
            Elementos b = new Elementos(800+(int)(Math.random()*50+1), 300);
            objetos.add(b);
        }
        recipiente = new Recipiente(6,530,1);
        mesita = new Recipiente(800, 350, 2);     
        fondo = this.getClass().getResource("/CosasMoviles/Objetos/EDITADACLARO.jpg");
        imagenfondo = new ImageIcon(fondo).getImage(); 
    }//Cierre constructor
    /**
    * Método que dibuja la imagen de fondo, recipiente, la mesita, detector de metales, los objetos y la correa transportadora.
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar
    */
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(imagenfondo,0,0,getWidth(),getHeight(),this); 
        if(recipiente!=null)recipiente.paint(g);
        if(mesita!=null)mesita.paint(g);
        if(det!=null)det.paint(g);
        if(objetos!=null){
            for(int i = 0; i<objetos.size();i++){
                Elementos aux = (Elementos)objetos.get(i);
                aux.paint(g);
            }
        }
        if(r1!=null)r1.paint(g);
        if(r2!=null)r2.paint(g);
        if(correa!=null)correa.paint(g);
    }
    /**
    * Método que capta el cambio de velocidad, de la correa, que realiza el cliente (con los botones superiores) y lo lleva a cabo.
    * @param ae El parámetro ae son los eventos del entorno que recibe el método.
    */   
    public void actionPerformed(ActionEvent ae) {
        if(r1!=null)r1.rotar(velocidad.getNVelocidad());
        if(r2!=null)r2.rotar(velocidad.getNVelocidad());
        if(correa!=null)correa.mover();
        for(int i = 0; i<objetos.size();i++){
            Elementos aux = (Elementos)objetos.get(i);               
            if(aux.getContador()>=1){
                aux.gravedad();
            }   
            //altura correa = 410
            if(aux.getY()>440 - aux.Tamaño() && aux.getY() < 480 - aux.Tamaño() && aux.getX() >= 145-aux.Tamaño() && aux.getX() <=750){
                aux.setContador(0);
                aux.correa(velocidad.getNVelocidad());                   
            }
            if(aux.getY() >= 440 - aux.Tamaño() && aux.getX() >= 110 - aux.Tamaño() && aux.getX() <=145-aux.Tamaño()){
                aux.setContador(aux.getContador()+1);  
                aux.correa(velocidad.getNVelocidad());
                det.setBol(false);
            }
            if(aux.getY() >= correa.getAltura() -200 && aux.getY() <= correa.getAltura() && aux.getX() >= 100 && aux.getX() <=270){
                if(aux.TieneMetal() == true){
                    det.setBol(true);
                }    
            }
            
        }
        repaint();   
    }
    /**
    * Clase que implementa los métodos de MouseListener y MouseMotionListener, esta utiliza la información que la ventana entrega cuando el cursor es utilizado por el cliente.
    */ 
    class EventosMouse implements MouseListener,MouseMotionListener{
        public void mouseClicked(MouseEvent me){}
        /**
        * Método que capta cuando el cliente mantiene el cursor presionado sobre un objeto: el objeto se queda quieto.
        * @param me El parámetro me es el evento que produce el cursor.
        */ 
        public void mousePressed(MouseEvent me) {
            for(int i = 0; i<objetos.size();i++){
                Elementos aux = (Elementos)objetos.get(i);
                if(me.getY()>=aux.getY() && me.getY()<=aux.getY()+aux.Tamaño() && me.getX()>=aux.getX() && me.getX()<=aux.getX()+aux.Tamaño() ){
                    bmover=aux;
                    bmover.setContador(0);
                    break;
                }
            }    
        }
        /**
        * Método que capta cuando el cliente suelta el cursor que tenía presionado sobre un objeto: el contador cambia y el objeto activa la gravedad.
        * @param me El parámetro me es el evento que produce el cursor.
        */ 
        public void mouseReleased(MouseEvent me){
            for(int i = 0; i<objetos.size();i++){
                Elementos aux = (Elementos)objetos.get(i);
                aux.setContador(aux.getContador()+1);  
            }
            bmover = null;
        }
        public void mouseEntered(MouseEvent me){;}
        public void mouseExited(MouseEvent me){;}
        /**
        * Método que permite que el cliente arrastre el objeto por el entorno.
        * @param me El parámetro me es el evento que produce el cursor.
        */ 
        public void mouseDragged(MouseEvent me){            
            if(bmover!=null){
                bmover.setContador(0);
                bmover.setX(me.getX());
                bmover.setY(me.getY());        
            }          
        }
        public void mouseMoved(MouseEvent me) {;}
    }
}
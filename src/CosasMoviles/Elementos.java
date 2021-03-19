package CosasMoviles;

import java.awt.*;
import java.net.URL;
import java.util.Random;
import javax.swing.*;
/**
* Esta clase define y dibuja todos los objetos que se pueden arrastrar y llevar a la correa transportadora, se les da la caracteristica de si son metálicos o no.
* @author: Martina Cádiz y Nicolás Araya
*/
public class Elementos extends JFrame{
    private int x,y;
    private int contador, rand, size;
    private boolean metal;
    private Image img;
    private URL u;
    /**
     * Constructor que le da atributos a cada objeto: entre ellos si es metalico y la imágen que lo describirá, la imagen es sacada del paquete CosasMoviles.Objetos
     * @param x El parámetro x define la posición del objeto en el eje x
     * @param y El parámetro y define la posición del objeto en el eje y
     */
    public Elementos(int x, int y){
        this.x = x;
        this.y = y;
        contador = 1;
        Random ran = new Random();
        metal = ran.nextBoolean();
        //metal = true;
        rand = (int) (Math.random()*4+1);
        //rand = 3;
        if (metal == false){
            if (rand==1){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Balong.png");
                img = new ImageIcon(u).getImage();
                size=50;
            }
            if (rand==2){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Gafas.png");
                img = new ImageIcon(u).getImage();
                size=30;
            }
            if (rand==3){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Botella.png");
                img = new ImageIcon(u).getImage();
                size=50;
            }
            if (rand==4){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Osito.png");
                img = new ImageIcon(u).getImage();
                size=50;
            }       
        } 
        if (metal == true){
            if(rand==1){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Llaves.png");
                img = new ImageIcon(u).getImage();
                size=30;
            }
            if (rand == 2){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Pistola.png");
                img = new ImageIcon(u).getImage();
                size=50;
            }
            if (rand == 3){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Telefono.png");
                img = new ImageIcon(u).getImage();
                size=50;
            }
            if (rand == 4){
                u = this.getClass().getResource("/CosasMoviles/Objetos/Reloj.png");
                img = new ImageIcon(u).getImage();
                size=30;
            }     
        }
    }//Cierre constructor
    /**
    * Método que dibuja las imagenes
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar el objeto
    */
    public void paint(Graphics g){
        g.drawImage(img, x, y, this); 
    }
    /**
    * Método que le da gravedad al ambiente, si el objeto es soltado por el cursor fuera de los parametros de la mesa, de la correa o del recipiente este comienza a caer hasta llegar al sueloMétodo que dibuja las imagenes.
    */
    public void gravedad(){
        if(contador!=0){
            y=y+2;
            if(y>580-size)y=580-size;
            if(x>-size && x<=126 & y>530-size){ //recipiente
                y=530-size;
            }
            if(x>=800-size/2 && x<=970 && y>=350-size && y<= 375-size )
                y=350-size;
        }
        if (contador == 0){
            y = 430-size;
        }
    }
    /**
    * Método que define la velocidad que tendra el objeto, recibe la velocidad de la correa para que este sea capaz de moverse al mismo tiempo esta.
    * @param velocidad El parámetro es la velocidad de la correa. 
    */
    public void correa(int velocidad){
        x -= velocidad;  
    }
    /**
    * Método que entrega la posición en el eje x del objeto.
    * @return la posición en el eje x
    */
    public int getX(){
        return x;
    }
    /**
    * Método que entrega la posición en el eje y del objeto.
    * @return la posición en el eje y
    */
    public int getY(){
        return y;
    }
    /**
    * Método que cambia la posición del objeto en el eje x.
    * @param xx la posición en el eje x que se quiere usar
    */
    public void setX(int xx){
        x = xx;
    }
    /**
    * Método que cambia la posición del objeto en el eje y.
    * @param yy la posición en el eje y que se quiere usar
    */
    public void setY(int yy){
        y = yy;     
    }
    /**
    * Método que entrega el contados, sirve para cambiar la gravedad.
    * @return entrega el contador como numero entero
    */
    public int getContador(){
        return contador;
    }
    /**
    * Método que permite realizar el cambio de gravedad cambia la posición del objeto en el eje y.
    * @param x la posición en el eje y que se quiere usar
    */
    public void setContador(int x){
        contador = x;
    }
    /**
    * Método que entrega la caracteristica de metal que se definio anteriormente en el constructor 
    * @return entrega un booleano. Si este es falso, el objeto no es metálico y si es verdadero, el obejto si es metálico
    */    
    public boolean TieneMetal(){
        return metal;
    }
    /**
    * Método que entrega el tamaño del objeto.
    * @return el tamaño en numero entero.
    */  
    public int Tamaño(){
        return size;
    }
}


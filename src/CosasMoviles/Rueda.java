package CosasMoviles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
/**
 * Esta clase define, dibuja y crea las ruedas de la correa.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Rueda {
    private int x, y, r;
    private double rotacion = 0.0;
    /**
    * El constructor define donde se ubicará la rueda y el tamaño que tendrá.
    * @param xx El parámetro xx de tipo entero le entrega la ubicación del detector en el eje x. 
    * @param yy El parámetro yy de tipo entero entrega la ubicación del detector en el eje y.
    * @param radio El parámetro entrega el radio que tendrá la rueda.
    */
    public Rueda(int xx, int yy, int radio){
        x = xx;
        y = yy;
        r = radio;      
    }//Cierre constructor
    /**
    * Método que entrega la estructura del dibujo de la rueda y además permite que estas roten en su propio eje(para esto se utilizó AffineTransform).
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar
    */
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.yellow);
        g.fillOval(x, y, r, r);
        AffineTransform tm = new AffineTransform();
        AffineTransform limitar = g2d.getTransform();
        tm.rotate(-rotacion, x+r/2 + 3/2, y + r/2);
        g2d.transform(tm);
        g2d.setColor(Color.GRAY);
        g2d.fillRect(x+r/2, y, 3, r);
        g2d.fillRect(x, y+r/2, r, 3);
        g2d.setTransform(limitar); 
    }
    /**
    * Método que entrega la ubicación en el eje X.
    * @return entrega la coordenada en el eje X de la rueda.
    */
    public int CordX(){
        return x;
    }
    /**
    * Método que entrega la ubicación en el eje Y.
    * @return entrega la coordenada en el eje Y de la rueda.
    */
    public int CordY(){
        return y;
    }
    /**
    * Método que entrega el radio de la rueda.
    * @return entrega el radio como numero entero.
    */
    public int GetRadio(){
        return r;
    }
    /**
    * Método que permite que las ruedas tengan la misma velocidad que la correa, cambia la velocidad de rotación de estas.
    * @param velocidad El parámetro velocidad es la velocidad que recibe de la correa.
    */
    public void rotar(int velocidad) {
        if(velocidad == 1)this.rotacion += 0.02;
        if(velocidad == 3)this.rotacion += 0.1;
        if(velocidad == 5)this.rotacion += 1.8;
    }    
}



   

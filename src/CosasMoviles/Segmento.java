package CosasMoviles;

import Matematica.Angular;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import Matematica.HolderVelocidad;
/**
 * Esta clase define, dibuja y crea los segmentos de la correa.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Segmento{
    public int pos;
    private double angulo;
    private Correa ruta;
    private Polygon pol;
    private HolderVelocidad velocidad;
    /**
    * El constructor define donde se ubicaran los segmentos (gracias a la correa), la velocidad que se moverán y la cantidad de segmentos que se quiere crear.
    * @param r El parámetro r de tipo correa le entrega todos los datos de la correa que se instancio en la clase Naturaleza. 
    * @param p El parámetro p de tipo entero entrega la cantidad de segmentos que tendrá la correa.
    * @param velocidad El parámetro velocidad entrega, por medio del HolderVelocidad, la velocidad que decida el cliente en el programa.
    */
    public Segmento(Correa r,int p, HolderVelocidad velocidad){
        ruta = r;
        angulo = 0;
        pos = p;
        this.velocidad = velocidad;   
    }//Cierre constructor
    /**
    * Método que entrega la estructura del dibujo de los segmentos.
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar
    */
    public void paint(Graphics g){
        Point xy = ruta.getPointPos(pos);
        Point uno = Angular.generaPunto(xy,20,angulo+0.15);
        Point dos = Angular.generaPunto(xy,20,angulo-0.15);
        Point tres = Angular.generaPunto(xy,20,angulo-0.85);
        Point cuatro = Angular.generaPunto(xy,20,angulo+0.85);
        pol = new Polygon();
        pol.addPoint(uno.x,uno.y);
        pol.addPoint(dos.x,dos.y); 
        pol.addPoint(tres.x,tres.y);
        pol.addPoint(cuatro.x,cuatro.y);
        g.setColor(Color.gray);
        g.fillPolygon(pol);
        g.setColor(Color.white);
        g.drawLine(uno.x, uno.y, dos.x, dos.y);
    }
    /**
    * Método que permite el movimiento de los segmentos por la cuerda.
    */   
    public void mover(){
        pos=(pos+velocidad.getNVelocidad()) % ruta.getLong();
        Point a1 = ruta.getPointPos(pos);
        Point a2 = ruta.getPointPos((pos+10)%ruta.getLong());
        angulo = Angular.anguloPI(a1,a2);      
    }
    /**
    * Método que da la velocidad que tienen los segmentos.
    * @return entrega la velociad que almacena el Holder.
    */
    public int getVelocidad(){
        return velocidad.getNVelocidad();
    }
}
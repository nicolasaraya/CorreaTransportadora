package CosasMoviles;

import Matematica.RellenaConPuntos;
import java.awt.*;
import java.util.ArrayList;
/**
 * Esta clase define, dibuja y crea a la correa transportadora, la cuerda y los segmentos que posee.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Correa {
    private Polygon ruta;
    private ArrayList<Segmento> seg;
    private int x1, y1, x2, y2, radio1, radio2;
    /**
     * Constructor que utiliza la clase Ruedas para brindarle la ubicación a la correa trnasportados, además indica a la cuerda de la correa donde ubicarse.
     * @param r1 El parámetro r1 de tipo Rueda entrega al constructor la información de la primera rueda. 
     * @param r2 El parámetro r2 de tipo Rueda entrega al constructor la información de la segunda rueda.
     */
    public Correa(Rueda r1, Rueda r2){
        ruta = new Polygon();
        seg = new ArrayList<Segmento>();
        x1 = r1.CordX();
        y1 = r1.CordY();
        radio1 = r1.GetRadio();
        x2 = r2.CordX();
        y2 = r2.CordY();
        radio2 = r2.GetRadio();
        
        RellenaConPuntos.nuevaLinea(x1, y1, x1-10, y1+radio1/2, ruta); //izq
        RellenaConPuntos.nuevaLinea(x1-10, y1+radio1/2,x1,y1+radio1, ruta);
        RellenaConPuntos.nuevaLinea(x1, y1+radio1, x2+radio2, y2+radio2, ruta); //abajo  
        RellenaConPuntos.nuevaLinea(x2+radio2, y2+radio2, x2+radio2+10, y2+radio2/2, ruta); //izq
        RellenaConPuntos.nuevaLinea(x2+radio2+10, y2+radio2/2,x2+radio2, y2, ruta);
        RellenaConPuntos.nuevaLinea(x2+radio2, y2, x1, y1, ruta); //arriba
    }//Cierre constructor
    /**
    * Método que dibuja la ruta.
    * @param p El parámetro p de tipo Polygon . 
    */
    public void setPolygon(Polygon p){
        ruta=p;
    }
    /**
    * Método que dibuja los segmentos y la cuerda de la correa.
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar el objeto
    */
    public void paint(Graphics g){
        if(ruta!=null){
            g.setColor(Color.white);
            g.drawPolyline(ruta.xpoints,ruta.ypoints,ruta.npoints);
        }
        if(seg!=null){
            for(int i = 0; i < seg.size(); i++){
                Segmento aux = (Segmento)seg.get(i);
                aux.paint(g);
            }
        }
    }
    /**
    * Método que entrega la cantidad de puntos que tiene correa.
    * @return da la cantidad de puntos que tiene el polygon ruta
    */
    public int getLong(){
        if(ruta!=null)return ruta.npoints;
        else return 0;
    }
    /**
    * Método que va creando puntos en el caso de que el polygon ruta exista.
    * @param pos El parámetro pos de tipo entero representa una posición.
    * @return entrega un punto que cumple con las condiciones que involucran al parámetro pos.
    */
    public Point getPointPos(int pos){
        Point ret=null;
        if(ruta!=null){
            if(ruta.npoints>0 && pos>=0 && pos<ruta.npoints)
                ret = new Point(ruta.xpoints[pos],ruta.ypoints[pos]);
        }
        return ret;
    }
    /**
    * Método que contiene un ciclo que permite que, por medio de un segmento auxiliar, estos se muevan por la cuerda.
    */
    public void mover(){
        if(seg!=null){
            for(int i = 0;i < seg.size();i++){
                Segmento aux = (Segmento)seg.get(i);
                aux.mover();
            }
        }
    }
    /**
    * Método que añade segmentos a la cuerda.
    * @param a El parámetro a es el segmento que se añadirá al arreglo. 
    */
    public void addSegmento(Segmento a){
        seg.add(a);
    }
    /**
    * Método que entrega una referencia de la altura de la correa.
    * @return entrega la coordenada, como numero entero, superior de la correa transportadora
    */
    public int getAltura(){
        return y2-30;
    }
}

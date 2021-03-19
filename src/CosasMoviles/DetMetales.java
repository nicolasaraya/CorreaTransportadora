package CosasMoviles;
import java.awt.Color;
import java.awt.Graphics;
/**
 * Esta clase define, dibuja y crea al detector de metales, este cambia el color dependiendo de las características de los elementos que pasan por debajo.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class DetMetales {
    private int x,y;
    private boolean es;
    /**
     * Constructor que define el color, gracias al booleano, con el que empezará el detector y además recibe su ubicación.
     * @param xx El parámetro xx de tipo entero le entrega la ubicación del detector en el eje x. 
     * @param yy El parámetro yy de tipo entero entrega la ubicación del detector en el eje y.
     * @param z El parámetro z de tipo booleano entrega al constructor información del color  que marcxará al comienzo el detector.
     */
    public DetMetales(int xx,int yy, boolean z){
        x = xx;
        y = yy;
        es = z;
    }
    /**
    * Método que dibuja el detector, aquí realiza el cambio de color. 
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar el objeto
    */
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, 150, 45);
        g.fillRect(x, y, 20, 200);
        g.fillRect(x+130, y, 20, 200);
        g.setColor(Color.white);
        g.fillRect(x+20,y+10,110,26);
        if(es == true){
            g.setColor(Color.green);
            g.fillRect(x+20,y+10,110/2,26);
            
        }
        else {
            g.setColor(Color.red);
            g.fillRect(x+20+110/2,y+10,110/2,26);
        }   
    }
    /**
    * Método que cambia el valor del booleano, esto es para que el detector vuelva a su color original(rojo) o para que tome el booleano del elemento. 
    * @param xx El parámetro xx es el booleano que se quiere obtener.
    */
    public void setBol(boolean xx){
        es = xx;
    }
}
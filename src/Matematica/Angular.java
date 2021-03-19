package Matematica;
import java.awt.Point;
/**
 * Esta clase es prehecha y ayudó en el trabajo para calculo de angulos y generar puntos con ellos.
 * @author: Profesor Jorge López
 */
public class Angular {
    public  static Point generaPunto(Point uno, double r, double alfaGiro){    
        int x = (int)((double) uno.x + r*Math.cos(alfaGiro*Math.PI));
        int y = (int)((double) uno.y - r*Math.sin(alfaGiro*Math.PI)); 
        Point p = new Point(x, y);
        return p;
    }
    public static float anguloPI(Point uno, Point dos){
        float angulo,alto,ancho;       
        alto=dos.y-uno.y;
        ancho=dos.x-uno.x;
        angulo = (float)Math.atan2(-(double)alto,(double)ancho);      
        return angulo/(float)Math.PI;
    }
    public static double distEntre2Puntos(int x1, int y1, int x2, int y2){
        double d = Math.sqrt(
               ((double)x1-(double)x2)*
               ((double)x1-(double)x2)+
               ((double)y1-(double)y2)* 
               ((double)y1-(double)y2)
            );
        return d;
    }
    public static double distEntre2Puntos(Point uno, Point dos){
        double d=Math.sqrt(
               ((double)uno.x-(double)dos.x)*
               ((double)uno.x-(double)dos.x)+
               ((double)uno.y-(double)dos.y)* 
               ((double)uno.y-(double)dos.y)
            );
        return d;
    }
}    

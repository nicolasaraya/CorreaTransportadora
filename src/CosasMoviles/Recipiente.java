
package CosasMoviles;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
/**
 * Esta clase define, dibuja y crea a los recipientes: la mesita donde se ubican los objetos al iniciar el programa y el recipiente que esta ubicado al final de la correa transportadora.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Recipiente {
    private int x,y, tipo;
    /**
    * El constructor define donde se ubicará el recipiente y de que tipo será: si es 1 es "Recipiente" y si es 2 es "mesita".
    * @param x El parámetro x de tipo entero le entrega la ubicación del detector en el eje x. 
    * @param y El parámetro y de tipo entero entrega la ubicación del detector en el eje y.
    * @param n El parámetro n es el tipo de recipiente que será.
    */
    public Recipiente(int x, int y, int n){
        this.x = x;
        this.y = y;
        tipo = n;       
    }//Cierre constructor
    /**
    * Método que entrega la estructura del dibujo de los recipientes, este tiene imagenes del paquete CosasMoviles.Objetos.
    * @param g El parámetro que se le entrega al método para que sea capaz de dibujar
    */
    public void paint(Graphics g){
        if(tipo==1){
            g.setColor(Color.pink);
            g.fillRect(x+20, y+20, 80, 20);
            g.fillRect(x, y, 120, 20);
            g.setColor(Color.black);
            Font fuente = new Font("hola", Font.BOLD, 14);
            g.setFont(fuente);
            g.drawString("RECIPIENTE", x+16, y+16);
        }
        if(tipo==2){
            g.setColor(new Color(75, 54, 33));
            g.fillRect(x, y, 170, 25);
            g.fillRect(x+7, y, 15, 220);
            g.fillRect(x+148, y, 15, 220);
            g.setColor(Color.white);
            Font fuente = new Font("hola", Font.BOLD, 14);
            g.setFont(fuente);
            g.drawString("MESITA", x+55, y+20);
        }       
    }
}

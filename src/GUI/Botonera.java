package GUI;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
/**
 * Esta clase instancia los botones y los muestra en pantalla.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Botonera extends JPanel {
    /**
     * Constructor que instancia 4 botones, comienza marcando el botón "stop" con velocidad 0.
     */
    public Botonera(){
        super();
        BotonVel b1 = new BotonVel("100%",false,5);
        BotonVel b2 = new BotonVel("75%",false,3);
        BotonVel b3 = new BotonVel("25%",false,1);
        BotonVel b4 = new BotonVel("stop",true,0);       
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        bg.add(b3);
        bg.add(b4);
    }//Cierre constructor       
}


package GUI;
import Matematica.HolderVelocidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
/**
 * Esta clase crea el tipo de botón que aparece en la parte superior del programa, extiende a JRadioButton(es por esto que son circulares) e implementa ActionListener.
 * @author: Martina Cádiz y Nicolás Araya
 */
class BotonVel extends JRadioButton implements ActionListener {
    private int cualv;
    /**
    * El constructor recibe los datos del botón, su nombre y si estará marcado o no.
    * @param s El parámetro sel de tipo String es el nombre del botón que aparecerá en el programa. 
    * @param sel El parámetro sel de tipo booleano, si es True el botón estará marcado y si es False no estará marcado.
    * @param cual El parámetro cual es el entero que da la velocidad que tendrá cada botón.
    */
    public BotonVel(String s, boolean sel, int cual){
        super(s,sel);
        cualv=cual;
        this.addActionListener(this);
    }//Cierre constructor
    /**
     * Método que recibe los cambios que hará el cliente en el programa, es decir el cambio de velocidad que hace con los botones.
     * @param ae es el evento del ambiente.
     */
    public void actionPerformed(ActionEvent ae) {
        HolderVelocidad h = HolderVelocidad.getHolder(); //obtengo el puntero
        h.setNVelocidad(cualv);       
    }
}

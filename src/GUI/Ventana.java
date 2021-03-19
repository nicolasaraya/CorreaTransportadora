package GUI;
import java.awt.BorderLayout;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * Esta clase define la estructura que tendrá la ventana en la que interactuará el cliente.
 * @author: Martina Cádiz y Nicolás Araya
 */
public class Ventana extends JFrame {
    /**
     * El constructor entrega las características de como estan distribuidos los elementos del progrmaa.
     */
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Correa Transportadora del AEROPUERTO");
        this.add(new Naturaleza(),BorderLayout.CENTER);      
        this.add(new Botonera(),BorderLayout.NORTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,650);
        this.setVisible(true); 
        this.setLocationRelativeTo(null);      
    }//Cierre constructor 
}


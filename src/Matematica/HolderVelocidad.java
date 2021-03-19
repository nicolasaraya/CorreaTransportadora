package Matematica;
/**
 * Esta clase define el Holder, este es el que almacenará la información que entregue el cliente a los botones.
 * @author: Martina Cádiz y Nicolás Araya
 */    
public class HolderVelocidad {
    public static HolderVelocidad HB = null;
    private int velocidad;
    /**
     * Método que iguala la velocidad a cero.
     */
    private HolderVelocidad(){
        velocidad = 0;
    }
    /**
     * Método que cambia la velocidad.
     * @param nb El parámetro nb es la velocidad que entregará el botón apretado.
     */
    public void setNVelocidad(int nb){
        this.velocidad=nb;
    }
    /**
     * Método que sirve para acceder a la velocidad que almacena el Holder.
     * @return entrega la velocidad como entero.
     */
    public int getNVelocidad(){
        return velocidad;
    }
    /**
     * Método que permite que el Holder tenga una única instancia.
     * @return entrega la instancia del Holder. 
     */    
    public static HolderVelocidad getHolder(){
       if(HB == null) HB = new HolderVelocidad( );
       return HB;
    }
}

package Items;
import entidades.Jugador;

public abstract class Item {
    protected String nombre;
    public abstract void usar(Jugador jugador);
    public String getNombre(){
        return nombre;
    }
}

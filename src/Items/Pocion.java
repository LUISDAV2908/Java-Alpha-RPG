package Items;
import entidades.Jugador;

public class Pocion extends Item {
    private int curacion;

    public Pocion(String nombre, int curacion){
        this.nombre=nombre;
        this.curacion=curacion;

    }

    @Override
    public void usar(Jugador jugador){
        jugador.recibirDano(-curacion);
        System.out.println("Usaste "+ nombre + " y recuperaste "+ curacion+" puntos de salud");

    }
}
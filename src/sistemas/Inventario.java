package sistemas;
import java.util.ArrayList;

import Items.Arma;
import Items.Item;
import Items.Pocion;
import entidades.Jugador;
public class Inventario {
    private ArrayList<Item> items;

    public Inventario(){
        items = new ArrayList<>();

    }

    public Inventario getInventario(){
        return this;
    }

    public int getTamaño(){
        return items.size();
    }

    public void agregarItem(Item item){
        items.add(item);
    }

    public Item obtenerItem(int indice){
        return items.get(indice);
    }

    public void mostrarItems(){
        System.out.println("Items en el inventario:");
        for(int i=0; i<items.size(); i++){
            System.out.println(i + "." + items.get(i).getNombre());
        }
    }

    public void usarItem(int indice, Jugador jugador){
        Item item = items.get(indice);
        if(item instanceof Pocion){
            item.usar(jugador);
            items.remove(indice);
        }else if(item instanceof Arma){
            item.usar(jugador);
        }
    }

}

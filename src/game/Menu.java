package game;
import java.util.Scanner;

import Items.Arma;
import Items.Item;
import Items.Pocion;
import entidades.Jugador;
import mundo.Mundo;

public class Menu{
    private Scanner scanner;

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

    
    public void mostrarInventario(Jugador jugador){
        System.out.println("---Inventario---");
        jugador.getInventario().mostrarItems();
        System.out.println("Selecciona un item(-1 para salir de inventario)");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if(opcion>= 0 && opcion < jugador.getInventario().getTamaño()){
            Item item = jugador.getInventario().obtenerItem(opcion);
            if(item instanceof Arma){
                item.usar(jugador);
            } 
            if(item instanceof Pocion){
                jugador.getInventario().usarItem(opcion, jugador);
            
            }
        }else if(opcion == -1) {
            return;
        }else{
            System.out.println("Opcion no valida");
        }
        
    }

    public boolean menuPrincipal(Jugador jugador, Mundo mundo){
        System.out.println(jugador.getNombre()+" Vida: "+ jugador.getPs());
        System.out.println("1.Moverse(WASD)");
        System.out.println("2.Inventario");
        System.out.println("3.Salir del juego");

        if(!scanner.hasNextInt()){
            System.out.println("Opcion invalida");
            scanner.nextLine();
            return false;
        }

        int index = scanner.nextInt();
        scanner.nextLine();
        switch(index) {
            case 1:
                System.out.println("A donde nos movemos: ");
                String direccion = scanner.nextLine().toUpperCase();
                System.out.println("Moviendote");
                return mundo.moverJugador(jugador, direccion);
            case 2:
                mostrarInventario(jugador);
                return false;
            case 3:
                System.out.println("Saliendo del juego...");
                System.exit(0);
                return false;
            default:
                System.out.println("Opcion no valida");
                return false;
        }

    }

}

package sistemas;
import java.util.ArrayList;
import java.util.Scanner;

import Items.Arma;
import Items.Habilidades;
import Items.Item;
import entidades.Enemigo;
import entidades.Jugador;

public class SistemaCombate {
    private Scanner sc;

    public SistemaCombate(Scanner sc){
        this.sc = sc;
    }
    public void iniciarCombate( Jugador Jugador, Enemigo Enemigo){
        

        while(Jugador.estaVivo() && Enemigo.estaVivo()){
            System.out.println("\nVida de "+ Jugador.getNombre() + ": " + Jugador.getPs());
            System.out.println("Vida de "+ Enemigo.getNombre() + ": " + Enemigo.getPs());

            System.out.println("\nElige una accion");
            System.out.println("1. Atacar");
            System.out.println("2.Abrir invenatario");
            System.out.println("3. Usar habilidades");
            System.out.println("-1.Regresar al menu");
            if(!sc.hasNextInt()){
                System.out.println("Opcion no valida");
                sc.nextLine();
                return;
            }
            int opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1:
                    Jugador.atacar(Enemigo);
                    Jugador.aumentarDominio(Jugador.getArmaEquipada().getTipo());
                    break;
                case 2:
                    Jugador.getInventario().mostrarItems();
                    int index = sc.nextInt();
                    sc.nextLine();

                    if(index == -1){
                        break;
                    }
                    else{
                        Item item = Jugador.getInventario().obtenerItem(index);
                        if(item instanceof Arma){
                            item.usar(Jugador);
                        }else{
                            Jugador.getInventario().usarItem(index, Jugador);
                        }
                    }
                        
                    break;
                case 3:
                    if(!Jugador.tieneArmaEquipada()){
                        System.out.println("No tienes arma equipada");
                        break;
                    }

                    ArrayList<Habilidades> habilidades= Jugador.getArmaEquipada().getHabilidades();
                    for(int i=0;i<habilidades.size();i++){
                        System.out.println(i+". "+habilidades.get(i).getNombre());
                    }
                    if(!sc.hasNextInt()){
                        System.out.println("Opcion no valida");
                        sc.nextLine();
                        return;
                    }
                
                    int habilidadSelccionada = sc.nextInt();
                    sc.nextLine();
                    if(habilidadSelccionada<1 || habilidadSelccionada > habilidades.size()){
                        System.out.println("Habilidad invalida");
                        
                    }

                    Habilidades Habilidad = habilidades.get(habilidadSelccionada);

                    int dañoTotal = Jugador.getPa()+Jugador.getArmaEquipada().getDaño()+Habilidad.getDaño();
                    Enemigo.recibirDano(dañoTotal);
                    
                    System.out.println(Jugador.getNombre()+" usa "+Habilidad.getNombre());
                    Jugador.aumentarDominio(Jugador.getArmaEquipada().getTipo());
                    break;
                case -1:
                    return;

            }
            if(Enemigo.estaVivo()){
                Enemigo.atacar(Jugador);
            }
        }
        if(Jugador.estaVivo()) {
            System.out.println("Has ganado el combate");
            Jugador.ganarExperiencia(Enemigo.getXp());
            
        } else {
            System.out.println("Has muerto, fin del juego");
            System.exit(0);
        }
        
    }
}

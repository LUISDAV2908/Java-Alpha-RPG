package game;

import java.util.Random;
import java.util.Scanner;

import Items.Arma;
import Items.ArmaMitica;
import Items.Item;
import Items.Pocion;
import entidades.Enemigo;
import entidades.TipoEnemigo;
import entidades.Jugador;
import mundo.Mundo;
import sistemas.SistemaCombate;




public class Juego {
    private Scanner scanner;
    private Menu menu;
    private Mundo mundo;
    private Jugador jugador;
    private boolean jugando = true;
    private Item item;

    public Juego(){
        scanner = new Scanner (System.in);
        menu = new Menu(scanner);
        mundo = new Mundo(7,7);
        jugador = new Jugador("Jugador",150,5);
    }

    public void iniciar(){
        while(jugando){
            
            boolean seMovio = menu.menuPrincipal(jugador, mundo);
            if(seMovio){
                if(mundo.hayArmaLegendaria(jugador.getX(), jugador.getY())){
                    encontrarArmaLegendaria();
                    mundo.recogerArmaLegendaria();
                }

                Mundo.TipoEvento evento = mundo.generarEvento();
                switch(evento){
                    case ENEMIGO:
                        iniciarCombate();
                        break;
                    case ITEM:
                        encontrarItem();
                        break;
                    case TRAMPA:
                        eventoTrampa();
                        break;
                    case MEJORA:
                        eventoMejora();
                        break;
                    case NADA:
                        break;

                }
            }
            
        }
    }

    public void encontrarArmaLegendaria(){
        ArmaMitica arma = ArmaMitica.EspadaNoche();

        System.out.println("¡Has encontrado un arma legendaria!");
        System.out.println("Arma legendaria :"+arma.getNombre());
        jugador.getInventario().agregarItem(arma);
        if(!jugador.tieneArmaEquipada()){
            jugador.equiparArma((Arma)item);;
        }else{
           System.out.println("El arma se fue a tu inventario"); 
        }
    }

    private void iniciarCombate(){
        TipoEnemigo[] tipos = TipoEnemigo.values();
        TipoEnemigo tipoAleatorio = tipos[new Random().nextInt(tipos.length)];
        Enemigo enemigo = new Enemigo(tipoAleatorio);
        SistemaCombate combate = new SistemaCombate(scanner);
        combate.iniciarCombate(jugador, enemigo);
    }

    private void encontrarItem(){
        
        Random random = new Random();
        if(random.nextBoolean()){
            item = new Pocion("Pocion de salud", 30);
        } else {
            

            Arma[] armas= {
                Arma.espadaMadera(),
                Arma.Arco(),
                Arma.Daga(),
                Arma.Hacha(),
                Arma.espadaCarmesi()
            };

            item = armas[random.nextInt(armas.length)];
            
        }
        System.out.println("Has encontrado un item: " + item.getNombre());
        jugador.getInventario().agregarItem(item);
        if(item instanceof Arma){
            if(!jugador.tieneArmaEquipada()){
                jugador.equiparArma((Arma) item);
            }else{
                System.out.println("El arma se fue a tu inventario");
            }
        }
        mundo.limpiarCasilla(jugador.getX(), jugador.getY());
    }

    private void eventoTrampa(){
        System.out.println("¡Has caído en una trampa! Has perdido 20 puntos de salud");
        jugador.recibirDano(20);
        if(!jugador.estaVivo()){
            System.out.println("Has muerto! Fin del juego.");
            System.exit(0);
        }
    }

    private void eventoMejora(){
        System.out.println("Una magia antigua a mejorado tus puntos de ataque en 10");
        jugador.AumentarPa(10);
    }
}


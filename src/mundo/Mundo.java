package mundo;
import java.util.Random;

import entidades.Jugador;
public class Mundo {
    private int [][] mapa;
    private int fila=7;
    private int columna=7;
    private Random random = new Random();
    private int xArmaLegendaria;
    private int yArmaLegendaria;

    public Mundo(int fila,int columna){
        xArmaLegendaria=random.nextInt(columna);
        yArmaLegendaria=random.nextInt(fila);
        mapa = new int[fila][columna];
        for(int i=0; i<fila; i++){
            for(int j=0; j<columna; j++){
                mapa[i][j]=random.nextInt(7); 

            }
        }
    }

    public int obtenerEvento(int x, int y){
        return mapa[y][x];
    }
    

    public void limpiarCasilla(int x, int y){
        mapa[y][x]=0;
    }

    public int getFila(){
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    public enum TipoEvento {
        ENEMIGO, ITEM, TRAMPA, MEJORA, NADA
    }

    public TipoEvento generarEvento(){
        int posibilidad=random.nextInt(100);
        if(posibilidad<10){
            System.out.println("Has caido en una trampa! Has perdido 20 puntos de salud.");
            return TipoEvento.TRAMPA;
        }else if(posibilidad<15){
           System.out.println("Has encontrado una mejora! Has ganado 10 puntos de ataque.");
            return TipoEvento.MEJORA;
        }else if(posibilidad<40){
            System.out.println("Has encontrado un item.");
            return TipoEvento.ITEM;
        }else if(posibilidad<55){
            System.out.println("Ha aparecido un enemigo! Prepárate para el combate.");
            return TipoEvento.ENEMIGO;
        }
        return TipoEvento.NADA; 
    }

    public boolean hayArmaLegendaria(int x, int y){
        return x==xArmaLegendaria && y==yArmaLegendaria;
    }

    public boolean moverJugador(Jugador jugador, String direccion) {

    int nuevaX = jugador.getX();
    int nuevaY = jugador.getY();

    switch(direccion) {
        case "W": nuevaY--; break;
        case "S": nuevaY++; break;
        case "A": nuevaX--; break;
        case "D": nuevaX++; break;
        default: 
            System.out.println("Direccion Invalida");
            return false;
    }

    if (nuevaX >= 0 && nuevaX < columna &&
        nuevaY >= 0 && nuevaY < fila) {

        jugador.setPosicion(nuevaX, nuevaY);
        System.out.println("Te moviste a: (" + nuevaX + "," + nuevaY + ")");
        return true;
    } else {
        System.out.println("No puedes salir del mapa.");
        System.out.println("Te quedaste en: (" + jugador.getX() + "," + jugador.getY() + ")");
        return false;
        }
    }

    public void recogerArmaLegendaria(){
        xArmaLegendaria=-1;
        yArmaLegendaria=-1;
    }
}

package Items;
import entidades.Jugador;
import java.util.ArrayList;

public class Arma extends Item{
    private int Daño;
    private TiposArma tipo;
    private Rareza rareza;
    private int DominioMinimo;
    private ArrayList<Habilidades> habilidades;

    public Arma(String nombre, int Daño, TiposArma tipo, Rareza rareza, int DominioMinimo) {
        this.nombre = nombre;
        this.Daño = Daño;
        this.tipo = tipo;
        this.rareza = rareza;
        this.DominioMinimo= DominioMinimo;
        habilidades = new ArrayList<>();
    }

    public int getDaño(){
        return Daño;
    }

    public Rareza getRareza(){
        return rareza;
    }

    public TiposArma getTipo(){
        return tipo;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDominioMin(){
        return DominioMinimo;
    }

    public ArrayList<Habilidades>getHabilidades(){
        return habilidades;
    }

    public void AñadirHabilidad(Habilidades h){
        habilidades.add(h);
    }

    public void mostrarHabilidades(){
        for(int i=0; i< habilidades.size();i++){
            System.out.println(i+". "+habilidades.get(i).getNombre());
        }
    }

    public static Arma espadaMadera(){
        Arma espadaM= new Arma("Espada de madera",5,TiposArma.Espada,Rareza.Comun,1);
        espadaM.AñadirHabilidad(Habilidades.Corte_Rapido);
        espadaM.AñadirHabilidad(Habilidades.ESTOCADA);
        espadaM.AñadirHabilidad(Habilidades.Arco_Vertical);
        espadaM.AñadirHabilidad(Habilidades.Golpe_Cruzado);
        return espadaM;
    }

    public static Arma espadaCarmesi(){
        Arma espadaCarmesi=new Arma("Espada Carmesi",18,TiposArma.Espada,Rareza.Raro,5);
        espadaCarmesi.AñadirHabilidad(Habilidades.Corte_Rapido);
        espadaCarmesi.AñadirHabilidad(Habilidades.ESTOCADA);
        espadaCarmesi.AñadirHabilidad(Habilidades.Arco_Vertical);
        espadaCarmesi.AñadirHabilidad(Habilidades.Golpe_Cruzado);
        return espadaCarmesi;
    }

    public static Arma Hacha(){
        Arma Hacha= new Arma("Hacha de principiantes",12,TiposArma.Hacha,Rareza.Raro,1);
        Hacha.AñadirHabilidad(Habilidades.Tajo);
        Hacha.AñadirHabilidad(Habilidades.Torbellino);
        Hacha.AñadirHabilidad(Habilidades.Golpe_Triturador);
        Hacha.AñadirHabilidad(Habilidades.Corte_Brutal);
        return Hacha;
    }

    public static Arma Arco(){
        Arma Arco=new Arma("Arco de los inicios",8,TiposArma.Arco,Rareza.Comun,1);
        Arco.AñadirHabilidad(Habilidades.Disparo_Preciso);
        Arco.AñadirHabilidad(Habilidades.Flecha_Penetrante);
        Arco.AñadirHabilidad(Habilidades.Flecha_Penetrante);
        Arco.AñadirHabilidad(Habilidades.Disparo_Rapido);

        return Arco;
    }

    public static Arma Daga(){
        Arma Daga=new Arma("Daga del rey demonio",20,TiposArma.Daga,Rareza.Legendario,4);
        Daga.AñadirHabilidad(Habilidades.Mutilacion);
        Daga.AñadirHabilidad(Habilidades.Punalada);
        Daga.AñadirHabilidad(Habilidades.Corte_Veloz);
        Daga.AñadirHabilidad(Habilidades.Ataque_sombra);
        return Daga;
    }
    @Override
    public void usar(Jugador jugador){
        jugador.equiparArma(this);
        
    }
}

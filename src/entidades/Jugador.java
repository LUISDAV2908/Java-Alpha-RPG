package entidades;
import Items.Arma;
import Items.TiposArma;
import sistemas.Inventario;

public class Jugador extends Entidad {
    private int nivel;
    private int experiencia;
    private int experienciaNecesaria;
    private Inventario inventario;
    private int x=0;
    private int y=0;
    private Arma armaEquipada;
    private int DominioDeEspada;
    private int DominioHacha;
    private int DominioArco;
    private int DominioDaga;
    
    public Jugador(String nombre, int Ps, int Pa){
        super(nombre, Ps, Pa);
        this.nivel=1;
        this.experiencia=0;
        this.experienciaNecesaria=50;
        this.inventario=new Inventario();
        this.DominioDeEspada=1;
        this.DominioArco=1;
        this.DominioHacha=1;
        
        Arma armaInicial = Arma.espadaMadera();
        inventario.agregarItem( armaInicial);
        equiparArma(armaInicial);
    }

    @Override
    public void atacar(Entidad objetivo){
        int danoFinal = Pa;
        if(armaEquipada != null){
            danoFinal += armaEquipada.getDaño();
            System.out.println(nombre + " ataca a " + objetivo.getNombre()+" con "+armaEquipada.getNombre());
        }else{
            System.out.println(nombre + " ataca a " + objetivo.getNombre()+" con sus puños");
        }
        objetivo.recibirDano(danoFinal);
    }

    public void aumentarDominio(TiposArma tipo){
        switch(tipo){
            case Espada:
                DominioDeEspada++;
                break;
            case Hacha:
                DominioHacha++;
                break;
            case Arco:
                DominioArco++;
                break;
            case Daga:
                DominioDaga++;
                break;
        }

    }

    public void ganarExperiencia(int xp){
        experiencia +=xp;
        System.out.println("Ganaste "+ xp+" puntos de experiencia"); 
        if(experiencia >= experienciaNecesaria){
            subirNivel();
        } 
    }
    private void subirNivel(){
        nivel++;
        experiencia=0;
        experienciaNecesaria +=50;
        Ps +=20;
        Pa +=10;
        DominioDeEspada+=2;
        DominioHacha+=2;
        DominioArco+=2;
        DominioDaga+=2;
        System.out.println("¡Has subido al nivel "+nivel+"!");
    }

    public void AumentarPa(int bonus){
        Pa += bonus;
    }

    public Inventario getInventario(){
        return inventario;
    }

    public int getX(){
        return x;

    }
    public int getY(){
        return y;
    }

    public void setPosicion(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getDominio(TiposArma Tipo){
        switch(Tipo){
            case Espada:
                return DominioDeEspada;
            case Hacha:
                return DominioHacha;
            case Arco:
                return DominioArco;
            case Daga:
                return DominioDaga;
        }

        return 0;
    }

    public void equiparArma(Arma arma){
        if(getDominio(arma.getTipo())<arma.getDominioMin()){
            System.out.println("No tienes el dominio suficiente para usarla");
            return;
        }

        this.armaEquipada=arma;
        System.out.println("Has equipado "+arma.getNombre());
    }

    public Arma getArmaEquipada(){
        return armaEquipada;
    }

    public  boolean tieneArmaEquipada(){
        return armaEquipada != null;
    }
}

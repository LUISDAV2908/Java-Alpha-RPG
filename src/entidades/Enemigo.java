package entidades;
public class Enemigo extends Entidad {
    private TipoEnemigo tipo;
    private int Xp;
    public Enemigo(TipoEnemigo tipo){
        super("", 0,0);
        this.tipo=tipo;
        this.Xp=0;
        switch(tipo){
            case Lobo:
                nombre="Lobo de planicies";
                Ps=30;
                PsMax=30;
                Pa=8;
                Xp=13;
                break;
            case Bandido:
                nombre="Bandido oscuro";
                Ps=40;
                PsMax=40;
                Pa=12;
                Xp=20;
                break;
            case Goblin:
                nombre="Goblin de la montaña";
                Ps=20;
                PsMax=20;
                Pa=10;
                Xp=15;
                break;
        }

    }

    public int getXp(){
        return Xp;
    }

    @Override
    public void atacar(Entidad objetivo){
        System.out.println(nombre + "Ataca a "+ objetivo.getNombre()+" con "+ Pa+" puntos de ataque");
        objetivo.recibirDano(Pa);
    }

}

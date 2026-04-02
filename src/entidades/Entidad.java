package entidades;
public abstract class Entidad {
    protected String nombre;
    protected int Ps;
    protected int Pa;
    protected int PsMax;

    public Entidad(String nombre, int Ps, int Pa){
        this.nombre=nombre;
        this.Ps=Ps;
        this.PsMax=Ps;
        this.Pa=Pa;
    }

    public boolean estaVivo(){
        return Ps>0;
    }

    public void recibirDano(int dano){
        Ps-=dano;
        if(Ps>PsMax){
            Ps=PsMax;
        }

        if(Ps<0){
            Ps=0;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int getPs(){
        return Ps;
    }

    public int getPa(){
        return Pa;
    }

    public abstract void atacar(Entidad objetivo);
}

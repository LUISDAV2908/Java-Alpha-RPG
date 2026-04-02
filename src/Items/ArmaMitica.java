package Items;

public class ArmaMitica extends Arma{
    
    
    public ArmaMitica(String nombre, int daño, TiposArma tipo,int DominioMinimo){
        super(nombre,daño, tipo, Rareza.Mitico,DominioMinimo);
    }

    public static ArmaMitica EspadaNoche(){
        ArmaMitica espadaNoche= new ArmaMitica("Espada noche estrellada", 30, TiposArma.Espada, 9);
        espadaNoche.AñadirHabilidad(Habilidades.Corte_Rapido);
        espadaNoche.AñadirHabilidad(Habilidades.ESTOCADA);
        espadaNoche.AñadirHabilidad(Habilidades.Arco_Vertical);
        espadaNoche.AñadirHabilidad(Habilidades.Golpe_Cruzado);
        espadaNoche.AñadirHabilidad(Habilidades.Mejorar_arma);
        espadaNoche.AñadirHabilidad(Habilidades.Liberar);

        return espadaNoche;
        
    }

    
    

}

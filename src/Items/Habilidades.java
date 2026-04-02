package Items;

public enum Habilidades {
    Corte_Rapido("Corte rapido",TiposArma.Espada,11),
    ESTOCADA("Estocada",TiposArma.Espada,15),
    Arco_Vertical("Arco Vertical",TiposArma.Espada,18),
    Golpe_Cruzado("Golpe Cruzado",TiposArma.Espada,20),
    Tajo("Tajo",TiposArma.Hacha,10),
    Torbellino("Torbellino",TiposArma.Hacha,14),
    Golpe_Triturador("Golpe Triturador",TiposArma.Hacha,18),
    Corte_Brutal("Corte Brutal",TiposArma.Hacha,22),
    Disparo_Preciso("Disparo Preciso",TiposArma.Arco,12),
    Flecha_Penetrante("Flecha Penetrante",TiposArma.Arco,16),
    Disparo_Rapido("Disparo rapido",TiposArma.Arco,20),
    Lluvia_Flechas("Lluvia de flechas",TiposArma.Arco,24),
    Punalada("Puñalada",TiposArma.Daga,11),
    Corte_Veloz("Corte Veloz",TiposArma.Daga,14),
    Ataque_sombra("Ataque Sombra",TiposArma.Daga,19),
    Mutilacion("Mutilacion",TiposArma.Daga,25),
    Mejorar_arma("Mejorar Armamento",TiposArma.Espada,40),
    Liberar("Liberacion",TiposArma.Espada,70);

    private String nombre;
    private TiposArma tipoArma;
    private int daño;

    Habilidades(String nombre,TiposArma tipoArma,int daño){
        this.nombre=nombre;
        this.tipoArma=tipoArma;
        this.daño=daño;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDaño(){
        return daño;
    }
    
    public TiposArma gettipoArma(){
        return tipoArma;
    }

}

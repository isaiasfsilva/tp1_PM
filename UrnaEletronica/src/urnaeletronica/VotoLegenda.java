/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

/**
 *
 * @author isaiasfaria
 */
public final class VotoLegenda extends Voto{
    
    private Partidos partido;
    
    //Construtor
    public VotoLegenda(int ID, Cargos cargo, Partidos partido) {
        super(ID,cargo);
        this.setPartido(partido);
    }

    //Seta Partido do Voto
    public void setPartido(Partidos partido){
        this.partido=partido;
    }
    
    @Override
    public char getTipo() {
        return 'L';
    }
    
    
}
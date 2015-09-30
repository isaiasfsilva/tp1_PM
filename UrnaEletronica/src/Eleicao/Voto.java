/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicao;

/**
 *
 * @author isaiasfaria
 */
public abstract class Voto {
    private int id; 
    private Cargos cargo;
    public Voto(int ID, Cargos cargo){
       this.setID(ID);
       this.cargo=cargo;
    }
    //Função responsável em setar o ID de cada Voto
    private void setID(int ID){
        this.id=ID;
    }
    
    //Retorna o  ID do voto
    public final int getID(){
        return this.id;
    }
    
    //Seta para qual cargo é esse voto
    public final void setCargo(Cargos cargo){
        this.cargo = cargo;
    }
    
    //Retorna o cargo
    public final Cargos getCargo(){ //OU DEVERIA SER getNomeCargo e getIdCargo ???
        return this.cargo;
    }
    
    public abstract char getTipo();
}


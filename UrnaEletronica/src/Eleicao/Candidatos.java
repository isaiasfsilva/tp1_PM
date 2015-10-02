/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicao;

/**
 *
 * @author isaiasfaria and André
 */
public final class Candidatos extends Pessoa {
    private int id; 
    private Cargos cargo;
    private Partidos partido; //ou seria private int idPartido????
    
    //Construtor
    public Candidatos(int ID, String nome, Cargos cargo, Partidos partido){
       this.setID(ID);
       this.setNome(nome);
       this.setCargo(cargo);
       this.setPartido(partido);
    }
    
    //Função responsável em setar o ID de cada Candidato
    private void setID(int ID){
        this.id=ID;
    }
    //Função para retornar ID
    public int getID(){
        return this.id;
    }
    
    //Seta Cargo
    public void setCargo(Cargos cargo){
        this.cargo=cargo;
    }

    //Retorna Partido
    public Cargos getCargo(){
        return this.cargo;
    }
    
    //Seta Partido
    public void setPartido(Partidos partido){
        this.partido = partido;
    }
    
    //Retorna nome partido
    public Partidos getPartido(){
        return this.partido;
    }

  
       
            
    
}

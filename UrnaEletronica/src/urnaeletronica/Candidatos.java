/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

/**
 *
 * @author isaiasfaria and André
 */
public class Candidatos {
    private int id; 
    private Cargos cargo;
    private Partidos partido; //ou seria private int idPartido????
    private String nome;
    
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
    public final int getID(){
        return this.id;
    }
    
    //Seta o nome do candidato
    public final void setNome(String nome){
        this.nome = nome;
    }
    
    //Retorna o nome do Candidato
    public final String getNome(){
        return this.nome;
    }
    
    //Seta Cargo
    public final void setCargo(Cargos cargo){
        this.cargo=cargo;
    }
    
    //Retorna qual cargo
    public final String getNomeCargo(){
        return this.cargo.getNome();
    }
    
    //Seta Partido
    public final void setPartido(Partidos partido){
        this.partido = partido;
    }
    
    //Retorna nome partido
    public final String getNomePartido(){
        return this.partido.getNome();
    }
}

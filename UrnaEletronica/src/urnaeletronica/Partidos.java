/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

/**
 *
 * 
 */
//Esta classe não pode ser herdada. Somente instanciada.
public final class Partidos {
    private int id; 
    private String nome;
    public Partidos(int ID, String Nome){
       this.setID(ID);
       this.setNome(Nome);
    }
    //Método responsável em setar o ID de cada partido
    private void setID(int ID){
        this.id=ID;
    }
    //Retorna o ID
    public final int getID(){
        return this.id;
    }
    
    //Método para definir um nome
    public final void setNome(String Nome){
        this.nome=Nome;
    }
    
    //Retorna o nome do partido
    public final String getNome(){
        return this.nome;
    }
}

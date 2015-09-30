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
public final class Cargos {
    private int id; 
    private String nome;
    public Cargos(int ID, String Nome){
       this.setID(ID);
       this.setNome(Nome);
    }
    //Método responsável em setar o ID de cada cargo
    private void setID(int ID){
        this.id=ID;
    }
    //Retorna o ID
    public int getID(){
        return this.id;
    }
    
    //Método para definir um nome
    public void setNome(String Nome){
        this.nome=Nome;
    }
    
    //Retorna o nome do cargo
    public String getNome(){
        return this.nome;
    }
}

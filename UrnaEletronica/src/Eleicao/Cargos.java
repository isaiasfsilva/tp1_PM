/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicao;

/**
 *
 * 
 */
//Esta classe não pode ser herdada. Somente instanciada.
public final class Cargos {
    
    private int id; 
    private String nome;
    private boolean majoritario;
    
    public Cargos(int ID, String Nome, boolean majoritario){
       this.setID(ID);
       this.setNome(Nome);
       this.setMajoritario(majoritario);
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
    
    //REtorna o tipo de sistema 
    public boolean getMajoritario(){
        return this.majoritario;
        
    }
    
    //Retorna se um cargo usa sistema majoritário (true) ou proporcional(false)
    private void setMajoritario(boolean majoritario) {
        this.majoritario = majoritario;
    }
}

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
public class Pessoa {
    private String nome;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    //Retorna o nome do Candidato
    public String getNome(){
        return this.nome;
    }
}

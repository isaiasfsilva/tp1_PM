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
    public Candidatos(int ID){
       this.setID(ID);
    }
    //Função responsável em setar o ID de cada Candidato
    private final void setID(int ID){
        this.id=ID;
    }
}

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
public class VotoCandidato extends Voto {

    private Candidatos candidato;
    
    public VotoCandidato(int ID, Cargos cargo, Candidatos candidato) {
        super(ID, cargo);
        this.setCandidato(candidato);
    }

    private void setCandidato(Candidatos candidato) {
        this.candidato=candidato;
    }
    
    public Candidatos getCandidato(){
        return this.candidato;
    }

    
    
}

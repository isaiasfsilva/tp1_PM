/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;
import java.util.ArrayList;
/**
 *
 * @author isaiasfaria
 */
public final class Eleicao {
     private ArrayList<Cargos> cargos = new ArrayList();
     private ArrayList<Partidos> partidos = new ArrayList();
     private ArrayList<Candidatos> candidatos = new ArrayList();

//Métodos relacionados à cargos
     //Adiciona um novo Cargo
     public Cargos addCargo(int ID, String nome){
         Cargos tmp = new Cargos(ID, nome);
         this.cargos.add(tmp);
         return tmp;
     }
     
    public Cargos getCargoByID(int ID){
        for (Cargos c : this.cargos) {
            if (c.getID() == ID) {
                return c;
            }
        }
        return null; 
     }
    
//Métodos relacionados à partidos
     //Adiciona Partido
     public Partidos addPartido(int ID, String nome){
         Partidos tmp = new Partidos(ID,nome);
         this.partidos.add(tmp);
         return tmp;
     }
     
     public Partidos getPartidoByID(int ID){
        for (Partidos p : this.partidos) {
            if (p.getID() == ID) {
                return p;
            }
        }
        return null; 
     }
     
//Métodos relacionados ao candidato
     //Adicionar novo candidato
     public void addCandidato(int ID, String nome, Cargos cargo, Partidos partido){
         this.candidatos.add(new Candidatos(ID, nome, cargo, partido));
     }
     
     public Candidatos getCandidatoByID(int ID){
        for (Candidatos c : this.candidatos) {
            if (c.getID() == ID) {
                return c;
            }
        }
        return null;        
     }
     
     //Lista candidatos
     public void listaCandidatos(){
        int i;
        for (i=0; i<this.candidatos.size(); i++) { 
            System.out.println("Nome:" +this.candidatos.get(i).getNome()+" - Cargo: "+this.candidatos.get(i).getNomeCargo()+" - Partido:"+this.candidatos.get(i).getNomePartido());
        }

     }
}

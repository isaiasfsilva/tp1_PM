/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author isaiasfaria
 */
public final class Eleicao {
     private ArrayList<Cargos> cargos = new ArrayList();
     private ArrayList<Partidos> partidos = new ArrayList();
     private ArrayList<Candidatos> candidatos = new ArrayList();     
     private ArrayList<VotoCandidato> votosCandidatos = new ArrayList();
     private ArrayList<VotoLegenda> votosLegenda = new ArrayList();

     private ArrayList<Voto> votosBranco = new ArrayList();
     
//Métodos relacionados à cargos
     //Adiciona um novo Cargo
     public Cargos addCargo(int ID, String nome){
         Cargos tmp = new Cargos(ID, nome, Eleicao.getSistema(nome));
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
            System.out.println("Nome:" +this.candidatos.get(i).getNome()+" - Cargo: "+this.candidatos.get(i).getNomeCargo()+" - Partido:"+this.candidatos.get(i).getPartido().getNome());
        }

     }
 //Métodos relacionados aos votos
    public void addVoto(int ID, int idCargo, char tipo, int idDest){
         if(tipo=='L'){ //se é voto de legenda!

             if(getVotoByIdAndPartido(idDest, idCargo)==null)
                     this.votosLegenda.add(new VotoLegenda(ID, this.getCargoByID(idCargo), this.getPartidoByID(idDest)));
//
//                 //vota no candidato / Cargo
                 getVotoByIdAndPartido(idDest, idCargo).addVoto();
         }else if(tipo=='C'){
             
            
            //Se não existe voto similar, ele cria. Caso contrário ADD VOTO
            if(getVotoByIdAndCargo(idDest, idCargo)==null)
               this.votosCandidatos.add(new VotoCandidato(ID, this.getCargoByID(idCargo), getCandidatoByID(idDest)));

              
//            //vota no candidato / Cargo
            getVotoByIdAndCargo(idDest, idCargo).addVoto();
//
//
             if(!this.getCargoByID(idCargo).getMajoritario()){ //Se esse cargo NAO usa sistema majoritário
                 //Se não existe voto similar, ele cria. Caso contrário ADD VOTO
                 if(getVotoByIdAndPartido(idDest, idCargo)==null)
                     this.votosLegenda.add(new VotoLegenda(ID, this.getCargoByID(idCargo), this.getCandidatoByID(idDest).getPartido()));
//
//                 //vota no candidato / Cargo
                 getVotoByIdAndPartido(this.getCandidatoByID(idDest).getPartido().getID(), idCargo).addVoto();
//                 
//             
             }
         
         }
    }
 public VotoCandidato getVotoByIdAndCargo(int idCandidato, int idCargo){
        for (VotoCandidato v : this.votosCandidatos) {

            if ( v.getCandidato().getID() == idCandidato && v.getCargo().getID()==idCargo ) {
                return v;
            }
        }
        return null;        
     }  
 
 
 public VotoLegenda getVotoByIdAndPartido(int idPartido, int idCargo){
        for (VotoLegenda v : this.votosLegenda) {

            if (v.getPartido().getID() == idPartido && v.getCargo().getID()==idCargo ) {
                return v;
            }
        }
        return null;        
     } 
      //Lista Votos
     public void listaVotos(){
        int i;
        System.out.println("VOTOS EM CANDIDATOS:");
        for (i=0; i<this.votosCandidatos.size(); i++) { 
            System.out.println("CARGO:"+this.votosCandidatos.get(i).getCandidato().getNomeCargo()+" - Candidato:" +this.votosCandidatos.get(i).getCandidato().getNome());
        }
        
        
        System.out.println("VOTOS EM PARTIDO:");
        for (i=0; i<this.votosLegenda.size(); i++) { 
            System.out.println("CARGO:"+this.votosLegenda.get(i).getCargo().getNome()+" - Partido:" +this.votosLegenda.get(i).getPartido().getNome());
        }
     }
    //true = Majoritário
    //false = Proporcional
    private static boolean getSistema(String nome){
        
        Map<String, Boolean> m = new HashMap<>();
        m.put("Presidente", true);
        m.put("Governador", true);
        m.put("Prefeito", true);
        m.put("Vice-presidente", true);
        m.put("Vice-governador", true);
        m.put("Vice-prefeito", true);
        
        
        m.put("Deputado federal", false);
        m.put("Deputado estadual", false);
        m.put("Vereador", false);
        return m.getOrDefault(nome,false);
    }
}

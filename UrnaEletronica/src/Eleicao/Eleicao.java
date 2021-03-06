/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
     private ArrayList<Voto> votosNulo = new ArrayList();
     
//Métodos relacionados à cargos
     //Adiciona um novo Cargo
     public void addCargo(int ID, String nome){
         this.cargos.add(new Cargos(ID, nome, Eleicao.getSistema(nome)));
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
     public void addPartido(int ID, String nome){
        this.partidos.add(new Partidos(ID,nome));
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
//Retorna o candidato pelo ID     
     public Candidatos getCandidatoByID(int ID){
        for (Candidatos c : this.candidatos) {
            if (c.getID() == ID) {
                return c;
            }
        }
        return null;        
     }
     
    
 //Métodos relacionados aos votos
    public void addVoto(int ID, int idCargo, char tipo, int idDest){
        //O voto é NULO se:
              //O cargo informado é de um VICE
              //Se é voto de LEGENDA e o ID do partido não existe
              //Se é voto de CANDIDATO e o ID do candidato não existe
        if(idDest==0){
              if(getVotoEmBrancoByCargo(idCargo)==null)
                 this.votosBranco.add(new Voto(ID, this.getCargoByID(idCargo)));

                 //vota no candidato / Cargo
                getVotoEmBrancoByCargo(idCargo).addVoto();
                 
                 
        }else{ //Se não é voto em branco!!
        
            if(tipo=='L'){ //se é voto de legenda!
                if(this.getPartidoByID(idDest)==null){//Se é NULO
                    if(getVotoNuloByCargo(idCargo)==null)
                        this.votosNulo.add(new Voto(ID, this.getCargoByID(idCargo)));

                    //vota no candidato / Cargo
                    getVotoNuloByCargo(idCargo).addVoto();  
                }else{
                 if(getVotoByIdAndPartido(idDest, idCargo)==null)
                    this.votosLegenda.add(new VotoLegenda(ID, this.getCargoByID(idCargo), this.getPartidoByID(idDest)));

                    //vota no candidato / Cargo
                    getVotoByIdAndPartido(idDest, idCargo).addVoto();
                }
            }else if(tipo=='C'){
                if(this.getCandidatoByID(idDest)==null){//Se é NULO
                    if(getVotoNuloByCargo(idCargo)==null)
                      this.votosNulo.add(new Voto(ID, this.getCargoByID(idCargo)));

                    //vota no candidato / Cargo
                    getVotoNuloByCargo(idCargo).addVoto();  
                }else{
                //Se não existe voto similar, ele cria. Caso contrário ADD VOTO
               if(getVotoById(idDest)==null)
                  this.votosCandidatos.add(new VotoCandidato(ID, this.getCargoByID(idCargo), getCandidatoByID(idDest)));


               //vota no candidato / Cargo
               getVotoById(idDest).addVoto();
                }
            }
        }

    }
    
 //Retorna os votos do candidato @idCandidato
 public VotoCandidato getVotoById(int idCandidato){
        for (VotoCandidato v : this.votosCandidatos) {
            if ( v.getCandidato().getID() == idCandidato ) {
                return v;
            }
        }
        return null;        
     }  
 
 //Retorna os votos para um @idCargo de um determinado partido @idCandidato
 public VotoLegenda getVotoByIdAndPartido(int idPartido, int idCargo){
        for (VotoLegenda v : this.votosLegenda) {
            if (v.getPartido().getID() == idPartido && v.getCargo().getID()==idCargo ) {
                return v;
            }
        }
        return null;        
     } 
 
  //Retorna um Voto em branco para o cardo @idCargo 
  public Voto getVotoEmBrancoByCargo(int idCargo){
        for (Voto v : this.votosBranco) {
            if (v.getCargo().getID()==idCargo ) {
                return v;
            }
        }
        return null;        
     } 
  
    //Retorna um Voto NULO para o cardo @idCargo 
  public Voto getVotoNuloByCargo(int idCargo){
        for (Voto v : this.votosNulo) {
            if (v.getCargo().getID()==idCargo ) {
                return v;
            }
        }
        return null;        
     } 
  
  
  
  
     
//Retorna o candidato eleito para um cargo @cargo 
      public final Candidatos getEleitoByCargo(Cargos cargo){
          VotoCandidato c_tmp=null; //Candidato temporário
          if(cargo.getMajoritario()){
              int i;
              for (i=0; i<this.votosCandidatos.size(); i++) {
                  
                 if(this.votosCandidatos.get(i).getCargo()==cargo){
                     
                     if(c_tmp==null){//Se achou alguém que teve voto e 
                         c_tmp=this.votosCandidatos.get(i);
                     }else{//Verifique se teve mais votos que o anterior
                         if(this.votosCandidatos.get(i).getVotos()>c_tmp.getVotos())
                             c_tmp=this.votosCandidatos.get(i);
                         else if(this.votosCandidatos.get(i).getVotos()==c_tmp.getVotos()){//Se empataram!!!
                             if(Utils.Utils.ordemAlfabetica(c_tmp.getCandidato(), this.votosCandidatos.get(i).getCandidato())==this.votosCandidatos.get(i).getCandidato()){
                               c_tmp=this.votosCandidatos.get(i); //Pega em ordem alfabética!!  
                             }
                         }
                     }
                  
                     
                 } 
                 
              }
          }else{
              Partidos p_tmp = this.getPartidoMaisVotadoByCargo(cargo);
             if(p_tmp==null)
                 return null;
             
             //Pega o candidato com maior número de votos dentro desse partido!!!
             int i;
             for (i=0; i<this.votosCandidatos.size(); i++) { 
                 if(this.votosCandidatos.get(i).getCargo()==cargo && this.votosCandidatos.get(i).getCandidato().getPartido()==p_tmp){
                     if(c_tmp==null){//Se achou alguém que teve voto e 
                         c_tmp=this.votosCandidatos.get(i);
                     }else{//Verifique se teve mais votos que o anterior
                         if(this.votosCandidatos.get(i).getVotos()>c_tmp.getVotos())
                             c_tmp=this.votosCandidatos.get(i);
                         else if(this.votosCandidatos.get(i).getVotos()==c_tmp.getVotos()){//Se empataram!!!
                             if(Utils.Utils.ordemAlfabetica(c_tmp.getCandidato(), this.votosCandidatos.get(i).getCandidato())==this.votosCandidatos.get(i).getCandidato()){
                               c_tmp=this.votosCandidatos.get(i); //Pega em ordem alfabética!!  
                             }
                         }
                     }
                  
                     
                 } 
                 
              }
          }
          return (c_tmp==null)?null:c_tmp.getCandidato(); //Retorna nulo se não teve nenhum voto para esse cargo!
          
      }
      
      
      
      
    //true = Majoritário
    //false = Proporcional
    private static boolean getSistema(String nome){
        
        Map<String, Boolean> m = new HashMap<>();
        
        //Cargos Majoritários
        m.put("Presidente", true);
        m.put("Governador", true);
        m.put("Prefeito", true);
        m.put("Vice-presidente", true);
        m.put("Vice-governador", true);
        m.put("Vice-prefeito", true);
        
        //Cardos cujo sistema de voto é normal
        m.put("Deputado federal", false);
        m.put("Deputado estadual", false);
        m.put("Vereador", false);
        return (m.get(nome)==null)?m.get(nome):false;
    }

    //Gera relatório do candidato
    public String getRelatorioByCandidato(Candidatos candidato) {
       String s="";
       s+=("Candidato - "+candidato.getCargo().getNome()+"\n");
       s+=(candidato.getNome()+"\n");
       s+=(candidato.getPartido().getNome()+"\n");
       if (candidato.getID()>9) //Vice sempre terá 0 votos
            s+="0 votos\n";
       else
            s+=(this.getVotoById(candidato.getID()).getVotos()+" voto"+((this.getVotoById(candidato.getID()).getVotos()!=1)?"s":"")+"\n");
      
       
       if(candidato.getID()>9) //Se é vice, temos que ver se o titular foi eleito!
            s+=((this.getEleitoByCargo(this.getCandidatoByID(candidato.getID()/10).getCargo())==this.getCandidatoByID(candidato.getID()/10))?"Eleito":"Não Eleito")+"\n";
       else
            s+=((this.getEleitoByCargo(candidato.getCargo())==candidato)?"Eleito":"Não Eleito")+"\n";
       
       return s;
    }

    //Gera relatório do Cargo
    public String getRelatorioByCargo(Cargos cargo) {
       String s="";
       s+=("Candidatos - "+cargo.getNome()+"\tVotos\n");
       int i;
        for (i=0; i<this.candidatos.size(); i++) { 
            if(this.candidatos.get(i).getCargo()==cargo){
                //Retorna 0 se o candidato não teve voto e N se o candidato tem algum voto, onde N é a quantidade de votos
                int qvotos = (getVotoById(this.candidatos.get(i).getID())!=null)?getVotoById(this.candidatos.get(i).getID()).getVotos():0;
                s+=(this.candidatos.get(i).getNome()+"\t"+qvotos+"\n");
            }
         }

        int qvotos=0;
            for (i=0; i<this.votosBranco.size(); i++) { 
                 if(this.votosBranco.get(i).getCargo()==cargo)
                     qvotos=this.votosBranco.get(i).getVotos();
             }      
             s+=("Brancos \t" +qvotos+"\n");

             qvotos=0;
             for (i=0; i<this.votosNulo.size(); i++) { 
                 if(this.votosNulo.get(i).getCargo()==cargo)
                     qvotos=this.votosNulo.get(i).getVotos();
             }
             s+=("Nulos \t" +qvotos+"\n\n");

             //Mostra votos LEGENDA
             String rotulo="Partidos\n";
             for (i=0; i<this.votosLegenda.size(); i++) { 
                if(this.votosLegenda.get(i).getCargo()==cargo){
                    s+=(rotulo+this.votosLegenda.get(i).getPartido().getNome()+"\t"+this.votosLegenda.get(i).getVotos()+"\n");
                    rotulo="";
                }
             }
      return s;
       }

    
    
    //Retorna o partido mais votado para um determinado cargo
    private Partidos getPartidoMaisVotadoByCargo(Cargos cargo) {
        Map<Partidos, Integer> p = new HashMap<Partidos, Integer>();
        int i;
        for (i=0; i<this.votosCandidatos.size(); i++) { //Soma todos os votos de candidato
            
            if(this.votosCandidatos.get(i).getCandidato().getCargo()==cargo){
                Integer temp =(p.get(this.votosCandidatos.get(i).getCandidato().getPartido())==null)?0:p.get(this.votosCandidatos.get(i).getCandidato().getPartido()); 
                p.remove(this.votosCandidatos.get(i).getCandidato().getPartido());
                p.put(this.votosCandidatos.get(i).getCandidato().getPartido(), temp+this.votosCandidatos.get(i).getVotos());
               // p.replace(this.votosCandidatos.get(i).getCandidato().getPartido(), (p.get(this.votosCandidatos.get(i).getCandidato().getPartido())+this.votosCandidatos.get(i).getVotos()));//Soma os votos para o partido

            }
                        
        }
//Soma todos os votos de LEGENDA        
        for (i=0; i<this.votosLegenda.size(); i++) { 
            
            if(this.votosLegenda.get(i).getCargo()==cargo){
                Integer temp = (p.get(this.votosLegenda.get(i).getPartido())==null)?0:p.get(this.votosLegenda.get(i).getPartido());
                p.remove(this.votosLegenda.get(i).getPartido());
                p.put(this.votosLegenda.get(i).getPartido(), temp+this.votosLegenda.get(i).getVotos());
              //  p.replace(this.votosLegenda.get(i).getPartido(), 
                       // p.get(this.votosLegenda.get(i).getPartido())+this.votosLegenda.get(i).getVotos());//Soma os votos para o partido

            }
                        
        }
       
        
//Percorre e descobre o Partido mais votado        
        Entry<Partidos,Integer> maxEntry = null;
        for(Entry<Partidos,Integer> entry : p.entrySet()) { 
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        
 
        return (maxEntry==null)?null:maxEntry.getKey();
    }

    //Gera relatório dos eleitos para todos os cargos
    public String getRelatorioGeral() {
        String s="";
        s+=("Cargo \t Eleito\n");
        int i;
        for (i=0; i<this.cargos.size(); i++) { 
            if(this.getEleitoByCargo(this.cargos.get(i))!=null)
                s+=(this.cargos.get(i).getNome()+"\t" +this.getEleitoByCargo(this.cargos.get(i)).getNome()+"\n");
        }
        return s;
    }
}

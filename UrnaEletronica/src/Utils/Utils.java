/*
 * Nesta classe vamos adicionar alguns métodos que serão úteis. 
  - Podemos pensar em leitura de arquivos e afins.
 */
package Utils;
import Eleicao.Candidatos;
import Eleicao.Eleicao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


/**
 *
 * @author isaiasfaria
 */
public abstract  class  Utils {
    // Retorna o candidato A se ele vier primeiro pela ordem alfabética. Se der empate retorna o A.
    public static Candidatos ordemAlfabetica(Candidatos A, Candidatos B){
        if(B.getNome().compareTo(A.getNome())<0)
            return B;
        else 
            return A;
    }

//carrega todos os cargos
    public static void loadCargos(Eleicao e){
        try (BufferedReader br = new BufferedReader(new FileReader("cargos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addCargo(Integer.parseInt(s[0]), s[1]);
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os cargos. Abortando operação agora!");
        }   
    }
    
//Carrega todos os partidos
    public static void loadPartidos(Eleicao e){
        try (BufferedReader br = new BufferedReader(new FileReader("partidos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addPartido(Integer.parseInt(s[0]), s[1]);
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os Partidos. Abortando operação agora!");
        }
    }

//Carrega todos os candidatos
    public static void loadCandidatos(Eleicao e){
        try (BufferedReader br = new BufferedReader(new FileReader("candidatos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addCandidato(Integer.parseInt(s[0]), s[3],e.getCargoByID(Integer.parseInt(s[1])), e.getPartidoByID(Integer.parseInt(s[2])));
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os Candidatos. Abortando operação agora!");
        }
    }
    
 //carrega todos os Votos
    public static void loadVotos(Eleicao e){
        try (BufferedReader br = new BufferedReader(new FileReader("votos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) { 
                //Percorre todos os votos
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addVoto(Integer.parseInt(s[0]), Integer.parseInt(s[1]),  s[2].charAt(0), Integer.parseInt(s[3]));
                   
            
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os cargos. Abortando operação agora!");
        }   
    }
   
    

//Carrega todos as estatísticas
    public static void loadRelatorios(Eleicao e){
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                
                //Cria arquivo de saíde
                Writer writer = null;
                try {
                    writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("estatistica-"+s[0]+"-"+s[1]+".txt")));
                 
                    switch (Integer.parseInt(s[0])){
                        case 1:
                            writer.write(e.getRelatorioGeral());
                            break;
                        case 2:
                            writer.write(e.getRelatorioByCargo(e.getCargoByID(Integer.parseInt(s[1]))));
                            break;
                        case 3:
                            writer.write(e.getRelatorioByCandidato(e.getCandidatoByID(Integer.parseInt(s[1]))));
                            break;
                        default:
                           writer.write("Tipo de Relatório inexistente");

                        }
                    } catch (IOException ex) {
                      // report
                    } finally {
                       try {writer.close();} catch (Exception ex) {/*ignore*/}
                    }
            
            
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os relatórios. Abortando operação agora!");
        }
    }
    
}

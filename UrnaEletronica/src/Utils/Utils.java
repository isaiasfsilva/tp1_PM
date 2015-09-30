/*
 * Nesta classe vamos adicionar alguns métodos que serão úteis. 
  - Podemos pensar em leitura de arquivos e afins.
 */
package Utils;
import Eleicao.Candidatos;
import Eleicao.Eleicao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import urnaeletronica.*;


/**
 *
 * @author isaiasfaria
 */
public class Utils {
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
                   e.addCandidato(Integer.parseInt(s[0]), s[1],e.getCargoByID(Integer.parseInt(s[2])), e.getPartidoByID(Integer.parseInt(s[2])));
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os Candidatos. Abortando operação agora!");
        }
    }
}

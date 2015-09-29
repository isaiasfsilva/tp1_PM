/*
 * Classe Principal
   -Nessa classe vamos instanciar os objetos e chamar os métodos das outras classes
 */
package urnaeletronica;
import Utils.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author isaiasfaria
 */
public class UrnaEletronica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utils u = new Utils();
        Eleicao e = new Eleicao();
        
    //Lembrar de adicionar os métodos de importar dentro de ELEIÇÃO !?? oU DENTRO DE UTILS?    
        //carrega todos os cargos
        try (BufferedReader br = new BufferedReader(new FileReader("cargos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addCargo(Integer.parseInt(s[0]), s[1]);
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os cargos. Abortando operação agora!");
        } 
        
        
        //carrega todos os Partidos
        try (BufferedReader br = new BufferedReader(new FileReader("partidos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addPartido(Integer.parseInt(s[0]), s[1]);
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os Partidos. Abortando operação agora!");
        } 
        
        
        //carrega todos os Candidatos
        try (BufferedReader br = new BufferedReader(new FileReader("candidatos.txt"))){
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                   String[] s = sCurrentLine.split(";"); // Pega o ID em s[0] e o nome em s[1]
                   e.addCandidato(Integer.parseInt(s[0]), s[1],e.getCargoByID(Integer.parseInt(s[2])), e.getPartidoByID(Integer.parseInt(s[2])));
            }
        } catch (IOException error) {
                System.out.println("Erro ao importar os Candidatos. Abortando operação agora!");
        } 
        
        
        
        e.listaCandidatos();
        
      }
    
}

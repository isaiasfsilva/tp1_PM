/*
 * Classe Principal
   -Nessa classe vamos instanciar os objetos e chamar os métodos das outras classes
 */
package urnaeletronica;
import Eleicao.*;
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
       Eleicao e = new Eleicao();
        
    // Carrega ambiente (Cargos, Partidos, Candidatos)    
        Utils.loadCargos(e);
        Utils.loadPartidos(e);
        Utils.loadCandidatos(e);
        
        e.listaCandidatos();
       
      }
    
}

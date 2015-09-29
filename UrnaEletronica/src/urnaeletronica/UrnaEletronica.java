/*
 * Classe Principal
   -Nessa classe vamos instanciar os objetos e chamar os métodos das outras classes
 */
package urnaeletronica;
import Utils.*;
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
        e.addCargo(1, "Prefeito");
        e.addCargo(2, "Vereador");
        
        e.addPartido(1, "PT");
        e.addPartido(2, "OMDB");
        
        e.addCandidato(1,"Isaías Faria", e.getCargoByID(2), e.getPartidoByID(1));
        e.addCandidato(2,"Gerlado", e.getCargoByID(1), e.getPartidoByID(1));
        e.addCandidato(3,"Bete", e.getCargoByID(2), e.getPartidoByID(2));
        
        e.listaCandidatos();
    }
    
}

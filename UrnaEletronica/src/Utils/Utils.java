/*
 * Nesta classe vamos adicionar alguns métodos que serão úteis. 
  - Podemos pensar em leitura de arquivos e afins.
 */
package Utils;
import urnaeletronica.*;


/**
 *
 * @author isaiasfaria
 */
public class Utils {
    // Retorna o candidato A se ele vier primeiro pela ordem alfabética. Se der empate retorna o A.
    public Candidatos ordemAlfabetica(Candidatos A, Candidatos B){
        if(B.getNome().compareTo(A.getNome())<0)
            return B;
        else 
            return A;
    }
    
   
}

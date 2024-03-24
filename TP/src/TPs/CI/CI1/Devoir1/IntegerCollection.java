
import java.util.List;
import java.util.ArrayList;
import MesExceptions.*;

public class IntegerCollection {

    private List<Integer> liste;

    /**
     * @effects crée une nouvelle IntegerCollection contenant dans l'ordre 1,2,3,4,5,6
     */
    public IntegerCollection() {
        liste = new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        liste.add(5);
        liste.add(6);
    }

    /**
     * @returns index of the first occurence of i in liste 
     * @throws MissingIntegerException if i is not in liste ( #{x ∈ liste| x = i} = 0 )
     */
    public int searchInt(Integer i) throws MissingIntegerException {
        int r = liste.indexOf(i);
        if (r == -1){
            throw new MissingIntegerException("Missing value : " + i +  " in IntegerCollection.searchInt()");
        }
        return r;
    }

    // Pas besoin de spécifier expliqué en cours théorique
    @Override
    public String toString() {
        return "Collection : " + liste;
    }

    /**
     * @throws NullPointerException
     */
    private void exceptionGenerator(){
        throw new NullPointerException();
        /*
         * Pourquoi l'appel à cette méthode exceptionGenerator ne pose pas de souci au compilateur?
         * Réponse : Il s'agit d'une exception non-vérifiée (héritée de RunTimeException)
         *      --> Elle n'est donc pas vérifiée par le compilateur lors de l'exécution du programme
         * Il semblerait que ce soit voulu et didactique! ToDo Effectuez les spécifications en suivant les recommendations
         * vues aux cours de CPOO.
         * 
         * 
         */
        
    }

    /**
     * @requires exceptionGenerator only throws NullPointerException
     * @throws MonExceptionAMoiException if a NullPointerException is caught
     */
    public void captureEtRelance(){
        /* Todo Capturez l'exception lancée lors de l'appel à exceptionGenerator et lancez une nouvelle exception
         * non-vérifiée MonExceptionAMoiException.
         * */

        try {
            exceptionGenerator();
        } 
        catch (NullPointerException e){
            throw new MonExceptionAMoiException();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
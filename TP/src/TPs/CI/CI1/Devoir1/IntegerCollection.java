package TPs.CI.CI1.Decoir1;

import java.util.List;
import java.util.ArrayList;
import MesExceptions

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
     * throws MissingIntegerException if i is not in this ( #{x ∈ this| x = i} = 0 )
     * returns index of the first occurence of i in this otherwise
     */
    public int searchInt(Integer i) {
        int r = this.indexOf(i);
        if (r == -1){
            throw new MissingIntegerException("IntegerCollection.searchInt()");
        }
        return r;
    }

    // Pas besoin de spécifier expliqué en cours théorique
    @Override
    public String toString() {
        return "Collection : " + liste;
    }

    /**
     * ToDo
     */
    private void exceptionGenerator(){
        throw new NullPointerException();
        /*
         * Pourquoi l'appel à cette méthode exceptionGenerator ne pose pas de souci au compilateur?
         * Réponse : ToDo
         * Il semblerait que ce soit voulu et didactique! ToDo Effectuez les spécifications en suivant les recommendations
         * vues aux cours de CPOO.
         */

    }

    /**
     * ToDo
     */
    public void captureEtRelance(){
        exceptionGenerator();
        /* Todo Capturez l'exception lancée lors de l'appel à exceptionGenerator et lancez une nouvelle exception
         * non-vérifiée MonExceptionAMoiException.
         */
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
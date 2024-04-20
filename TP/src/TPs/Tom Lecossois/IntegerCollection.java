package TPs.CI;

import TPs.Exceptions.MissingIntegerException;
import TPs.Exceptions.MonExceptionAMoiException;

import java.util.List;
import java.util.ArrayList;

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
     * @param i l'entier à rechercher
     * @return l'index de l'entier s'il est présent, sinon lance une MissingIntegerException
     * @throws MissingIntegerException si l'entier spécifié n'existe pas dans la collection
     */
    public int searchInt(Integer i) throws MissingIntegerException {
        int index = liste.indexOf(i);
        if (index == -1) {
            throw new MissingIntegerException("L'entier spécifié n'existe pas dans la collection");
        }
        return index;
    }

    // Pas besoin de spécifier expliqué en cours théorique
    @Override
    public String toString() {
        return "Collection : " + liste;
    }

    /**
     * @return une nouvelle NullPointerException
     */
    private void exceptionGenerator() {
        throw new NullPointerException("NullPointerException générée par exceptionGenerator()");
        /*
         * L'appel à cette méthode ne pose pas de problème au compilateur car elle ne déclare pas qu'elle lance
         * une exception. Cela est possible car NullPointerException est une RuntimeException, donc elle
         * n'est pas vérifiée à la compilation.
         */
    }

    /**
     * Lance une MonExceptionAMoiException en capturant la NullPointerException lancée par exceptionGenerator()
     */
    public void captureEtRelance() {
        try {
            exceptionGenerator();
        } catch (NullPointerException e) {
            throw new MonExceptionAMoiException("MonExceptionAMoiException lancée depuis IntegerCollection.captureEtRelance");
        }
    }
}
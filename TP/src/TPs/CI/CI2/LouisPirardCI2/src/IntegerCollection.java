package LouisPirardCI2.src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

class MissingIntegerException extends Exception {
    public MissingIntegerException() {
        super();
    }

    public MissingIntegerException(String s) {
        super(s);
    }
}

class MonExceptionAMoiException extends RuntimeException {
    public MonExceptionAMoiException() {
        super();
    }

    public MonExceptionAMoiException(String s) {
        super(s);
    }
}
//A la place de copier coller mes exceptions, j'aurai pu importer les packaqes mais j'ai choisi cette façon de faire par facilité.

public class IntegerCollection implements Iterable<Integer> {

    private List<Integer> liste;

    public IntegerCollection() {
        liste = new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        liste.add(5);
        liste.add(6);
    }

    // Ajouter un élément à la liste
    public void add(Integer i) {
        liste.add(i);
    }

    /** Méthode qui permet la création d'un générateur qui permet de parcourir la collection dans l'ordre d'insertion
     *
     * @return permet de retourner un itérateur lors du parcours de la collection dans l'ordre normal d'insertion.
     * @requires la collection doit rester inchangée lors de l'itération.
     */
    public Iterator<Integer> OrderedIterator() {
        return liste.iterator();
    }

    /** Méthode qui permet la création d'un générateur qui a pour objectif de parcourir la liste dans l'odre inverse d'insertion.
     *
     * @return permet de retourner un itérateur lors du parcours de la collection dans l'ordre inverse d'insertion.
     * @requires la collection doit rester inchangée lors de l'itération.
     */
    public Iterator<Integer> ReverseOrderedIterator() {
        List<Integer> reversedList = new ArrayList<>(liste);
        Collections.reverse(reversedList);
        return reversedList.iterator();
    }

    /**Cette méthode permet de renvoyer un itérateur sur les éléments de cette collection dans l'ordre attendu
     *
     * @return un itérateur sur les éléments de cette collection dans l'ordre approprié
     */
    @Override
    public Iterator<Integer> iterator() {
        return liste.iterator();
    }

    /**
     * @return une réprésentation sous forme d'une chaine de caractères de notre collection.
     */
    @Override
    public String toString() {
        return "Collection : " + liste;
    }

    /**
     * @param i étant l'entier que nous recherchons
     * @return permet de retourner l'index s'il est présent dans la liste
     * @throws permet de lancer l'exception MissingIntegerException qui est lancée lorsque l'entier est manquant dans la liste.
     */
    public int searchInt(Integer i) throws MissingIntegerException {
        int index = liste.indexOf(i);
        if (index == -1) {
            throw new MissingIntegerException("L'entier " + i + " est manquant dans la liste.");
        }
        return index;
    }

    private void exceptionGenerator() {
        throw new NullPointerException();
        /*
         * Pourquoi l'appel à cette méthode exceptionGenerator ne pose pas de souci au compilateur?
         * Réponse : L'appel de cette méthode ne pose aucun souci au compilateur car celui-ci comprend que cette exception est intentionnelle
         *
         */

    }

    /**
     * @throws permet de lancer l'exception NullPointerException lorsque une erreur survient lors de la capture et de la relance de l'exception.
     */
    public void captureEtRelance() {
        try {
            exceptionGenerator();
        } catch (NullPointerException e) {
            throw new MonExceptionAMoiException("Une erreur s'est produite lors de la capture et de la relance de l'exception." , e);
        }
    }
}
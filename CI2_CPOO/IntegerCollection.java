import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Overview IntegerCollection représente une collection d'entiers, triée par ordre d'insertion.
 * Elle est mutable. De manière générale, une IntegerCollection est définie comme [x1, xi,..., xn]
 * avec 0 < i <= n et n = cardinalité de IntegerCollection.
 * Exemple: {3,5,18,5,59,23}; 3 est le premier élément inséré dans IntegerCollection, 23 le plus récent.
 */
public class IntegerCollection implements Iterable<Integer> {
    private List<Integer> liste;

    /**
     * @effects crée une nouvelle IntegerCollection vide
     */
    public IntegerCollection() {
        liste = new ArrayList<>();
    }

    /**
     * @modifies this
     * @effects ajoute une occurrence de i à this
     * @param i l'entier à ajouter à la collection
     */
    public void add(int i) {
        liste.add(i);
    }

    /**
     * @modifies this
     * @effects retire une (et une seule) occurrence de i de this
     * @param i l'entier à retirer de la collection
     */
    public void remove(int i) {
        liste.remove((Integer) i);
    }

    /**
     * @return l'index de i si i appartient à this
     * @throws MissingIntegerException si i n'est pas trouvé dans la collection
     * @param i l'entier à rechercher dans la collection
     */
    public int searchInt(Integer i) throws MissingIntegerException {
        int index = liste.indexOf(i);
        if (index != -1) return index;
        else throw new MissingIntegerException("Integer not found in IntegerCollection");
    }

    @Override
    public String toString() {
        return "Collection : " + liste.toString();
    }

    /**
     * @effects Retourne un itérateur pour parcourir la collection dans l'ordre d'insertion.
     * @return Iterator<Integer> qui permet d'itérer sur les éléments de la collection en avant.
     */
    public Iterator<Integer> forwardIterator() {
        return new IntegerCollectionIterator(true);
    }

    /**
     * @effects Retourne un itérateur pour parcourir la collection dans l'ordre inverse d'insertion.
     * @return Iterator<Integer> qui permet d'itérer sur les éléments de la collection en arrière.
     */
    public Iterator<Integer> reverseIterator() {
        return new IntegerCollectionIterator(false);
    }

    @Override
    public Iterator<Integer> iterator() {
        return forwardIterator();
    }

    /**
     * Classe interne IntegerCollectionIterator implémente Iterator<Integer> pour parcourir les entiers de IntegerCollection.
     */
    private class IntegerCollectionIterator implements Iterator<Integer> {
        private int currentIndex;
        private boolean isForward;

        /**
         * @effects Initialise un nouvel itérateur pour IntegerCollection.
         * @param isForward booléen indiquant le sens de l'itération; true pour l'ordre d'insertion, false pour l'ordre inverse.
         */
        public IntegerCollectionIterator(boolean isForward) {
            this.isForward = isForward;
            this.currentIndex = isForward ? 0 : liste.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return isForward ? currentIndex < liste.size() : currentIndex >= 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the collection");
            }
            Integer result = liste.get(currentIndex);
            currentIndex += isForward ? 1 : -1;
            return result;
        }
    }
}
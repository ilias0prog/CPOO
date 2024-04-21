package MyCI2;
import MyCI2.MesExceptions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * @Overview IntegerCollection représente une collection d'entier,  trié par ordre insertion.
 * Il est mutable
 * De manière générale, un IntSet est défini comme [x1, xi,...,xn]
 * avec 0 < i <= n et n = cardinalité de IntegerCollection
 * ex: {3,5,18,5,59,23}; 3 est le premier élément rentré dans IntegerCollection, 23 le plus récent
 */
public class IntegerCollection implements Iterable<Integer>{

    private List<Integer> liste;

    /**
     * @effects crée une nouvelle IntegerCollection vide
     */
    public IntegerCollection() {
        liste = new ArrayList<>();
    }

    /**
     * @modifies this
     * @effects ajoute une occurence de i à this
     */
    public void add(int i){
        liste.add(i);
    }

    /**
     * @modifies this
     * @effects retire une (et une seule) occurence de i à this
     */
    public void remove(int i){
        liste.remove((Integer) i);
    }

    /**
     * @return l'index de i si i appartient à this;
     * @throws MissingIntegerException sinon
     */
    public int searchInt(Integer i) throws MissingIntegerException{
        if(liste.contains(i)) return liste.indexOf(i);
        else throw new MissingIntegerException("IntegerCollection.searchInt(Integer i)");
    }


    @Override
    public String toString() {
        return "Collection : " + liste.toString();
    }

    /**
     * @throws NullPointerException, toujours
     */
    private void exceptionGenerator() throws NullPointerException{
        throw new NullPointerException();
    }

    /**
     * @throws MonExceptionAMoiException, toujours
     */
    public void captureEtRelance() throws MonExceptionAMoiException{
        try {
            exceptionGenerator();
        }
        catch(NullPointerException e){
            throw new MonExceptionAMoiException("IntegerCollections.captureetRelance()");
        }
    }


    /**
    * @return un générateur qui parcourt les éléments de la collection dans l'ordre inverse d'insertion
    */
    public Iterator<Integer> IntegerCollectionIterator() {
			return new IntegerCollectionGenerator(true);
	}

	public Iterator<Integer> IntegerCollectionReverseIterator() {
			return new IntegerCollectionGenerator(false);
	}

	public Iterator<Integer> ForEachIterator() {
		return new IntegerCollectionGenerator(false);
}

	class IntegerCollectionGenerator implements Iterator<Integer> {
			private int currentIndex;
			private final boolean forward;

			public IntegerCollectionGenerator(boolean forward) {
					this.forward = forward;
					if (forward) {
							currentIndex = 0;
					} else {
							currentIndex = liste.size() - 1;
					}
			}

			@Override
			public boolean hasNext() {
					if (forward) {
							return currentIndex < liste.size();
					} else {
							return currentIndex >= 0;
					}
			}

			@Override
			public Integer next() {
					if (!hasNext()) {
							throw new NoSuchElementException("No more elements");
					}
					Integer currentElement = liste.get(currentIndex);
					if (forward) {
							currentIndex++;
					} else {
							currentIndex--;
					}
					return currentElement;
			}
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}
}
package TPs.AbsProcedurale;

/**
 * @Overview Les ImmuMultiSets sont des ensembles non bornés d'entiers qui
 * peuvent contenir des doublons.
 * Ils sont immutables.
 * De manière générale, un ImmuMultiSet est défini comme {x1,...,xn}
 * où x1,...,xn sont des entiers. Ex: {2,9,5,5,19}
 * @invariant size = #this
 */

public interface ImmuMultiSet {

    // Type immutable -> toute méthode qui "modifie" un immuMultiSet
    // doit en retourner une nouvelle instance (aka. ne pas modifier l'ADT)

    /**
     * @return un nouveau ImmuMultiSet équivalent à this U {i}, ajoute une occurence
     */
    public ImmuMultiSet insert(int i);

    /**
     * @return un nouveau ImmuMultiSet équivalent à this \ {i} , toutes les occurences
     */
    public ImmuMultiSet remove(int i);

    /**
     * @return true si i appartient à this, sinon false
     */
    public boolean isIn(int i);

    /**
     * @return le nombre d'élément de mon ImmuMultiSet
     */
    public int size();

    /**
     * @requires i appartient à this
     * @return retourne le nombre d'occurence de i
     */
    public int numberOfOccurence(int i);

    /**
     * @requires this est non vide
     * @return retourne un élément de this
     */
    public int choose();

}

package TPs.AbsProcedurale;
/**
 * @Overview Les MultiSets sont des ensembles non bornés d'entiers qui
 * peuvent contenir des doublons.
 * Ils sont mutables.
 * De manière générale, un MultiSet est défini comme {x1,...,xn}
 * où x1,...,xn sont des entiers. Ex: {2,9,5,5,19}
 * @invariant size = #this
 */


public interface MultiSet {

    // Type mutable -> toutes les méthodes qui modifient this
    // modifient directement this, donc pas de type de retour


    private ArrayList<Integer> mySet;

    /**
     * @modifies this
     * @effects this_post = this U {i} , ajouter une occurence
     */
    public void insert(int i){
        mySet.add(i);
    }


    /**
     * @modifies this
     * @effects this_post = this \ {i} , retire toutes les occurences
     */
    public void remove(int i);
    mySet.remove((Integer) i) = new ArrayList<>();
    /**
     * @return true si i appartient à this, sinon false
     */
    public boolean isIn(int i);
    return mySet.conatains(i);
    /**
     * @return la cardinalité de this
     */
    public int size();
    return mySet.size();
    /**
     * @requires i appartient à this
     * @return retourne le nombre d'occurences de i
     */
    public int numberOfOccurence(int i);
    int n = 0;
    for (Integer element : mySet){
        if(element == i) nb++;
    }
    /**
     * @requires this est non vide
     * @return retourne un élément de this
     */
    public int choose();
}

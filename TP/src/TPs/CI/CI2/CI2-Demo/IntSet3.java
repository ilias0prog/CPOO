import java.util.*;

import exceptions.EmptyException;

/**
 * @overview Les IntSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un IntSet est défini comme {x1, xi,...,xn}
 * avec 0 < i <= n et n = size où size = cardinalité de l'IntSet
 * @invariant size toujours positif
 */
public class IntSet3 implements Iterable<Integer> {

  private List<Integer> els;
  /**
   * FA(c) : { c.els[i].intValue | 0 <= i < c.els.size() }
   */

  /**
   * IR(c) : c.els is not null &&
   *  		for all integer i, c.els[i] is an Integer  (c.els contains only Integers elements )   &&
   *  		for all i,j | ( 0 <= i < j < c.els.size() => c.els[i] != c.els[j] )   (c.els doesn't allows any duplicate elements)
   */


  /**
   * @effects initialise this à l'ensemble vide
   */
  public IntSet3() {
    els = new ArrayList<>();
  }

  /**
   * @effects crée un nouveau multiset contenant une copie des éléments contenus dans original, dans le même ordre que dans original
   */
  public IntSet3(IntSet3 original) {
    this.els = new ArrayList<Integer>(original.els);
  }

  /**
   * @modifies this
   * @effects this_post = this U {x}
   */
  public void insert (int x) {
    if (els.indexOf(x) < 0) els.add(x);

  }

  /**
   * @modifies this
   * @effects this_post = this \ {x}
   */
  public void remove (int x) {
    els.remove((Object)x);
  }

  /**
   * @return true si x appartient à this; renvoie false sinon
   */
  public boolean isIn (int x) {
    return els.contains(x);
  }

  /**
   * @return la cardinalité de this.
   */
  public int size () { return els.size();  }

  /**
   * @return x t.q. x appartient à this.
   * @throws EmptyException  si this = {}
   */
  public int choose () throws EmptyException {
    if (els.size()==0) { throw new EmptyException("IntSet.choose()"); }
    return els.get(0);
  }

  public boolean repOk(){
    if(this.els == null)
      return false;
    for(Object i : els) {
      if ( i instanceof Integer == false) return false;
      if (els.indexOf(i) != els.lastIndexOf(i)) return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.size() == 0 ) {
      sb.append("IntSet : {}");
    }
    else {
      sb.append("IntSet : {");
      for(Integer i : this.els) {
        sb.append(i+",");
      }
      sb.deleteCharAt(sb.length()-1);
      sb.append("}");
    }
    return sb.toString();
  }

  /**
   * @return Un Générateur qui produira tous les élements de this, chacun exactement une fois et dans l'ordre où ils ont été insérés.
   * @requires this ne peut pas être modifié pendant que le générateur est utilisé
   */
  @Override
  public Iterator<Integer> iterator() {
    return Collections.unmodifiableCollection(els).iterator();
  }

  /**
   * @return Un Générateur qui produira tous les éléments de this, chacun exactement une fois et dans l'ordre croissant.
   * @requires this ne peut pas être modifié pendant que le générateur est utilisé
   */
  public Iterator<Integer> sortedElements() { return new IntSetOrderedGenerator(); }

  /**
   * @return Un Générateur qui produit tous les éléments de this étant > exclusiveMinimum, chacun exactement une fois, et dans l'ordre d'insertion.
   * @requires this ne peut pas être modifié pendant que le générateur est utilisé
   */
  public Iterator<Integer> elementsBiggerThan(int exclusiveMinimum) {
    return new IntSetBiggerThanGenerator(exclusiveMinimum);
  }

  private class IntSetOrderedGenerator implements Iterator<Integer> {
    private int lastRetrievedIndex;
    private int[] sortedElements;

    public IntSetOrderedGenerator() {
      lastRetrievedIndex = 0;
      sortedElements = new int[els.size()];
      for(int i = 0; i < els.size(); i++) {
        sortedElements[i] = els.get(i);
      }
      Arrays.sort(sortedElements);
    }

    @Override
    public boolean hasNext() {
      return lastRetrievedIndex < sortedElements.length;
    }

    @Override
    public Integer next() throws NoSuchElementException {
      if(!hasNext())
        throw new NoSuchElementException("IntSet3.IntSetOrderedGenerator.next()");

      Integer currentElement = sortedElements[lastRetrievedIndex];
      lastRetrievedIndex++;
      return currentElement;
    }
  }
  private class IntSetBiggerThanGenerator implements Iterator<Integer> {
    private int lastRetrievedIndex;
    private ArrayList<Integer> validElements;

    public IntSetBiggerThanGenerator(int exclusiveMaximum) {
      lastRetrievedIndex = 0;
      validElements = new ArrayList<>();
      for(int i = 0; i < els.size(); i++)
        if(els.get(i) > exclusiveMaximum)
          validElements.add(els.get(i));
    }

    @Override
    public boolean hasNext() {
      return lastRetrievedIndex < validElements.size();
    }

    @Override
    public Integer next() throws NoSuchElementException {
      if(!hasNext())
        throw new NoSuchElementException("IntSet3.IntSetBiggerThanGenerator.next()");

      Integer currentElement = validElements.get(lastRetrievedIndex);
      lastRetrievedIndex++;
      return currentElement;
    }
  }

}
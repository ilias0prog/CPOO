package LouisPirardCI2.src;
import java.util.Iterator;
public class CI2 {
    
    public static void main(String[] args) {
        IntegerCollection ic = new IntegerCollection();
        ic.add(1);
        ic.add(3);
        ic.add(3);
        ic.add(5);
        ic.add(6);
        ic.add(10);
        System.out.println("Collection : " + ic);

        // Itération 1: Parcours de la collection dans l'ordre d'insertion au moyen d'une boucle "while"
        System.out.println("Itération 1");
        Iterator<Integer> iterator1 = ic.OrderedIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        // Itération 2: Parcours de la collection dans l'ordre inverse d'insertion au moyen d'une boucle de type "while"
        System.out.println("Itération 2");
        Iterator<Integer> iterator2 = ic.ReverseOrderedIterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        // Itération 3: Parcours de la collection dans l'ordre d'insertion via une boucle for-each et permet également l'affichage de chaque élément dans la console.
        System.out.println("Itération 3");
        for (Integer integer : ic) {
            System.out.println(integer);
        }
    }
}
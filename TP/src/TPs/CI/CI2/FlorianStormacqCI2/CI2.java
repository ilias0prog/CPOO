package FlorianStormacqCI2;
import java.util.Iterator;

import FlorianStormacqCI2.IntegerCollection;

import java.util.Collections;

public class CI2 {

    public static void main(String[] args) {
        IntegerCollection ic = new IntegerCollection();
        ic.add(1);
        ic.add(3);
        ic.add(3);
        ic.add(5);
        ic.add(6);
        ic.add(10);
        System.out.println(ic);

        /**
         * ITERATION 1
         * Parcours de la collection dans l'ordre d'insertion
         */
        System.out.println("Itération 1");
        Iterator<Integer> iterator1 = ic.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        /**
         * ITERATION 2
         * Parcours de la collection dans l'ordre inverse d'insertion
         */
        System.out.println("Itération 2");
        Iterator<Integer> reverseIterator = ic.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }

        /**
         * ITERATION 3
         * Parcours de la collection dans l'ordre d'insertion via une boucle for-each
         */
        System.out.println("Itération 3");
        for (Integer element : ic) {
            System.out.println(element);
        }
    }
}

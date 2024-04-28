import java.util.Iterator;

public class CI2 {

    public static void main(String [] args){
        IntegerCollection ic = new IntegerCollection();
        ic.add(1);
        ic.add(3);
        ic.add(3);
        ic.add(5);
        ic.add(6);
        ic.add(10);
        System.out.println(ic);

        // ITÉRATION 1
        // Parcours de la collection dans l'ordre d'insertion
        System.out.println("Itération 1");
        Iterator<Integer> forwardIterator = ic.forwardIterator();
        while (forwardIterator.hasNext()) {
            System.out.println(forwardIterator.next());
        }

        // ITÉRATION 2
        // Parcours de la collection dans l'ordre inverse d'insertion
        System.out.println("Itération 2");
        Iterator<Integer> reverseIterator = ic.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }

        // ITÉRATION 3
        // Parcours de la collection dans l'ordre d'insertion via une boucle for-each
        System.out.println("Itération 3");
        for (Integer num : ic) {
            System.out.println(num);
        }
    }
}

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        //IntSet
        IntSet intSet = new IntSet();
        intSet.insert(1);
        intSet.insert(3);
        intSet.insert(-10);

        //Le type IntSet implémente l'interface Iterable<T> --> On peut utiliser le for each
        System.out.println("IntSet > For Each");
        for(int elem : intSet)
            System.out.println(elem);
        //On peut aussi utiliser l'itérateur sans une boucle for each
        System.out.println("IntSet > iterator()");
        Iterator<Integer> intSetIt = intSet.iterator();
        while(intSetIt.hasNext())
            System.out.println(intSetIt.next());

        //IntSet2
        //IntSet2 n'implémente pas l'interface Iterable --> Impossible d'utiliser le for each
        IntSet2 i2 = new IntSet2();
        i2.insert(11);
        i2.insert(-2);
        System.out.println("IntSet2 > elements()");
        Iterator<Integer> i2Iterator = i2.elements();

        while(i2Iterator.hasNext())
            System.out.println(i2Iterator.next());

        //IntSet3
        //IntSet3 implémente l'interface Iterable --> for each possible --> Génère les éléments dans l'ordre d'insertion
        //Un autre itérateur est aussi proposé: sortedElements --> Génère les éléments dans l'ordre croissant
        IntSet3 i3 = new IntSet3();
        i3.insert(100);
        i3.insert(-50);
        i3.insert(0);
        System.out.println("IntSet3 > For Each");
        for(int elem : i3)
            System.out.println(elem);

        System.out.println("IntSet3 > sortedElements()");
        Iterator<Integer> it3 = i3.sortedElements();
        while(it3.hasNext())
            System.out.println(it3.next());

        //Un autre intérateur est disponible: elementsBiggerThan --> Génère les éléments dans l'ordre d'insertion, chacun une fois, mais uniquement ceux qui sont supérieurs à un entier choisi.
        System.out.println("IntSet3 > elementsBiggerThan(int)");
        Iterator<Integer> it4 = i3.elementsBiggerThan(50);
        while(it4.hasNext())
            System.out.println(it4.next());
    }
}

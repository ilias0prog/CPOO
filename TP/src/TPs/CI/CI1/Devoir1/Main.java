import MesExceptions.*;

public class Main {

    public static void main(String[] args) throws MissingIntegerException {
        IntegerCollection collection = new IntegerCollection();
        System.out.println(collection);
        System.out.println(collection.searchInt(9));
    }
}
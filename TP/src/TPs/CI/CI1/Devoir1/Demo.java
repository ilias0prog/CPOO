package TPs.CI;

import TPs.Exceptions.*;

public class Demo {

    public static void main(String[] args) {
        Compute c=new Compute();
        c.compute();

        c.computeBis();
        // Cette ligne de code plante le programme
        // Exception indiquée dans le terminal

        try {
            c.computeTer();
        } catch (NotFoundException e) {
            //e.printStackTrace();
        }
    }
}
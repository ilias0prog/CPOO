package TPs.CI;


public class CI1 {

    /*
     * A ne pas spécifier
     */
    public static void main(String [] args){
        IntegerCollection ic = new IntegerCollection(); // crée une nouvelle collection d'Integer
        System.out.println(ic); // affiche la collection

        for(int i = 1; i <= 10; i++)
        {
            Integer elementAleatoire =  TPs.AbsProcedurale.Num.randomInt(11); // Entier entre 0 et 10
            System.out.println("Element aléatoire généré : " + elementAleatoire);
            System.out.println("Position de l'élément : " + ic.searchInt(elementAleatoire)); // Une fois les
            // modifications souhaitées dans IntegerCollection, le programme ne s'exécute pas correctement
        }
        ic.captureEtRelance(); // Le programme ne s'exécute pas correctement !

        /* En lisant la sortie dans le terminal vous comprenez que des exceptions empêchent le programme
         * de s'exécuter correctement.
         * TOdo Capturez-les et indiquez leur captures dans le terminal (e.g. "MissingIntegerException capturée").
         * Exemple d'exécution dans le terminal :
         *      Element aléatoire généré : 7
         *      MissingIntegerException capturée
         *      Element aléatoire généré : 1
         *      Position de l'élément : 0
         *      Element aléatoire généré : 2
         *      Position de l'élément : 1
         *      Element aléatoire généré : 6
         *      Position de l'élément : 5
         *      Element aléatoire généré : 0
         *      MissingIntegerException capturée
         *      Element aléatoire généré : 3
         *      Position de l'élément : 2
         *      Element aléatoire généré : 2
         *      Position de l'élément : 1
         *      Element aléatoire généré : 6
         *      Position de l'élément : 5
         *      Element aléatoire généré : 9
         *      MissingIntegerException capturée
         *      Element aléatoire généré : 2
         *      Position de l'élément : 1
         *      MonExceptionAMoiException capturée
         */
    }
}
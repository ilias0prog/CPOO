package TPs.CI;

import TPs.Exceptions.NotFoundException;
import TPs.Exceptions.UnexpectedException;

public class Compute {

    /**
     * @modifies System.out
     * @effects Des informations sont affichées dans les terminal
     *  et le curseur est placé à la fin de ce dernier
     */
    public void compute() {
        try{
            generateCheckedException();
            //gestion locale
        }
        catch (NotFoundException e){
            System.out.println("Capture de la NotFoundException");
            return; // (pour illustrer le finally)
            //throw new NullPointerException();
            //throw e;
            // possibilité de jeter une autre Exception, voire la même
            // si aucun traitement n'a été effectué
        }
        catch (NullPointerException e)
        {
            //il est possible de rajouter autant de catch que l'on souhaite
        }

        finally{
            System.out.println("Hello ! ;)");
            System.out.println("Bloc de code toujours effectué");
        }
        System.out.println("Hello (celui de la fin de la méthode compute())");
    }

    /**
     *
     * @throws NotFoundException (toujours)
     */
    public void computeTer() throws NotFoundException {
        generateCheckedException();
        //mécanisme de propagation; gestion laissée au code appelant

        System.out.println("Hello (computeTer())");
    }


    public void computeBis(){
        generateUncheckedException();
    }


    /**
     * ATTENTION : dans la méthode suivante, on peut observer qu'une exception non-vérifiée
     * n'a pas besoin d'être indiquée dans la signature. L'illustration est pédagogique.
     * Pour rappel dans le cadre du cours, on vous demande de toujours spécifier et indiquer
     * dans la signature les exceptions non-vérifiées (sauf FailureException)
     */
    private void generateUncheckedException(){
        throw new UnexpectedException("Compute.generateUncheckedException()");
    }

    /**
     * Présence d'une exception vérifiée, Java force son indication dans la signature
     * s'il n'y a pas de gestion locale
     * @throws NotFoundException (toujours)
     */
    private void generateCheckedException() throws NotFoundException {
        throw new NotFoundException("Compute.generateCheckedException()");
    }
}

import Exceptions.NoMoreRoomException;

public class Main {

    public static void main(String[] args) {
        //Création d'étudiants, pas d'exceptions ici
        Etudiant e1 = new Etudiant("Victor", "Amaral de Sousa");
        Etudiant e2 = new Etudiant("Charlotte", "Lejeune");

        //Création des cours, pas d'exceptions ici
        Cours c1 = new Cours("INFOB234","CPOO", "P.Heyman", 1);
        Cours c2 = new Cours("EIMIB212", "GID", "S. Faulkner", 2);
        Cours c3 = new Cours("EIMIB414", "Un Cours", "Un Prof.", 1);

        //Ajout d'un étudiant dans le cours C3
        //Puisque Cours.ajouterEtudiant peut lancer une Exception de type NoMoreRoomException (vérifiée), on est obligé d'entourer
        //l'appel à la méthode dans un try { ... } catch(...) { ...}, soit directement (gestion locale), soit après propagation.
        //Ici, nous sommes dans le point d'entrée du programme donc on ne peut pas propager l'exception en question,
        //et on est obligés de la traiter. Sinon, une erreur de compilation apparaîtra.
        try {
            c3.ajouterEtudiant(e1);    //Ajouter un étudiant: ok, Ajouter un deuxième étudiant: exception
            //c3.ajouterEtudiant(e2);
        } catch(NoMoreRoomException e) {
            System.out.println(e);
        }


        //Création du programme de cours, pas d'exceptions ici
        Programme p1 = new Programme("INGMI");
        p1.ajouterCours(c1);
        p1.ajouterCours(c2);

        //L'ajout des étudiants au programme peut lancer des exceptions
        //L'appel à Programme.ajouterEtudiant(Etudiant) peut lancer une ProgrammeFullException (non vérifiée).
        //Puisque l'exception est non vérifiée, le compilateur n'exige pas que la signature de la méthode spécifie que ce type d'exception peut être lancé.
        //Néanmoins, dans le cadre de ce cours, nous vous demandons de le faire malgré tout.
        //De plus, le compilateur n'exigera pas que l'exception soit traitée.
        //Dans le cadre du cours, nous vous demanderons de traîter ces exceptions malgré tout (soit localement, soit après leur propagation).
        //Puisque le compilateur n'exige pas de traîter explicement les exceptions non vérifiées, le code ci-dessous compilera.
        //Si une exception (non vérifiée) est lancée et non traitée, elle sera donc propagée en dehors de main, ce qui causera un arrêt du logiciel, avec un code d'erreur.
        p1.ajouterEtudiant(e1);
        //p1.ajouterEtudiant(e2);

        //Ici, nous faisons appel à la méthode Programme.ajouterEtudiant(Etudiant, int).
        //Cette méthode peut propager une exception de type NoMoreRoomException. Nous sommes, depuis le main (ou bien avant d'en arriver au main dans le code),
        //obligés de traîter cette exception puisqu'elle est de type vérifiée.
        try {
            p1.ajouterEtudiant(e1, 0);
        } catch(NoMoreRoomException e) {
            /* Ici, nous devrions afficher un message concernant l'exception qui est lancée et que l'on catch.
               Une des possibilités pour le traitement des exceptions est de les masquer.
               Pour ce faire, il suffit de catcher l'exception, et de ne rien en faire.

               Ca n'est pas ce qui serait conseillé dans ce cas, mais c'est une possibilité.
             */
        }

    }
}
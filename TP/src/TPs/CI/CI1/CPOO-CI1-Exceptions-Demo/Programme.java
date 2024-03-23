import Exceptions.NoMoreRoomException;
import Exceptions.ProgrammeFullException;

import java.util.ArrayList;

/**
 * @overview un Programme représente un programme de cours. Un Programme typique est un n-uplet <name, courses>, où
 *
 * @specfield name (String) - nom du cours
 * @specfield courses (Ensemble de Cours) - Ensemble des cous faisant partie du programme de cours
 *
 * Les Programmes sont mutables.
 */
public class Programme {
  private String nom;
  private ArrayList<Cours> coursProgramme;

  /**
   * @effects Créer un nouveau Programme p tel que:
   *          p.name = nom &&
   *          p.courses = {}
   */
  public Programme(String nom) {
    this.nom = nom;
    this.coursProgramme = new ArrayList<>();
  }

  /**
   * @return this.name
   */
  public String getNom() { return this.nom; }

  /**
   * @modifies this.courses
   * @effects this_post.courses = this.courses U { c }
   */
  public void ajouterCours(Cours c) {
    this.coursProgramme.add(c);
  }

  /**
   * @throws ProgrammeFullException si un des cours de this.courses ne contient plus suffisamment de place que pour ajouter un étudiant
   * @modifies sinon, modifie this.courses
   * @effects pour chaque cours c de this.courses, this_post.courses[c].inscrits = this.courses[c].inscrits U { e }
   *
   * Notes Etudiants: dans ce cas-ci, nous effectuons une propagation explicite. En effet, Cours.ajouterEtudiant peut lancer une NoMoreRoomException.
   * Nous attrapons l'exception en question localement, et nous renvoyons une autre exception, plus précise (de type ProgrammeFullException).
   */
  public void ajouterEtudiant(Etudiant e) throws ProgrammeFullException {
    for(int i = 0; i < this.coursProgramme.size(); i++) {
      try {
        this.coursProgramme.get(i).ajouterEtudiant(e);
      } catch(NoMoreRoomException ex) {
        for(int j = 0; j < i; j++) {
          this.coursProgramme.get(i).supprimerEtudiant(e);
        }
        throw new ProgrammeFullException("Programme.ajouterEtudiant(Etudiant): Il n'y a plus de place dans le cours " + this.coursProgramme.get(i).getNom());
      }
    }
  }

  /**
   *
   * @throws NoMoreRoomException si il n'y a plus de place dans le cours this.courses[courseIndex]
   * @modifies sinon, modifie this.courses[courseIndex]
   * @effects this_post.courses[courseIndex].inscrits = this.courses[coursIndex] U { e }
   *
   * Note Etudiants: Nous procédons ici à une propagation implicite. En effet, l'appel à la méthode
   * Cours.ajouterEtudiant(Etudiant) peut lancer une NoMoreRoomException.
   * L'exception n'est ici pas gérée localement, et sera donc propagée au code qui appelera la méthode Programme.ajouterEtudiant(Etudiant, int).
   * Pour que cela puisse fonctionner, il faudra malgré tout mentionner dans la signature le "throws NoMoreRoomException".
   * Si ça n'est pas fait, il y aura une erreur de compilation étant donné que NoMoreRoomException est une Exception vérifiée
   * Si NoMoreRoomException avait été une exception non vérifiée, alors le compilateur n'aurait pas imposé de mentionner
   * L'exception dans la signature, mais nous vous demandons malgré tout de le faire dans le cadre du cours.
   */
  public void ajouterEtudiant(Etudiant e, int courseIndex) throws NoMoreRoomException {
    this.coursProgramme.get(courseIndex).ajouterEtudiant(e);
  }

}
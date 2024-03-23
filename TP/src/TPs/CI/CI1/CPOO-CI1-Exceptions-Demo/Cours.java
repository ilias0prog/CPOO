import java.util.ArrayList;

import Exceptions.NoMoreRoomException;

/**
 * @overviex Un Cours typique est un n-uplet <mnemo, name, prof, nbPlacesMax, inscrits, placesRestantes>, où
 *
 * @specfield mnemo (String) - Mnémonique du cours
 * @specfield name (String) - Nom du cours
 * @specfield prof (String) - Nom du professeur en charge du cours
 * @specfield nbPlacesMax (entier) - Nombre maximum de places pour des étudiants dans le cours
 * @specfield inscrits (Ensemble d'Etudiants) - Ensemble des étudiants inscrits au cours
 * @derivedfield placesRestantes (entier) - Nombre de places restantes
 *
 * Les Cours sont mutables.
 *
 * @invariant nbPlacesMax > 0
 * @invariant placesRestantes = nbPlacesMax - #inscrits
 */
public class Cours {
  private String mnemonique;
  private String nom;
  private String professeur;
  private int nbPlacesMax;
  private ArrayList<Etudiant> etudiantsInscrits;

  /**
   *
   * @effects Crée un nouveau Cours c tel que:
   *          c.mnemo = mnemonique &&
   *          c.name = nom &&
   *          c.prof = professeur &&
   *          c.nbPlacesMax = nbMaxPlaces &&
   *          c.inscrits = {}
   */
  public Cours(String mnemonique, String nom, String professeur, int nbMaxPlaces) {
    this.mnemonique = mnemonique;
    this.nom = nom;
    this.professeur = professeur;
    this.nbPlacesMax = nbMaxPlaces;
    this.etudiantsInscrits = new ArrayList<>();
  }

  /**
   * @return this.mnemo
   */
  public String getMnemonique() { return this.mnemonique; }

  /**
   * @return this.nom
   */
  public String getNom() { return this.nom; }

  /**
   * @return this.prof
   */
  public String getProfesseur() { return this.professeur; }

  /**
   * @return this.nbPlacesMax
   */
  public int getNbMaxPlaces() { return this.nbPlacesMax; }

  /**
   * @return this.placesRestantes
   */
  public int getPlacesRestantes() { return this.nbPlacesMax - this.etudiantsInscrits.size(); }

  /**
   * @return Une shallow copy de this.inscrits
   */
  public ArrayList<Etudiant> getEtudiantsInscrits() { return (ArrayList<Etudiant>)this.etudiantsInscrits.clone(); }

  /**
   * @throws NoMoreRoomException si il n'y a plus de places restantes dans this (i.e. this.placesRestantes = 0)
   * @modifies sinon, modifies this.inscrits
   * @effects this_post.inscrits = this.inscrits U { e }
   */
  public void ajouterEtudiant(Etudiant e) throws NoMoreRoomException {
    if(this.getPlacesRestantes() == 0)
      throw new NoMoreRoomException("Cours.ajouterEtudiant(Etudiant)");

    this.etudiantsInscrits.add(e);
  }

  /**
   * @modifies this.inscrits
   * @effects supprime (une seule fois) l'Etudiant e de this.inscrits
   */
  public void supprimerEtudiant(Etudiant e) {
    this.etudiantsInscrits.remove(e);
  }
}

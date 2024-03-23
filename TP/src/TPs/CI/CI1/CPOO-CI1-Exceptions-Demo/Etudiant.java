/**
 * @overview Un Etudiant typique est un n-uplet <firstName, lastName>, où
 *
 * @specfield firstName (String) - Prénom de l'étudiant
 * @specfield lastName (String) - Nom de famille de l'étudiant
 *
 * Les Etudiants sont mutables.
 */
public class Etudiant {
  private String prenom;
  private String nomFamille;

  /**
   * @effects Crée un nouvel Etudiant e tel que:
   *          e.firstName = prenom &&
   *          e.lastName = nom
   */
  public Etudiant(String prenom, String nom) {
    this.prenom = prenom;
    this.nomFamille = nom;
  }

  /**
   * @return this.firstName
   */
  public String getPrenom() { return this.prenom; }

  /**
   * @return this.lastName
   */
  public String getNomFamille() { return this.nomFamille; }
}

enum Couleur {
    ROUGE,
    BLEU,
}

public class Joueur {

    private String nom;
    private Integer pointsDeVie;
    private Integer positionPlateau;
    private Couleur couleurPion;

    public Joueur(String nom, Couleur couleurPion) {
        this.nom = nom;
        this.pointsDeVie = 5;
        this.positionPlateau = 1;
        this.couleurPion = couleurPion;
    }

    public void avancer(int nbCases) {
        positionPlateau += nbCases;
    }

    public Boolean estVivant() {
        return pointsDeVie > 0;
    }

    public void modifierVie(int points) {
        pointsDeVie += points;
    }

    public Integer getPositionPlateau() {
        return positionPlateau;
    }

    public String getNom() {
        return nom;
    }

    public Integer getPointsDeVie() {
        return pointsDeVie;
    }

    public Couleur getCouleurPion() {
        return couleurPion;
    }

    public void setPositionPlateau(Integer positionPlateau) {
        this.positionPlateau = positionPlateau;
    }
}

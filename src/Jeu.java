public class Jeu {

    private Integer nbJoueurs;
    private Integer nbDes;
    private Affichage affichage;
    private Plateau plateau;
    private Des des;
    private Joueur[] joueurs;

    public Jeu(
        Integer nbJoueurs,
        Integer nbDes,
        Affichage affichage,
        Plateau plateau,
        Des des,
        Joueur joueur1,
        Joueur joueur2
    ) {
        this.nbJoueurs = nbJoueurs;
        this.nbDes = nbDes;
        this.affichage = affichage;
        this.plateau = plateau;
        this.des = des;
        this.joueurs = new Joueur[] { joueur1, joueur2 };
    }

    public void lancerJeu() {}

    public void deplacerJoueur(Joueur joueur) {
        int resultat = des.lancerDes();
        joueur.avancer(resultat);
    }

    public Boolean verifierFinPartie() {
        for (Joueur joueur : joueurs) {
            if (!joueur.estVivant()) {
                return true;
            }
        }
        return false;
    }
}

public class Jeu {

    private Integer nbJoueurs;
    private IAffichage affichage;
    private Plateau plateau;
    private Des des;
    private Joueur[] joueurs;

    public Jeu(
        IAffichage affichage,
        Plateau plateau,
        Des des,
        Joueur joueur1,
        Joueur joueur2
    ) {
        this.nbJoueurs = 2;
        this.affichage = affichage;
        this.plateau = plateau;
        this.des = des;
        this.joueurs = new Joueur[] { joueur1, joueur2 };
    }

    public void lancerJeu() {
        affichage.afficherJeu(this);
        int tour = 0;
        boolean finPartie = false;

        while (!finPartie) {
            int indiceJoueur = tour % nbJoueurs;
            Joueur joueurActuel = joueurs[indiceJoueur];
            Joueur joueurEnnemi = joueurs[1 - indiceJoueur];

            deplacerJoueur(joueurActuel);
            affichage.afficherResultatDe(des);

            Case caseActuelle = plateau.getCase(
                joueurActuel.getPositionPlateau()
            );
            affichage.afficherCase(caseActuelle);
            caseActuelle.declencherAction(joueurActuel, joueurEnnemi);

            affichage.afficherJoueur(joueurActuel);

            finPartie = verifierFinPartie();
            tour++;
        }

        affichage.afficherFinPartie(getJoueurGagnant());
    }

    public void deplacerJoueur(Joueur joueur) {
        int resultat = des.lancerDes();
        int max = plateau.getNbCases();
        int positionArrivee = joueur.getPositionPlateau() + resultat;

        if (positionArrivee > max) {
            int excedent = positionArrivee - max;
            positionArrivee = max - excedent;
        }

        joueur.setPositionPlateau(positionArrivee);
    }

    public Joueur getJoueurGagnant() {
        for (int i = 0; i < nbJoueurs; i++) {
            Joueur joueur = joueurs[i];
            if (joueur.getPositionPlateau() == plateau.getNbCases()) {
                return joueur;
            }
            if (!joueur.estVivant()) {
                return joueurs[1 - i];
            }
        }
        return null;
    }

    public Boolean verifierFinPartie() {
        for (Joueur joueur : joueurs) {
            if (
                !joueur.estVivant() ||
                joueur.getPositionPlateau() == plateau.getNbCases()
            ) {
                return true;
            }
        }
        return false;
    }
}

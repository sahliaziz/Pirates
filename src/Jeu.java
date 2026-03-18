public class Jeu {

    private int nbJoueurs;
    private IAffichage affichage;
    private Plateau plateau;
    private Des des;
    private Joueur[] joueurs;

    public Jeu(IAffichage affichage) {
        this.nbJoueurs = 2;
        this.affichage = affichage;
        this.plateau = new Plateau();
        this.des = new Des();
        Joueur joueur1 = new Joueur("Jack Le Borgne", Couleur.ROUGE);
        Joueur joueur2 = new Joueur("Bill Jambe De Bois", Couleur.BLEU);
        this.joueurs = new Joueur[] { joueur1, joueur2 };
    }

    public void lancerJeu() {
        affichage.afficherJeu(this);
        int tour = 0;
        boolean finPartie = false;

        do {
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
        } while (!finPartie);

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

    public boolean verifierFinPartie() {
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

public class Affichage implements IAffichage {

    @Override
    public void afficherJeu(Jeu jeu) {
        System.out.println("========================================");
        System.out.println("========== DÉBUT DE LA PARTIE ==========");
        System.out.println(" Objectif : Atteindre la case 30 !      ");
        System.out.println("========================================\n");
    }

    @Override
    public void afficherJoueur(Joueur joueur) {
        System.out.println(
            "   => " + joueur.getNom() + " [" + joueur.getCouleurPion() + "]"
        );
        System.out.println(
            "      Position : " +
                joueur.getPositionPlateau() +
                " | Vies restantes : " +
                joueur.getPointsDeVie()
        );
        System.out.println("-----------------------------------------");
    }

    @Override
    public void afficherCase(Case c) {
        if (c != null) {
            System.out.println(
                "   -> Atterrit sur la case n°" + c.getNumeroCase()
            );
        }
    }

    @Override
    public void afficherResultatDe(Des des) {
        System.out.println("Résultat des dés : " + des.getDernierResultat());
    }
}

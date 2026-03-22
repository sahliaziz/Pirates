import java.util.Scanner;

public class Affichage implements IAffichage {

    private final Scanner scanner = new Scanner(System.in);

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
        System.out.println("----------------------------------------");
    }

    @Override
    public void afficherCase(Case c) {
        if (c != null) {
            System.out.println(
                "   -> Atterrit sur la case n°" + c.getNumeroCase()
            );
            if (c.estSpeciale()) {
                System.out.println("   [case spéciale] " + c.getNomCase());
                System.out.println("   [action] " + c.getDescriptionCase());
            }
        }
    }

    @Override
    public void afficherResultatDe(Des des) {
        System.out.print("\nAppuyez sur Entrée pour lancer les dés...");
        scanner.nextLine();
        System.out.println("Résultat des dés : " + des.getDernierResultat());
    }

    @Override
    public void afficherFinPartie(Joueur joueurGagnant) {
        System.out.println("========================================");
        System.out.println("=========== FIN DE LA PARTIE ===========");
        System.out.println("Le joueur gagnant est : " + joueurGagnant.getNom());
        System.out.println("========================================\n");
    }
}

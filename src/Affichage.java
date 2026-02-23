
public class Affichage {
	
	public void afficherJeu(Jeu jeu) {
		System.out.println("Affichage du jeu : " + jeu);
	}
	
	public void afficherJoueur(Joueur joueur) {
		System.out.println("Affichage du joueur : " + joueur);
	}
	
	public void afficherCase(Case case) {
		System.out.println("Affichage de la case : " + case);
	}
	
	public void afficherResultatDe(De de) {
		System.out.println("Résultat du dé : " + de.lancerDe());
	}

}

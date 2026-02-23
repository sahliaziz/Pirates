enum Couleur {
	ROUGE, BLEU
}

public class Joueur {
	private String nom;
	private Integer pointsDeVie;
	private Integer position;
	private Couleur couleurPion;
	
	public Joueur(String nom, Couleur couleurPion) {
		this.nom = nom;
		this.pointsDeVie = 100; 
		this.position = 0; 
		this.couleurPion = couleurPion;
	}
	
	public void avancer(int nbCases) {
		position += nbCases;
		System.out.println(nom + " avance de " + cases + " cases. Position actuelle : " + position);
	}
	
	public Boolean estVivant() {
		return pointsDeVie > 0;
	}
	

}

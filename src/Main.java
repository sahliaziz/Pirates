public class Main {

    public static void main(String[] args) {
        Des des = new Des();
        Plateau plateau = new Plateau(30, des);
        Affichage affichage = new Affichage();

        Joueur j1 = new Joueur("Jack Le Borgne", Couleur.ROUGE);
        Joueur j2 = new Joueur("Bill Jambe De Bois", Couleur.BLEU);

        Jeu jeu = new Jeu(affichage, plateau, des, j1, j2);
        jeu.lancerJeu();
    }
}

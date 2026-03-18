public class Main {

    public static void main(String[] args) {
        IAffichage affichage = new Affichage();

        Jeu jeu = new Jeu(affichage);
        jeu.lancerJeu();
    }
}

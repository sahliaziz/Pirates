public class CaseMine extends Case {

    public CaseMine(int numeroCase) {
        super(numeroCase);
        this.nomCase = "Case Mine";
        this.descriptionCase = "Vous perdez 2 points de vie.";
        this.estSpeciale = true;
    }

    @Override
    public void declencherAction(Joueur joueur1, Joueur joueur2) {
        joueur1.modifierVie(-2);
    }
}

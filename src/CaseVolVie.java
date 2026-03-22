public class CaseVolVie extends Case {

    public CaseVolVie(int numeroCase) {
        super(numeroCase);
        this.nomCase = "Case Vol Vie";
        this.descriptionCase =
            "Vous perdez 1 point de vie. Votre adversaire gagne 1 point de vie.";
        this.estSpeciale = true;
    }

    @Override
    public void declencherAction(Joueur joueur1, Joueur joueur2) {
        joueur1.modifierVie(1);
        joueur2.modifierVie(-1);
    }
}

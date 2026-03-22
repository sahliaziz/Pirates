public class CaseNormale extends Case {

    public CaseNormale(int numeroCase) {
        super(numeroCase);
        this.nomCase = "Case Normale";
        this.descriptionCase = "Ne fait rien.";
        this.estSpeciale = false;
    }

    @Override
    protected void declencherAction(Joueur joueur1, Joueur joueur2) {
        // Comportement par défaut : aucune action
    }
}

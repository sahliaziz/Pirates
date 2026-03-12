public class CaseNormale extends Case {

    public CaseNormale(Integer numeroCase) {
        super(numeroCase);
        this.nomCase = "Case Normale";
        this.estSpeciale = false;
    }

    @Override
    protected void declencherAction(Joueur joueur1, Joueur joueur2) {}
}

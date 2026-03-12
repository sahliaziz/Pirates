import java.util.Random;

public class CaseRouletteRusse extends Case {

    private Random random;

    public CaseRouletteRusse(Integer numeroCase) {
        super(numeroCase);
        this.random = new Random();
        this.nomCase = "Case Roulette Russe";
        this.estSpeciale = true;
    }

    @Override
    public void declencherAction(Joueur joueur1, Joueur joueur2) {
        int caseArrivee = random.nextInt(30) + 1;
        joueur1.setPositionPlateau(caseArrivee);
    }
}

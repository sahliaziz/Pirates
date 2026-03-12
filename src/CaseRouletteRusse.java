public class CaseRouletteRusse extends Case {

    private Des des;

    public CaseRouletteRusse(Integer numeroCase, Des des) {
        super(numeroCase);
        this.des = des;
        this.nomCase = "Case Roulette Russe";
        this.estSpeciale = true;
    }

    @Override
    public void declencherAction(Joueur joueur1, Joueur joueur2) {
        int resultat = des.lancerDes();

        joueur1.avancer(resultat - 6);
    }
}

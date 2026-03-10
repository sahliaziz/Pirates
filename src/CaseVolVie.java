public class CaseVolVie extends Case {

    public CaseVolVie(Integer numeroCase) {
        super(numeroCase);
    }

    @Override
    public void declencherAction(Joueur joueur1, Joueur joueur2) {
        joueur1.ajouterVie(1);
        joueur2.ajouterVie(-1);
    }
}

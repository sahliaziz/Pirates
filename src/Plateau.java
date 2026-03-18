public class Plateau {

    private int nbCases = 30;
    private Case[] cases;

    public Plateau(int nbCases) {
        this.nbCases = nbCases;
        this.cases = new Case[nbCases];
        for (int i = 0; i < nbCases; i++) {
            int numCase = i + 1;

            if (numCase == 7 || numCase == 21) {
                this.cases[i] = new CaseVolVie(numCase);
            } else if (numCase == 13 || numCase == 27) {
                this.cases[i] = new CaseRouletteRusse(numCase);
            } else if (numCase == 11 || numCase == 19) {
                this.cases[i] = new CaseMine(numCase);
            } else {
                this.cases[i] = new CaseNormale(numCase);
            }
        }
    }

    public Case getCase(int num) {
        return cases[num - 1];
    }

    public int getNbCases() {
        return nbCases;
    }
}

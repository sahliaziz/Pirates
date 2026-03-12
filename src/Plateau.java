public class Plateau {

    private Integer nbCases;
    private Case[] cases;

    public Plateau(Integer nbCases) {
        this.nbCases = nbCases;
        this.cases = new Case[nbCases];
        for (int i = 0; i < nbCases; i++) {
            int numCase = i + 1;

            if (numCase == 7 || numCase == 21) {
                this.cases[i] = new CaseVolVie(numCase);
            } else if (numCase == 13 || numCase == 27) {
                this.cases[i] = new CaseRouletteRusse(numCase);
            } else {
                this.cases[i] = new CaseNormale(numCase);
            }
        }
    }

    public Case getCase(Integer num) {
        return cases[num - 1];
    }

    public Integer getNbCases() {
        return nbCases;
    }
}

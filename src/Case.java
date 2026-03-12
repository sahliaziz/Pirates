public abstract class Case {

    protected Integer numeroCase;
    protected String nomCase;
    protected Boolean estSpeciale;

    public Case(Integer numeroCase) {
        this.numeroCase = numeroCase;
    }

    public Integer getNumeroCase() {
        return numeroCase;
    }

    protected abstract void declencherAction(Joueur joueur1, Joueur joueur2);
}

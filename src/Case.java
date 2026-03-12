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

    public Boolean estSpeciale() {
        return estSpeciale;
    }

    public String getNomCase() {
        return nomCase;
    }

    protected abstract void declencherAction(Joueur joueur1, Joueur joueur2);
}

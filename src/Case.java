public abstract class Case {

    protected int numeroCase;
    protected String nomCase;
    protected boolean estSpeciale;

    protected Case(int numeroCase) {
        this.numeroCase = numeroCase;
    }

    public int getNumeroCase() {
        return numeroCase;
    }

    public boolean estSpeciale() {
        return estSpeciale;
    }

    public String getNomCase() {
        return nomCase;
    }

    protected void declencherAction(Joueur joueur1, Joueur joueur2) {
        // Comportement par défaut : aucune action
    }
}

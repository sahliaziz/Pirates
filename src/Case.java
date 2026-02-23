
public abstract class Case {
	private Integer numeroCase;
	
	public Case(Integer numeroCase) {
		this.numeroCase = numeroCase;
	}
	
	public Integer getNumeroCase() {
		return numeroCase;
	}
	
	public abstract void declencherAction(Joueur joueur);

}

public abstract class Case {
	private Integer numeroCase;
	
	public Case(Integer numeroCase) {
		this.numeroCase = numeroCase;
	}
	
	public Integer getNumeroCase() {
		return numeroCase;
	}
	
	protected abstract void declencherAction(Joueur joueur1, Joueur joueur2);
	

}

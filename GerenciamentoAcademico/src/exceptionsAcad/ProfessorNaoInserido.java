package exceptionsAcad;

public class ProfessorNaoInserido extends Exception{
	public ProfessorNaoInserido() {
		super("Falha a inserir o professor.");
	}
}

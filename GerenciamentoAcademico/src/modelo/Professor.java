package modelo;

public class Professor extends Pessoa{
	private int matricula;
	
	public Professor() {
		
	}
	
	public Professor(int matricula) {
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}

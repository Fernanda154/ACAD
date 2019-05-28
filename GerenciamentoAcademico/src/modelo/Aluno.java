package modelo;

public class Aluno extends Pessoa {
	private int matricula;
	private double[] notas;
	private double frequencia;

	private int faltas;
	private boolean atuante;
	
	public Aluno() {
		
	}


	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public boolean isAtuante() {
		return atuante;
	}

	public void setAtuante(boolean atuante) {
		this.atuante = atuante;
	}

	public Aluno(int matricula) {
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(double frequencia) {
		this.frequencia = frequencia;
	}
	
	
	//------------------------------   MÉTODOS PARA NOTA ------------------------------
	public void inserirNota(String matricula, double nota) {
		//insere uma nota a partir de uma matricula.
	}
	public void atualizarNota(String matricula, double novaNota) {
		//Insere nova nota a partir de uma matricula
	}
	public double[] buscarNotas(String matricula) {
		//Retorna as notas associadas a uma matricula.
		return this.notas;
	}
	

}

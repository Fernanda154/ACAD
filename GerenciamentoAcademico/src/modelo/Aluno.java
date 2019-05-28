package modelo;

public class Aluno extends Pessoa {
	private int matricula;
	Turma turma[];
	private double[] notas;
	private double frequencia;
	
	private int aulasDadas;
	private int faltas;
	
	
	public Aluno() {
		
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
	
	//------------------------------  MÉTODOS PARA FREQUÊNCIA  -----------------------------
	
	public void inserirFrequencia(int falta, int quantAulas) {
		// Insere frequencia em media do aluno em %
		this.aulasDadas = aulasDadas + quantAulas;
		this.faltas = faltas + falta;
		int presenca = aulasDadas - faltas;
		this.frequencia = presenca*100/aulasDadas;
	}
	public double buscarFrequencia(String matricula) {
		// Retorna a frequência média do aluno
		return this.frequencia;
	}
	public void atualizarFrequencia(int falta, int quantAulas) {
		//Atualizar frequencia media do aluno
		
	}
}

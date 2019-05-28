package modelo;

public class Professor extends Pessoa{
	private double salario;
	private int matricula;
	
	public Professor() {
		
	}
	
	public Professor(double salario, int matricula) {
		this.salario = salario;
		this.matricula = matricula;
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}

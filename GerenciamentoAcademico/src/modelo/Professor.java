package modelo;

public class Professor extends Pessoa{
	private double salario;
	private String matricula;
	
	public Professor() {
		
	}
	
	public Professor(double salario, String matricula) {
		super();
		this.salario = salario;
		this.matricula = matricula;
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}

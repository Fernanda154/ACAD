package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Administrador extends Pessoa{
	private int matricula;

	public Administrador() {
		
	}
	
	
	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public Administrador(int matricula) {
		this.matricula = matricula;
	}

	
	

}

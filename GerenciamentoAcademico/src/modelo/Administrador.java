package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Administrador {
	private int matricula;
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	
	public Administrador() {
		
	}
	
	
	public Administrador(int matricula, ArrayList<Turma> turmas) {
		this.matricula = matricula;
		this.turmas = turmas;
	}


	public void inserirAluno(String codigo, Aluno aluno) {
		for(int i=0;i<turmas.size();i++){
			Turma turmaEncontrada = turmas.get(i);
			if(turmaEncontrada.getCodigo() == codigo) {
				turmaEncontrada.inserirAlunos(aluno.getMatricula(), aluno);
				
				break;
			}
		}
	}
	
	public void listarAlunos(String codigo) {
		for(int i=0;i<turmas.size();i++){
			Turma turmaEncontrada = turmas.get(i);
			if(turmaEncontrada.getCodigo() == codigo) {
				turmaEncontrada.listarAlunos();
				break;
			}
		}
	}
	
	public void inserirTurma(Turma turma) {
		this.turmas.add(turma);
	}
}

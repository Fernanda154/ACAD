package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Administrador {
	private int matricula;
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	private HashMap<Integer, Aluno> alunos = new HashMap<Integer, Aluno>(); 
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
				turmaEncontrada.inserirAlunos(aluno);
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
	
	public void inserirProfessor(String codigo, Professor prof) {
		for(int i=0;i<turmas.size();i++){
			Turma turmaEncontrada = turmas.get(i);
			if(turmaEncontrada.getCodigo() == codigo) {
				turmaEncontrada.setProf(prof);
				break;
			}
		}
	}
	public void listaProfessor(String codigo) {
		for(int i=0;i<turmas.size();i++){
			Turma turmaEncontrada = turmas.get(i);
			if(turmaEncontrada.getCodigo() == codigo) {
				turmaEncontrada.getProf();
				break;
			}
		}
	}
	public void inserirTurma(Turma turma) {
		this.turmas.add(turma);
	}
	public void listarTurmas() {
		if(turmas == null) {
			System.out.println("Não há turmas cadastradas. ");
		}else {
			for(int i = 0; i < turmas.size(); i++) {
				Turma aux = turmas.get(i);
				System.out.println(aux.getDescricao() + " CÓDIGO DA TURMA: " + aux.getCodigo());
			}
		}
		System.out.println("Quantidade de turmas cadastradas." + turmas.size());
	}

}

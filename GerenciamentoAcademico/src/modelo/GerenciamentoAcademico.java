package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class GerenciamentoAcademico {
	
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	private ArrayList<Aluno> alunosRP = new ArrayList<Aluno>(); 
	private ArrayList<Professor>professoresRP = new ArrayList<Professor>(); 
	
	
	public GerenciamentoAcademico() {
		
	}
	public GerenciamentoAcademico(ArrayList<Turma> turmas, ArrayList<Aluno> alunosRP) {
		this.turmas = turmas;
		this.alunosRP = alunosRP;
	}
	//Registra permanentemente um aluno aluno na instituição
	public void inserirAlunoNoSistema(Aluno aluno) {
		this.alunosRP.add(aluno);
		if(this.alunosRP == null) {
			System.out.println("nada inserido");
		}
	}
	
	//Lista todos os alunos que passaram ou ainda estão na instituição
	public void listarAlunos() {
		for(int i=0;i<alunosRP.size();i++){
			Aluno aux = alunosRP.get(i);
			System.out.println(aux.getNome() + " " + aux.getMatricula());
		}
	}
	
	//Registra permanentemente um professor na instituição
	public void inserirProfessorNoSistema(Professor prof) {
			this.professoresRP.add(prof);
			if(turmas == null) {
				System.out.println("Tais iludida");
			}
	}
	
	//Registra um professor numa turma
	public void inserirProfessorNaTurma(int codigo, int matricula) {
		for(int i = 0; i < turmas.size(); i++) {
			Turma aux = turmas.get(i);
			if(codigo == i) {
				System.out.println("Turma encontrada");
				for(int k = 0; k < professoresRP.size(); k ++) {
					if(matricula == professoresRP.get(k).getMatricula() ) {
						turmas.get(i).inserirProfessor(professoresRP.get(k));
						System.out.println("Professor encontrado.");
						break;
					}
				}
				break;
			}
			else {
				System.out.println("Turma não encontrada.");
			}
		}
	}
	
	//Lista o professor da turma
	public void buscarProfessor(int codigo) {
		for(int i = 0; i<turmas.size();i++) {
			if(codigo == i) {
				String nome = turmas.get(i).getProf().getNome();
				int matricula = turmas.get(i).getProf().getMatricula();
				System.out.println(nome + " MATRÍCULA: " + matricula);
			}
		}
	}
	//Lista todos os professores que passaram ou ainda estão na instituição
	public void listarProfessores() {
		for(int i= 0; i < professoresRP.size(); i++) {
			Professor aux = professoresRP.get(i);
			System.out.println(aux.getNome() + " " + aux.getMatricula());
		}
	}
	//Inserir turma no sistema 
	public void inserirTurma(Turma turma) {
		this.turmas.add(turma);
		if(turmas == null) {
			System.out.println("Tais iludida");
		}
	}
	
	//Listar turmas do sistema
	public void listarTurmas() {
		if(turmas == null) {
			System.out.println("Não há turmas cadastradas. ");
		}else {
			for(int i = 0; i < turmas.size(); i++) {
				Turma aux = turmas.get(i);
				System.out.println(aux.getDescricao() + " CÓDIGO DA TURMA: " + i);
			}
		}
		System.out.println("Quantidade de turmas cadastradas." + turmas.size());
	}

}

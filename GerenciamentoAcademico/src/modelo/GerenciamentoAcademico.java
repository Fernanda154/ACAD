package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class GerenciamentoAcademico {
	
	private ArrayList<Turma> turmas = new ArrayList<Turma>();
	private ArrayList<Aluno> alunosRP = new ArrayList<Aluno>(); 
	private ArrayList<Professor>professoresRP = new ArrayList<Professor>(); 
	private ArrayList<Administrador>adm = new ArrayList<Administrador>(); 
	
	public GerenciamentoAcademico() {
		
	}
	public GerenciamentoAcademico(ArrayList<Turma> turmas, ArrayList<Aluno> alunosRP) {
		this.turmas = turmas;
		this.alunosRP = alunosRP;
	}
	
	
	//logar
	public int logar(int matricula, String senha) {
		int podeEntrar = 0;
		if(matricula < 200 && matricula > 3) {
			for(int i=0;i<professoresRP.size();i++){
				if(professoresRP.get(i).getMatricula() == matricula && professoresRP.get(i).getSenha() == senha) {
					podeEntrar = 1;
				}else {
					System.out.println("SENHA OU MATRÍCULA INVÁVLIDOS.");
				}
			}
		}
		if(matricula > 200) {
			for(int i=0;i<alunosRP.size();i++){
				if(alunosRP.get(i).getMatricula() == matricula && alunosRP.get(i).getSenha() == senha) {
					podeEntrar = 2;
				}else {
					System.out.println("SENHA OU MATRÍCULA INVÁVLIDOS.");
				}
			}
		}
		if(matricula < 3) {
			for(int i=0;i<adm.size();i++){
				if(adm.get(i).getMatricula() == matricula && adm.get(i).getSenha() == senha) {
					podeEntrar = 3;
				}else {
					System.out.println("SENHA OU MATRÍCULA INVÁVLIDOS.");
				}
			}
		}
		return podeEntrar;
	}
	public void inserirAdm(Administrador adm) {
		this.adm.add(adm);
		if(this.adm == null) {
			System.out.println("---------------------------------------NADA INSERIDO");
		}
	}

	//Registra permanentemente um aluno aluno na instituição
	public void inserirAlunoNoSistema(Aluno aluno) {
		this.alunosRP.add(aluno);
		if(this.alunosRP == null) {
			System.out.println("---------------------------------------NADA INSERIDO");
		}
	}
	//Atualiza os dados de um aluno
	public void atualizarAluno(Aluno kid) {
		for(int i=0;i<alunosRP.size();i++){
			if(kid.getMatricula() == alunosRP.get(i).getMatricula()){
				alunosRP.get(i).setEndereco(kid.getEndereco());
				alunosRP.get(i).setTelefone(kid.getTelefone());
				alunosRP.get(i).setSenha(kid.getSenha());
			}
		}
	}
	//Atualiza os dados de um professor
	public void atualizarProfessor(Professor prof) {
		for(int i=0;i<professoresRP.size();i++){
			if(prof.getMatricula() == professoresRP.get(i).getMatricula()){
				professoresRP.get(i).setEndereco(prof.getEndereco());
				professoresRP.get(i).setTelefone(prof.getTelefone());
				professoresRP.get(i).setSenha(prof.getSenha());
			}
		}
	}
	//Lista todos os alunos que passaram ou ainda estão na instituição
	public void listarAlunos() {
		for(int i=0;i<alunosRP.size();i++){
			Aluno aux = alunosRP.get(i);
			System.out.println(aux.getNome() + " " + aux.getMatricula());
		}
		if(this.alunosRP == null) {
			System.out.println("---------------------------------------NADA INSERIDO.");
		}
	}
	
	//Lista todos os alunos de uma turma
	public void listarAlunosDaTurma(String codigo) {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>(); 
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo() == codigo) {
				for(int k = 0; k < turmas.get(i).getAlunos().size(); k++) {
					System.out.println( turmas.get(i).getAlunos().get(k).getNome() + "MATRÍCULA: " + turmas.get(i).getAlunos().get(k).getMatricula());
					
				}
			}
		}
	}
	
	//Registra permanentemente um professor na instituição
	public void inserirProfessorNoSistema(Professor prof) {
			this.professoresRP.add(prof);
	}
	
	//Registra um aluno numa turma
	public void inserirAlunoNaTurma(String codigo, int matricula) {
		for(int i = 0; i < turmas.size(); i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)) {
				for(int k = 0; k < alunosRP.size(); k ++) {
					if(matricula == alunosRP.get(k).getMatricula() ) {
						turmas.get(i).inserirAlunos(alunosRP.get(k));
						System.out.println("---------------------------------------ALUNO INSERIDO.");
						break;
					}
				}
				break;
			}
			else {
				System.out.println("---------------------------------------TURMA NÃO ENCONTRADA.");
			}
		}
	}
	
	public void removerAluno(String codigo, int matricula) {
		for(int i = 0; i < turmas.size(); i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)) {
				for(int k = 0; k < alunosRP.size(); k ++) {
					if(matricula == alunosRP.get(k).getMatricula() ) {
						turmas.get(i).removerAluno(matricula);
					}
				}
			}
		}
	}
	
	//Registra um professor numa turma
	public void inserirProfessorNaTurma(String codigo, int matricula) {
		for(int i = 0; i < turmas.size(); i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)) {
				System.out.println("Turma encontrada");
				for(int k = 0; k < professoresRP.size(); k ++) {
					if(matricula == professoresRP.get(k).getMatricula() ) {
						turmas.get(i).inserirProfessor(professoresRP.get(k));
						System.out.println("---------------------------------------PROFESSOR INSERIDO.");
						break;
					}
				}
				break;
			}
			else {
				System.out.println("---------------------------------------TURMA NÃO ENCONTRADA.");
			}
		}
	}
	
	//Lista o professor da turma
	public void buscarProfessor(String codigo) {
		for(int i = 0; i<turmas.size();i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)){
				String nome = turmas.get(i).getProf().getNome();
				int matricula = turmas.get(i).getProf().getMatricula();
				System.out.println(nome + " MATRÍCULA: " + matricula);
			}
		}
	}
	//Remover um professor de uma turma 
	public void removerProfessor(String codigo, int matricula) {
		for(int i = 0; i<turmas.size();i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)){
				turmas.get(i).removerProfessor(matricula);
			}else {
				System.out.println("---------------------------------------TURMA NÃO ENCONTRADA.");
			}
		}
	}
	
	//Lista todos os professores que passaram ou ainda estão na instituição
	public void listarProfessores() {
		System.out.println("------------PROFESSORES CADASTRADOS------------");
		for(int i= 0; i < professoresRP.size(); i++) {
			Professor aux = professoresRP.get(i);
			System.out.println(i + " " + aux.getNome() + "MATRÍCULA: " + aux.getMatricula());
		}
	}
	//Inserir turma no sistema 
	public void inserirTurma(Turma turma) {
		this.turmas.add(turma);
	}
	//Atualizar uma turma
	public void atualizarTurma(String codigo, int sala) {
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				turmas.get(i).setSala(sala);
			}else {
				System.out.println("---------------------------------------TURMA NÃO ENCONTRADA.");
			}
		}
	}
	//Remover uma turma
	public void removerTurma(String codigo) {
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				if(turmas == null) {
					turmas.remove(turmas.get(i));
				}
			}
		}
	}
	//Listar turmas do sistema
	public void listarTurmas() {
		if(turmas == null) {
			System.out.println("NÃO HÁ TURMAS CADASTRADAS. ");
		}else {
			System.out.println("------------ TURMAS CADASTRADAS ------------");
			for(int i = 0; i < turmas.size(); i++) {
				Turma aux = turmas.get(i);
				System.out.println(i + " " + aux.getDescricao() + " CÓDIGO DA TURMA: " + aux.getCodigo());
			}
		}
		System.out.println("QUANTIDADE DE TURMAS CADASTRADsAS: " + turmas.size());
	}
	public void listarTurmasDoAluno(int matricula) {
		if(turmas == null) {
			System.out.println("NÃO HÁ TURMAS CADASTRADAS. ");
		}else {
			System.out.println("------------ TURMAS CADASTRADAS ------------");
			for(int i = 0; i < turmas.size(); i++) {
				if(turmas.get(i).buscarAlunos(matricula) == matricula) {
					System.out.println(turmas.get(i).getDescricao() + " CÓDIGO: " + turmas.get(i).getCodigo());
				}
			}
		}
		System.out.println("QUANTIDADE DE TURMAS CADASTRADAS: " + turmas.size());
	}

}

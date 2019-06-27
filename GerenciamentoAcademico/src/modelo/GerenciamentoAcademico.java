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
	
	
	//FUN��ES DO SISTEMA-----------------------------------------------------------------------------------------------------------------------------------------------
	public void exibirAdm() {
		for(int i=0;i<adm.size();i++){
			System.out.println(adm.get(i).getNome() + " " + adm.get(i).getMatricula());
		}
	}
	//logar
	public int logar(int matricula, String senha) {
		int podeEntrar = 0;
		if(matricula < 200 && matricula > 3) {
			for(int i=0;i<professoresRP.size();i++){
				if(professoresRP.get(i).getMatricula() == matricula && professoresRP.get(i).getSenha().equals(senha)) {
					podeEntrar = 1;
					System.out.println("� PROFESSOR");
				}
			}
			
		}
		if(matricula > 200) {
			for(int i=0;i<alunosRP.size();i++){
				if(alunosRP.get(i).getMatricula() == matricula && alunosRP.get(i).getSenha().equals(senha)) {
					podeEntrar = 2;
					System.out.println("� ALUNO");
				}
			}
		}
		if(matricula < 3) {
			for(int i=0;i<adm.size();i++){
				if(adm.get(i).getMatricula() == matricula && adm.get(i).getSenha().equals(senha)) {
					podeEntrar = 3;
				}
			}
		}
		if(podeEntrar == 0) {
			System.out.println("SENHA OU USU�RIO INV�LIDOS");
		}
		return podeEntrar;
	}
	public void inserirAdm(Administrador adm) {
		this.adm.add(adm);
		if(this.adm == null) {
			System.out.println("---------------------------------------NADA INSERIDO");
		}
	}
//FUN��ES DE ALUNO -----------------------------------------------------------------------------------------------------------------------------------------------
	//Registra permanentemente um aluno aluno na institui��o
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
	//Registra um aluno numa turma
	public void inserirAlunoNaTurma(String codigo, int matricula) {
		for(int i = 0; i < turmas.size(); i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)) {
				for(int k = 0; k < alunosRP.size(); k ++) {
					if(matricula == alunosRP.get(k).getMatricula() ) {
						turmas.get(i).inserirAlunos(alunosRP.get(k));
						alunosRP.get(k).setRegistroDisciplinas(turmas.get(i).getDescricao());
						System.out.println("---------------------------------------ALUNO INSERIDO.");
						break;
					}
				}
				break;
			}
		}
	}
	
	public void removerAlunoDeTurma(int matricula, String codigo) {
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				turmas.get(i).removerAluno(matricula);
			}
		}
	}
	
	//Lista todos os alunos que passaram ou ainda est�o na institui��o
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
				alunos = turmas.get(i).getAlunos();
				for(int k = 0; k < alunos.size(); k++) {
					System.out.println( alunos.get(k).getNome() + " MATR�CULA: " + alunos.get(k).getMatricula());
					
				}
			}
		}
	}
	public Aluno buscarAluno(String codigo, String nome) {
		Aluno aux = null;
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				System.out.println("Achei turma");
				aux = turmas.get(i).buscarAluno(nome);
			}
		}
		if(aux == null) {
			System.out.println("Achei nada");
		}
		return aux;
	}
	
	public void listarTurmasDoAluno(int matricula) {
		if(turmas == null) {
			System.out.println("N�O H� TURMAS CADASTRADAS. ");
		}else {
			System.out.println("------------ TURMAS CADASTRADAS ------------");
			for(int i = 0; i < turmas.size(); i++) {
				if(turmas.get(i).buscarAlunos(matricula) == matricula) {
					System.out.println(turmas.get(i).getDescricao() + " C�DIGO: " + turmas.get(i).getCodigo());
				}
			}
		}
		System.out.println("QUANTIDADE DE TURMAS CADASTRADAS: " + turmas.size());
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

	

	
	//Registra permanentemente um professor na institui��o
	public void inserirProfessorNoSistema(Professor prof) {
			this.professoresRP.add(prof);
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
		}
	}
	
	//Lista o professor da turma
	public Professor buscarProfessor(String codigo) {
		Professor auxProf = null;
		for(int i = 0; i<turmas.size();i++) {
			Turma aux = turmas.get(i);
			if(aux.getCodigo().equals(codigo)){
				auxProf =  turmas.get(i).getProf();
			}
		}
		return auxProf;
	}
	//Busca todas as turmas nas quais o professor ministra aula
	public void buscarTurmasDeProfessor(int matricula) {
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getProf().getMatricula() == 0) {
				
			}
			if(turmas.get(i).getProf().getMatricula() == matricula) {
				System.out.println("NOME: "+ turmas.get(i).getDescricao() + " C�DIGO: " + turmas.get(i).getCodigo());
				break;
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
				System.out.println("---------------------------------------TURMA N�O ENCONTRADA.");
			}
		}
	}
	
	//Lista todos os professores que passaram ou ainda est�o na institui��o
	public void listarProfessores() {
		System.out.println("------------PROFESSORES CADASTRADOS------------");
		for(int i= 0; i < professoresRP.size(); i++) {
			Professor aux = professoresRP.get(i);
			System.out.println(i + " " + aux.getNome() + "MATR�CULA: " + aux.getMatricula());
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
				System.out.println("---------------------------------------TURMA N�O ENCONTRADA.");
			}
		}
	}
	//Remover uma turma
	public void removerTurma(String codigo) {
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				if(turmas.get(i).getAlunos() == null) {
					turmas.remove(turmas.get(i));
				}else {
					System.out.println("*****N�O SE PODE EXCLUIR UMA TURMA CUJA TENHA ALUNOS MATRICULADO*****");
				}
			}
		}
	}
	//Listar turmas do sistema
	public void listarTurmas() {
		if(turmas == null) {
			System.out.println("N�O H� TURMAS CADASTRADAS. ");
		}else {
			System.out.println("------------ TURMAS CADASTRADAS ------------");
			for(int i = 0; i < turmas.size(); i++) {
				Turma aux = turmas.get(i);
				System.out.println(i + " " + aux.getDescricao() + " C�DIGO DA TURMA: " + aux.getCodigo());
			}
		}
		System.out.println("QUANTIDADE DE TURMAS CADASTRADsAS: " + turmas.size());
	}
	

	public void inserirFrequencia(String codigo, int matricula, boolean presenca) {
		ArrayList<Aluno>aux = new ArrayList();
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				aux = turmas.get(i).getAlunos();
				for(int e = 0; e < aux.size(); e++) {
					if(aux.get(e).getMatricula() == matricula) {
						aux.get(e).inserirFrequencia(presenca);
						System.out.println(aux.get(e).exibirFrequencia() + "%" );
					}
				}
			}
		}
	}

	public void inserirNota(String codigo, int matricula, String nota) {
		ArrayList<Aluno>aux = new ArrayList();
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				aux = turmas.get(i).getAlunos();
				for(int e = 0; e < aux.size(); e++) {
					if(aux.get(e).getMatricula() == matricula) {
						aux.get(e).inserirNota( nota, turmas.get(i).getDescricao());
						aux.get(e).buscarNotas(turmas.get(i).getDescricao());
					}
				}
			}
		}
		
	}
	public void atualizarNota(String codigo, int matricula, String nota, String notaAntiga) {
		ArrayList<Aluno>aux = new ArrayList();
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				aux = turmas.get(i).getAlunos();
				for(int e = 0; e < aux.size(); e++) {
					if(aux.get(e).getMatricula() == matricula) {
						aux.get(e).atualizarNota( nota, turmas.get(i).getDescricao(), notaAntiga);
						
					}
				}
			}
		}
		
	}
	public void buscarNota(String codigo, int matricula) {
		ArrayList<Aluno>aux = new ArrayList();
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				aux = turmas.get(i).getAlunos();
				for(int e = 0; e < aux.size(); e++) {
					if(aux.get(e).getMatricula() == matricula) {
						aux.get(e).buscarNotas(turmas.get(i).getDescricao());
					}
				}
			}
		}
	}
	public double exibirFrequencia(String codigo, int matricula) {
		ArrayList<Aluno>aux = new ArrayList();
		double media = 0;
		for(int i = 0; i < turmas.size(); i++) {
			if(turmas.get(i).getCodigo().equals(codigo)) {
				aux = turmas.get(i).getAlunos();
				for(int e = 0; e < aux.size(); e++) {
					if(aux.get(e).getMatricula() == matricula) {
						System.out.println(aux.get(e).exibirFrequencia());
					}
				}
			}
		}
		return media;
		
	}


}

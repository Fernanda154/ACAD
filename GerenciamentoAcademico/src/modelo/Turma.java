package modelo;
import java.util.*;

public class Turma {
	private String descricao;
	private String turno;
	private int sala;
	private String codigo;
	private Professor prof; 
	private ArrayList<String> notas = new ArrayList();
	private ArrayList<Aluno> alunos = new ArrayList();
	
	public Turma() {
		
	}

	public Turma(String descricao, String turno, int sala) {
		super();
		this.alunos = new ArrayList<Aluno>();
		this.descricao = descricao;
		this.turno = turno;
		this.sala = sala;
	}
	

	public ArrayList<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public ArrayList<String> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<String> notas) {
		this.notas = notas;
	}

	//------------------------------------------ MÃ‰TODO DE ALUNO --------------------------------
	//Insere um aluno
	public void inserirAlunos(Aluno aluno) {
		alunos.add(aluno);
	}
	public void inserirNota(String nota) {
		notas.add(nota);
	}
	public void listarNotas() {
		for(int i = 0; i < notas.size(); i++) {
			System.out.println("NOTA: " + notas.get(i));
		}
	}
	
	/*
	public Aluno buscarAluno(int matricula) {
		Aluno kid = null;
		if(this.alunos.containsKey(matricula)) {
			kid = this.alunos.get(matricula);
			System.out.print(kid.getNome());
		}
		else {
			System.out.println("Aluno não encontrado.");
		}
		return kid;
		
	}
	*/
	public void listarAlunos() {
		if(alunos == null) {
			System.out.println("Não inseriu");
		}else {
			for(int i = 0; i < alunos.size(); i++) {
				Aluno aux = alunos.get(i);
				System.out.println(aux.getNome() + " MATRÍCULA: " + aux.getMatricula());
			}
		}
		System.out.println(alunos.size());
		
	}
	//Busca um aluno na turma
	public int buscarAlunos(int matricula) {
		int taAqui = 0;
		for(int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getMatricula() == matricula) {
				taAqui = alunos.get(i).getMatricula();
			}
		}
		return taAqui;
	}
	//Busca um aluno na turma
	public int buscarProfessor(int matricula) {
		int taAqui = 0;
		if(this.prof.getMatricula() == matricula) {
			taAqui = 1;
		}
		return taAqui;
	}
	//Busca um aluno na turma pelo nome
	public Aluno buscarAluno(String nome) {
		Aluno aux = null;
		for(int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getNome().equals(nome)) {
				aux = alunos.get(i);
			}
		}
		return aux;
	}
	
	public void removerAluno(int matricula) {
		
		for(int i = 0; i < alunos.size(); i++) {
			Aluno teste = alunos.get(i);
			
			if(teste.getMatricula() == matricula) {
				alunos.remove(alunos.get(i));
				break;
			}
			
		}
		
		
	}
	//-------------------------------------------------- MÉTODOS DE INSERÇÃO -----------------------------------------
	
	public void inserirProfessor(Professor prof) {
		if(this.prof == null) {
			this.prof = prof;
		}
	}
	public void removerProfessor(int matricula) {
		if(prof.getMatricula() == matricula) {
			prof = null;
		}
	}
	

	
	
}

package modelo;
import java.util.*;

public class Turma {
	private String descricao;
	private String turno;
	private int sala;
	private String codigo;
	private Professor prof;
	private HashMap<Integer, Aluno> alunos = new HashMap<Integer, Aluno>(); 

	
	public Turma() {
		
	}

	public Turma(String descricao, String turno, int sala) {
		super();
		this.alunos = new HashMap<Integer, Aluno>();
		this.descricao = descricao;
		this.turno = turno;
		this.sala = sala;
	}
	
	public HashMap<Integer, Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(HashMap<Integer, Aluno> alunos) {
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
	
	//--------------------------------  MÃ‰TODOS DE TURMA  --------------------------

//------------------------------------------ MÃ‰TODO DE ALUNO --------------------------------
	//Insere um aluno
	public void inserirAlunos(int matricula, Aluno aluno) {
		if(this.alunos.isEmpty()) {
			this.alunos.put(matricula, aluno);
		}else {
			if(this.alunos.containsKey(matricula)) {
				System.out.println("ERRO : Aluno já está matriculado.");
			}
		}
		if(alunos == null) {
			System.out.println("Não inseriu");
		}
	}
	
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
	
	public void listarAlunos() {

		for(int matricula : alunos.keySet()) {
			Aluno alunoEncontrado = alunos.get(matricula);
			System.out.println(alunoEncontrado.getNome());
		}
		
	}
	public void removerAluno(String matricula) {
		if(this.alunos.containsKey(matricula)) {
			alunos.remove(matricula);
		}else {
			System.out.println("VocÃª nÃ£o pode remover quem nunca inseriu baby.");
		}
		
	}
	//-------------------------------------------------- MÉTODOS DE INSERÇÃO -----------------------------------------
	
	public void inserirProfessor(String codigo, Professor prof) {
		if(this.prof == null) {
			this.prof = prof;
		}
	}
	public Professor buscarProfessor(String codigo) {
		Professor prof = new Professor();
		return prof;
	}
	

	
	
}

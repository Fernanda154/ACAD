package modelo;
import java.util.*;

public class Turma {
	private String descricao;
	private String turno;
	private int sala;
	private String codigo;
	private Professor prof; 
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
		return alunos;
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

//------------------------------------------ MÃ‰TODO DE ALUNO --------------------------------
	//Insere um aluno
	public void inserirAlunos(Aluno aluno) {
		Boolean temOUnao = false;
		for(int i = 0; i < alunos.size(); i++) {
			Aluno teste = alunos.get(i);
			
			if(teste.getMatricula() == aluno.getMatricula()) {
				temOUnao = true;
			}else {
				temOUnao = false;
			}
		}
		if(temOUnao) {
			System.out.println("Aluno já matriculado.");
		}else {
			alunos.add(aluno);
		}
		if(alunos.contains(aluno)) {
			System.out.println("Aluno inserido.");
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

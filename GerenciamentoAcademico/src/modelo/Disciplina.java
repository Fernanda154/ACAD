package modelo;
import java.util.HashMap;

public class Disciplina {
	private String descricao;
	private String codigo;
	Aluno alunos[];
	Professor prof = new Professor();
	
	public Disciplina() {
		alunos = new Aluno[10];
	}
	
	public Disciplina(String descricao, String codigo, Professor prof) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.prof = prof;
		alunos = new Aluno[10];
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	//   inserirAluno ---> Insere um aluno na Disciplina
	public void inserirAluno(Aluno aluno){
		boolean arrayCheio = true;
		for (int i = 0; i < alunos.length; i++) {
			if(alunos[i] == null){
				alunos[i] = aluno;
				arrayCheio = false;
				break;
			}
		}
		if(arrayCheio){
			Aluno aux[] = new Aluno[alunos.length*2];
			int posicaoImediata = alunos.length;
			for (int i = 0; i < alunos.length; i++) {
				aux[i] = alunos[i];
			}
			alunos = aux;			
			alunos[posicaoImediata] = aluno;
		}
	}
	
	
	// inserirProfessor ----> Insere um professor na disciplina
	public void inserirProfessor(Professor prof) {
		if(this.prof == null) {
			this.prof = prof;
		}else {
			System.out.println("Esta matéria já tem ministrante.");
		}
	}

}

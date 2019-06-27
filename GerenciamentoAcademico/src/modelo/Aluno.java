package modelo;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	private int matricula;
	private String [][] notas = new String[7][14];
	private ArrayList<Boolean>frequencia = new ArrayList();
	private int faltas;
	private boolean atuante;
	private ArrayList<Turma>turmasAluno = new ArrayList();
	public Aluno() {
		
	}


	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public boolean isAtuante() {
		return atuante;
	}

	public void setAtuante(boolean atuante) {
		this.atuante = atuante;
	}

	public Aluno(int matricula) {
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String[][] getNotas() {
		return notas;
	}
	

	public void setRegistroDisciplinas(String nome) {
		Turma aux = new Turma();
		aux.setDescricao(nome);
		turmasAluno.add(aux);
	}
	
	
	//------------------------------   MÉTODOS PARA NOTA ------------------------------
	public void inserirNota(String nota, String nomeDisciplina) {
		for(int i = 0; i < turmasAluno.size(); i++) {
			if(turmasAluno.get(i).getDescricao().equals(nomeDisciplina)) {
				turmasAluno.get(i).inserirNota(nota);
			}
			else {
				System.out.println("NAO ACHEI");
			}
		}
	}
	public void atualizarNota(String nota, String nomeDisciplina, String notaAntiga) {
		ArrayList notas = new ArrayList();
		for(int i = 0; i < turmasAluno.size(); i++) {
			if(turmasAluno.get(i).getDescricao().equals(nomeDisciplina)) {
				notas = turmasAluno.get(i).getNotas();
				for(int e = 0; e < notas.size(); e++) {
					if(notas.get(e).equals(notaAntiga)) {
						turmasAluno.get(i).inserirNota(nota);
					}
				}
				turmasAluno.get(i).inserirNota(nota);
			}
			else {
				System.out.println("NAO ACHEI");
			}
		}
	}
	public void listarTurmas() {
		for(int i = 0; i < turmasAluno.size(); i++) {
			System.out.println(turmasAluno.get(i).getDescricao());
		}
	}
	public void atualizarNota(int matricula, double novaNota) {
		//Insere nova nota a partir de uma matricula
	}
	public void buscarNotas(String nome) {
		for(int i = 0; i < turmasAluno.size(); i++) {
			if(turmasAluno.get(i).getDescricao().equals(nome)) {
				turmasAluno.get(i).listarNotas();
			}
		}
	}
	
	//-------------------------------------------------------------------------
	public void inserirFrequencia(boolean presenca) {
		frequencia.add(presenca);
	}
	public double exibirFrequencia() {
		int totalAulas = frequencia.size();
		int aulasAssistidas = 0;
		for(int i = 0; i < frequencia.size();i++) {
			if(frequencia.get(i) == true) {
				aulasAssistidas = aulasAssistidas + 1;
			}
		}
		double media = (aulasAssistidas*100)/totalAulas;
		return media;
	}

}

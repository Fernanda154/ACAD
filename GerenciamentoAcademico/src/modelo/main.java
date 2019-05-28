package modelo;
import  ExceptionsAcad.CPFInvalidoException;
import java.sql.Connection;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		Aluno kid = new Aluno();
		Professor prof = new Professor();
		Turma turma = new Turma();
		Disciplina materia = new Disciplina();
		//As matrículas dos alunos serão contabilizidas a partir do números 200, de duzentos para baixo é reservada para funcionários.
		int matriculaAlunos = 200;
		int matriculaProfessores;
		Scanner lendo = new Scanner(System.in);
		System.out.println("------------  ***********  Menu  ***********  ---------------");
		System.out.println("00 - SAIR");
		System.out.println("01 - LOGIN DO ALUNO");
		System.out.println("02 - LOGIN DO PROFESSOR");
		System.out.println("03 - LOGIN DO ADMINISTRADOR");
		int operacao = lendo.nextInt();
		switch(operacao) {
		case 1:
			
			System.out.println("DIGITE SEU LOGIN: ");
			String loginAluno = lendo.next();
			kid.setLogin(loginAluno);
			System.out.println("DIGITE SUA SENHA: ");
			String senhaAluno = lendo.next();
			kid.setSenha(senhaAluno);
			if(kid.logar(loginAluno, senhaAluno)) {
				System.out.println("----------------- ********* MENU ******** -----------------");
				System.out.println("00 - SAIR");
				System.out.println("01 - LISTAR DISCIPLINAS");
				System.out.println("02 - BOLETIM");
				System.out.println("03 - FREQUENCIA");
				
				int subOP = lendo.nextInt();
				
				if(subOP == 00) {
					break;
				}
				if(subOP == 01) {
					kid.listaMaterias(kid.getMatricula());
				}
				if(subOP == 02) {
					kid.ListaNotas(kid.getMatricula());
				}
				if(subOP == 03) {
					kid.listaFrequencia();
				}
			}
			
		case 2: 
			
			System.out.println("DIGITE SEU LOGIN: ");
			String loginProfessor = lendo.next();
			prof.setLogin(loginProfessor);
			System.out.println("DIGITE SUA SENHA: ");
			String senhaProfessor = lendo.next();
			prof.setSenha(senhaProfessor);
			prof.logar(loginProfessor, senhaProfessor);
		}
		
		
		
		

		
		
		
		
		
	/*	if(operacao == 01) {
			System.out.println("DIGITE O NOME DO ALUNO: ");
			String nome = lendo.next();
			kid.setNome(nome);
			
			System.out.println("DIGITE O CPF DO ALUNO: ");
			String cpf = lendo.next();	
			kid.setCpf(cpf);
			
			System.out.println("DIGITE O ENDEREÇO DO ALUNO:");
			String endereco = lendo.next();
			kid.setEndereco(endereco);
			
			System.out.println("ESCOLHA A TURMA A QUAL O ALUNO PERTENCERÁ: ");
			turma.listarTurmas();
			String codigoTurma = lendo.next();
			//Falta a inserção do aluno na turma aqui, pense!
			matriculaAlunos = matriculaAlunos+1;
			
			
			int codMaterias;
			boolean para = false;
			//EM INTERFACE ISSO SERÁ CHECK
			System.out.println("DIGITE O CÓDIGO DAS DISCIPLINAS QUE O ALUNO IRÁ CURSAR: ");
			codMaterias = lendo.nextInt();
			materia.inserirAluno(kid);
			
			while(para!= true) {
				
			}
			
			
			if(kid!=null) {
				System.out.println("------------------------------------------- Aluno matriculado!");
			}
		}
		
		if(operacao == 02) {
			System.out.println("DIGITE O NOME DO PROFESSOR: ");
			String nome = lendo.next();
			prof.setNome(nome);
			
			System.out.println("DIGITE O CPF DO PROFESSOR: ");
			String cpf = lendo.next();
			prof.setCpf(cpf);
			
			System.out.println("DIGITE O ENDEREÇO DO PROFESSOR: ");
			String endereco = lendo.next();
			prof.setEndereco(endereco);
			
			System.out.println("DIGITE O VALOR DE SALÁRIO DO NOVO PROFESSOR: ");
			double salario = lendo.nextDouble();
			prof.setSalario(salario);
			
			System.out.println("");
		}
	}*/
	}
}

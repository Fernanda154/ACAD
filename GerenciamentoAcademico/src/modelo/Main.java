package modelo;
import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;

import exceptionsAcad.CPFInvalidoException;


public class Main {

	public static void main(String[] args) {
		
		Aluno kid;
		Professor prof = new Professor();
		Turma turma = new Turma();
		Administrador adm = new Administrador();
		GerenciamentoAcademico gerenciamento = new GerenciamentoAcademico();
		//As matrï¿½culas dos alunos serï¿½o contabilizidas a partir do nï¿½meros 200, de duzentos para baixo ï¿½ reservada para funcionï¿½rios.
		int matriculaAlunos = 200;
		int matriculaProfessores = 0;
		String codigo = "turma";
		
		
		Scanner lendo = new Scanner(System.in);
		System.out.println("------------MENU ADMMINISTRATIVO------------");
		System.out.println("00 - SAIR");
		System.out.println("01 - INSERIR ALUNO NO SISTEMA");
		System.out.println("02 - INSERIR TURMA");
		System.out.println("03 - LISTAR TURMAS");
		System.out.println("04 - LISTAR ALUNOS");
		System.out.println("05 - INSERIR PROFESSOR NO SISTEMA");
		System.out.println("06 - LISTAR PROFESSORES");
		System.out.println("07 - REMOVER ALUNO");
		System.out.println("08 - REMOVER PROFESSOR");
		System.out.println("09 - INSERIR PROFESSOR NA TURMA");
		System.out.println("10 - BUSCAR PROFESSOR");
		System.out.println("11 - ATUALIZAR DADOS DO PROFESSOR");
		System.out.println("12 - ATUALIZAR DADOS DO ALUNO");
		System.out.println("13 - ATUALIZAR DADOS DA TURMA");
		System.out.println("14 - BUSCAR TURMAS DE ALUNO");
		int operacao = lendo.nextInt();
		while(operacao !=0) {
			if(operacao == 01) {
				System.out.println("------------------------------------Inserção de Aluno--------------------------------");
				kid = new Aluno();
				
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				
				System.out.println("DIGITE O NOME DO ALUNO: ");
				String nome = lendo.nextLine();
				kid.setNome(nome);
				
				System.out.println("DIGITE O CPF DO ALUNO: ");
				String cpf = lendo.nextLine();
				kid.setCpf(cpf);
				
				System.out.println("DIGITE O ENDEREÇO: ");
				String endereco = lendo.nextLine();
				kid.setEndereco(endereco);
				
				System.out.println("DIGITE SEU TELEFONE: ");
				String telefone = lendo.nextLine();
				kid.setTelefone(telefone);
				
				System.out.println("DIGITE UMA SENHA PARA USO CONTÍNUO: ");
				String senha = lendo.nextLine();
				kid.setSenha(senha);
				
				matriculaAlunos = matriculaAlunos+1;
				kid.setMatricula(matriculaAlunos);
				
				gerenciamento.inserirAlunoNoSistema(kid);
			}
			if(operacao == 02) {
				System.out.println("------------------------------------Inserção de Turma--------------------------------");
				turma = new Turma();
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				
				System.out.println("DIGITE O NOME DA DISCIPLINA: ");
				String descricao = lendo.nextLine();
				turma.setDescricao(descricao);
				
				System.out.println("DIGITE O TURNO: ");
				String turno = lendo.nextLine();
				turma.setTurno(turno);
				
				System.out.println("DIGITE O NÚMERO DA SALA: ");
				int sala = lendo.nextInt();
				turma.setSala(sala);
				
				int quant = 0;
				quant = quant + 1;
				String.valueOf(quant);
				
				codigo = codigo + quant;
				turma.setCodigo(codigo);
				
				gerenciamento.inserirTurma(turma);
				System.out.println(codigo); 
			}
			if(operacao == 03) {
				System.out.println("------------------------------------Listar Turmas--------------------------------");
				gerenciamento.listarTurmas();
			}
			if(operacao == 04) {
				System.out.println("------------------------------------Listar Alunos--------------------------------");
				gerenciamento.listarAlunos();
			}
			if(operacao == 05) {
				System.out.println("------------------------------Inserção de Professor no Sistema-------------------------");
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				System.out.println("Digite o nome do professor: ");
				String nome = lendo.nextLine();
				System.out.println("Digite o CPF: ");
				String cpf = lendo.nextLine();
				System.out.println("Digite o endereço: ");
				String endereco = lendo.nextLine();
				System.out.println("Digite seu telefone: ");
				String telefone = lendo.nextLine();
				System.out.println("Digite uma senha para uso contínuo: ");
				String senha = lendo.nextLine();
				
				matriculaProfessores = matriculaProfessores +1;
				prof = new Professor();
				prof.setNome(nome);
				prof.setCpf(cpf);
				prof.setEndereco(endereco);
				prof.setTelefone(telefone);
				prof.setSenha(senha);
				prof.setMatricula(matriculaProfessores);
				gerenciamento.inserirProfessorNoSistema(prof);
			}
			if(operacao == 06) {
				System.out.println("------------------------------------Listar Professores--------------------------------");
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				gerenciamento.listarProfessores();
				
			}
			if(operacao == 07) {
				System.out.println("------------------------------------Remoção de Aluno--------------------------------");
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				gerenciamento.listarTurmas();
				System.out.println("DIGITE O CÓDIGO DA TURMA: ");
				String codigoTurma = lendo.next();
				gerenciamento.listarAlunos();
				System.out.println("DIGITE A MATRÍCULA: ");
				int matricula = lendo.nextInt();
				gerenciamento.removerAluno(codigoTurma, matricula);
			}
			if(operacao == 8) {
				System.out.println("------------------------------------Remoção de Professor--------------------------------");
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				System.out.println("DIGITE O CÓDIGO DA TURMA: ");
				String codigoDaTurma = lendo.next();
				System.out.println("DIGITE A MATRÍCULA DO PROFESSOR: ");
				int matricula = lendo.nextInt();
				gerenciamento.removerProfessor(codigoDaTurma, matricula);
			}
			if(operacao == 9) {
				System.out.println("------------------------------Inserção de Professor em Turma----------------------------");
				gerenciamento.listarTurmas();
				System.out.println("DIGITE O CÓDIGO DA TURMA A QUAL O PROFESSOR IRÁ MINISTRAR AULA:");
				String codigoTurma = lendo.next();
				gerenciamento.listarProfessores();
				System.out.println("DIGITE A MATRÍCULA DO PROFESSOR: ");
				int matricula = lendo.nextInt();
				gerenciamento.inserirProfessorNaTurma(codigoTurma, matricula);
			}
			if(operacao == 10) {
				gerenciamento.listarTurmas();
				System.out.println("DIGITE O CÓDIGO DA TURMA: ");
				String codigoTurma = lendo.next();
				gerenciamento.buscarProfessor(codigoTurma);
			}
			if(operacao == 14) {
				gerenciamento.listarAlunos();
				System.out.println("DIGITE A MATRÍCULA DO ALUNO: ");
				int matricula = lendo.nextInt();
				gerenciamento.listarTurmasDoAluno(matricula);
				
			}
			System.out.println("------------MENU ADMMINISTRATIVO------------");
			System.out.println("00 - SAIR");
			System.out.println("01 - INSERIR ALUNO");
			System.out.println("02 - INSERIR TURMA");
			System.out.println("03 - LISTAR TURMAS");
			System.out.println("04 - LISTAR ALUNOS");
			System.out.println("05 - INSERIR PROFESSOR NO SISTEMA");
			System.out.println("06 - LISTAR PROFESSORES");
			System.out.println("07 - REMOVER ALUNO");
			System.out.println("08 - REMOVER PROFESSOR");
			System.out.println("09 - INSERIR PROFESSOR NA TURMA");
			System.out.println("10 - BUSCAR PROFESSOR");
			System.out.println("11 - ATUALIZAR DADOS DO PROFESSOR");
			System.out.println("12 - ATUALIZAR DADOS DO ALUNO");
			System.out.println("13 - ATUALIZAR DADOS DA TURMA");
			System.out.println("14 - BUSCAR TURMAS DE ALUNO");
			operacao = lendo.nextInt();
			
		}

		

	}
}

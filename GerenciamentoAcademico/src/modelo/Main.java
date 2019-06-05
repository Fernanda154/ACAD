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
		//As matr�culas dos alunos ser�o contabilizidas a partir do n�meros 200, de duzentos para baixo � reservada para funcion�rios.
		int matriculaAlunos = 200;
		int matriculaProfessores = 0;
		String codigo = "turma";
		
		
		Scanner lendo = new Scanner(System.in);
		System.out.println("------------MENU ADMMINISTRATIVO------------");
		System.out.println("00 - SAIR");
		System.out.println("01 - INSERIR ALUNO");
		System.out.println("02 - INSERIR TURMA");
		System.out.println("03 - LISTAR TURMAS");
		System.out.println("04 - LISTAR ALUNOS");
		System.out.println("05 - INSERIR PROFESSOR");
		System.out.println("06 - LISTAR PROFESSORES");
		System.out.println("07 - REMOVER ALUNO");
		System.out.println("08 - REMOVER PROFESSOR");
		System.out.println("09 - INSERIR PROFESSOR NA TURMA");
		System.out.println("10 - BUSCAR PROFESSOR");
		int operacao = lendo.nextInt();
		while(operacao !=0) {
			if(operacao == 01) {
				System.out.println("------------------------------------Inser��o de Aluno--------------------------------");
				kid = new Aluno();
				
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				
				System.out.println("Digite o nome do aluno: ");
				String nome = lendo.nextLine();
				kid.setNome(nome);
				
				System.out.println("Digite o CPF do aluno: ");
				String cpf = lendo.nextLine();
				kid.setCpf(cpf);
				
				System.out.println("Digite o endere�o: ");
				String endereco = lendo.nextLine();
				kid.setEndereco(endereco);
				
				System.out.println("Digite seu telefone: ");
				String telefone = lendo.nextLine();
				kid.setTelefone(telefone);
				
				System.out.println("Digite uma senha para uso cont�nuo: ");
				String senha = lendo.nextLine();
				kid.setSenha(senha);
				
				matriculaAlunos = matriculaAlunos+1;
				kid.setMatricula(matriculaAlunos);
				
				System.out.println("Digite o c�digo da turma a qual o aluno pertencer�: ");
				String codigoTurma = lendo.next(); 

				gerenciamento.inserirAlunoNoSistema(kid);
			}
			if(operacao == 02) {
				turma = new Turma();
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				
				System.out.println("Digite o nome da displina: ");
				String descricao = lendo.nextLine();
				turma.setDescricao(descricao);
				
				System.out.println("Digite o turno: ");
				String turno = lendo.nextLine();
				turma.setTurno(turno);
				
				System.out.println("Digite o n�mero da sala: ");
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
				gerenciamento.listarTurmas();
			}
			if(operacao == 04) {
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				System.out.println("Digite o c�digo da turma: ");
				String codigoTurma = lendo.next();
				gerenciamento.listarAlunos();
			}
			if(operacao == 05) {

				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				System.out.println("Digite o nome do professor: ");
				String nome = lendo.nextLine();
				System.out.println("Digite o CPF: ");
				String cpf = lendo.nextLine();
				System.out.println("Digite o endere�o: ");
				String endereco = lendo.nextLine();
				System.out.println("Digite seu telefone: ");
				String telefone = lendo.nextLine();
				System.out.println("Digite uma senha para uso cont�nuo: ");
				String senha = lendo.nextLine();
				System.out.println("Digite o sal�rio do novo professor: ");
				double salario = lendo.nextDouble();
				
				matriculaProfessores = matriculaProfessores +1;
				prof = new Professor();
				prof.setNome(nome);
				prof.setCpf(cpf);
				prof.setEndereco(endereco);
				prof.setTelefone(telefone);
				prof.setSenha(senha);
				prof.setSalario(salario);
				prof.setMatricula(matriculaProfessores);
				gerenciamento.inserirProfessorNoSistema(prof);
			}
			if(operacao == 06) {
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.

				gerenciamento.listarProfessores();
				
			}
			if(operacao == 07) {
				turma.listarAlunos();
				System.out.println("Digite a matricula do aluno a ser removido: ");
				int matricula = lendo.nextInt();
				turma.removerAluno(matricula);
			}
			if(operacao == 8) {
				lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
				System.out.println("Digite o c�digo da turma: ");
				String codigoDaTurma = lendo.next();
				gerenciamento.removerProfessor(codigoDaTurma);
			}
			if(operacao == 9) {
				gerenciamento.listarTurmas();
				
				System.out.println("Digite o c�digo da turma a qual o professor ir� ministrar aula:");
				String codigoTurma = lendo.next();
				System.out.println("Digite a matr�cula do professor: ");
				int matricula = lendo.nextInt();
				gerenciamento.inserirProfessorNaTurma(codigoTurma, matricula);
			}
			if(operacao == 10) {
				gerenciamento.listarTurmas();
				System.out.println("Digite o c�digo da turma:");
				String codigoTurma = lendo.next();
				gerenciamento.buscarProfessor(codigoTurma);
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
			operacao = lendo.nextInt();
			
		}

		

	}
}

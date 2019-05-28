package modelo;
import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;

import exceptionsAcad.CPFInvalidoException;


public class Main {

	public static void main(String[] args) {
		
		Aluno kid = new Aluno();
		Professor prof = new Professor();
		Turma turma = new Turma();
		Administrador adm = new Administrador();
		
		//As matr�culas dos alunos ser�o contabilizidas a partir do n�meros 200, de duzentos para baixo � reservada para funcion�rios.
		int matriculaAlunos = 200;
		int matriculaProfessores;
		String codigo = "turma";
		Scanner lendo = new Scanner(System.in);
		System.out.println("------------MENU ADMMINISTRATIVO------------");
		System.out.println("00 - SAIR");
		System.out.println("01 - INSERIR ALUNO");
		System.out.println("02 - INSERIR TURMA");
		System.out.println("03 - LISTAR TURMAS");
		System.out.println("04 - LISTAR ALUNOS");
		int operacao = lendo.nextInt();
		while(operacao !=0) {
			if(operacao == 01) {
				System.out.println("----------------------------------------------Inser��o de Aluno--------------------------------");
				System.out.println("Digite o nome do aluno: ");
				String nome = lendo.next();
				kid.setNome(nome);
				
				System.out.println("Digite o CPF do aluno: ");
				String cpf = lendo.next();	
				kid.setCpf(cpf);
				
				System.out.println("Digite o endere�o: ");
				String endereco = lendo.next();
				kid.setEndereco(endereco);
				
				System.out.println("Digite seu telefone: ");
				String telefone = lendo.next();
				kid.setTelefone(telefone);
				
				System.out.println("Digite uma senha para uso cont�nuo: ");
				String senha = lendo.next();
				kid.setSenha(senha);
				
				matriculaAlunos = matriculaAlunos+1;
				kid.setMatricula(matriculaAlunos);
				
				
				System.out.println("Digite o c�digo da turma a qual o aluno pertencer�: ");
				String codigoTurma = lendo.next();

				adm.inserirAluno(codigoTurma, kid);
				
			}
			if(operacao == 02) {
				System.out.println("Digite o nome da displina: ");
				String descricao = lendo.next();
				turma.setDescricao(descricao);
				
				System.out.println("Digite o turno: ");
				String turno = lendo.next();
				turma.setTurno(turno);
				
				System.out.println("Digite o n�mero da sala: ");
				int sala = lendo.nextInt();
				turma.setSala(sala);
				
				int quant = 0;
				quant = quant + 1;
				String.valueOf(quant);
				codigo = codigo + quant;
				turma.setCodigo(codigo);
				
				adm.inserirTurma(turma);
				System.out.println(codigo);
			}
			if(operacao == 03) {
				System.out.println("Digite o c�digo da turma: ");
				String codigoTurma = lendo.next();
				adm.listarAlunos(codigoTurma);
			}
			
			System.out.println("------------MENU ADMMINISTRATIVO------------");
			System.out.println("00 - SAIR");
			System.out.println("01 - INSERIR ALUNO");
			System.out.println("02 - INSERIR TURMA");
			System.out.println("03 - LISTAR TURMAS");
			System.out.println("04 - LISTAR ALUNOS");
			operacao = lendo.nextInt();
			
		}

		

	}
}

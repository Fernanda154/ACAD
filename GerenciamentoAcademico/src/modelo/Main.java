package modelo;
import java.sql.Connection;
import java.util.ArrayList;
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
		int matriculaProfessores = 3;
		String codigo = "turma";
		Scanner lendo = new Scanner(System.in);
		
		//Pre- inserindo adms
		int matriculaAdm = 0;
		while(matriculaAdm != 3) {
			adm = new Administrador();
			String nome = "ADMINISTRADOR1";
			adm.setNome(nome);
			String senha = "gerenciamentoAcademico154";
			adm.setSenha(senha);
			adm.setMatricula(matriculaAdm);
			matriculaAdm = matriculaAdm+1;
			gerenciamento.inserirAdm(adm);
		}
		
		int geralzao = 1;
		while(geralzao != 0) {
			//Login
			System.out.println("******************** SISTEMA DE GERENCIAMENTO ACADÊMICO ********************");
			System.out.println("MATRÍCULA: ");
			int matriculaLogin = lendo.nextInt();
			System.out.println("SENHA: ");
			lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
			String senhaLogin = lendo.next();
			
			if(gerenciamento.logar(matriculaLogin, senhaLogin) == 2){
				System.out.println("00 - SAIR");
				System.out.println("01 - CONSULTAR FREQUÊNCIA");
				System.out.println("02 - CONSULTAR NOTAS");
				System.out.println("03 - ATUALIZAR DADOS PESSOAIS");
				System.out.println("04 - LISTAR TURMAS");
				int operacao = lendo.nextInt();
				while(operacao !=0) {
					if(operacao == 01) {
						System.out.println("------------------------------------|| CONSULTAR FREQUÊNCIA");
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoDaTurma = lendo.next();
						gerenciamento.exibirFrequencia(codigoDaTurma, matriculaLogin);
					}
					if(operacao == 02) {
						System.out.println("------------------------------------|| CONSULTAR NOTAS");
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoDaTurma = lendo.next();
						gerenciamento.buscarNota(codigoDaTurma, matriculaLogin);
					}
					if(operacao == 03) {
						System.out.println("------------------------------------|| ATUALIZAR DADOS PESSOAIS");
						kid = new Aluno();
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O ENDEREÇO: ");
						String endereco = lendo.nextLine();
						System.out.println("DIGITE SEU TELEFONE: ");
						String telefone = lendo.nextLine();
						System.out.println("DIGITE UMA SENHA PARA USO CONTÍNUO: ");
						String senha = lendo.nextLine();
							kid.setEndereco(endereco);
							kid.setTelefone(telefone);
							kid.setSenha(senha);
						gerenciamento.atualizarAluno(kid);
					}
					if(operacao == 04) {
						System.out.println("------------------------------------|| TURMAS CURSANDO");
						gerenciamento.listarTurmasDoAluno(matriculaLogin);
					}
					System.out.println("00 - SAIR");
					System.out.println("01 - CONSULTAR FREQUÊNCIA");
					System.out.println("02 - CONSULTAR NOTAS");
					System.out.println("03 - ATUALIZAR DADOS PESSOAIS");
					System.out.println("04 - LISTAR TURMAS");
					operacao = lendo.nextInt();
				}
				
			}
			if(gerenciamento.logar(matriculaLogin, senhaLogin) == 1){
				System.out.println("00 - SAIR");
				System.out.println("01 - INSERIR FREQUÊNCIA");
				System.out.println("02 - INSERIR NOTA");
				System.out.println("03 - ATUALIZAR NOTAS");
				System.out.println("04 - ATUALIZAR FREQUÊNCIA");
				System.out.println("05 - ATUALIZAR DADOS PESSOAIS");
				System.out.println("06 - BUSCAR ALUNO");
				System.out.println("07 - LISTAR ALUNOS POR TURMA");
				int operacao = lendo.nextInt();
				while(operacao !=0) {
					if(operacao == 01) {
						System.out.println("------------------------------------|| INSERIR FREQUÊNCIA");
						gerenciamento.buscarTurmasDeProfessor(matriculaLogin);
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						gerenciamento.listarAlunosDaTurma(codigoTurma);
						System.out.println("DIGITE A MATRÍCULA DO ALUNO: ");
						int matricula = lendo.nextInt();
						System.out.println("DIGITE 1 PARA MARCAR COMO PRESENTE E 0 PARA AUSENTE:  ");
						int presenca = lendo.nextInt();
						if(presenca == 1) {
							gerenciamento.inserirFrequencia(codigoTurma, matricula, true);
						}
						if(presenca == 0) {
							gerenciamento.inserirFrequencia(codigoTurma, matricula, false);
						}
					}
					if(operacao == 02) {
						System.out.println("------------------------------------|| INSERIR NOTA");
						gerenciamento.buscarTurmasDeProfessor(matriculaLogin);
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						System.out.println("DIGITE A MATRÍCULA DO ALUNO: ");
						int matricula = lendo.nextInt();
						System.out.println("DIGITE A NOTA: ");
						String nota = lendo.next();
						gerenciamento.inserirNota(codigoTurma, matricula, nota);
					}
					if(operacao == 03) {
						System.out.println("------------------------------------|| INSERIR NOTA");
						gerenciamento.buscarTurmasDeProfessor(matriculaLogin);
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						System.out.println("DIGITE A MATRÍCULA DO ALUNO: ");
						int matricula = lendo.nextInt();
						System.out.println("DIGITE A NOTA ANTIGA: ");
						String nota = lendo.next();
						System.out.println("DIGITE A NOVA NOTA: ");
						String notaNova = lendo.next();
						gerenciamento.atualizarNota(codigoTurma, matricula, notaNova, nota);
						gerenciamento.buscarNota(codigoTurma, matricula);
					}
					if(operacao == 04) {
						System.out.println("FUNÇÃO NÃO IMPLEMENTADA.");
					}
					if(operacao == 05) {
						System.out.println("------------------------------------|| ATUALIZAR DADOS PESSOAIS");
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O ENDEREÇO: ");
						String endereco = lendo.nextLine();
						System.out.println("DIGITE O TELEFONE: ");
						String telefone = lendo.nextLine();
						System.out.println("DIGITE UMA SENHA PARA USO CONTÍNUO: ");
						String senha = lendo.nextLine();
						prof = new Professor();
						prof.setEndereco(endereco);
						prof.setTelefone(telefone);
						prof.setSenha(senha);
						gerenciamento.atualizarProfessor(prof);
					}
					if(operacao == 06) {
						System.out.println("------------------------------------|| BUSCAR ALUNO");
						gerenciamento.buscarTurmasDeProfessor(matriculaLogin);
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoDaTurma = lendo.next();
						System.out.println("DIGITE O NOME DO ALUNO: ");
						String nome = lendo.next();
						gerenciamento.buscarAluno(codigoDaTurma, nome);
					}
					if(operacao == 07) {
						System.out.println("------------------------------------|| LISTAR ALUNOS POR TURMA");
						gerenciamento.buscarTurmasDeProfessor(matriculaLogin);
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoDaTurma = lendo.next();
						gerenciamento.listarAlunosDaTurma(codigoDaTurma);
					}
					System.out.println("00 - SAIR");
					System.out.println("01 - INSERIR FREQUÊNCIA");
					System.out.println("02 - INSERIR NOTA");
					System.out.println("03 - ATUALIZAR NOTAS");
					System.out.println("04 - ATUALIZAR FREQUÊNCIA");
					System.out.println("05 - ATUALIZAR DADOS PESSOAIS");
					System.out.println("06 - BUSCAR ALUNO");
					System.out.println("07 - LISTAR ALUNOS POR TURMA");
					operacao = lendo.nextInt();
			}
			}
			if(gerenciamento.logar(matriculaLogin, senhaLogin) == 2){
				System.out.println("00 - SAIR");
				System.out.println("01 - INSERIR ALUNO");
				System.out.println("02 - INSERIR PROFESSOR");
				System.out.println("03 - INSERIR TURMA");
				System.out.println("04 - INSERIR NOVO ADMINISTRADOR");
				System.out.println("05 - REMOVER ALUNO");
				System.out.println("06 - REMOVER PROFESSOR");
				System.out.println();
			}

			if(gerenciamento.logar(matriculaLogin, senhaLogin) == 3){
				System.out.println("00 - SAIR");
				System.out.println("------------------------------------|| AÇÕES DE TURMA");
				System.out.println("01 - INSERIR TURMA");
				System.out.println("02 - ATUALIZAR DADOS DA TURMA");
				System.out.println("03 - EXCLUIR UMA TURMA");
				System.out.println("------------------------------------|| AÇÕES DE ALUNO");
				System.out.println("04 - INSERIR ALUNO NO SISTEMA");
				System.out.println("05 - INSERIR ALUNO NA TURMA");
				System.out.println("06 - REMOVER ALUNO DA TURMA");
				System.out.println("------------------------------------|| AÇÕES DE PROFESSOR");
				System.out.println("07 - INSERIR PROFESSOR NO SISTEMA");
				System.out.println("08 - INSERIR PROFESSOR NA TURMA");
				System.out.println("09 - REMOVER PROFESSOR DA TURMA");
				int operacao = lendo.nextInt();
				while(operacao!= 0){
					if (operacao == 1) {
						System.out.println("------------------------------------|| INSERÇÃO DE TURMA");
						turma = new Turma();
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O NOME DA DISCIPLINA: ");
						String descricao = lendo.nextLine();
						
						
						System.out.println("DIGITE O TURNO: ");
						String turno = lendo.nextLine();
						
						
						System.out.println("DIGITE O NÚMERO DA SALA: ");
						int sala = lendo.nextInt();
						turma.setSala(sala);
						
						int quant = 0;
						quant = quant + 1;

						codigo = codigo + quant; 
						turma.setDescricao(descricao);
						turma.setTurno(turno);
						turma.setCodigo(codigo);

						gerenciamento.inserirTurma(turma);
						System.out.println("CÓDIGO GERADO: " + codigo); 
					}
					if(operacao == 2) {
						System.out.println("------------------------------------|| ATUALIZAÇÃO DE DADOS DA TURMA");
						gerenciamento.listarTurmas();
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						System.out.println("DIGITE A NOVA SALA RESERVADA PARA ESTA TURMA: ");
						int sala = lendo.nextInt();
						gerenciamento.atualizarTurma(codigo, sala);
					}
					if(operacao == 3) {
						System.out.println("------------------------------------|| EXCLUIR TURMA");
						gerenciamento.listarTurmas();
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						gerenciamento.removerTurma(codigoTurma);
					}
					if (operacao == 4){
						kid = new Aluno();
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O NOME DO ALUNO: ");
						String nome = lendo.nextLine();
						System.out.println("DIGITE O CPF DO ALUNO: ");
						String cpf = lendo.nextLine();
						System.out.println("DIGITE O ENDEREÇO: ");
						String endereco = lendo.nextLine();
						System.out.println("DIGITE SEU TELEFONE: ");
						String telefone = lendo.nextLine();
						System.out.println("DIGITE UMA SENHA PARA USO CONTÍNUO: ");
						String senha = lendo.nextLine();
						matriculaAlunos = matriculaAlunos+1;
							kid.setMatricula(matriculaAlunos);
							kid.setNome(nome);
							kid.setCpf(cpf);
							kid.setEndereco(endereco);
							kid.setTelefone(telefone);
							kid.setSenha(senha);
						gerenciamento.inserirAlunoNoSistema(kid);
					}
					if (operacao == 5){
						System.out.println("------------------------------------|| INSERIR ALUNO EM TURMA");
						gerenciamento.listarAlunos();
						System.out.println("DIGITE A MATRÍCULA DO ALUNO: ");
						int matricula = lendo.nextInt();
						gerenciamento.listarTurmas();
						System.out.println("DIGITE O CÓDIGO DA TURMA A QUAL O ALUNO PERTENCERÁ: ");
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						String codigoTurma = lendo.next();
						gerenciamento.inserirAlunoNaTurma(codigoTurma, matricula);
					}
					if(operacao == 6) {
						System.out.println("------------------------------------|| REMOVER ALUNO DE TURMA");
						System.out.println("DIGITE A MATRÍCULA DO ALUNO");
						int matricula = lendo.nextInt();
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						
						//Chame a função aqui
					}
					if(operacao == 7) {
						System.out.println("------------------------------------|| INSERIR PROFESSOR NO SISTEMA");
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						System.out.println("DIGITE O NOME DO PROFESSOR: ");
						String nome = lendo.nextLine();
						System.out.println("DIGITE O CPF: ");
						String cpf = lendo.nextLine();
						System.out.println("DIGITE O ENDEREÇO: ");
						String endereco = lendo.nextLine();
						System.out.println("DIGITE O TELEFONE: ");
						String telefone = lendo.nextLine();
						System.out.println("DIGITE UMA SENHA PARA USO CONTÍNUO: ");
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
					if(operacao == 8) {
						System.out.println("------------------------------------|| INSERIR PROFESSOR EM TURMA");
						gerenciamento.listarTurmas();
						System.out.println("DIGITE O CÓDIGO DA TURMA A QUAL O PROFESSOR IRÁ MINISTRAR AULA:");
						String codigoTurma = lendo.next();
						gerenciamento.listarProfessores();
						System.out.println("DIGITE A MATRÍCULA DO PROFESSOR: ");
						int matricula = lendo.nextInt();
						gerenciamento.inserirProfessorNaTurma(codigoTurma, matricula);
					}
					if(operacao == 9) {
						System.out.println("------------------------------------|| REMOVER PROFESSOR DE TURMA");
						gerenciamento.listarTurmas();
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoDaTurma = lendo.next();
						gerenciamento.listarProfessores();
						System.out.println("DIGITE A MATRÍCULA DO PROFESSOR: ");
						int matricula = lendo.nextInt();
						gerenciamento.removerProfessor(codigoDaTurma, matricula);
					}
					if(operacao == 10) {
						System.out.println("------------------------------------|| BUSCAR PROFESSOR DE TURMA");
						gerenciamento.listarTurmas();
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						Professor profAux = gerenciamento.buscarProfessor(codigoTurma);
						System.out.println("NOME: "+ profAux.getNome() +" MATRÍCULA: "+ profAux.getMatricula());
					}
					if(operacao == 11) {
						System.out.println("------------------------------------|| BUSCAR ALUNO NA TURMA");
						gerenciamento.listarTurmas();
						System.out.println("DIGITE O CÓDIGO DA TURMA: ");
						String codigoTurma = lendo.next();
						gerenciamento.listarAlunos();
						System.out.println("DIGITE O NOME DO ALUNO: ");
						lendo.nextLine(); // esvazia o buffer do teclado, para poder ler strings agora.
						String nome = lendo.next();
						Aluno alunoEncontrado =  gerenciamento.buscarAluno(codigoTurma, nome);
						System.out.println(alunoEncontrado.getNome() + " MATRÍCULA: " + alunoEncontrado.getMatricula());
					}
					if(operacao == 12) {
						System.out.println("------------------------------------|| BUSCAR TURMAS DE ALUNO");
						gerenciamento.listarAlunos();
						System.out.println("DIGITE A MATRÍCULA DO ALUNO: ");
						int matricula = lendo.nextInt();
						gerenciamento.listarTurmasDoAluno(matricula);
					}
					if(operacao == 13) {
						System.out.println("------------------------------------|| BUSCAR TURMAS DE PROFESSOR");
						gerenciamento.listarProfessores();
						System.out.println("DIGITE A MATRÍCULA DO PROFESSOR: ");
						int matricula = lendo.nextInt();
						gerenciamento.buscarTurmasDeProfessor(matricula);
					}
					if(operacao == 14) {
						System.out.println("------------------------------------|| LISTAR PROFESSORES DO SISTEMA");
						gerenciamento.listarProfessores();
					}
					if(operacao == 15) {
						System.out.println("------------------------------------|| LISTAR ALUNOS DO SISTEMA");
						gerenciamento.listarAlunos();
					}
					

					System.out.println("00 - SAIR");
					System.out.println("------------------------------------|| AÇÕES DE TURMA");
					System.out.println("01 - INSERIR TURMA");
					System.out.println("02 - ATUALIZAR DADOS DA TURMA");
					System.out.println("03 - EXCLUIR UMA TURMA");
					System.out.println("------------------------------------|| AÇÕES DE ALUNO");
					System.out.println("04 - INSERIR ALUNO NO SISTEMA");
					System.out.println("05 - INSERIR ALUNO NA TURMA");
					System.out.println("06 - REMOVER ALUNO DA TURMA");
					System.out.println("------------------------------------|| AÇÕES DE PROFESSOR");
					System.out.println("07 - INSERIR PROFESSOR NO SISTEMA");
					System.out.println("08 - INSERIR PROFESSOR NA TURMA");
					System.out.println("09 - REMOVER PROFESSOR DA TURMA");
					System.out.println("------------------------------------|| AÇÕES DE BUSCA");
					System.out.println("10 - BUSCAR PROFESSOR DE TURMA");
					System.out.println("11 - BUSCAR ALUNO NA TURMA");
					System.out.println("12 - BUSCAR TURMAS DE ALUNO");
					System.out.println("13 - BUSCAR TURMAS DE PROFESSOR");
					System.out.println("14 - LISTAR PROFESSORES DO SISTEMA");
					System.out.println("15 - LISTAR ALUNOS DO SISTEMA");
					operacao = lendo.nextInt();
				}
			}
		}


	}
}

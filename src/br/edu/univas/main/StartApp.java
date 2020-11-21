package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.opcoes.Classificacao;
import br.edu.univas.opcoes.OpcaoJogo;
import br.edu.univas.opcoes.OpcaoTime;
import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Times;

public class StartApp {

	public static void main(String[] args) {
		Times[] times = new Times[50];
		Jogo[] jogos = new Jogo[50];
		boolean sair = false;

		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Menu: 1 a 9");
			System.out.println("1 – Cadastrar Time");
			System.out.println("2 – Editar Time");
			System.out.println("3 – Excluir Time");
			System.out.println("4 – Cadastrar Jogo");
			System.out.println("5 – Editar Jogo");
			System.out.println("6 – Excluir Jogo");
			System.out.println("7 – Listar Classificação do Campeonato");
			System.out.println("9 - Sair");
			int escolha = input.nextInt();
			
			switch (escolha) {
			case 1:
				new OpcaoTime("cadastrar", times);
				break;
			case 2:
				new OpcaoTime("editar", times);
				break;
			case 3:
				new OpcaoTime("excluir", times);
				break;
			case 4:
				new OpcaoJogo("cadastrar", jogos, times);
				break;
			case 5:
				new OpcaoJogo("editar", jogos, times);
				break;
			case 6:
				new OpcaoJogo("excluir", jogos, times);
				break;
			case 7:
				new Classificacao(jogos, times);
				break;
			case 9:
				input.close();
				sair = true;
				break;
			default:
				break;
			}
		} while (!sair);
	}
}

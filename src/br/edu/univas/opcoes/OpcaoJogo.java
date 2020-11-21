package br.edu.univas.opcoes;

import java.util.Scanner;
import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Times;

public class OpcaoJogo {

	Jogo jogo;
	Scanner entrada = new Scanner(System.in);
	Times[] time;

	public OpcaoJogo(String escolha, Jogo[] jogos, Times[] times) {
		time = times;
		switch (escolha) {
		case "cadastrar":
			this.CadJogo(jogos);
			break;
		case "editar":
			this.EditJogo(jogos);
			break;
		case "excluir":
			this.ExcluirJogo(jogos);
			break;
		default:
			break;
		}
	}

	private void CadJogo(Jogo[] jogos) {
		boolean sair = false;
		int valor = 0;
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				valor++;
			}
		}
		do {
			Jogo jogo = new Jogo();
			System.out.println("Informe o time mandante:");
			for (int i = 0; i < time.length; i++) {
				if (time[i] != null) {
					System.out.println(i + ". " + time[i].nome.toString());
				}
			}
			System.out.print(">");
			int timeMandante = entrada.nextInt();
			jogo.timeMandante = time[timeMandante].nome;

			System.out.print("Gols do time mandante:");
			jogo.golsTimeMandante = entrada.nextInt();

			System.out.println("Informe o time visitante:");
			for (int i = 0; i < time.length; i++) {
				if (time[i] != null && time[i].nome != time[timeMandante].nome) {
					System.out.println(i + ". " + time[i].nome.toString());
				}
			}
			System.out.print(">");
			int timeVisitante = entrada.nextInt();
			jogo.timeVisitante = time[timeVisitante].nome;

			System.out.print("|Gols do time visitante:");
			jogo.golsTimeVisitante = entrada.nextInt();

			jogos[valor] = jogo;

			System.out.println(" +-+-+-+-+-+ +-+-+-+-+-+-+-+ +-+-+\r\n" + " " + jogo.timeMandante + " "
					+ jogo.golsTimeMandante + " X " + jogo.golsTimeVisitante + " " + jogo.timeVisitante + "\r\n"
					+ " +-+-+-+-+-+ +-+-+-+-+-+-+-+ +-+-+");

			System.out.println("1. Cadastrar outro jogo ?");
			System.out.println("2. Voltar");

			System.out.print(">");
			int option = entrada.nextInt();

			if (option == 1) {
				valor++;
				System.out.flush();
				continue;
			} else {
				sair = true;
				System.out.flush();
			}

		} while (!sair);
	}

	private void EditJogo(Jogo[] jogos) {
		boolean sair = false;
		do {
			System.out.println("Qual jogo deseja editar?");
			int escolha = 0;

			System.out.println("99. Sair");
			for (int i = 0; i < jogos.length; i++) {
				if (jogos[i] != null) {
					System.out.println(i + ". " + jogos[i].timeMandante.toString() + ": " + jogos[i].golsTimeMandante
							+ " X " + jogos[i].timeVisitante.toString() + ": " + jogos[i].golsTimeVisitante);
				}
			}

			System.out.print(">");
			escolha = entrada.nextInt();

			if (escolha == 99) {
				sair = true;
				break;
			} else {
				System.out.println("Editar o time mandante:");
				jogos[escolha].timeMandante = entrada.next();
				System.out.println("Editar o time visitante");
				jogos[escolha].timeVisitante = entrada.next();

				System.out.println("1. Editar outro time ?");
				System.out.println("2. Voltar");

				System.out.print(">");
				int option = entrada.nextInt();

				if (option == 1) {
					System.out.flush();
					continue;
				} else {
					sair = true;
					System.out.flush();
				}
			}

		} while (!sair);
	}

	private void ExcluirJogo(Jogo[] jogos) {
		System.out.println("Qual time deseja excluir ?");
		int escolha = 0;
		System.out.println("99. Sair");
		for (int i = 0; i < time.length; i++) {
			if (time[i] != null) {
				System.out.println(i + ". " + time[i].nome.toString());
			}
		}

		System.out.print(">");
		escolha = entrada.nextInt();

		if (escolha == 99) {
			System.out.flush();
			return;
		} else {
			time[escolha] = null;
			System.out.flush();
		}
	}
}

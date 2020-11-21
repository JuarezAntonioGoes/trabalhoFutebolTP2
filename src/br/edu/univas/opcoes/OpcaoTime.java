package br.edu.univas.opcoes;


import java.util.Scanner;

import br.edu.univas.vo.Times;

public class OpcaoTime {

	Times time;
	Scanner entrada = new Scanner(System.in).useDelimiter("\n");;

	public OpcaoTime(String escolha, Times[] times) {
		switch (escolha) {
		case "cadastrar":
			this.CadTime(times);
			break;
		case "editar":
			this.EditTime(times);
			break;
		case "excluir":
			this.ExcluirTime(times);
			break;
		default:
			break;
		}
	}

	public void CadTime(Times[] times) {
		boolean sair = false;
		int valor = 0;
		for (int i = 0; i < times.length; i++) {
			if (times[i] != null) {
				valor++;
			}
		}
		do {
			Times time = new Times();
			System.out.print("Informe o nome do time:");
			time.nome = entrada.nextLine();

			System.out.print("Informe o estado de origem do time:");
			time.estadoOrigem = entrada.nextLine();

			System.out.println();

			times[valor] = time;

			System.out.println("1. Cadastrar outro time ?");
			System.out.println("2. Voltar");

			System.out.print(">");
			int option = Integer.parseInt(entrada.nextLine());

			if (option == 1) {
				valor++;
				continue;
			} else {
				sair = true;
			}
		} while (!sair);
	}

	public void EditTime(Times[] times) {
		boolean sair = false;
		do {
			System.out.println("Qual time deseja editar?");
			int escolha = 0;

			System.out.println("99. Sair");
			for (int i = 0; i < times.length; i++) {
				if (times[i] != null) {
					System.out.println(i + ". " + times[i].nome.toString());
				}
			}

			System.out.print(">");
			escolha = entrada.nextInt();

			if (escolha == 99) {
				sair = true;
				break;
			} else {
				System.out.println("Editar o nome:");
				times[escolha].nome = entrada.next();
				System.out.println("Editar o estado de origem");
				times[escolha].estadoOrigem = entrada.next();

				System.out.println("1. Editar outro time ?");
				System.out.println("2. Voltar");

				System.out.print(">");
				int opcao = entrada.nextInt();

				if (opcao == 1) {
					continue;
				} else {
					sair = true;
				}
			}

		} while (!sair);
	}
	
	public void ExcluirTime(Times[] times) {
		System.out.println("Qual time deseja excluir ?");
		int escolha = 0;
		System.out.println("99. Sair");
		for (int i = 0; i < times.length; i++) {
			if (times[i] != null) {
				System.out.println(i + ". " + times[i].nome.toString());
			}
		}

		System.out.print(">");
		escolha = entrada.nextInt();

		if (escolha == 99) {
			return;
		} else {
			times[escolha] = null;
		}
	}

}

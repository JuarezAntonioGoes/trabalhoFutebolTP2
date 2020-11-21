package br.edu.univas.opcoes;

import br.edu.univas.vo.Jogo;
import br.edu.univas.vo.Times;

public class Classificacao {

	public Classificacao(Jogo[] jogos, Times[] times) {

		String align = "| %-15s | %-4d   | %-4d |%n";

		System.out.format("| Time            | Pontos | SG   |%n");

		for (int i = 0; i < times.length; i++) {
			if (times[i] != null) {
				System.out.format(align, times[i].nome.toString().toUpperCase(), Pontos(times[i].nome, jogos),
						SaldoDeGols(times[i].nome, jogos));
			}
		}

	}

	public int Pontos(String nome, Jogo[] jogos) {
		int ptsTotal = 0;
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				if (nome == jogos[i].timeMandante) {
					if (jogos[i].golsTimeMandante > jogos[i].golsTimeVisitante) {
						ptsTotal += 3;
					} else if (jogos[i].golsTimeMandante == jogos[i].golsTimeVisitante) {
						ptsTotal += 1;
					}
				} else if (nome == jogos[i].timeVisitante) {
					if (jogos[i].golsTimeVisitante > jogos[i].golsTimeMandante) {
						ptsTotal += 3;
					} else if (jogos[i].golsTimeVisitante == jogos[i].golsTimeMandante) {
						ptsTotal += 1;
					}
				}
			}
		}

		return ptsTotal;
	}

	public int SaldoDeGols(String nome, Jogo[] jogos) {
		int totalSaldo = 0;
		int gProprios = 0;
		int gSofridos = 0;
		for (int i = 0; i < jogos.length; i++) {
			if (jogos[i] != null) {
				if (nome == jogos[i].timeMandante) {
					
				}
			}
		}
		
		totalSaldo = gProprios - gSofridos;
		return totalSaldo;
	}
}

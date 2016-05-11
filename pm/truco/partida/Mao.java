package pm.truco.partida;

import java.util.*;
import pm.truco.jogador.*;

public class Mao {
	private int tento = 2;
	private List<Rodada> rodadas = new ArrayList<Rodada>();
	private List<Jogador> vencedores;

	Mao() {
		for (int i = 0; i < 3; i++) {
			this.rodadas.add(new Rodada());
		}
	}

	public Rodada acessarRodada(int n) {
		return this.rodadas.get(n);
	}

	// Define se o pedido de truco feito por um membro da equipe "equipe"
	// na rodada R é aceito pelos adversários.
	private boolean definirAceite(Rodada r, int equipe, Jogador[][] jogadorPorEquipe) {
		int outraEquipe;
		if (equipe == 1) {
			outraEquipe = 2;
		} else {
			outraEquipe = 1;
		}

		for (Jogador j: jogadorPorEquipe[outraEquipe-1]) {
			if (j.definirSeAceitaTruco()) {
				r.aceitarRequisicaoDeTruco(j);
			} else {
				r.negarRequisicaoDeTruco(j);
			}
		}

		return r.definirAceite();
	}

	private void executarInteracaoDeJogador(Jogador j, Rodada r, int equipe, Jogador[][] jogadorPorEquipe) {
		if (j.definirSePedeTruco()) {
			r.receberRequisicaoDeTruco(j);
			if (this.definirAceite(r, equipe, jogadorPorEquipe)) {
				System.out.println("Truco foi aceito!");
				this.incrementarTento();
			}
		}
		r.adicionarCartaNaMesa(j, j.escolherCarta());
	}

	private void jogarRodada(Rodada r, Jogador[][] jogadorPorEquipe) {
		int nJogadores = jogadorPorEquipe[0].length;

		for (int i = 0; i < nJogadores; i++) {
			Jogador j1 = jogadorPorEquipe[0][i];
			this.executarInteracaoDeJogador(j1, r, 1, jogadorPorEquipe);

			Jogador j2 = jogadorPorEquipe[1][i];
			this.executarInteracaoDeJogador(j2, r, 2, jogadorPorEquipe);
		}
	}

	public int jogar(Jogador[][] jogadorPorEquipe) {
		this.vencedores = new ArrayList<Jogador>();
		int i = 1;
		for(Rodada r: this.rodadas) {
			System.out.println();
			System.out.println("+--------------------------------------+");
			System.out.println("|-------------- RODADA " + i++ + " --------------|");
			System.out.println("+--------------------------------------|");
			System.out.println("|           Valor do tento: " + this.tento + "          |");
			System.out.println("+--------------------------------------+");
			this.jogarRodada(r, jogadorPorEquipe);
			this.vencedores.add(r.getVencedor());
			System.out.println();
		}

		return this.getEquipeVencedora();
	}

	// Retorna o número da equipe que ganhou
	// contando cada jogador que ganhou cada rodada.
	// No caso de empate, a equipe que ganhou pela primeira vez na
	// mão leva. Se todas empatarem, retorna 0, que quer dizer que
	// nenhuma das equipes leva os pontos.
	private int getEquipeVencedora() {
		int[] vitoriasEquipes = {0, 0};
		int primeiraEquipeAGanhar = -1;

		for (int i = 0; i < 3; i++) {
			Jogador vencedor = this.vencedores.get(i);
			if (vencedor != null) {
				int equipe = this.vencedores.get(i).getEquipe();
				vitoriasEquipes[equipe - 1] += 1;

				if (primeiraEquipeAGanhar == -1) {
					primeiraEquipeAGanhar = equipe;
				}
			}
		}

		if (vitoriasEquipes[0] > vitoriasEquipes[1]) {
			return 1;
		} else if (vitoriasEquipes[1] > vitoriasEquipes[0]) {
			return 2;
		} else if (vitoriasEquipes[0] == 0 && vitoriasEquipes[1] == 0) {
			return 0;
		}

		System.out.println();
		System.out.println("****** Equipe " + primeiraEquipeAGanhar + " venceu esta mão! *******");
		return primeiraEquipeAGanhar;

	}

	public int getTento() {
		return this.tento;
	}

	public void incrementarTento() {
		this.tento += 2;
	}
}

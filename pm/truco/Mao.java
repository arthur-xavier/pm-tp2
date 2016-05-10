import java.util.*;

public class Mao {
	private int tento = 2;
	private ArrayList<Rodada> rodadas = new ArrayList<Rodada>();

	Mao() {
		for (int i = 0; i < 3; i++) {
			this.rodadas.add(new Rodada(this));
		}
	}

	public Rodada acessarRodada(int n) {
		return this.rodadas.get(n);
	}

	// Define se o pedido de truco feito por um membro da equipe "equipe"
	// na rodada R é aceito pelos adversários.
	private void definirAceite(Rodada r, int equipe, Jogador[][] jogadorPorEquipe) {
		int outraEquipe;
		if (equipe == 1) {
			outraEquipe = 2;
		} else {
			outraEquipe = 1;
		}

		for (Jogador j: jogadorPorEquipe[outraEquipe-1]) {
			if (j.definirSeAceitaTruco()) {
				j.aceitar(r);
			} else {
				j.correr(r);
			}
		}

		r.definirAceite();
	}

	public Jogador jogarRodada(Rodada r, Jogador[][] jogadorPorEquipe) {
		int nJogadores = jogadorPorEquipe[0].length;

		for (int i = 0; i < nJogadores; i++) {
			Jogador j1 = jogadorPorEquipe[0][i];
			if (j1.definirSePedeTruco()) {
				j1.trucar(r);
				this.definirAceite(r, 1, jogadorPorEquipe);
			}

			j1.jogar(r);

			Jogador j2 = jogadorPorEquipe[1][i];
			if (j2.definirSePedeTruco()) {
				j2.trucar(r);
				this.definirAceite(r, 2, jogadorPorEquipe);
			}

			j2.jogar(r);
		}

		return r.getVencedor();
	}
	// Retorna o número da equipe que ganhou
	// contando cada jogador que ganhou cada rodada.
	// No caso de empate, a equipe que ganhou pela primeira vez na
	// mão leva. Se todas empatarem, retorna 0, que quer dizer que
	// nenhuma das equipes leva os pontos.
	public int getEquipeVencedora() {
		ArrayList<Jogador> vencedores = new ArrayList<Jogador>();
		int[] vitoriasEquipes = {0, 0};
		int primeiraEquipeAGanhar = -1;

		for (int i = 0; i < 3; i++) {
			vencedores.add(this.acessarRodada(i).getVencedor());
			Jogador vencedor = vencedores.get(i);
			if (vencedor != null) {
				int equipe = vencedores.get(i).getEquipe();
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

		return primeiraEquipeAGanhar;

	}

	public int getTento() {
		return this.tento;
	}

	public void incrementarTento() {
		this.tento += 2;
	}
}

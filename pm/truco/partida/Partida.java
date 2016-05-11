package pm.truco.partida;

import java.util.*;
import pm.truco.baralho.*;
import pm.truco.jogador.*;

public class Partida {
	private int[] pontos = {0, 0};
	private List<Jogador> jogadores;
	private List<Mao> maos;
	private Baralho baralho;
	private Jogador[][] jogadorPorEquipe;

	Partida() {
		this.jogadores = new ArrayList<Jogador>();
		this.maos = new ArrayList<Mao>();
		this.baralho = BaralhoDeTruco.getInstance();
	}

	private void separarJogadoresPorEquipe() {
		if (this.jogadorPorEquipe != null) {
			return;
		}

		int nJogadores = this.jogadores.size() / 2;
		this.jogadorPorEquipe = new Jogador[2][nJogadores];
		// indice que controla a última posição adicionada em cada equipe
		int[] i = {0, 0};

		for (Jogador j: this.jogadores) {
			int indiceEquipe = j.getEquipe() - 1;
			int ultimoIndice = i[indiceEquipe];
			this.jogadorPorEquipe[indiceEquipe][ultimoIndice] = j;
			i[indiceEquipe] += 1;
		}
	}

	public void adicionarJogador(Jogador j) {
		this.jogadores.add(j);
	}

	public List<Jogador> getJogadores() {
		return this.jogadores;
	}

	private void distribuirCartas() {
		for (int i = 0; i < jogadores.size(); i++) {
			List<Carta> cartas = this.baralho.retirarCartas(3);
			jogadores.get(i).setCartasNaMao(cartas);
		}
	}

	private boolean algumaEquipeGanhou() {
		return this.pontos[0] >= 12 || this.pontos[1] >= 12;
	}

	public int jogar() {
		this.separarJogadoresPorEquipe();

		while (!this.algumaEquipeGanhou()) {
			System.out.println();
			System.out.println("+--------------------------------------+");
			System.out.println("|--------- INÍCIO DE NOVA MÃO ---------|");
			System.out.println("+--------------------------------------+");
			System.out.println("|      Pontos da equipe 1: " + this.pontos[0] + "           |");
			System.out.println("|      Pontos da equipe 2: " + this.pontos[1] + "           |");
			System.out.println("+--------------------------------------+");
			System.out.println();
      this.baralho.embaralhar();
			this.distribuirCartas();
			Mao m = new Mao();
			this.maos.add(m);
			int equipeVencedora = m.jogar(this.jogadorPorEquipe);

			if (equipeVencedora != 0) {
				this.pontos[equipeVencedora-1] += m.getTento();
			}
		}

		if (this.pontos[0] >= 12) {
			System.out.println("****** A equipe 1 ganhou *******");
			return 1;
		}
		System.out.println("******* A equipe 2 ganhou *******");
		return 2;
	}
}

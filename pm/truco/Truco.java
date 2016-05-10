import java.util.*;

public class Truco {
	private int[] pontos = {0, 0};
	private ArrayList<Jogador> jogadores;
	private ArrayList<Mao> maos;
	private BaralhoDeTruco baralho;
	private Jogador[][] jogadorPorEquipe;

	Truco() {
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

	public ArrayList<Jogador> getJogadores() {
		return this.jogadores;
	}

	private void distribuirCartas() {
		for (int i = 0; i < jogadores.size(); i++) {
			ArrayList<Carta> cartas = this.baralho.retirarCartas(3);
			jogadores.get(i).setCartasNaMao(cartas);
		}
	}

	private boolean algumaEquipeGanhou() {
		return this.pontos[0] >= 12 || this.pontos[1] >= 12;
	}

	public int jogar() {
		this.separarJogadoresPorEquipe();

		while (!this.algumaEquipeGanhou()) {
			this.distribuirCartas();
			Mao m = new Mao();
			this.maos.add(m);
			int equipeVencedora = m.jogar(this.jogadorPorEquipe);
			
			if (equipeVencedora != 0) {
				this.pontos[equipeVencedora-1] += m.getTento();
			}
		}
		
		if (this.pontos[0] >= 12) {
			System.out.println("A equipe 1 ganhou!");
			return 1;
		}
		System.out.println("A equipe 2 ganhou!");
		return 2;
	}
}

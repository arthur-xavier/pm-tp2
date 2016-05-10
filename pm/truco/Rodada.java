import java.util.*;

public class Rodada {
	private Hashtable<Jogador, Carta> cartasNaMesa;
	private Jogador pedidorDeTruco;
	// Lista de jogadores de uma determinada equipe que aceitam o truco
	private ArrayList<Jogador> aceitadorDeTruco;
	// Lista de jogadores que correm do truco
	private ArrayList<Jogador> corredorDeTruco;
	private Mao m;

	Rodada(Mao m) {
		this.cartasNaMesa = new Hashtable<Jogador, Carta>();
		this.m = m;
	}

	public void adicionarCartaNaMesa(Jogador j, Carta c) {
		this.cartasNaMesa.put(j, c);
	}

	public Jogador getVencedor() {
		Set<Jogador> keys = this.cartasNaMesa.keySet();
		Jogador[] maioresJogadores = {null, null};
		int[] maioresValores = {-1, -1};
		BaralhoDeTruco bdt = BaralhoDeTruco.getInstance();

		for (Jogador j: keys) {
			Carta c = this.cartasNaMesa.get(j);
			int valor = bdt.getValorCarta(c); 
			int equipe = j.getEquipe();
			int i = equipe - 1;
			if (valor > maioresValores[i]) {
				maioresValores[i] = valor;
				maioresJogadores[i] = j;
			}	
		}

		// empate entre equipe 1 e 2
		if (maioresValores[0] == maioresValores[1]) {
			return null;
		}

		int equipeVencedora;
		if (maioresValores[0] > maioresValores[1]) {
			equipeVencedora = 0;
		} else {
			equipeVencedora = 1;
		}

		return maioresJogadores[equipeVencedora];
	}

	public void receberRequisicaoDeTruco(Jogador j) {
		this.pedidorDeTruco = j;
		this.aceitadorDeTruco = new ArrayList<Jogador>();
		this.corredorDeTruco = new ArrayList<Jogador>();
	}

	public void aceitarRequisicaoDeTruco(Jogador j) {
		if (j.getEquipe() == this.pedidorDeTruco.getEquipe()) {
			return;
		}
		
		this.aceitadorDeTruco.add(j);
	}

	public void negarRequisicaoDeTruco(Jogador j) {
		if (j.getEquipe() == this.pedidorDeTruco.getEquipe()) {
			return;
		}

		this.corredorDeTruco.add(j);
	}

	public void definirAceite() {
		if (this.pedidorDeTruco == null) {
			return;
		}

		if (this.aceitadorDeTruco.size() > this.corredorDeTruco.size()) {
			this.m.incrementarTento();	
		}
		this.aceitadorDeTruco = null;
		this.corredorDeTruco = null;
		this.pedidorDeTruco = null;
	}

}

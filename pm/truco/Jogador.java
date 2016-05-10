package pm.truco;

import java.util.*;

public abstract class Jogador {
	private String nome;
	private int equipe;
	protected ArrayList<Carta> cartasNaMao;
	protected Hashtable<Jogador, Carta> cartasNaMesa;

	public void setCartasNaMesa(Hashtable<Jogador, Carta> cartasNaMesa) {
		this.cartasNaMesa = cartasNaMesa;
	}

	public void setCartasNaMao(ArrayList<Carta> cartas) {
		this.cartasNaMao = cartas;
	}

	public ArrayList<Carta> getCartasNaMao() {
		return this.cartasNaMao;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public int getEquipe() {
		return this.equipe;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public abstract Carta escolherCarta();
	public abstract boolean definirSePedeTruco();
	public abstract boolean definirSeAceitaTruco();

}

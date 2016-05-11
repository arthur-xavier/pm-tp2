package pm.truco.jogador;

import java.util.*;
import pm.truco.baralho.*;

public abstract class Jogador {
	private String nome;
	private int equipe;
	protected List<Carta> cartasNaMao;
	protected Hashtable<Jogador, Carta> cartasNaMesa;

  public enum TipoJogador {
    HUMANO,
    RANDOMICO
  }

	public void setCartasNaMesa(Hashtable<Jogador, Carta> cartasNaMesa) {
		this.cartasNaMesa = cartasNaMesa;
	}

	public void setCartasNaMao(List<Carta> cartas) {
		this.cartasNaMao = cartas;
	}

	public List<Carta> getCartasNaMao() {
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

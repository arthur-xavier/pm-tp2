import java.util.*;

public class Jogador {
	private String nome;
	private int equipe;
	private ArrayList<Carta> cartasNaMao;

	Jogador(String nome, int equipe) {
		this.nome = nome;
		this.equipe = equipe;
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

	public Carta escolherCarta() {
		// escolher carta de acordo com criterio
		Random random = new Random();
		int i = random.nextInt(this.cartasNaMao.size());
		Carta c = this.cartasNaMao.get(i);
		this.cartasNaMao.remove(i);
		return c;
	}

	public boolean definirSePedeTruco() {
		Random random = new Random();
		float probabilidade = 0.2f;
		return random.nextFloat() < probabilidade;
	}

	public boolean definirSeAceitaTruco() {
		Random random = new Random();
		float probabilidade = 0.5f;
		return random.nextFloat() < probabilidade;
	}
}

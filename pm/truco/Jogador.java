public class Jogador {
	private String nome;
	private int equipe;

	Jogador(String nome, int equipe) {
		this.nome = nome;
		this.equipe = equipe;
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
}

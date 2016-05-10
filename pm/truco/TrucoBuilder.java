package pm.truco;

public class TrucoBuilder {

	public Truco criarTrucoDoisJogadores() {
		Truco truco = new Truco();

		Jogador vc = JogadorFactory.criarJogador(Jogador.TipoJogador.HUMANO, "Voce", 1);
		Jogador comp = JogadorFactory.criarJogador(Jogador.TipoJogador.RANDOMICO, "Computador", 2);

		truco.adicionarJogador(comp);
		truco.adicionarJogador(vc);
		truco.jogar();

    return truco;
	}
}
